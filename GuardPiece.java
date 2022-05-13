
/**
 * This is a GuardPiece class
 *
 * Hiroki Nakayama 
 */
public class GuardPiece extends ChessPiece implements Diagnol
{
    
    /*
     * This is a custom constructor of the GuardPiece
     * it takes int row and column and side of the piece and the chess board which the piece belongs to 
     */  
    public GuardPiece(int row, int column, ChessGame.Side Side, ChessBoard chessBoard)
    {
        super(row, column,Side,chessBoard);
        super.setLabel("G");
    }

    /*
     * This method takes no inputs and returns the string value 
     * it returns the symbol of the GuardPiece
     */
    public String getLabel()
    {
        return "G";   
    }

    /* 
     * This method takes two integer inputs 
     * it checks if the selected row and column are in the range of GuardPiece's movement 
     * it returns true if it is, otherwise returns false
     */
    public boolean isLegalNonCaptureMove(int row, int column)
    {
        //This if else statement makes sure the piece does not move out of the speficied squares 
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
        
        if(this.isAllowedDiagnol(row, column, this, 1))
        {
            return true;
        }
        else
        {
            return false;   
        }
    }
}
