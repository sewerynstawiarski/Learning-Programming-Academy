import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;

    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    public boolean addSong(String title, double duration) {
      return songs.add(new Song(title, duration));
    }

    public boolean addToPlayList(int numberOfTrack, LinkedList<Song> playList) {
        if (numberOfTrack <= 0) {
            return false;
        } else if (numberOfTrack > (songs.songs.size()+ 1)) {
            System.out.println("This album does not have a track " + numberOfTrack);
            return false;
        }
        try {
            Song songExists = songs.songs.get(numberOfTrack - 1);
            if (songs.songs.contains(songExists)) {
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
        Song songExists = songs.findSong(title);
        if (songExists != null) {
            playList.add(songExists);
            return true;
        } else {
            System.out.println("The song " +  title + "is not in this album");
            return false;
        }
    }

    public static class SongList {
        private ArrayList<Song> songs;

        public SongList() {
            this.songs = new ArrayList<>();
        }
        public boolean add(Song songToAdd) {
            Song songExist = findSong(songToAdd.getTitle());
            if (songExist == null) {
                songs.add(songToAdd);
                return true;
            } else {
                return false;
            }
        }
    private Song findSong(String title) {
            for (var song :
                    this.songs) {
                if (song.getTitle().equalsIgnoreCase(title)) {
                    return song;
                }
            }
            return null;
        }
    private Song findSong(int numberOfTrack) {
            if (numberOfTrack <= 0 || numberOfTrack > (this.songs.size() -1)) {
                return null;
            }
            if (this.songs.get(numberOfTrack -1) != null) {
                return this.songs.get(numberOfTrack -1);
            } else {
                return null;
            }
    }
        }
    }
