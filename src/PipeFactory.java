import java.util.List;
import java.util.Random;

/**
 * Factory in charge of creating pipe pairs with a random gap.
 * <p>
 * Applies the <b>Creator</b> and <b>Pure Fabrication</b> patterns from GRASP:
 * it isolates the creation logic so that neither the game model nor the
 * entities need to know how the random position is computed.
 */
public class PipeFactory {

    private final Random random;

    /**
     * Creates a factory with its own random number generator.
     */
    public PipeFactory() {
        this(new Random());
    }

    /**
     * Creates a factory with a given generator (useful for testing).
     *
     * @param random the random number generator to use
     */
    public PipeFactory(Random random) {
        this.random = random;
    }

    /**
     * Generates a pair of pipes (top and bottom) separated by a gap.
     * <p>
     * The position of the top pipe varies between {@code -3/4} and {@code -1/4}
     * of its height, so the gap appears at different heights.
     *
     * @return a list with the top pipe first and the bottom pipe second
     */
    public List<Pipe> createPair() {
        int topY = (int) (-GameConfig.PIPE_HEIGHT / 4
                - random.nextDouble() * (GameConfig.PIPE_HEIGHT / 2));
        int bottomY = topY + GameConfig.PIPE_HEIGHT + GameConfig.PIPE_OPENING_SPACE;

        return List.of(
                new Pipe(PipeType.TOP, topY),
                new Pipe(PipeType.BOTTOM, bottomY));
    }
}