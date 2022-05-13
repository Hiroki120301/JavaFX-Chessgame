/**
 * An interface that encodes specific rules for a version of chess.
 * 
 * @author Hiroki Nakayama
 */
public interface ChessGame 

{

    /*
     * The "side" or "team" or "player" the piece belongs to.  
     * The "players" are able to play north vs south or east vs west game 
     */
    public enum Side 
    {NORTH, SOUTH, EAST, WEST};

    /*
     * This method takes chess piece, int row, and int column as inputs 
     * it checks to see if the user is allowed to choose the piece and play it 
     */
    public boolean legalPieceToPlay(ChessPiece piece, int row, int column);

    /*
     * This method takes chess piece, int row, int column as inputs and it returns boolean variable 
     * it checks to see if the user is allowed to move the piece to selected square 
     */
    public boolean makeMove(ChessPiece piece, int toRow, int toColumn);

    /*
     * the method takes chess piece, int row, and int column as inputs and it returns the boolean variable 
     * it checks to see if the user is allowed to switch the piece that he/she selected previously 
     */
    public default boolean canChangeSelection(ChessPiece piece) 
    {
        return true;
    }

    /* 
     * This method takes no inputs and returns the int value 
     * it returns the number of rows of the game 
     */  
    public int getNumRows();

    /*
     * This method takes no inputs and returns the int value 
     * it returns the number of columns of the game 
     */
    public int getNumColumns();

    /*
     * This method takes chess board as an input and returns nothing
     * it places all the necessary pieces on the chess board to start the game 
     */
    public void startGame(ChessBoard board);
}