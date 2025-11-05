---

# 🌌 Space Invaders – Design Patterns Edition 🎮

## 🧩 Overview

This project is a **modern, refactored version** of the classic *Space Invaders* game, developed in **Java**.
It demonstrates the application of **Creational** and **Structural Design Patterns** to create a scalable, flexible, and educational game system.

Players not only enjoy classic gameplay, they also **learn software design patterns** interactively through the shield system.

---

## 🚀 Stage 1: Creational Design Patterns

### **1. Singleton Pattern**

* **Class:** `Board`
* **Implementation:** `Board.getInstance()`
* **Purpose:** Ensures that only one instance of the game board exists throughout the program.
* **Benefit:** Maintains a consistent game state and prevents duplication.

### **2. Abstract Factory Pattern**

* **Classes:** `AbstractFactory`, `FactoryProducer`, `PlayerFactory`, `AlienFactory`, `ShotFactory`, `BombFactory`
* **Purpose:** Separates the creation of game objects (players, aliens, shots, bombs) from game logic.
* **Benefit:** Makes it easy to introduce new object types without modifying existing code.

🎮 **Stage 1 Key Features:**

* Multiple shot types → Normal, Water, Fire
* Player selection system → Red, Green, Blue
* Alien variations → Normal, Rath
* Difficulty modes → Easy (Stone Bombs), Hard (Missiles)
* Singleton `Board` to control the entire game lifecycle

---

## 🏛️ Stage 2: Structural Design Patterns

### **1. Adapter Pattern**

* **Class:** `GameIntegrationAdapter`
* **Purpose:** Connects and adapts external systems (like **Sound** and **Barrier**) to the main game logic.
* **Benefit:** Allows components with incompatible interfaces to work seamlessly together.



### **2. Decorator Pattern**

* **Classes:** `PlayerDecorator`, `ShieldedPlayer`
* **Purpose:** Dynamically adds shield functionality to players without altering the base `Player` class.
* **Behavior:** The shield absorbs **two bomb hits**, then automatically gets removed.
* **Benefit:** Extends player capabilities in a flexible, non-intrusive way.



### **3. Proxy Pattern**

* **Class:** `ShieldAccessProxy`
* **Purpose:** Controls access to the shield feature through an **educational mini-challenge**.
* **Process:**

  1. Player requests a shield before the game starts.
  2. Proxy shows a **random design pattern question** from `QuestionBank`.
  3. If the player answers correctly → Shield granted ✅
  4. If wrong → No shield ❌
* **Benefit:** Combines gameplay and learning, reinforcing understanding of design patterns interactively.



### **4. Flyweight Pattern**

* **Classes:** `Alien`, `RathAlien`, shared attributes via factories
* **Purpose:** Efficiently manages multiple (24+) alien instances by sharing common data (intrinsic state).
* **Benefit:** Greatly reduces memory usage and enhances performance.



🎮 **Stage 2 Key Features:**

* Interactive **shield unlocking system** using the Proxy Pattern
* **Decorated Player** class with a dynamic visual shield overlay
* **Two-hit protection system** before the shield breaks
* **Integrated Sound and Barrier systems** through Adapter Pattern
* Optimized **Alien management** with Flyweight for performance
* Enhanced **learning experience** via real-world pattern questions
* Real-time feedback for correct or incorrect answers

---

## 🧠 Educational Component

* **QuestionBank:** Contains 12 real-world design pattern scenarios.
* **Interactive Learning:** Players must use their design pattern knowledge to unlock game features.
* **Feedback System:** Immediate correct/incorrect feedback after each question.
* **Purpose:** Turn gameplay into a hands-on software engineering experience.

---



## 🎮 Gameplay Summary

| Feature              | Description                                  |
| -------------------- | -------------------------------------------- |
| **Movement**         | ← / → to move                                |
| **Shots**            | Space → Normal, W → Water, F → Fire          |
| **Player Types**     | 1 = Red, 2 = Green, 3 = Blue                 |
| **Difficulty Modes** | Easy = Stone Bombs, Hard = Missiles          |
| **Aliens**           | Normal & Rath types                          |
| **Shield System**    | Unlockable via correct design pattern answer |
| **Shield Behavior**  | Absorbs 2 hits before breaking               |

---

## ⚙️ Technical Details

**Language:** Java
**Tools:** IntelliJ IDEA / Eclipse
**JDK Version:** 8+
**Design Patterns Covered:**

* **Creational:** Singleton, Abstract Factory
* **Structural:** Adapter, Decorator, Proxy, Flyweight

---

## 🧾 Summary

| Stage       | Patterns Implemented                 | Key Classes                                                              |
| ----------- | ------------------------------------ | ------------------------------------------------------------------------ |
| **Stage 1** | Singleton, Abstract Factory          | `Board`, `FactoryProducer`, `PlayerFactory`, etc.                        |
| **Stage 2** | Adapter, Decorator, Proxy, Flyweight | `GameIntegrationAdapter`, `ShieldedPlayer`, `ShieldAccessProxy`, `Alien` |

---



