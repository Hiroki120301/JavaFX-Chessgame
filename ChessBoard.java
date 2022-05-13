import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * This is a chess board  interface 
 * 
 * Hiroki Nakayama
 */
public interface ChessBoard 
{
    /* 
     * This method tajes chess piece, number of rows and columns as inputs 
     * It places the  piece to specified row and column 
     */
    public void addPiece(final ChessPiece piece, final int row, final int col);

    /* this method takes number of rows and columns as inputs 
     * it removes a piece from the specified row and column 
     */
    public ChessPiece removePiece(final int row, final int col);

    /* This method take row and column as inputs 
     * it returns true if there is a piece at specified suqare
     * returns false otherwise
     */
    public boolean hasPiece(int row, int col);

    /* This method takes row and coulmn as inputs 
     * it returns the piece from the piece from the specified square
     */
    public ChessPiece getPiece(int row, int col);

    /* 
     * This method takes no inputs and returns the ChessGame associated with this chess board 
     */
    public ChessGame getGameRules();

    /* this method takes row, column, and piece as inputs 
     * it checks to see if the square between piece's current position and row and column has been or will be threatened 
     */
    public default boolean squareThreatened(int row, int column, ChessPiece piece) 
    {

        //this loop goes through every square between piece's current position and specified row and column
        for (int i = 0; i < piece.getChessBoard().getGameRules().getNumRows(); i++) {
            for (int j = 0; j < piece.getChessBoard().getGameRules().getNumColumns(); j++) 
            {
                if (hasPiece(i,j) && getPiece(i, j).getSide() != piece.getSide() &&
                getPiece(i, j).isLegalMove(row, column))
                {
                    return true;
                }
            }
        }
        return false;
    }
}

