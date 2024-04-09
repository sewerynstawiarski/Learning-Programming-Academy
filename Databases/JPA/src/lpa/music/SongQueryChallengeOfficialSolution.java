package lpa.music;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.*;

import java.util.List;

public class SongQueryChallengeOfficialSolution {
    public static void main(String[] args) {
        List<Artist> songs = null;

        try(EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lpa.music");
            EntityManager entityManager = entityManagerFactory.createEntityManager();) {
            String dashedString = "-".repeat(19);
            String word = "Soul";
            var transaction = entityManager.getTransaction();
            transaction.begin();

            songs = getMatchedSongs(entityManager, "%" + word + "%");
            System.out.printf("%-30s %-65s %s%n", "Artist", "Album", "Song Title");
            System.out.printf("%1$-30s %1$-65s %1$s%n", dashedString);
            songs.forEach(a -> {
                String artistName = a.getArtistName();
                a.getAlbums().forEach(b -> {
                    String albumName = b.getAlbumName();
                    b.getAlbumSongs().forEach(s -> {
                        String songTitle = s.getSongTitle();
                        if (songTitle.contains(word)) {
                            System.out.printf("%-30s %-65s %s%n", artistName, albumName, songTitle);
                        }
                    });
                });
            });
            System.out.printf("%-30s %-65s %s%n", "Artist", "Album", "Song Title");
            System.out.printf("%1$-30s %1$-65s %1$s%n", dashedString);
            var bmatches = getMatchedSongsBuilder(entityManager, "%" + word + "%");
            bmatches.forEach(m -> {
                System.out.printf("%-30s %-65s %s%n", (String) m[0], (String)m[1], (String) m[2]);
            });


            transaction.commit();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    private static List<Artist> getMatchedSongs(EntityManager em, String matchedValue) {
        String jpql = "SELECT a FROM Artist a JOIN albums album JOIN albumSongs p WHERE p.songTitle LIKE ?1";
        var query = em.createQuery(jpql, Artist.class);
        query.setParameter(1, matchedValue);
        return query.getResultList();
    }
    public static List<Object[]> getMatchedSongsBuilder(EntityManager em, String matchedValue) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
        Root<Artist> artistRoot = criteriaQuery.from(Artist.class);
        Join<Artist, Album> albumJoin = artistRoot.join("albums", JoinType.INNER);
        Join<Album, Song> songsJoin = albumJoin.join("albumSongs", JoinType.INNER);

        criteriaQuery.multiselect(artistRoot.get("artistName"), albumJoin.get("albumName"), songsJoin.get("songTitle"))
                .where(criteriaBuilder.like(songsJoin.get("songTitle"), matchedValue))
                .orderBy(criteriaBuilder.asc(artistRoot.get("artistName")));
        return em.createQuery(criteriaQuery).getResultList();
    }
}
