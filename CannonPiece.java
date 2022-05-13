
/**
 * This is a class for Cannon Piece 
 *
 * Hiroki Nakayama
 */
public class CannonPiece extends ChessPiece implements Vertical, Horizontal 
{
    /*
     * This is a custom constructor of the CannonPiece
     * it takes int row and column and side of the piece and the chess board which the piece belongs to 
     */  
    public CannonPiece(int row, int column, ChessGame.Side Side, ChessBoard chessBoard)
    {
        super(row, column,Side,chessBoard);
        super.setLabel("C");
    }

    /*
     * This method takes no inputs and returns the string value 
     * it returns the symbol of the CannonPiece
     */
    public String getLabel()
    {
        return "C";   
    }

    /* 
     * This method takes two integer inputs 
     * it checks if the selected row and column are in the range of cannonPiece's movement 
     * it returns true if it is, otherwise returns false
     */
    public boolean isLegalNonCaptureMove(int row, int column)
    {
        if(this.isAllowedHorizontal(row, column, this, this.getChessBoard().getGameRules().getNumRows()) || 
        this.isAllowedVertical(row, column, this, this.getChessBoard().getGameRules().getNumColumns()))
        {
            return true;
        }
        else
        {
            return false;   
        }
    }

    /*
     * This is an overriden version of the isLegalCaptureMove method from the chessPiece class 
     * This method returns true if there is only none or one piece between this piece and the piece that this piece attempts to capture 
     */
    @Override
    public boolean isLegalCaptureMove(int row, int column)
    {
        int count = 0;//This keeps track of number of pieces between this piece and the piece that this piece tries to capture
        if(row > this.getRow() && column == this.getColumn())
        {
            //This loop checks every square between this piece and piece at specified square to check if there is a piece 
            for(int r = this.getRow() + 1; r < row; r++)
            {
                if(this.getChessBoard().hasPiece(r, column))
                {
                    count++;
                }
                if(count == 2)
                {
                    return false;   
                }
            }
        }
        else if(row < this.getRow() && column == this.getColumn())
        {
            //This loop checks every square between this piece and piece at specified square to check if there is a piece 
            for(int r = this.getRow() - 1; r > row; r--)
            {
                if(this.getChessBoard().hasPiece(r, column))
                {
                    count++;
                }
                if(count == 2)
                {
                    return false;   
                }
            }
        }
        else if(row == this.getRow() && column > this.getColumn())
        {
            //This loop checks every square between this piece and piece at specified square to check if there is a piece 
            for(int c = this.getColumn() + 1; c < column; c++)
            {
                if(this.getChessBoard().hasPiece(row, c))
                {
                    count++;
                }
                if(count == 2)
                {
                    return false;
                }
            }
        }
        else
        {
            //This loop checks every square between this piece and piece at specified square to check if there is a piece 
            for(int c = this.getColumn() - 1; c > column; c--)
            {
                if(this.getChessBoard().hasPiece(row, c))
                {
                    count++;
                }
                if(count == 2)
                {
                    return false;
                }
            }
        }

        if(!this.getChessBoard().hasPiece(row, column))
        {
            return false;   
        }
        else if(this.getChessBoard().getPiece(row, column).getSide() != this.getSide() && 
        (row != this.getRow() && column == this.getColumn()) || (row == this.getRow() && column != this.getColumn()))
        {
            return true;
        }
        return false;
    }
}
