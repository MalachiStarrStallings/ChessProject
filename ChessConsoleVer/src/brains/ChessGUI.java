package brains;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
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
        PieceTextureLoader textureLoader = new PieceTextureLoader();

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
                    ImageView pieceTexture = getPieceTexture(piece, textureLoader);
                    tile.getChildren().add(pieceTexture);
                }

                root.add(tile, i, j);
            }
        }
        Scene scene = new Scene(root, TILE_SIZE*8, TILE_SIZE*8);
        primaryStage.setTitle("Chess Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private ImageView getPieceTexture (Piece piece, PieceTextureLoader textureLoader) {
        return textureLoader.getPieceImage(piece);
    }
}
