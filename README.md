# Space Invaders – Design Patterns Edition 🎮

## Overview
This project is a refactored version of the classic **Space Invaders** game, built in Java.  
We applied **Creational Design Patterns** (Singleton & Abstract Factory) to make the code more flexible, maintainable, and extensible.  

Main enhancements include:
- **Singleton:** ensures a single game board instance.  
- **Abstract Factory:** clean creation of shots, bombs, aliens, and player types.  
- **New Features:**  
  - Multiple shot types (Normal, Water, Fire)  
  - Player selection (Red, Green, Blue)  
  - Difficulty modes (Easy: Stone bombs, Hard: Missiles)  
  - Alien variations (Normal, Rath)  
  - Menu system with difficulty & alien selection  

### Why These Patterns?

**Singleton**
We used it to ensure only one game board instance exists. This prevents duplication and keeps the game state consistent.

**Abstract Factory**
We applied it to separate the creation of game objects (Shots, Bombs, Players, Aliens) from the game logic. This makes it easy to add new types (e.g., a new alien or shot) without breaking the existing code.---

## How to Run

### Requirements
- Java JDK 8+  
- Any IDE (IntelliJ / Eclipse / NetBeans)  

### Run via Command Line
```bash
Controls
← / →: Move player

Space: Shoot normal

W: Shoot water

F: Shoot fire

1, 2, 3: Switch player types


