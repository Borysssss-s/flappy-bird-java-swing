import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Application entry point.
 * <p>
 * Acts as the <b>composition root</b>: it is the only place where the objects
 * (model, view, controller and input) are created and wired together, so the
 * rest of the classes remain decoupled from each other.
 */
public class App {

    /**
     * Builds and shows the game window.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(App::createAndShowGame);
    }

    /**
     * Assembles the game pieces and shows the window.
     */
    private static void createAndShowGame() {
        GameModel model = new GameModel(new PipeFactory());
        GamePanel panel = new GamePanel(model, new AssetLoader());
        GameController controller = new GameController(model, panel);
        panel.addKeyListener(new GameInputHandler(controller));

        JFrame frame = new JFrame("Flappy Bird");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        panel.requestFocusInWindow();
        controller.start();
    }
}