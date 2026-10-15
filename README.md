# Java Blackjack

A console-based Blackjack game built with Java.

## Overview

This project is a simplified implementation of the classic Blackjack card game. The player competes against a computer-controlled dealer and earns or loses points based on each round's outcome.

## Features

- Standard 52-card deck with randomized shuffling
- Player and dealer turns
- Hit or stay gameplay
- Automatic Ace value adjustment
- Dealer draws until reaching a hand value of at least 17
- Blackjack detection and bust handling
- Point tracking across multiple rounds

## Project Structure

- `Main.java`: Entry point of the application
- `Game.java`: Main gameplay logic and round management
- `Card.java`: Card representation and value calculation
- `Deck.java`: Deck creation, shuffling, and card drawing
- `Player.java`: Hand management, score calculation, and point tracking

## How to Run

Requirements: Java JDK installed.

Compile the Java source files from the project root:

```bash
javac Blackjack/*.java
```

Run the game:

```bash
java Blackjack.Main
```

## Technologies

- Java
- Object-Oriented Programming
- ArrayList
- Random
- Scanner

## Future Improvements

- Add unit tests
- Improve input validation
- Separate game logic from user interface
- Add a graphical user interface

## Author

Junie Xue
