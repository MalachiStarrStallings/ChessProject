package pieces;

import brains.Board;
import brains.Move;

import java.util.List;

public class Queen extends Piece {
    public Queen(Color color, String position) {
        super(color, position);
    }

    @Override
    public List<Move> getLegalMoves(Board board) {
        return null;
    }
}
