import javax.swing.Timer;

/**
 * Game controller: coordinates the model and the view.
 * <p>
 * <b>Controller</b> pattern from GRASP: it receives system events (timer
 * ticks, action key presses) and delegates them to the model, without
 * containing any domain or drawing logic. It manages the timers of the game
 * loop and of the pipe spawning.
 */
public class GameController {

    private final GameModel model;
    private final GameView view;
    private final Timer gameLoop;
    private final Timer placePipesTimer;

    /**
     * Creates the controller.
     *
     * @param model the game model
     * @param view  the view that is refreshed on every frame
     */
    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
        this.placePipesTimer = new Timer(GameConfig.PIPE_SPAWN_INTERVAL_MS, e -> model.spawnPipes());
        this.gameLoop = new Timer(GameConfig.FRAME_INTERVAL_MS, e -> tick());
    }

    /**
     * Starts the game timers.
     */
    public void start() {
        placePipesTimer.start();
        gameLoop.start();
    }

    /**
     * Runs one frame: updates the model, refreshes the view and stops the game
     * if it is over.
     */
    private void tick() {
        model.update();
        view.render();
        if (model.isGameOver()) {
            stop();
        }
    }

    /**
     * Stops the game timers.
     */
    private void stop() {
        placePipesTimer.stop();
        gameLoop.stop();
    }

    /**
     * Handles the press of the action key.
     * <p>
     * If the game is over, it restarts it; otherwise, it makes the bird flap.
     */
    public void onActionPressed() {
        if (model.isGameOver()) {
            model.reset();
            start();
        } else {
            model.flap();
        }
    }
}