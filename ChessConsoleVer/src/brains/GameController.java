package brains;

import pieces.BoardSetup;

public class GameController {
    // Start game by setting up the default board state
    Board board = BoardSetup.createDefaultLayout();

    public Board getBoard() {
        return board;
    }
}
