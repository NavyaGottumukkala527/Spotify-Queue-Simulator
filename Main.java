import java.util.Scanner;

/**
 * Interactive driver for the Spotify Simulator
 */
public class Main {
    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();
        Scanner scanner = new Scanner(System.in);

        // Pre-populate with sample library data
        player.addSongToQueue(new Song("Starboy", "The Weeknd", 230));
        player.addSongToQueue(new Song("Blinding Lights", "The Weeknd", 200));
        player.addSongToQueue(new Song("As It Was", "Harry Styles", 167));
        player.addSongToQueue(new Song("Levitating", "Dua Lipa", 203));

        boolean running = true;
        System.out.println("\n=== Spotify Music Queue & Playlist Simulator ===");

        // Actual queue loop with user input
        while (running) {
            System.out.println("\n[1] Play Next  [2] Play Previous  [3] Add Song  [4] Shuffle Queue  [5] Display Queue  [6] Exit");
            System.out.print("Select an option: ");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    player.playNext();
                    break;
                case "2":
                    player.playPrevious();
                    break;
                case "3":
                    System.out.print("Enter song title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter artist name: ");
                    String artist = scanner.nextLine();
                    System.out.print("Enter duration in seconds: ");
                    
                    try {
                        int duration = Integer.parseInt(scanner.nextLine().trim());
                        player.addSongToQueue(new Song(title, artist, duration));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid duration input. Song addition canceled.");
                    }
                    break;
                case "4":
                    player.shuffleQueue();
                    break;
                case "5":
                    player.displayStatus();
                    break;
                case "6":
                    running = false;
                    System.out.println("Exiting Spotify Queue Simulator. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid selection. Please enter a number between 1 and 6.");
            }
        }

        scanner.close();
    }
}