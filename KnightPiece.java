
/**
 * Write a description of class KnightPiece here.
 *
 * Hiroki Nakayama
 * @version (a version number or a date)
 */
public class KnightPiece extends ChessPiece
{
    /* this is the custom constructor of the pawn piece class
     * it takes the row and column of the piece, the side of the piece and the board that the piece belngs to as inputs 
     */
    public KnightPiece(int row, int column, ChessGame.Side Side, ChessBoard chessBoard)
    {
        super(row, column,Side,chessBoard);
        super.setLabel("N");
    }

    //This method returns the symbol of the knight piece
    @Override
    public String getLabel()
    {
        return "N";
    }

    /* This method takes two integer inputs 
     * it checks if the selected row and column are in the range of pawn's movement 
     * it returns true if it is, otherwise returns false
     */
    public boolean isLegalNonCaptureMove(int toRow, int toColumn)
    {
        if(toColumn == this.getColumn() || this.getRow() == toRow)
        {
            return false;   
        }
        else if(toRow - this.getRow() == 1 || this.getRow() - toRow == 1 && toColumn - this.getColumn() == 2 || this.getColumn() - toColumn == 2 || 
                toRow - this.getRow() == 2 || this.getRow() - toRow == 2 && toColumn - this.getColumn() == 1 || this.getColumn() - toColumn == 1)
        {
            return true;
        }
        return false;
    }
}
