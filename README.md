# Spotify Music Queue Simulator

A lightweight, object-oriented Java console application that simulates music player queue management and playback state tracking. Built to demonstrate core Java data structures, dynamic queue operations, and defensive input handling.

## Features

* **Queue Management**: Enqueue upcoming tracks using standard FIFO queue semantics.
* **Playback History**: Track previously played songs using a stack-based history buffer for back-navigation.
* **Dynamic Shuffling**: In-place randomization of upcoming tracks using Fisher-Yates array shuffling (`Collections.shuffle`).
* **Interactive CLI**: Menu-driven terminal UI with runtime error handling for invalid user inputs.

## Technical Highlights

* **Language**: Java (JDK 21)
* **Data Structures**: `Queue` (LinkedList implementation), `Deque` / `Stack` (`ArrayDeque`)
* **Concepts**: Object-Oriented Programming (OOP), encapsulation, state management, Java Collections Framework

## Project Structure

```text
spotify-queue-simulator/
├── Song.java          # Model representing individual track metadata and formatting
├── MusicPlayer.java   # Core execution logic, queue state, and history operations
└── Main.java          # CLI interface, menu control loop, and entry point

## How to Run

### Prerequisites
* Java Development Kit (JDK 21 or higher) installed on your system.

### Compilation and Execution

1. Open your terminal in the project directory.
2. Compile all source files:
   ```bash
   javac *.java
3. Run the application:
   ```bash
   java Main