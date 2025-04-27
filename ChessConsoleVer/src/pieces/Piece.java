package pieces;
import java.awt.*;
import java.util.List;
import brains.Move;
import brains.Board;

public abstract class Piece {

    // The color of the piece (BLACK or WHITE)
    protected Color color;
    // The position of the piece using chess alg notation (E4, G2, ect.)
    protected String algPosition;
    // The position of the piece using coordinate notation (1, 1), (2, 4) ect.
    protected Point cordPosition;

    // Constructor for Pieces
    public Piece (Color color, String algPosition) {
        this.color = color;
        this.algPosition = algPosition;
        this.cordPosition = decodePosition(algPosition);
    }

    public Color getColor() { return color; } // We do not need a setter for the color since it never changes
    public String getAlgPosition() { return algPosition; }
    public Point getCordPosition() { return cordPosition; }

    public void setAlgPosition(String algPosition) {
        this.algPosition = algPosition;
    }
    public void setCordPosition(Point cordPosition) { this.cordPosition = cordPosition; }

    // To find the list of legal moves a given piece can make the piece needs to know the state of the board
    public abstract List<Move> getLegalMoves(Board board);

    /*
   This method will translate an algebraic position into a coordinate one
   E.g: A8 -> (0,0), E2 -> (4, 6)
    */
    private Point decodePosition (String position) {
        char file = position.charAt(0);
        int rank = Character.getNumericValue(position.charAt(1));
        int y = 8 - rank;
        int x = Character.getNumericValue(file) - 10;
        return new Point(x, y);
    }

}
