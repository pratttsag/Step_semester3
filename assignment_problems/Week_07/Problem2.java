import java.util.Arrays;

class Playlist {
    private String[] songs;
    private int songCount;

    Playlist(int maxSongs) {
        songs = new String[maxSongs];
        songCount = 0;
    }

    void addSong(String song) {
        if (songCount < songs.length) {
            songs[songCount] = song;
            songCount++;
        }
    }

    String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    int getSongCount() {
        return songCount;
    }
}

public class Problem2 {
    public static void main(String[] args) {

        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();

        System.out.println("Songs:");
        for (String song : copy) {
            System.out.println(song);
        }

        copy[0] = "Hacked";

        System.out.println("Original first song: " + p.getSongs()[0]);
        System.out.println("Song count: " + p.getSongCount());
    }
}