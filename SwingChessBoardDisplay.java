import javax.swing.JButton;
/**
 * This is an interface of display for swing chess board 
 *
 * @Hiroki Nakayama 
 */
public interface SwingChessBoardDisplay extends ChessBoardDisplay
{

    /*
     * it displays the square with no piece on 
     * it takes JButton, int row, and int column as inputs 
     */
    public void displayEmptySquare(JButton button, int row, int column);

    /*
     * it displays the square with a piece on 
     * it takes JButton, int row, and int col as inputs 
     */
    public void displayFilledSquare(JButton button, int row, int column, ChessPiece piece);

    /*
     * it highlights a sqyare that the user chooses 
     * it takes Boolean highlight, JButton, int row, int column, and chess piece as inputs 
     */
    public void highlightSquare(boolean highlight, JButton button, int row, int column, ChessPiece piece);
}
