package pieces;

import brains.Board;
import brains.Move;

import java.util.List;

public class Pawn extends Piece {
    public Pawn(Color color, String position) {
        super(color, position);
    }

    @Override
    public List<Move> getLegalMoves(Board board) {
        return null;
    }
}
