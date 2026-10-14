<div align="center">

# 🐦 Flappy Bird

**A Flappy Bird clone built with Java Swing, designed around GRASP principles.**

![Java](https://img.shields.io/badge/Java-11%2B-orange?style=for-the-badge&logo=openjdk&logoColor=white)
![Swing](https://img.shields.io/badge/GUI-Swing-blue?style=for-the-badge)
![GRASP](https://img.shields.io/badge/Design-GRASP-success?style=for-the-badge)
![Javadoc](https://img.shields.io/badge/Docs-Javadoc-red?style=for-the-badge)

</div>

<!-- Add a screenshot or GIF of the game here:
<div align="center">
  <img src="docs/screenshot.png" width="300" alt="Game screenshot">
</div>
-->

---

## 📑 Table of contents

- [Features](#-features)
- [How to play](#-how-to-play)
- [Getting started](#-getting-started)
- [Architecture](#-architecture)
- [GRASP principles applied](#-grasp-principles-applied)
- [Project structure](#-project-structure)
- [Documentation](#-documentation)

---

## ✨ Features

- 🎮 Classic one-button Flappy Bird gameplay
- 🧱 Clean, layered architecture (model, view, controller)
- 📐 Designed following **GRASP** principles
- 📝 Fully documented with **Javadoc**
- 🔌 Decoupled view: Swing can be swapped through the `GameView` interface

---

## 🎮 How to play

| Key | Action |
|:---:|---|
| `SPACE` | Flap / Restart after game over |

1. Press **SPACE** to make the bird flap.
2. Fly through the gaps between the pipes to score points.
3. Avoid the pipes and do not fall off the screen.
4. When the game is over, press **SPACE** to try again.

---

## 🚀 Getting started

### Requirements

- ☕ Java JDK 11 or higher

### Build and run

```bash
# Clone the repository
git clone (https://github.com/Borysssss-s/flappy-bird-java-swing)
cd YOUR_REPO

# Compile (images must be next to the compiled classes)
mkdir -p bin
javac -d bin src/*.java
cp src/*.png bin/

# Run
java -cp bin App
```

> 💡 **Windows (PowerShell):** use `mkdir bin`, `javac -d bin src\*.java` and `copy src\*.png bin\`.

### Required images

The game expects these files in the same folder as the sources:

| File | Purpose |
|---|---|
| `flappybirdbg.png` | Background |
| `flappybird.png` | Bird |
| `toppipe.png` | Top pipe |
| `bottompipe.png` | Bottom pipe |

---

## 🏗️ Architecture

The project follows an MVC-like layout where the **model has no dependency on Swing**.

```mermaid
classDiagram
    class App
    class GameController
    class GameModel
    class GameView {
        <<interface>>
    }
    class GamePanel
    class GameInputHandler
    class Bird
    class Pipe
    class PipeFactory
    class AssetLoader

    App ..> GameModel : creates
    App ..> GamePanel : creates
    App ..> GameController : creates
    GameController --> GameModel : updates
    GameController --> GameView : renders
    GamePanel ..|> GameView
    GamePanel --> GameModel : reads
    GamePanel --> AssetLoader : uses
    GameInputHandler --> GameController : delegates
    GameModel o-- Bird
    GameModel o-- Pipe
    GameModel --> PipeFactory : uses
    PipeFactory ..> Pipe : creates
```

**Game flow:** a timer in `GameController` triggers a frame → `GameModel.update()` applies the rules → `GameView.render()` redraws the screen.

---

## 🎯 GRASP principles applied

| Class | GRASP pattern | Why |
|---|---|---|
| `Bird`, `Pipe`, `GameModel` | **Information Expert**, **High Cohesion** | Each one manages its own data and rules |
| `PipeFactory` | **Creator**, **Pure Fabrication** | Isolates how pipes are created |
| `GameController` | **Controller** | Handles system events and coordinates model and view |
| `GameView` / `GamePanel` | **Polymorphism**, **Protected Variations** | The view can change without affecting the rest |
| `GameInputHandler` | **Low Coupling** | Only class that knows the actual keys |
| `AssetLoader`, `GameConfig` | **Pure Fabrication** | Separate resource loading and constants |
| `App` | **Composition root** | The only place where objects are wired together |

---

## 📂 Project structure

```
📦 flappy-bird
 ┣ 📂 src
 ┃ ┣ 📜 App.java                # Entry point (composition root)
 ┃ ┣ 📜 GameConfig.java         # Game constants
 ┃ ┣ 📜 Bird.java               # Bird entity
 ┃ ┣ 📜 Pipe.java               # Pipe entity
 ┃ ┣ 📜 PipeType.java           # Pipe type enum (TOP / BOTTOM)
 ┃ ┣ 📜 PipeFactory.java        # Creates pipe pairs with a random gap
 ┃ ┣ 📜 GameModel.java          # Game state and rules (no Swing)
 ┃ ┣ 📜 GameView.java           # View interface
 ┃ ┣ 📜 GamePanel.java          # Swing view
 ┃ ┣ 📜 GameController.java     # Coordinates model, view and timers
 ┃ ┣ 📜 GameInputHandler.java   # Keyboard input
 ┃ ┣ 📜 AssetLoader.java        # Image loading
 ┃ ┗ 🖼️ *.png                   # Game images
 ┣ 📜 .gitignore
 ┗ 📜 README.md
```

---

## 📚 Documentation

Every class and method is documented with Javadoc. To generate the HTML documentation:

```bash
javadoc -d docs -private src/*.java
```

Then open `docs/index.html` in your browser.

---

<div align="center">

Made with ☕ and Java

</div>
