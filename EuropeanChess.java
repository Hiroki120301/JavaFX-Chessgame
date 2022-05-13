
/**
 * This is an european cheess class
 *
 * Hiroki Nakayama 
 */
public class EuropeanChess implements ChessGame
{
    //this field stores the side of the player 1
    final ChessGame.Side player1;

    //This field stores the side of the player 2 
    final ChessGame.Side player2;

    //this field stores value that indicates which side is playing currently
    private ChessGame.Side turn;

    //This field stores the number of rows 
    private final int numRows;

    //This stores the number of columns
    private final int numColumns;

    /*
     * This is the custom constructor of the European Chess class
     * It takes two ChessGame.Side values as inputs 
     */
    public EuropeanChess(ChessGame.Side player1, ChessGame.Side player2)
    {
        this.player1 = player1;
        this.player2 = player2;
        this.turn = player1; 
        this.numRows = 8;
        this.numColumns = 8;
    }

    /*
     * This method takes ChessPiece, int row, and int col as inputs 
     * it checks if the player is able to play the selected piece the specified row and column 
     */
    public boolean legalPieceToPlay(ChessPiece piece, int row, int column)
    {
        if(this.getTurn() == piece.getSide())
        {
            return true;
        }
        return false; 
    }

    /* This method takes chess piece input and two integer inputs 
     * it checks to see if the selected piece is allowed to move to selected sqaure 
     * if so, it returns true and it removes the piece from the suare if there is any and moves the piece to the selected square 
     * Then, it processes any additional movement that is suppsoed to happen after the move is done and switch the turn 
     */
    public boolean makeMove(ChessPiece piece, int toRow, int toColumn)
    {
        if(piece.isLegalMove(toRow, toColumn))
        {
            if(piece.isLegalNonCaptureMove(toRow, toColumn))
            {
                piece.getChessBoard().removePiece(toRow,toColumn);
            }
            piece.getChessBoard().removePiece(piece.getRow(),piece.getColumn());
            piece.getChessBoard().addPiece(piece, toRow, toColumn);
            piece.moveDone();
            if(this.turn == player1)
            {
                this.setTurn(player2);   
            }
            else
            {
                this.setTurn(player1);   
            }
            return true;
        }
        return false;
    }

    /*
     * This method takes the side of the player
     * it set the turn to the input value 
     */
    public void setTurn(ChessGame.Side turn)
    {
        this.turn = turn;
    }

    /*
     * This method takes no inputs and returns the side of the current turn 
     */   
    public ChessGame.Side getTurn()
    {
        return this.turn;
    }

    /*
     * This is an overriden version of getRow method 
     * it returns the int value 
     */
    @Override
    public int getNumRows()
    {
        return numRows;   
    }

    /*
     * This method returns the number of columns
     */
    public int getNumColumns()
    {
        return numColumns;   
    }

    /*
     * This is an overriden version of startGame method from the chess game class
     */
    public void startGame(ChessBoard board)
    {
        board.addPiece(new KingPiece(0, 4, ChessGame.Side.NORTH, board), 0, 4);
        board.addPiece(new QueenPiece(0, 3, ChessGame.Side.NORTH, board), 0, 3);
        board.addPiece(new KnightPiece(0, 1, ChessGame.Side.NORTH, board), 0, 1);
        board.addPiece(new KnightPiece(0, 6, ChessGame.Side.NORTH, board), 0, 6);
        board.addPiece(new BishopPiece(0, 2, ChessGame.Side.NORTH, board), 0, 2);
        board.addPiece(new BishopPiece(0, 5, ChessGame.Side.NORTH, board), 0, 5);
        board.addPiece(new RookPiece(0, 0, ChessGame.Side.NORTH, board), 0, 0);
        board.addPiece(new RookPiece(0, 7, ChessGame.Side.NORTH, board), 0, 7);
        for(int i = 0; i < 8; i++)
        {
            board.addPiece(new PawnPiece(1, i, ChessGame.Side.NORTH, board), 1, i);
        }

        board.addPiece(new KingPiece(7, 4, ChessGame.Side.SOUTH, board), 7, 4);
        board.addPiece(new QueenPiece(7, 3, ChessGame.Side.SOUTH, board), 7, 3);
        board.addPiece(new KnightPiece(7, 1, ChessGame.Side.SOUTH, board), 7, 1);
        board.addPiece(new KnightPiece(7, 6, ChessGame.Side.SOUTH, board), 7, 6);
        board.addPiece(new BishopPiece(7, 5, ChessGame.Side.SOUTH, board), 7, 5);
        board.addPiece(new BishopPiece(7, 2, ChessGame.Side.SOUTH, board), 7, 2);
        board.addPiece(new RookPiece(7, 0, ChessGame.Side.SOUTH, board), 7, 0);
        board.addPiece(new RookPiece(7, 7, ChessGame.Side.SOUTH, board), 7, 7);
        for(int i = 0; i < 8; i++)
        {
            board.addPiece(new PawnPiece(6, i, ChessGame.Side.SOUTH, board), 6, i);
        }
    }
}
