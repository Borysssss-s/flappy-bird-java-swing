/**
 * Game configuration constants.
 * <p>
 * Centralizes all "magic numbers" so that no other class duplicates them. This
 * is a utility class (Pure Fabrication in GRASP): it does not represent a
 * domain concept, but it reduces coupling and improves maintainability.
 */
public final class GameConfig {

    /** Board width in pixels. */
    public static final int BOARD_WIDTH = 360;

    /** Board height in pixels. */
    public static final int BOARD_HEIGHT = 640;

    /** Initial horizontal position of the bird. */
    public static final int BIRD_START_X = BOARD_WIDTH / 8;

    /** Initial vertical position of the bird. */
    public static final int BIRD_START_Y = BOARD_HEIGHT / 2;

    /** Bird width in pixels. */
    public static final int BIRD_WIDTH = 34;

    /** Bird height in pixels. */
    public static final int BIRD_HEIGHT = 24;

    /** Vertical acceleration applied to the bird on every frame. */
    public static final int GRAVITY = 1;

    /** Vertical velocity (negative = upwards) assigned to the bird when it flaps. */
    public static final int FLAP_VELOCITY = -9;

    /** Width of each pipe in pixels. */
    public static final int PIPE_WIDTH = 64;

    /** Height of each pipe in pixels. */
    public static final int PIPE_HEIGHT = 512;

    /** Horizontal velocity of the pipes (negative = towards the left). */
    public static final int PIPE_VELOCITY_X = -4;

    /** Vertical gap between the top pipe and the bottom pipe. */
    public static final int PIPE_OPENING_SPACE = BOARD_HEIGHT / 4;

    /** Interval, in milliseconds, between the spawning of two pipe pairs. */
    public static final int PIPE_SPAWN_INTERVAL_MS = 1500;

    /** Interval, in milliseconds, between frames (approx. 60 FPS). */
    public static final int FRAME_INTERVAL_MS = 1000 / 60;

    /** Private constructor: this class must not be instantiated. */
    private GameConfig() {
    }
}