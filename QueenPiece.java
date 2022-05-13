
/**
 * This is a Queen Piece class
 *
 * Hiroki Nakayama
 */
public class QueenPiece extends ChessPiece implements Horizontal, Vertical, Diagnol
{
    /* this is the custom constructor of the pawn piece class
     * it takes the row and column of the piece, the side of the piece and the board that the piece belngs to as inputs 
     */
    public QueenPiece(int row, int column, ChessGame.Side Side, ChessBoard chessBoard)
    {
        super(row, column, Side, chessBoard);
        super.setLabel("Q");
    }

    //This method returns the symbol of the queen piece
    @Override
    public String getLabel()
    {
        return "Q";
    }

    /* This method takes two integer inputs 
     * it checks if the selected row and column are in the range of pawn's movement 
     * it returns true if it is, otherwise returns false
     */
    public boolean isLegalNonCaptureMove(int toRow, int toColumn)
    {
        if(this.isAllowedHorizontal(toRow, toColumn, this, this.getChessBoard().getGameRules().getNumRows()) || 
        this.isAllowedVertical(toRow, toColumn, this,this.getChessBoard().getGameRules().getNumColumns()) || 
        this.isAllowedDiagnol(toRow, toColumn, this, this.getChessBoard().getGameRules().getNumRows()))
        {
            return true;
        }
        return false;
    }
}
