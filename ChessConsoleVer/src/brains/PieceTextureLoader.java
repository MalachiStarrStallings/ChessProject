package brains;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pieces.*;
import java.util.Objects;

/*
This class is only responsible for loading the sprite sheet that is used for the pieces images,
and parsing the sprite sheet so a given piece is only getting the relevant part of the image.
Pass piece -> determine piece color -> give texture depending on what type the piece is -> return cropped image
 */

public class PieceTextureLoader {
    private static final double TEXTURE_WIDTH = 256;
    private static final int TEXTURE_HEIGHT = 86;
    private static final int TILE_SIZE = 64;

    //TODO: remove this debugging later
    static {
         System.out.println("DEBUG: Trying to load: " + PieceTextureLoader.class.getResource("/chess_spritesheet.png"));
     }
     // Assign and declare an image object that will contain the sprite sheet
     private static final Image textureMap = new Image(Objects.requireNonNull(PieceTextureLoader.class.getResource(
            "/chess_spritesheet.png")).toExternalForm());
    // Takes a piece object and finds correct image from the sprite sheet and returns cropped image
    public ImageView getPieceImage (Piece piece) {
         ImageView imageView = new ImageView(textureMap);
         imageView.setViewport(findPieceTexture(piece));
         imageView.setFitHeight(TILE_SIZE);
         imageView.setFitWidth(TILE_SIZE);
         return imageView;
     }

     // Helper method that finds the pieces cropped image from the whole sprite sheet
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
