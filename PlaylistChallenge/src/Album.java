import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;

    private ArrayList<Song> songs;

    @Override
    public String toString() {
        return "Album{" +
                "name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", songs=" + songs +
                '}';
    }

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    private Song findSong(String title) {
        for (var song :
                songs) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                return song;
            }
        } return null;
    }

    public boolean addSong(String title, double duration) {
        Song songExist = findSong(title);
        if (songExist == null) {
            songs.add(new Song(title,duration));
            return true;
        } else {
            return false;
        }
    }

    public boolean addToPlayList(int numberOfTruck, LinkedList<Song> playList) {
        if (numberOfTruck <= 0) {
            return false;
        }
        try {
            Song songExists = songs.get(numberOfTruck -1);
            if (songs.contains(songExists)) {
                playList.add(songExists);
                return true;
            } else {
                return false;
            }
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            return false;
        }
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song songExists =  findSong(title);
        if (songExists != null) {
            playList.add(songExists);
            return true;
        }
        else {
            return false;
        }
    }
 }

