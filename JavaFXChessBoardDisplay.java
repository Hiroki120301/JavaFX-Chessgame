import javafx.scene.control.Button;
/**
 * This is a chess board display for Java FX
 *
 * Hiroki Nakayama
 */
public interface JavaFXChessBoardDisplay 
{

    /*
     * it displays the square with no piece on 
     * it takes Button, int row, and int column as inputs 
     */
    public void displayEmptySquare(Button button, int row, int column);

    /*
     * it displays the square with a piece on 
     * it takes Button, int row, and int col as inputs 
     */
    public void displayFilledSquare(Button button, int row, int column, ChessPiece piece);

    /*
     * it highlights a sqyare that the user chooses 
     * it takes Boolean highlight, Button, int row, int column, and chess piece as inputs 
     */
    public void highlightSquare(boolean highlight, Button button, int row, int column, ChessPiece piece);
}
