
/**
 * This is a class for soldier piece 
 *
 * @Hiroki Nakayama
 */
public class SoldierPiece extends ChessPiece implements Vertical, Horizontal
{
    /*
     * This is a custom constructor of the SoldierPiece
     * it takes int row and column and side of the piece and the chess board which the piece belongs to 
     */  
    public SoldierPiece(int row, int column, ChessGame.Side Side, ChessBoard chessBoard)
    {
        super(row, column,Side,chessBoard);
        super.setLabel("S");
    }

    /*
     * This method takes no inputs and returns the string value 
     * it returns the symbol of the SoldierPiece
     */    
    public String getLabel()
    {
        return "S";   
    }

    /*
     * This method takes two integer inputs 
     * it checks if the selected row and column are in the range of SoldierPiece's movement 
     * it returns true if it is, otherwise returns false
     */  
    public boolean isLegalNonCaptureMove(int row, int column)
    {
        //This if else statement makes sure that the piece is making a proper move
        if(this.getSide().equals(ChessGame.Side.NORTH))
        {
            if(row < this.getRow())
            {
                return false;
            }
            if(this.getRow() > 4)
            {
                if(this.isAllowedVertical(row, column, this, 1) || this.isAllowedHorizontal(row, column, this, 1))
                {
                    return true;   
                }
                else
                {
                    return false;
                }
            }
            else
            {
                if(this.isAllowedVertical(row, column, this, 1))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        else if(this.getSide().equals(ChessGame.Side.SOUTH))
        {
            if(row > this.getRow())
            {
                return false;
            }
            if(this.getRow() < 5)
            {
                if(this.isAllowedVertical(row, column, this, 1) || this.isAllowedHorizontal(row, column, this, 1))
                {
                    return true;   
                }
                else
                {
                    return false;
                }
            }
            else
            {
                if(this.isAllowedVertical(row, column, this, 1))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        return false;
    }
}
