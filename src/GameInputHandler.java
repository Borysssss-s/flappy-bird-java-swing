import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Translates keyboard events into game actions.
 * <p>
 * It is the only class that knows the concrete keys; the rest of the system
 * only sees {@link GameController#onActionPressed()} (<b>low coupling</b> and
 * <b>protected variations</b>: changing the controls does not affect the game).
 */
public class GameInputHandler extends KeyAdapter {

    private final GameController controller;

    /**
     * Creates the input handler.
     *
     * @param controller the controller to which actions are delegated
     */
    public GameInputHandler(GameController controller) {
        this.controller = controller;
    }

    /**
     * Reacts to a key press.
     *
     * @param e the keyboard event; only the space bar is handled
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            controller.onActionPressed();
        }
    }
}