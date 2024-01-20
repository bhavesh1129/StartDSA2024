package SD;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();

        // Sample playlist
        List<Song> playlist = List.of(
                new Song("Song1", "Artist1", 180),
                new Song("Song2", "Artist2", 220),
                new Song("Song3", "Artist3", 200)
        );

        player.loadPlaylist(playlist);

        // Play songs
        player.play();
        player.next();
        player.next();
        player.previous();
    }
}