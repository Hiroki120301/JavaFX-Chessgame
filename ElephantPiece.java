
/**
 * This is a class for ElephantPiece
 *
 * Hiroki Nakayama
 */
public class ElephantPiece extends ChessPiece implements Diagnol
{
    
    /*
     * This is a custom constructor of the ElephantPiece
     * it takes int row and column and side of the piece and the chess board which the piece belongs to 
     */  
    public ElephantPiece(int row, int column, ChessGame.Side Side, ChessBoard chessBoard)
    {
        super(row, column,Side,chessBoard);
        super.setLabel("E");
    }

    /*
     * This method takes no inputs and returns the string value 
     * it returns the symbol of the ElephantPiece
     */
    public String getLabel()
    {
        return "E";   
    }

    /* 
     * This method takes two integer inputs 
     * it checks if the selected row and column are in the range of ElephantPiece's movement 
     * it returns true if it is, otherwise returns false
     */
    public boolean isLegalNonCaptureMove(int row, int column)
    {
        if(Math.abs(this.getRow() - row) != 2 || Math.abs(this.getColumn() - column) != 2)
        {
            return false;
        }
        else if(this.getRow() < 5 && row > 5)
        {
            return false;   
        }
        else if(this.getRow() > 4 && row < 5)
        {
            return false;   
        }
        if(this.isAllowedDiagnol(row, column, this, 2))
        {
            return true;
        }
        else
        {
            return false;   
        }
    }
}
