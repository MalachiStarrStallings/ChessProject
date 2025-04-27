package pieces;
import brains.Board;

/*
This class is responsible for setting up a standard chess board layout
It creates the board, pieces, and places the pieces in their appropriate place
 */

public class BoardSetup {
    public static Board createDefaultLayout() {
        // Initialize a new board that we will place our pieces on
        Board board = new Board();

        // Create and place all white pieces (except for pawns)
        board.placePiece(new King(Color.WHITE, "E1"));
        board.placePiece(new Queen(Color.WHITE, "D1"));
        board.placePiece(new Bishop(Color.WHITE, "F1"));
        board.placePiece(new Bishop(Color.WHITE, "C1"));
        board.placePiece(new Knight(Color.WHITE, "G1"));
        board.placePiece(new Knight(Color.WHITE, "B1"));
        board.placePiece(new Rook(Color.WHITE, "H1"));
        board.placePiece(new Rook(Color.WHITE, "A1"));
        // Create and place all white pawns
        StringBuilder pwnStrW = new StringBuilder("A2");
        for (int i = 0; i <= 7; i++) {
           board.placePiece(new Pawn(Color.WHITE, pwnStrW.toString()));
           char temp = pwnStrW.charAt(0);
           temp += 1;
           pwnStrW.setCharAt(0, temp);
        }

        // Create and place all black pieces (except for pawns)
        board.placePiece(new King(Color.BLACK, "E8"));
        board.placePiece(new Queen(Color.BLACK, "D8"));
        board.placePiece(new Bishop(Color.BLACK, "F8"));
        board.placePiece(new Bishop(Color.BLACK, "C8"));
        board.placePiece(new Knight(Color.BLACK, "G8"));
        board.placePiece(new Knight(Color.BLACK, "B8"));
        board.placePiece(new Rook(Color.BLACK, "H8"));
        board.placePiece(new Rook(Color.BLACK, "A8"));
        // Create and place all black pawns
        StringBuilder pwnStrB = new StringBuilder("A7");
        for (int i = 0; i <= 7; i++) {
            board.placePiece(new Pawn(Color.BLACK, pwnStrB.toString()));
            char temp = pwnStrB.charAt(0);
            temp += 1;
            pwnStrB.setCharAt(0, temp);
        }
        return board;
    }
}