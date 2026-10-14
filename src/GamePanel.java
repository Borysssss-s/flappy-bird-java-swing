import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Game view: draws the state of the {@link GameModel} on a Swing panel.
 * <p>
 * Its only responsibility is presentation (<b>high cohesion</b>). It neither
 * modifies the model nor handles keyboard events.
 */
public class GamePanel extends JPanel implements GameView {

    private static final long serialVersionUID = 1L;

    private final transient GameModel model;
    private final transient AssetLoader assets;

    /**
     * Creates the game panel.
     *
     * @param model  the model whose state will be drawn
     * @param assets the image provider
     */
    public GamePanel(GameModel model, AssetLoader assets) {
        this.model = model;
        this.assets = assets;
        setPreferredSize(new Dimension(GameConfig.BOARD_WIDTH, GameConfig.BOARD_HEIGHT));
        setFocusable(true);
    }

    /**
     * Requests a new repaint of the panel.
     */
    @Override
    public void render() {
        repaint();
    }

    /**
     * Draws the current frame.
     *
     * @param g the graphics context
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBackground(g);
        drawBird(g);
        drawPipes(g);
        drawScore(g);
    }

    /**
     * Draws the background.
     *
     * @param g the graphics context
     */
    private void drawBackground(Graphics g) {
        g.drawImage(assets.getBackground(), 0, 0,
                GameConfig.BOARD_WIDTH, GameConfig.BOARD_HEIGHT, null);
    }

    /**
     * Draws the bird.
     *
     * @param g the graphics context
     */
    private void drawBird(Graphics g) {
        Bird bird = model.getBird();
        g.drawImage(assets.getBird(), bird.getX(), bird.getY(),
                bird.getWidth(), bird.getHeight(), null);
    }

    /**
     * Draws all the pipes.
     *
     * @param g the graphics context
     */
    private void drawPipes(Graphics g) {
        for (Pipe pipe : model.getPipes()) {
            g.drawImage(assets.getPipeImage(pipe.getType()), pipe.getX(), pipe.getY(),
                    pipe.getWidth(), pipe.getHeight(), null);
        }
    }

    /**
     * Draws the score (and the game over message when applicable).
     *
     * @param g the graphics context
     */
    private void drawScore(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 32));
        String text = model.isGameOver()
                ? "Game Over: " + model.getScore()
                : String.valueOf(model.getScore());
        g.drawString(text, 10, 35);
    }
}