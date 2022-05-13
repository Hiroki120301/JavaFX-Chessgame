
/**
 * This is a rook piece class
 *
 * Hiroki Nakayama
 */
public class RookPiece extends ChessPiece implements Horizontal, Vertical
{
    //This field stores how many moves the piece has completed
    private int moveCount = 0;
    
    /* this is the custom constructor of the pawn piece class
     * it takes the row and column of the piece, the side of the piece and the board that the piece belngs to as inputs 
     */
    public RookPiece(int row, int column, ChessGame.Side Side, ChessBoard chessBoard)
    {
        super(row, column,Side,chessBoard);
        super.setLabel("R");
    }
    
    //this returns the symbol of rook piece
    @Override
    public String getLabel()
    {
       return "R";
    }
    
    /* This method takes two integer inputs 
     * it checks if the selected row and column are in the range of pawn's movement 
     * it returns true if it is, otherwise returns false
     */
    public boolean isLegalNonCaptureMove(int toRow, int toColumn)
    {
        if(this.isAllowedHorizontal(toRow, toColumn, this, this.getChessBoard().getGameRules().getNumRows()) || this.isAllowedVertical(toRow, toColumn, this, this.getChessBoard().getGameRules().getNumColumns()))
        {
            return true;
        }
        return false;
    }
    
    //This method returns the move count of the rook piece
    protected int getMoveCount()
    {
     return moveCount;   
    }
    
    //This move done increments the moveCount every time the piece moves
    public void moveDone()
    {
     moveCount++;   
    }
}
