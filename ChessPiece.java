
/**
 * this is a chess piece class
 *
 * Hiroki Nakayama 
 */
public abstract class ChessPiece 
{
    // This field stores which side the piece belongs to 
    final ChessGame.Side side;

    //This field stores the chess board the peice belongs to 
    private ChessBoard chessBoard;

    //This field stores the row of the piece
    private int row;

    //This field stores the column of the piece 
    private int column;

    //this field stores the label of each piece
    private String label;

    /* This is the custom constructor of the chess piece class
     * it takes four inputs
     */
    ChessPiece(int row, int col, ChessGame.Side side, ChessBoard chessBoard)
    {
        this.setLocation(row, col);
        this.chessBoard = chessBoard;
        this.side = side;
    }

    /*
     * This method takes String value and returns nothing 
     * it setsthe label of the piece to the inut string value 
     */    
    public void setLabel(String label)
    {
        this.label = label;
    }

    /*
     * This merhod takes no inputs and returns the ChessGame.Side value 
     * it returns which sid ethe piece belongs to 
     * 
     */    public ChessGame.Side getSide()
    {
        return side;
    }

    /*
     * This is an abstract method 
     * it returns the string value of the label of each piece 
     */ 
    public abstract String getLabel();

    /*
     * This method returns the icon of the piece 
     */    
    public Object getIcon()
    {
        return null;   
    }

    /*This method take two integer inputs 
     * it sets the row and column pf the piece to the input 
     */
    public void setLocation(int row, int column)
    {
        this.row = row;
        this.column = column;
    }

    /* 
     * This method takes no inputs and returns the row of the piece 
     */
    public int getRow()
    {
        return row;
    }

    /*
     * This method takes no inputs and returns the int value
     * it returns the column of the piece
     */    
    public int getColumn()
    {
        return column;
    }

    /* This method takes two integer inputs 
     * This method checks if the selected piece is allowed to move to the selected row and column
     */ 
    public boolean isLegalMove(int toRow, int toColumn)
    {
        if(toRow > this.getChessBoard().getGameRules().getNumRows() || toColumn > this.getChessBoard().getGameRules().getNumColumns() || toRow < 0 || toColumn < 0)
        {
            return false;    
        }
        if(this.isLegalCaptureMove(toRow, toColumn) || this.isLegalNonCaptureMove(toRow, toColumn))
        {
            return true;   
        }
        return false;
    }

    /*
     * this method takes no inputs and retuns the ChessBoard 
     * it returns the chess baord which the piece belongs to 
     */
    ChessBoard getChessBoard()
    {
        return chessBoard;
    }

    /* This method takes two integer inputs
     * it checks if the piece is allowed to move to the selected row and column assuming there is no piece on the specific square
     */
    public abstract boolean isLegalNonCaptureMove(int row, int column);

    /* 
     * This method takes two integer inputs
     * it checks if the piece is allowed to move to the selected rwo and column assuming there is a piece of either the same or opponenet side on the specific square 
     */
    public boolean isLegalCaptureMove(int toRow, int toColumn)
    {
        if(this.getChessBoard().hasPiece(toRow, toColumn) == false)
        {
            return false;
        }
        else if(this.getChessBoard().getPiece(toRow, toColumn).getSide() != this.getSide() && isLegalNonCaptureMove(toRow, toColumn))
        {
            return true;
        }
        return false;
    }

    /*
     * this method takes no inputs and returns nothing
     * it processes ay addition events after the move is done 
     */
    public void moveDone()
    {
        ;
    }
}
