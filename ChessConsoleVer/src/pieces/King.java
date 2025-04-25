package pieces;

import brains.Board;
import brains.Move;

import java.util.List;

public class King extends Piece {

    public King(Color color, String position) {
        super(color, position);
    }

    @Override
    public List<Move> getLegalMoves(Board board) {
        return null;
    }
}
