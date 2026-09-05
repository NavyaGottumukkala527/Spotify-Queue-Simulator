import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Core MusicPlayer for controlling the playback queue, history stack, and player state
 */
public class MusicPlayer {
    private Queue<Song> upcomingQueue;
    private Deque<Song> playbackHistory;
    private Song currentlyPlaying;

    public MusicPlayer() {
        this.upcomingQueue = new LinkedList<>();
        this.playbackHistory = new ArrayDeque<>();
        this.currentlyPlaying = null;
    }

    public void addSongToQueue(Song song) {
        upcomingQueue.add(song);
        System.out.println("-> Added to queue: " + song);
    }

    public void playNext() {
        if (upcomingQueue.isEmpty()) {
            System.out.println("Queue is empty. Add more songs to continue playback.");
            return;
        }

        if (currentlyPlaying != null) {
            playbackHistory.push(currentlyPlaying);
        }

        currentlyPlaying = upcomingQueue.poll();
        System.out.println("\n[NOW PLAYING]: " + currentlyPlaying);
    }

    public void playPrevious() {
        if (playbackHistory.isEmpty()) {
            System.out.println("No history available to play previous song.");
            return;
        }

        if (currentlyPlaying != null) {
            // Push current song back to front of queue
            ((LinkedList<Song>) upcomingQueue).addFirst(currentlyPlaying);
        }

        currentlyPlaying = playbackHistory.pop();
        System.out.println("\n[NOW PLAYING (Previous)]: " + currentlyPlaying);
    }

    public void shuffleQueue() {
        if (upcomingQueue.isEmpty()) {
            System.out.println("Cannot shuffle an empty queue.");
            return;
        }

        List<Song> songList = new ArrayList<>(upcomingQueue);
        Collections.shuffle(songList);
        upcomingQueue = new LinkedList<>(songList);
        System.out.println("-> Queue shuffled successfully.");
    }

    public void displayStatus() {
        System.out.println("\n================ MUSIC PLAYER STATUS ================");
        System.out.println("Currently Playing: " + (currentlyPlaying != null ? currentlyPlaying : "None"));
        System.out.println("Up Next (" + upcomingQueue.size() + " songs):");
        
        int index = 1;
        for (Song song : upcomingQueue) {
            System.out.println("  " + index + ". " + song);
            index++;
        }
        
        System.out.println("History Stack Depth: " + playbackHistory.size() + " tracks");
        System.out.println("====================================================");
    }

    public Song getCurrentlyPlaying() {
        return currentlyPlaying;
    }
}