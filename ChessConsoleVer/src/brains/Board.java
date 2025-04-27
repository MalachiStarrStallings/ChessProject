package brains;

import pieces.*;

import java.awt.*;

public class Board {
    // 8x8 grid of piece objects used to represent the chess board
    private Piece[][] chessBoard;

    public Board() {
        this.chessBoard = new Piece[8][8]; // Initialize the game board

    }

    public void placePiece(Piece piece) {
        Point location = piece.getCordPosition();
        chessBoard[location.y][location.x] = piece;
    }

    public void movePiece(Move move) {
        Point startLoc = move.getCordStarPos();
        // If the start location of the move is empty, the piece couldn't be moved
        if (chessBoard[startLoc.y][startLoc.x] == null) {
            throw new IllegalArgumentException("Illegal move, must select a cell with a piece");
        }
        Point endLoc = move.getCordTargPos();
        Piece chosenPiece = chessBoard[startLoc.y][startLoc.x];
        chessBoard[startLoc.y][startLoc.x] = null;
        chessBoard[endLoc.y][endLoc.x] = chosenPiece;
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
        System.out.println(boardStr.toString());
    }
}
