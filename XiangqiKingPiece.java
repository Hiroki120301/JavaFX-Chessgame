
/**
 * This is XiangqiKingPiece class 
 *
 * Hiroki Nakayama 
 */
public class XiangqiKingPiece extends ChessPiece implements Vertical, Horizontal
{

    /*
     * This is a custom constructor of the XiangqiKingPiece
     * it takes int row and column and side of the piece and the chess board which the piece belongs to 
     */
    public XiangqiKingPiece(int row, int column, ChessGame.Side Side, ChessBoard chessBoard)
    {
        super(row, column,Side,chessBoard);
        super.setLabel("X");
    }

    /*
     * The method takes no input and returns the string value 
     * it returns the symbol of the piece 
     */
    public String getLabel()
    {
        return "X";   
    }

    /* 
     * This method takes two integer inputs 
     * it checks if the selected row and column are in the range of XiangqiKingPiece's movement 
     * it returns true if it is, otherwise returns false
     */
    public boolean isLegalNonCaptureMove(int row, int column)
    {
        
        //This is else statement check if the king is not moving out of the specified squares 
        if(this.getSide() == ChessGame.Side.NORTH)
        {
            if((column < 3 || column > 5) || row > 2)
            {
                return false;  
            }
        }
        else if(this.getSide() == ChessGame.Side.SOUTH)
        {
            if((column < 3 || column > 5) || row < 7)
            {
                return false;  
            }
        }

        if(this.isAllowedHorizontal(row, column, this, 1) || this.isAllowedVertical(row, column, this, 1))
        {
            return true;
        }
        else
        {
            return false;   
        }
    }
}
