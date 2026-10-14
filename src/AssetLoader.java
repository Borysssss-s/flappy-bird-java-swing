import java.awt.Image;
import java.util.Objects;
import javax.swing.ImageIcon;

/**
 * Loads and stores the game images.
 * <p>
 * This is a <b>Pure Fabrication</b> class: it separates the responsibility of
 * accessing resources so that neither the model nor the controller know where
 * the images come from.
 */
public class AssetLoader {

    private final Image background;
    private final Image bird;
    private final Image topPipe;
    private final Image bottomPipe;

    /**
     * Loads all the images from the classpath.
     *
     * @throws NullPointerException if any image cannot be found
     */
    public AssetLoader() {
        background = load("/flappybirdbg.png");
        bird = load("/flappybird.png");
        topPipe = load("/toppipe.png");
        bottomPipe = load("/bottompipe.png");
    }

    /**
     * Loads an image from its classpath location.
     *
     * @param path the absolute path of the resource
     * @return the loaded image
     */
    private Image load(String path) {
        return new ImageIcon(Objects.requireNonNull(
                getClass().getResource(path), "Resource not found: " + path)).getImage();
    }

    /**
     * Returns the image associated with a pipe type.
     *
     * @param type the pipe type
     * @return the corresponding image
     */
    public Image getPipeImage(PipeType type) {
        return type == PipeType.TOP ? topPipe : bottomPipe;
    }

    /** @return the background image */
    public Image getBackground() {
        return background;
    }

    /** @return the bird image */
    public Image getBird() {
        return bird;
    }
}