package brains;
import pieces.*;
import java.awt.*;
/*
This class is the "physical" game board where the pieces are stored, added, moved, and removed.
The board is "dumb" and doesn't know if a given move is actually following the rules.
All the board needs to do is store, track, move, and remove pieces during gameplay.
 */
public class Board {
    // 8x8 grid of piece objects used to represent the chess board
    private Piece[][] chessBoard;

    public Board() {
        this.chessBoard = new Piece[8][8]; // Initialize the game board

    }
    // Method used only on game startup, all other times you move a piece, well... you are moving it
    public void placePiece(Piece piece) {
        Point location = piece.getCordPosition();
        chessBoard[location.y][location.x] = piece;
    }
    // Method used to retrive a piece at a specific coordinate
    public Piece getPieceAt(int i, int j) {
        return chessBoard[j][i];
    }
    // Overloaded method for retrieval in algebraic notation
    public Piece getPieceAt(String position) {
        Point point = Move.decodePosition(position);
        return chessBoard[point.y][point.x];
    }

    public Piece removePieceAt(int i, int j) {
        Piece removed = chessBoard[j][i];
        chessBoard[j][i] = null;
        return removed;
    }
    public Piece removePieceAt(String position) {
        Point point = Move.decodePosition(position);
        Piece removed = chessBoard[point.y][point.x];
        chessBoard[point.y][point.x] = null;
        return removed;
    }

    public void movePiece(Move move) {
        Point startLoc = move.getCordStarPos();
        // If the start location of the move is empty, the piece couldn't be moved
        if (chessBoard[startLoc.y][startLoc.x] == null) {
            throw new IllegalArgumentException("Illegal move! Must select a cell with a piece");
        }
        Point endLoc = move.getCordTargPos();
        // If the start location and destination location are the same, the move is invalid
        if ((startLoc.x == endLoc.x) && (startLoc.y == endLoc.y)) {
            throw new IllegalArgumentException("Illegal move! Start cell and end cell must be different");
        }
        // Update the piece location in the board, and set the old location as null
        Piece chosenPiece = chessBoard[startLoc.y][startLoc.x];
        chessBoard[startLoc.y][startLoc.x] = null;
        chessBoard[endLoc.y][endLoc.x] = chosenPiece;

        // Update the piece location inside the piece itself, and mark it as having moved
        chosenPiece.setHasMoved(true);
        chosenPiece.setAlgPosition(move.getTargetPosition());
        chosenPiece.setCordPosition(endLoc);
    }


    public void printBoard() {
        StringBuilder boardStr = new StringBuilder();
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                if (this.chessBoard[i][j] instanceof Pawn) {
                    boardStr.append("[P]");
                }
                else if (this.chessBoard[i][j] instanceof Rook) {
                    boardStr.append("[R]");
                }
                else if (this.chessBoard[i][j] instanceof Bishop) {
                    boardStr.append("[B]");
                }
                else if (this.chessBoard[i][j] instanceof Knight) {
                    boardStr.append("[N]");
                }
                else if (this.chessBoard[i][j] instanceof Queen) {
                    boardStr.append("[Q]");
                }
                else if (this.chessBoard[i][j] instanceof King) {
                    boardStr.append("[K]");
                }
                else if (this.chessBoard[i][j] == null) {
                    boardStr.append("[ ]");
                }
                if (j == 7) {
                    boardStr.append("\n");
                }
            }
        }
        System.out.println(boardStr);
    }
}
