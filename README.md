# Flappy Bird (Java Swing)

A Flappy Bird clone written in Java with Swing, structured following the **GRASP** principles and fully documented with Javadoc.

## How to play

- Press **SPACE** to make the bird flap.
- Avoid the pipes and do not fall off the screen.
- When the game is over, press **SPACE** to restart.

## Requirements

- Java JDK 11 or higher

## Project structure

```
src/
├── App.java               # Entry point (composition root)
├── GameConfig.java        # Game constants
├── Bird.java              # Bird entity
├── Pipe.java              # Pipe entity
├── PipeType.java          # Pipe type enum (TOP / BOTTOM)
├── PipeFactory.java       # Creates pipe pairs with a random gap
├── GameModel.java         # Game state and rules (no Swing)
├── GameView.java          # View interface
├── GamePanel.java         # Swing view that draws the model
├── GameController.java    # Coordinates model, view and timers
├── GameInputHandler.java  # Translates key events into actions
├── AssetLoader.java       # Loads the images
└── *.png                  # Game images
```

## GRASP principles applied

| Class | GRASP pattern |
|---|---|
| `Bird`, `Pipe`, `GameModel` | Information Expert, High Cohesion |
| `PipeFactory` | Creator, Pure Fabrication |
| `GameController` | Controller |
| `GameView` / `GamePanel` | Polymorphism, Protected Variations |
| `GameInputHandler`, `AssetLoader`, `GameConfig` | Low Coupling, Pure Fabrication |
| `App` | Composition root |

## Build and run

From the project root:

```bash
# Compile (the .png files must be on the classpath, next to the sources)
mkdir -p bin
javac -d bin src/*.java
cp src/*.png bin/

# Run
java -cp bin App
```

## Generate the Javadoc

```bash
javadoc -d docs -private src/*.java
```

Then open `docs/index.html` in your browser.

## Required images

The game expects these files in the same folder as the sources:

- `flappybirdbg.png`
- `flappybird.png`
- `toppipe.png`
- `bottompipe.png`