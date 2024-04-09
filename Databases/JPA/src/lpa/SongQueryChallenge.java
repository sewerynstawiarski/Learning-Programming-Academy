package lpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.*;
import lpa.music.Album;
import lpa.music.Artist;
import lpa.music.Song;

import java.util.List;

public class SongQueryChallenge {
    public static void main(String[] args) {
        List<Tuple> songs = null;

        try(EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lpa.music");
            EntityManager entityManager = entityManagerFactory.createEntityManager();) {
            var transaction = entityManager.getTransaction();
            transaction.begin();

        songs = getSongsByJPQL(entityManager, "%Storm%");
//        songs = getSongsByCriteriaBuilder(entityManager, "%Love%");
        songs
                .forEach(System.out::println);

            transaction.commit();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static List<Tuple> getSongsByJPQL(EntityManager em, String matchedValue) {
        String jpql = "SELECT s FROM Song s WHERE s.songTitle LIKE ?1";
        String jpql2 = "SELECT t.artistName, a.albumName, song.songTitle FROM Artist t JOIN albums a JOIN albumSongs song WHERE song.songTitle LIKE ?1";
        var query = em.createQuery(jpql2, Tuple.class);
        query.setParameter(1, matchedValue);
        return query.getResultList();

    }
public static List<Tuple> getSongsByCriteriaBuilder(EntityManager em, String matchedValue) {
    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createTupleQuery();
    Root<Artist> artistRoot = criteriaQuery.from(Artist.class);
//    Root<Album> albumRoot = criteriaQuery.from(Album.class);
//    Root<Song> songRroot = criteriaQuery.from(Song.class);
    Join<Artist, Album> albumJoin = artistRoot.join("albums", JoinType.INNER);
    Join<Album, Song> songsJoin = albumJoin.join("albumSongs", JoinType.INNER);

    criteriaQuery.multiselect(artistRoot.get("artistName") ,albumJoin.get("albumName"), songsJoin.get("songTitle"))
            .distinct(true)
                    .where(criteriaBuilder.like(artistRoot.get("songTitle"), matchedValue));
return em.createQuery(criteriaQuery).getResultList();
}
}
