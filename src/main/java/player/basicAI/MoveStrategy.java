package main.java.player.basicAI;

import main.java.board.Board;
import main.java.board.Move;

/**
 * The general interface for a move strategy
 */
public interface MoveStrategy {

    /**
     * This method shall generate the best move available according
     * to it's given move strategy logic
     * @param board to generate move for
     * @return the best Move according to a given strategy
     */
    Move execute(Board board);

}
