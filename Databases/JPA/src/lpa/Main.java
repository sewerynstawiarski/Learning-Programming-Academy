package lpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import lpa.music.Artist;

public class Main {
    public static void main(String[] args) {
        try(var sessionFactory = Persistence.createEntityManagerFactory("lpa.music");
            EntityManager entityManager = sessionFactory.createEntityManager();
        ) {
            var transaction = entityManager.getTransaction();
            transaction.begin();
            Artist artist = entityManager.find(Artist.class, 149);

//            Artist artist = new Artist(202, "Muddy Water");
//            artist.setArtistName("Muddy Waters");
            System.out.println(artist);
//            artist.removeDuplicates();
//            artist.addAlbum("The Best Of Muddy Waters");
//            System.out.println(artist);
//            entityManager.remove(artist);
//            entityManager.persist(new Artist("Muddy Water"));
//            entityManager.merge(artist);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
