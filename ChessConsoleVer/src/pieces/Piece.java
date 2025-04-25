package pieces;
import java.util.List;
import brains.Move;
import brains.Board;

public abstract class Piece {

    // The color of the piece (BLACK or WHITE)
    protected Color color;
    // The position of the piece using chess number and letter notation (E4, G2, ect)
    protected String position;

    // Constructor for Pieces
    public Piece (Color color, String position) {
        this.color = color;
        this.position = position;
    }

    public Color getColor() { return color; } // We do not need a setter for the color since it never changes
    public String getPosition() { return position; } // We do need a setter for the position because
                                                     // it changes as the pieces move on the board
    public void setPosition(String position) {
        this.position = position;
    }

    // To find the list of legal moves a given piece can make the piece needs to know the state of the board
    public abstract List<Move> getLegalMoves(Board board);

}
