package lpa.music;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "albums")
public class Album implements Comparable<Album>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id")
    private int albumId;
    @Column(name = "album_name")
    private String albumName;
    @OneToMany
    @JoinColumn(name = "album_id")
    List<Song> albumSongs = new ArrayList<>();

    public Album() {
    }

    public Album(String albumName) {
        this.albumName = albumName;
    }

    public Album(int albumId, String albumName) {
        this.albumId = albumId;
        this.albumName = albumName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public List<Song> getAlbumSongs() {
        return albumSongs;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner("\n");

        Set<Song> sortedSongs = new TreeSet<>(albumSongs);

        sortedSongs.forEach(s -> stringJoiner.add(s.toString()));

        return "\nAlbum{" +
                "albumId=" + albumId +
                ", albumName='" + albumName + '\'' +
                ", albumSongs='" +  "\n" + stringJoiner.toString() +
                '}';
    }

    @Override
    public int compareTo(Album o) {
        return this.albumName.compareTo(o.getAlbumName());
    }
}
