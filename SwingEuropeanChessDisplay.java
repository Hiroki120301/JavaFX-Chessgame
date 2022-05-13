import javax.swing.JButton;
import java.awt.Color;
import javax.swing.Icon;
import java.awt.Toolkit;
/**
 * This is european display class for swing chess board 
 *
 * Hiroki Nakayama
 */
public class SwingEuropeanChessDisplay implements SwingChessBoardDisplay
{
    
  /* The primary color of the checkerboard */
  public static Color redColor   = Color.red;
  
  /* The secondary color of the checkerboard */
  public static Color blackColor = Color.black;
  
  /* The color of the SOUTH player */
  public static Color southPlayerColor = Color.yellow;
  
  /* The color of the NORTH player */
  public static Color northPlayerColor = Color.green;
  
  /* The color of the EAST player */
  public static Color eastPlayerColor = Color.white;
  
  /* The color of the WEST player */
  public static Color westPlayerColor = Color.gray;
  
  /*The color used to highlight a square */
  public static Color highlightColor = Color.blue;
  
  /*
   * it displays the square with no piece on 
   * it takes JButton, int row, and int column as inputs 
   */
  public void displayEmptySquare(JButton button, int row, int column) {
    button.setBackground((row + column) % 2 == 0 ? Color.black : Color.red);
    button.setText(null);
    button.setIcon(null);
  }
  
  /*
   * it displays the square with a piece on 
   * it takes JButton, int row, and int col as inputs 
   */
  public void displayFilledSquare(JButton button, int row, int column, ChessPiece piece) {
     //This stores the color of the players 
    Color pieceColor;
    
    switch (piece.getSide()) {
      case NORTH:   pieceColor = northPlayerColor;
                    break;
      case SOUTH:   pieceColor = southPlayerColor;
                    break;
      case EAST:    pieceColor = eastPlayerColor;
                    break;
      default:      pieceColor = westPlayerColor;
    }
    
    button.setBackground(pieceColor);
    button.setText(piece.getLabel());
    button.setIcon((Icon)piece.getIcon());
  }
  
  /*
   * it highlights a sqyare that the user chooses 
   * it takes Boolean highlight, JButton, int row, int column, and chess piece as inputs 
   */
  public void highlightSquare(boolean highlight, JButton button, int row, int column, ChessPiece piece) {
    if (highlight) {
      button.setBackground(highlightColor);
    }
    else if (piece == null)
      displayEmptySquare(button, row, column);
    else
      displayFilledSquare(button, row, column, piece);
  }
}
