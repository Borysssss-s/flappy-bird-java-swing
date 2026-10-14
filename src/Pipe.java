import java.awt.Rectangle;

/**
 * Domain entity that represents a pipe.
 * <p>
 * It is the expert on its own position, its movement and on whether the bird
 * has already passed it (<b>Information Expert</b>).
 */
public class Pipe {

    private int x;
    private final int y;
    private final int width;
    private final int height;
    private final PipeType type;
    private boolean passed;

    /**
     * Creates a pipe at the right edge of the board.
     *
     * @param type the pipe type (top or bottom)
     * @param y    the vertical coordinate of the top corner of the pipe
     */
    public Pipe(PipeType type, int y) {
        this.type = type;
        this.x = GameConfig.BOARD_WIDTH;
        this.y = y;
        this.width = GameConfig.PIPE_WIDTH;
        this.height = GameConfig.PIPE_HEIGHT;
        this.passed = false;
    }

    /**
     * Moves the pipe horizontally according to the configured velocity.
     */
    public void update() {
        x += GameConfig.PIPE_VELOCITY_X;
    }

    /**
     * Checks whether the bird has completely passed this pipe.
     *
     * @param bird the bird to check
     * @return {@code true} if the pipe is already behind the bird
     */
    public boolean isPassedBy(Bird bird) {
        return bird.getX() > x + width;
    }

    /**
     * Checks whether the bird collides with this pipe.
     *
     * @param bird the bird to check
     * @return {@code true} if their rectangles overlap
     */
    public boolean collidesWith(Bird bird) {
        return bird.getBounds().intersects(getBounds());
    }

    /**
     * Computes the rectangle occupied by the pipe.
     *
     * @return the rectangular area of the pipe
     */
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    /** @return {@code true} if the pipe has already been counted as passed */
    public boolean isPassed() {
        return passed;
    }

    /** Marks the pipe as passed so that it does not score twice. */
    public void markPassed() {
        this.passed = true;
    }

    /** @return the X coordinate of the pipe */
    public int getX() {
        return x;
    }

    /** @return the Y coordinate of the pipe */
    public int getY() {
        return y;
    }

    /** @return the width of the pipe */
    public int getWidth() {
        return width;
    }

    /** @return the height of the pipe */
    public int getHeight() {
        return height;
    }

    /** @return the type of the pipe */
    public PipeType getType() {
        return type;
    }
}