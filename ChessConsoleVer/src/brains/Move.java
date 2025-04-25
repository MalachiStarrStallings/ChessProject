/*
This class is used for encapsulating the move orders for a piece.
Once a move has been created, for example E2 to E4, the starting and target destination
are not able to be changed ensuring that the attempted move is not altered.
If the player wants to try another move, a new Move object will be created.
 */

package brains;

import java.awt.*;

public class Move {

    private final String algStartingPos; // Starting position of piece before move is made (Algebraic notation)
    private final String algTargetPos; // Targeted position of piece after move is made (Algebraic notation)
    private final Point cordStarPos; // Starting position in coordinate notation
    private final Point cordTargPos; // Target position in coordinate notation

    public Move(String algStartingPos, String algTargetPos) {
        this.algStartingPos = algStartingPos;
        this.algTargetPos = algTargetPos;
        this.cordStarPos = decodePosition(algStartingPos);
        this.cordTargPos = decodePosition(algTargetPos);
    }

    public String getStartingPosition() { return algStartingPos; } // We need to be able to access these values
    public String getTargetPosition() { return algTargetPos; } // but we do not want to change them because
                                                               // that would just be its own Move object
    public Point getCordStarPos() { return cordStarPos; }
    public Point getCordTargPos() { return cordTargPos; }


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
    @Override
    public String toString() {
        return "Alg move:" + algStartingPos + " to " + algTargetPos
                            + "\nCoord move:" + cordStarPos + " to " + cordTargPos;
    }
}
