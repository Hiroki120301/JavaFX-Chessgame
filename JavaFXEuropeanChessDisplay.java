import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Background;
import javafx.geometry.Insets;

/**
 * This is a display class for JavaFx european chess game 
 *
 * Hiroki Nakayama
 */
public class JavaFXEuropeanChessDisplay implements JavaFXChessBoardDisplay

{
    /** The primary color of the checkerboard */
    public static Color redColor   = Color.RED;

    /** The secondary color of the checkerboard */
    public static Color blackColor = Color.BLACK;

    /* The color of the SOUTH player */
    public static Color southPlayerColor = Color.YELLOW;

    /* The color of the NORTH player */
    public static Color northPlayerColor = Color.GREEN;

    /* The color of the EAST player */
    public static Color eastPlayerColor = Color.WHITE;

    /* The color of the WEST player */
    public static Color westPlayerColor = Color.GRAY;

    /** The color used to highlight a square */
    public static Color highlightColor = Color.BLUE;

     /* This method takes button, row, and column as inputs 
     * It displays the empty square which does nothave a piece on 
     */
    public void displayEmptySquare(Button button, int row, int column)
    {
        button.setBackground(new Background(new BackgroundFill((row + column) % 2 == 0 ? blackColor : redColor, CornerRadii.EMPTY, Insets.EMPTY)));
        button.setText(null);
    }

    /* 
     * This method takes button, row, column, and piece as inputs 
     * It displays the square with the piece on 
     */
    public void displayFilledSquare(Button button, int row, int column, ChessPiece piece)
    {
        //This stores the color of the player 
        Color pieceColor;
        switch (piece.getSide()) 
        {
            case NORTH:   pieceColor = northPlayerColor;
            break;
            case SOUTH:   pieceColor = southPlayerColor;
            break;
            case EAST:    pieceColor = eastPlayerColor;
            break;
            default:      pieceColor = westPlayerColor;
        }
        
        //This stores the color of the square filled with a piece
        BackgroundFill fill = new BackgroundFill(pieceColor, new CornerRadii(30), new Insets(5,5,5,5));
        
        button.setBackground(new Background(new BackgroundFill((row + column) % 2 == 0 ? blackColor : redColor, CornerRadii.EMPTY, Insets.EMPTY), fill));
        
        button.setText(piece.getLabel());
    }

    /* 
     * This method takes boolean variable, button, row, column, and piece 
     * It highlights the square selected by users 
     */
    public void highlightSquare(boolean highlight, Button button, int row, int column, ChessPiece piece)
    {
        if (highlight) 
        {
            button.setBackground(new Background(new BackgroundFill(highlightColor, new CornerRadii(1.0), new Insets(1.0))));
        }
        else if (piece == null)
        {
            displayEmptySquare(button, row, column);
        }
        else
        {
            displayFilledSquare(button, row, column, piece);
        }
    }
}
