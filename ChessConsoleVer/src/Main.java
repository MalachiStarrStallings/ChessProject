import brains.Board;
import brains.GameController;
import brains.Move;

public class Main {
    public static void main(String[] args) {


        GameController game = new GameController();
        game.getBoard().printBoard();
        Move testMove = new Move("E2", "E2");
        game.getBoard().movePiece(testMove);
        game.getBoard().printBoard();

    }
}