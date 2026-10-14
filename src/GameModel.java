import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Game model: holds all the state and rules, with no dependency on the
 * graphical interface.
 * <p>
 * It is the <b>Information Expert</b> for the global state (bird, pipes, score
 * and game over) and keeps <b>high cohesion</b>: it only deals with the game
 * rules. Pipe creation is delegated to {@link PipeFactory}.
 */
public class GameModel {

    private final Bird bird;
    private final List<Pipe> pipes;
    private final PipeFactory pipeFactory;
    private int score;
    private boolean gameOver;

    /**
     * Creates a model with a fresh game.
     *
     * @param pipeFactory the factory used to generate pipes
     */
    public GameModel(PipeFactory pipeFactory) {
        this.bird = new Bird();
        this.pipes = new ArrayList<>();
        this.pipeFactory = pipeFactory;
        this.score = 0;
        this.gameOver = false;
    }

    /**
     * Advances one frame: moves the bird and the pipes, updates the score and
     * detects collisions.
     */
    public void update() {
        bird.update();

        for (Pipe pipe : pipes) {
            pipe.update();

            if (!pipe.isPassed() && pipe.isPassedBy(bird)) {
                pipe.markPassed();
                // Each pair has two pipes; only the top one scores.
                if (pipe.getType() == PipeType.TOP) {
                    score++;
                }
            }

            if (pipe.collidesWith(bird)) {
                gameOver = true;
            }
        }

        if (bird.isOutOfBounds()) {
            gameOver = true;
        }
    }

    /**
     * Adds a new pair of pipes to the board.
     */
    public void spawnPipes() {
        pipes.addAll(pipeFactory.createPair());
    }

    /**
     * Makes the bird flap.
     */
    public void flap() {
        bird.flap();
    }

    /**
     * Resets the game to its initial state.
     */
    public void reset() {
        bird.reset();
        pipes.clear();
        score = 0;
        gameOver = false;
    }

    /** @return the bird of the game */
    public Bird getBird() {
        return bird;
    }

    /** @return a read-only view of the current pipes */
    public List<Pipe> getPipes() {
        return Collections.unmodifiableList(pipes);
    }

    /** @return the current score */
    public int getScore() {
        return score;
    }

    /** @return {@code true} if the game is over */
    public boolean isGameOver() {
        return gameOver;
    }
}