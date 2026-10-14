/**
 * Types of pipes that can appear in the game.
 * <p>
 * Replaces any direct dependency on images in the model: the view decides
 * which image to draw depending on the type (low coupling).
 */
public enum PipeType {

    /** Pipe hanging from the ceiling. */
    TOP,

    /** Pipe rising from the ground. */
    BOTTOM
}