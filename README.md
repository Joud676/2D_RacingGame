# Space Invaders – Design Patterns Edition 🎮

## Overview

This project is a **modern, refactored version** of the classic *Space Invaders* game, developed in **Java**.
It demonstrates the application of **Creational**, **Structural**, and **Behavioral Design Patterns** to create a scalable, flexible, and educational game system.

Players not only enjoy classic gameplay, they also **learn software design patterns** interactively through the shield system.

---

## Stage 1: Creational Design Patterns

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

## Stage 2: Structural Design Patterns

### **1. Adapter Pattern**

* **Class:** `GameIntegrationAdapter`
* **Purpose:** Connects and adapts **external Sound systems** to the main game logic.
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

* **Classes:** `AlienFactory`, `Alien`, `RathAlien`
* **Implementation:** Modified the existing `AlienFactory` by introducing a `HashMap` and a `getSharedAlienImage()` method.
* **Purpose:** The method checks whether a similar alien image already exists in the map — if yes, it reuses it; if not, it creates a new one, stores it in the map, and returns it.
* **Proof of Correctness:** The `hashCode()` method was used to print the memory locations of all alien objects, demonstrating that identical images share the same object reference.
* **Benefit:** Reduces memory consumption and improves performance by reusing shared alien images instead of creating new ones for every instance.

🎮 **Stage 2 Key Features:**

* Interactive **shield unlocking system** using the Proxy Pattern
* **Decorated Player** class with a dynamic visual shield overlay
* **Two-hit protection system** before the shield breaks
* **Integrated Sound systems** through Adapter Pattern
* Optimized **Alien management** with Flyweight for performance
* Enhanced **learning experience** via real-world pattern questions
* Real-time feedback for correct or incorrect answers

---

## Stage 3: Behavioral Design Patterns

### **1. Template Method Pattern**

* **Class:** `Shot` (abstract base class)
* **Implementation:** The `build()` method serves as the template method
* **Purpose:** Standardizes shot creation across different projectile types (Normal, Water, Fire).
* **Process:**
  1. The abstract `Shot` class defines the fixed `build()` template sequence.
  2. The template calls the abstract `loadImage()` method, which subclasses must override.
  3. Each subclass (`NormalShot`, `WaterShot`, `FireShot`) implements its own `loadImage()` method to load the specific shot image.
  4. All shots follow the same construction process: call `loadImage()` → set position.
* **Benefit:** Eliminates code duplication and ensures consistent shot initialization while allowing flexible customization per shot type through the overridden `loadImage()` method.

### **2. State Pattern**

* **Classes:** `PlayerState` (interface), `VulnerableState`, `ShieldedState`
* **Implementation:** The `Player` class delegates hit detection to state objects instead of using conditional logic.
* **Purpose:** Manages player vulnerability dynamically during gameplay.
* **States:**
  * **VulnerableState:** Player dies immediately when hit by a bomb.
  * **ShieldedState:** Absorbs bomb hits and tracks damage. After reaching `MAX_HITS`, transitions player back to `VulnerableState` and removes the shield.
* **Benefit:** Clean, flexible state management with easy extensibility for future player states (e.g., invincible, stunned).

### **3. Observer Pattern**

* **Classes:** `PlayerObserver` (interface), `Board` (concrete observer), `Player` (subject)
* **Implementation:** The `Board` class observes `Player` movements and state changes.
* **Purpose:** Tracks real-time player activity without tight coupling.
* **Process:**
  1. Player registers observers via `addObserver()`.
  2. When player moves or changes state, `notifyObservers()` is called.
  3. Board receives updates and logs player coordinates, speed, and type.
* **Benefit:** Decouples game logic from display logic, making the system more maintainable and extensible.

🎮 **Stage 3 Key Features:**

* **Unified shot creation** using Template Method with overridable `loadImage()`
* **Dynamic state transitions** between vulnerable and shielded modes
* **Real-time movement tracking** via Observer pattern
* **Automatic shield removal** when hit limit is reached
* **Console logging** for debugging player state changes
* **Extensible architecture** for adding new player states or observers

---

## Educational Component

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
| **State Management** | Automatic transition from shielded to vulnerable |
| **Real-time Tracking** | Console logs player movements and state changes |

---

## Technical Details

**Language:** Java  
**Tools:** IntelliJ IDEA / Eclipse  
**JDK Version:** 8+  
**Design Patterns Covered:**  
- **Creational:** Singleton, Abstract Factory  
- **Structural:** Adapter, Decorator, Proxy, Flyweight  
- **Behavioral:** Template Method, State, Observer

---

## Summary

| Stage       | Patterns Implemented                 | Key Classes                                                              |
| ----------- | ------------------------------------ | ------------------------------------------------------------------------ |
| **Stage 1** | Singleton, Abstract Factory          | `Board`, `FactoryProducer`, `PlayerFactory`, etc.                        |
| **Stage 2** | Adapter, Decorator, Proxy, Flyweight | `GameIntegrationAdapter`, `ShieldedPlayer`, `ShieldAccessProxy`, `Alien` |
| **Stage 3** | Template Method, State, Observer     | `Shot`, `PlayerState`, `VulnerableState`, `ShieldedState`, `PlayerObserver` |

---

## Project Highlights

 **12 Design Patterns** implemented across 3 stages  
 **Educational gameplay** combining coding concepts with classic arcade action  
 **Clean architecture** with separation of concerns  
 **Extensible codebase** ready for future enhancements  
 **Real-world applicability** demonstrating professional software design principles  

---







