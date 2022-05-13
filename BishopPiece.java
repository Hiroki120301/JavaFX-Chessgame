
/**
 * This is a bishop piece class
 *
 * Hiroki Nakayama
 */
public class BishopPiece extends ChessPiece implements Diagnol
{
    /* this is the custom constructor of the pawn piece class
     * it takes the row and column of the piece, the side of the piece and the board that the piece belngs to as inputs 
     */
    public BishopPiece(int row, int column, ChessGame.Side Side, ChessBoard chessBoard)
    {
        super(row, column,Side,chessBoard);
        super.setLabel("B");
    }

    //This emthod returns the symbol of the bishop piece
    @Override
    public String getLabel()
    {
        return "B";
    }
    
    /* This method takes two integer inputs 
     * it checks if the selected row and column are in the range of pawn's movement 
     * it returns true if it is, otherwise returns false
     */
    public boolean isLegalNonCaptureMove(int toRow, int toColumn)
    {
        if(this.isAllowedDiagnol(toRow, toColumn, this, this.getChessBoard().getGameRules().getNumRows()))
        {
            return true;
        }
        return false;
    }
}
