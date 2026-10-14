/**
 * Contract that any game view must fulfill.
 * <p>
 * Introduces <b>polymorphism</b> and <b>protected variations</b> (GRASP): the
 * controller depends on this interface and not on Swing, so the view can be
 * replaced without touching the rest of the code.
 */
public interface GameView {

    /**
     * Asks the view to redraw itself with the current state of the model.
     */
    void render();
}