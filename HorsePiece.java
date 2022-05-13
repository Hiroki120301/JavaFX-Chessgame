
/**
 * Write a description of class HorsePiece here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HorsePiece extends ChessPiece  
{
    /*
     * This is a custom constructor of the HorsePiece
     * it takes int row and column and side of the piece and the chess board which the piece belongs to 
     */  
    public HorsePiece(int row, int column, ChessGame.Side Side, ChessBoard chessBoard)
    {
        super(row, column,Side,chessBoard);
        super.setLabel("H");
    }

    /*
     * This method takes no inputs and returns the string value 
     * it returns the symbol of the HorsePiece
     */
    public String getLabel()
    {
        return "H";   
    }

    /* 
     * This method takes two integer inputs 
     * it checks if the selected row and column are in the range of HorsePiece's movement 
     * it returns true if it is, otherwise returns false
     */
    public boolean isLegalNonCaptureMove(int toRow, int toColumn)
    {
        //This if else statement makes sure that the piece is making a L shape move and not jumping over a piece
        if(toRow - this.getRow() == 2 && Math.abs(toColumn - this.getColumn()) == 1)
        {
            if(this.getChessBoard().hasPiece(this.getRow() + 1, this.getColumn()))
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        else if(Math.abs(toRow - this.getRow()) == 1 && toColumn - this.getColumn() == -2)
        {
            if(this.getChessBoard().hasPiece(this.getRow(), this.getColumn() -1))
            {
                return false;
            }
            else
            {
                return true;   
            }
        }
        else if(toRow - this.getRow() == -2 && Math.abs(toColumn - this.getColumn()) == 1)
        {
            if(this.getChessBoard().hasPiece(this.getRow() - 1, this.getColumn()))
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        else if(toColumn - this.getColumn() == 2 && Math.abs(this.getRow() - toRow) == 1)
        {
            if(this.getChessBoard().hasPiece(this.getRow(), this.getColumn() + 1))
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        return false;
    }
}
