import javax.swing.JOptionPane;
/**
 * This is a pawn piece class
 *
 * Hiroki Nakayama
 */
public class PawnPiece extends ChessPiece implements Vertical, Diagnol
{
    //This fied stores the number of times each pawn piece completed the move
    private int moveCount = 0;
    
    /* this is the custom constructor of the pawn piece class
     * it takes the row and column of the piece, the side of the piece and the board that the piece belngs to as inputs 
     */
    public PawnPiece(int row, int column, ChessGame.Side Side, ChessBoard chessBoard)
    {
        super(row, column,Side,chessBoard);
        super.setLabel("P");
    }

    //This method return the symbol of a pawn piece
    @Override
    public String getLabel()
    {
        return "P";
    }

    /* This method takes two integer inputs 
     * it checks if the selected row and column are in the range of pawn's movement 
     * it returns true if it is, otherwise returns false
     */
    public boolean isLegalNonCaptureMove(int toRow, int toColumn)
    {
        //This returns false if the piece is trying to move to any where other than vertical forward
        if(this.getSide().equals(ChessGame.Side.NORTH) && toRow < this.getRow())
        {
            return false;
        }
        else if(this.getSide().equals(ChessGame.Side.SOUTH) && toRow > this.getRow())
        {
            return false;
        }
        else if(this.getSide().equals(ChessGame.Side.EAST) && toColumn > this.getColumn())
        {
            return false;
        }
        else if(this.getSide().equals(ChessGame.Side.WEST) && toColumn < this.getColumn())
        {
            return false;
        }

        if (moveCount == 0 && this.isAllowedVertical(toRow, toColumn, this, 2) && this.getChessBoard().hasPiece(toRow, toColumn) == false)
        {
            return true;
        }
        else if (moveCount != 0 && this.isAllowedVertical(toRow, toColumn, this, 1) && this.getChessBoard().hasPiece(toRow, toColumn) == false)
        {
            return true;   
        }
        return false;
    }

    /* This is a helper method to check if the piece has reached the last row of the opponent side
     * This method takes two interger inputs
     * It returns true if the pawn piece reaches the last row of the opponent side
     */
    protected boolean lastTwoRows(int row, int col)
    {
        //These if else statements check if the piece is in the last row of the opponent side based on the side of the piece.
        if(this.getSide().equals(ChessGame.Side.NORTH))
        {
            if(this.getChessBoard().getGameRules().getNumRows() - 1 == row)
            {
                return true;
            }
        }
        else if(this.getSide().equals(ChessGame.Side.SOUTH))
        {
            if(row == 0)
            {
                return true;
            }
        }
        else if(this.getSide().equals(ChessGame.Side.EAST))
        {
            if(col == 0)
            {
                return true;
            }
        }
        else if(this.getSide().equals(ChessGame.Side.WEST))
        {
            if (this.getChessBoard().getGameRules().getNumColumns() - 1 ==  col)
            {
                return true;
            }
        }
        return false;
    }

    /* This method checks to see if the piece is allowed to capture the piece at the selected row and column
     * the method takes two integers inpiuts 
     */
    @Override
    public boolean isLegalCaptureMove(int toRow, int toColumn)
    {
        //This checks to see if tehre is opponent side of piece at front diagnol position based on its side
        if(this.getSide().equals(ChessGame.Side.NORTH) && (toRow - this.getRow() == 1 && toColumn - this.getColumn() == 1 || this.getColumn() - toColumn == 1) && 
        (this.getChessBoard().getPiece(toRow,toColumn).getSide() != this.getSide()))
        {
            return true;
        }
        else if(this.getSide().equals(ChessGame.Side.SOUTH) && this.getRow() - toRow == 1 && (toColumn - this.getColumn() == 1 || this.getColumn() - toColumn == 1) && 
        this.getChessBoard().getPiece(toRow,toColumn).getSide() != this.getSide())
        {
            return true;
        }
        else if(this.getSide().equals(ChessGame.Side.EAST) && this.getColumn() - toColumn == 1 && (toRow - this.getRow() == 1 || this.getRow() - toRow == 1) && 
        this.getChessBoard().getPiece(toRow,toColumn).getSide() != this.getSide())
        {
            return true;
        }
        else if(this.getSide().equals(ChessGame.Side.WEST) && toColumn - this.getColumn() == 1 && (toRow - this.getRow() == 1 || this.getRow() - toRow == 1) && 
        this.getChessBoard().getPiece(toRow,toColumn).getSide() != this.getSide())
        {
            return true;
        }
        return false;
    }

    /* This method takes no input and does not return anything 
     * if the piece is at the last row of the opponent side, it asks the player what piece he/she wants to replace the pawn piece with
     */
    public void moveDone()
    {
        moveCount++;
        int toRow = this.getRow(); // this stores the current row of the piece 
        int toColumn = this.getColumn(); // this stores the current column of the piece 
        
        // this asks user what piece they want to replace the pawn piece with if the piece is in the last row of the opponent side
        if(this.lastTwoRows(toRow, toColumn))
        {
            //this is the user input and stores what piece they want to replace the pawn piece with by storing the number associated with the piece
            String newPiece = JOptionPane.showInputDialog("Choose the piece. 1: Queen, 2: Knight, 3: Bishop, 4: Rook. Please place quotation mark around the number");
            if(newPiece.equals("1"))
            {
                QueenPiece newQueenPiece = new QueenPiece(toRow, toColumn, this.getSide(), super.getChessBoard());
                this.getChessBoard().removePiece(toRow, toColumn);
                this.getChessBoard().addPiece(newQueenPiece, toRow, toColumn);
            }
            else if(newPiece.equals("2"))
            {
                KnightPiece newKnightPiece = new KnightPiece(toRow, toColumn, this.getSide(), super.getChessBoard());
                this.getChessBoard().removePiece(toRow, toColumn);
                this.getChessBoard().addPiece(newKnightPiece, toRow, toColumn);
            }
            else if(newPiece.equals("3"))
            {
                BishopPiece newBishopPiece = new BishopPiece(toRow, toColumn, this.getSide(), super.getChessBoard());
                this.getChessBoard().removePiece(toRow, toColumn);
                this.getChessBoard().addPiece(newBishopPiece, toRow, toColumn);
            }
            else if(newPiece.equals("4"))
            {
                RookPiece newRookPiece = new RookPiece(toRow, toColumn, this.getSide(), super.getChessBoard());
                this.getChessBoard().removePiece(toRow, toColumn);
                this.getChessBoard().addPiece(newRookPiece, toRow, toColumn);
            }
        }
    }
}
