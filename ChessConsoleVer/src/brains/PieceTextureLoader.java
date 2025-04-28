package brains;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pieces.*;

import java.util.Objects;

public class PieceTextureLoader {
    private static final double TEXTURE_WIDTH = 256;
    private static final int TEXTURE_HEIGHT = 86;
    private static final int TILE_SIZE = 64;

   static {
        System.out.println("DEBUG: Trying to load: " + PieceTextureLoader.class.getResource("/chess_spritesheet.png"));
    }
    private static final Image textureMap = new Image(Objects.requireNonNull(PieceTextureLoader.class.getResource(
            "/chess_spritesheet.png")).toExternalForm());
    public ImageView getPieceImage (Piece piece) {
        ImageView imageView = new ImageView(textureMap);
        imageView.setViewport(findPieceTexture(piece));
        imageView.setFitHeight(TILE_SIZE);
        imageView.setFitWidth(TILE_SIZE);
        return imageView;
    }

    private Rectangle2D findPieceTexture (Piece piece) {
        final double tileWidth = TEXTURE_WIDTH/6;
        final double tileHeight = TEXTURE_HEIGHT/2;

        int col = 0;
        int row = (piece.getColor() == Color.WHITE) ? 0 : 1;
        if (piece instanceof Pawn) {
            col = 5;
        }
        else if (piece instanceof Rook) {
            col = 4;
        }
        else if (piece instanceof Bishop) {
            col = 2;
        }
        else if (piece instanceof Knight) {
            col = 3;
        }
        else if (piece instanceof Queen) {
            col = 1;
        }
        else if (piece instanceof King) {
            col = 0;
        }
        return new Rectangle2D(col * tileWidth, row * tileHeight, tileWidth, tileHeight);
    }


}
