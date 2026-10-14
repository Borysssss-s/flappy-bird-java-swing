import java.awt.Rectangle;

/**
 * Domain entity that represents the bird controlled by the player.
 * <p>
 * Following the <b>Information Expert</b> pattern from GRASP, the bird is
 * responsible for managing its own position and velocity. It knows nothing
 * about Swing or images: it only models state and behavior.
 */
public class Bird {

    private int x;
    private int y;
    private final int width;
    private final int height;
    private int velocityY;

    /**
     * Creates a bird at its initial position and at rest.
     */
    public Bird() {
        this.x = GameConfig.BIRD_START_X;
        this.y = GameConfig.BIRD_START_Y;
        this.width = GameConfig.BIRD_WIDTH;
        this.height = GameConfig.BIRD_HEIGHT;
        this.velocityY = 0;
    }

    /**
     * Applies gravity and updates the vertical position.
     * The bird can never leave through the top edge of the screen.
     */
    public void update() {
        velocityY += GameConfig.GRAVITY;
        y += velocityY;
        y = Math.max(y, 0);
    }

    /**
     * Makes the bird flap by assigning it an upward velocity.
     */
    public void flap() {
        velocityY = GameConfig.FLAP_VELOCITY;
    }

    /**
     * Restores the bird to its initial position and velocity.
     */
    public void reset() {
        x = GameConfig.BIRD_START_X;
        y = GameConfig.BIRD_START_Y;
        velocityY = 0;
    }

    /**
     * Tells whether the bird has fallen below the bottom edge of the board.
     *
     * @return {@code true} if the bird is below the board
     */
    public boolean isOutOfBounds() {
        return y > GameConfig.BOARD_HEIGHT;
    }

    /**
     * Computes the rectangle occupied by the bird, useful for collision detection.
     *
     * @return the rectangular area of the bird
     */
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    /** @return the X coordinate of the bird */
    public int getX() {
        return x;
    }

    /** @return the Y coordinate of the bird */
    public int getY() {
        return y;
    }

    /** @return the width of the bird */
    public int getWidth() {
        return width;
    }

    /** @return the height of the bird */
    public int getHeight() {
        return height;
    }
}