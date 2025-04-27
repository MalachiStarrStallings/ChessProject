package brains;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pieces.Pawn;
import pieces.*;

public class ChessGUI extends Application {

    public static final int TILE_SIZE = 64;
    private GameController game;

    @Override
    public void start(Stage primaryStage) throws Exception {
        game = new GameController();
        Board board = game.getBoard();

        GridPane root = new GridPane();

        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                StackPane tile = new StackPane();
                Rectangle square = new Rectangle(TILE_SIZE, TILE_SIZE);

                if ((i+j) % 2 == 0) {
                    square.setFill(Color.web("0xE4D5B4"));
                }
                else {
                    square.setFill(Color.web("0xC4A484"));
                }
                tile.getChildren().add(square);

                Piece piece = board.getPieceAt(i, j);
                if (piece != null) {
                    Text pieceText = new Text(getPieceSymbol(piece));
                    tile.getChildren().add(pieceText);
                }

                root.add(tile, i, j);
            }
        }
        Scene scene = new Scene(root, TILE_SIZE*8, TILE_SIZE*8);
        primaryStage.setTitle("Chess Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private String getPieceSymbol (Piece piece) {
        if (piece instanceof Pawn) {
            return "P";
        }
        else if (piece instanceof Rook) {
            return "R";
        }
        else if (piece instanceof Bishop) {
            return "B";
        }
        else if (piece instanceof Knight) {
            return "N";
        }
        else if (piece instanceof Queen) {
            return "Q";
        }
        else if (piece instanceof King) {
            return "K";
        }
        else return "?";
    }
}
