package SD;

import java.util.List;

class MusicPlayer {
    private List<Song> playlist;
    private int currentSongIndex;

    public MusicPlayer() {
        // Constructor
        this.playlist = null;
        this.currentSongIndex = -1;
    }

    public void loadPlaylist(List<Song> playlist) {
        this.playlist = playlist;
        this.currentSongIndex = 0; // Start playing from the first song
    }

    public void play() {
        if (playlist != null && !playlist.isEmpty() && currentSongIndex >= 0 && currentSongIndex < playlist.size()) {
            Song currentSong = playlist.get(currentSongIndex);
            System.out.println("Playing: " + currentSong.getTitle() + " by " + currentSong.getArtist());
        } else {
            System.out.println("No song to play. Playlist is empty.");
        }
    }

    public void next() {
        if (playlist != null && !playlist.isEmpty()) {
            currentSongIndex = (currentSongIndex + 1) % playlist.size();
            play();
        } else {
            System.out.println("No next song. Playlist is empty.");
        }
    }

    public void previous() {
        if (playlist != null && !playlist.isEmpty()) {
            currentSongIndex = (currentSongIndex - 1 + playlist.size()) % playlist.size();
            play();
        } else {
            System.out.println("No previous song. Playlist is empty.");
        }
    }
}


