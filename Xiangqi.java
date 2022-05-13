
/**
 * This is a Xiangqi chess game class
 *
 * Hiroki Nakayama
 */
public class Xiangqi implements ChessGame
{
    //this field stores the side of the player 1
    final ChessGame.Side player1;

    //This field stores the side of the player 2 
    final ChessGame.Side player2;

    //this field stores value that indicates which side is playing currently
    private ChessGame.Side turn;

    //this stores the number of rows for the game 
    private final int numRows;

    //This stores the number of the columns for the game 
    private final int numColumns;

    /*
     * This is the custom constructor of the European Chess class
     * It takes two ChessGame.Side values as inputs 
     */
    public Xiangqi(ChessGame.Side player1, ChessGame.Side player2)
    {
        this.player1 = player1;
        this.player2 = player2;
        this.turn = player1; 
        this.numRows = 10;
        this.numColumns = 9;
    }

    /*
     * the method takes the ChessPiece, int row, int column as inputs and returns the boolean value 
     * it checks if the player can play the piece 
     */
    public boolean legalPieceToPlay(ChessPiece piece, int row, int column)
    {
        if(this.getTurn() == piece.getSide())
        {
            return true;
        }
        return false; 
    }

    /*
     * This method takes chess piece input and two integer inputs 
     * it checks to see if the selected piece is allowed to move to selected sqaure 
     * if so, it returns true and it removes the piece from the suare if there is any and moves the piece to the selected square 
     * Then, it processes any additional movement that is suppsoed to happen after the move is done and switch the turn 
     */
    public boolean makeMove(ChessPiece piece, int toRow, int toColumn)
    {
        /*
         * This if else statement is for the game north vs south 
         * it prevents the king facing situation 
         */
        if(toColumn != piece.getColumn())
        {
            if(piece.getSide() == ChessGame.Side.NORTH || piece.getSide() == ChessGame.Side.SOUTH)
            {
                boolean kingExist = false; //this gets set to true if there is a king piece in front of the piece and there is no other piece in between 

                boolean kingExist2 = false; //this gets set to true if there is a king piece behind the piece and there is no other piece in between 

                boolean pieceExist = false; //This stores if the non king piece exists 

                //it checks every square in fornt of the square and if the piece is instance of the king piece 
                for(int row = piece.getRow() + 1; row < this.getNumRows() && !kingExist && !pieceExist; row++)
                {
                    if(piece.getChessBoard().hasPiece(row, piece.getColumn()))
                    {
                        if(piece.getChessBoard().getPiece(row, piece.getColumn()) instanceof XiangqiKingPiece)
                        {
                            kingExist = true;
                        }
                        else
                        {
                            pieceExist = true;
                        }
                    }
                }

                pieceExist = false;

                //it checks every square behind the piece and if the piece is the instance of the king piece 
                for(int row = piece.getRow() - 1; row >= 0 && !kingExist2 && !pieceExist; row--)
                {
                    if(piece.getChessBoard().hasPiece(row, piece.getColumn()))
                    {
                        if(piece.getChessBoard().getPiece(row, piece.getColumn()) instanceof XiangqiKingPiece)
                        {
                            kingExist2 = true;
                        }
                        else
                        {
                            pieceExist = true;   
                        }
                    }
                }

                System.out.println(kingExist);
                System.out.println(kingExist2);

                //it returns false if both of the local boolean variable is true or either of them is true and the piece is the isnatnce of the king piece 
                if(kingExist && kingExist2 || (piece instanceof XiangqiKingPiece && (kingExist || kingExist2)))
                {
                    return false;   
                }
            }
        }

        /*
         * This if else statement is for the game east vs west 
         * it prevents the king facing situation 
         */
        if(toRow != piece.getRow())
        {
            if(piece.getSide() == ChessGame.Side.EAST || piece.getSide() == ChessGame.Side.WEST)
            {
                boolean kingExist = false; //this gets set to true if there is a king piece in front of the piece and there is no other piece in between 

                boolean kingExist2 = false; //this gets set to true if there is a king piece behind the piece and there is no other piece in between 

                boolean pieceExist = false; //This indicates if the piece exist between two kings 

                //it checks every square in fornt of the square and if the piece is instance of the king piece 
                for(int col = piece.getColumn() + 1; col < this.getNumColumns() && !kingExist && !pieceExist; col++)
                {
                    if( piece.getChessBoard().hasPiece(toRow, col) && piece.getChessBoard().getPiece(toRow, col) instanceof XiangqiKingPiece)
                    {
                        kingExist = false;
                    }
                    else
                    {
                        pieceExist = true;   
                    }
                }

                //it checks every square behind the piece and if the piece is the instance of the king piece
                for(int col = piece.getColumn() - 1; col < this.getNumColumns() && !kingExist2 && !pieceExist; col--)
                {
                    if(piece.getChessBoard().hasPiece(toRow, col) && piece.getChessBoard().getPiece(toRow, col) instanceof XiangqiKingPiece)
                    {
                        kingExist2 = false;
                    }
                    else
                    {
                        pieceExist = true;   
                    }
                }

                //it returns false if both of the local boolean variable is true or either of them is true and the piece is the isnatnce of the king piece 
                if(kingExist && kingExist2 || (piece instanceof XiangqiKingPiece && (kingExist || kingExist2)))
                {
                    return false;   
                }
            }
        }

        if(piece.isLegalMove(toRow, toColumn))
        {
            if(piece.isLegalNonCaptureMove(toRow, toColumn))
            {
                piece.getChessBoard().removePiece(toRow, toColumn);
            }
            piece.getChessBoard().removePiece(piece.getRow(), piece.getColumn());
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
        board.addPiece(new XiangqiKingPiece(0, 4, ChessGame.Side.NORTH, board), 0, 4);
        board.addPiece(new GuardPiece(0, 3, ChessGame.Side.NORTH, board), 0, 3);
        board.addPiece(new GuardPiece(0, 5, ChessGame.Side.NORTH, board), 0, 5);
        board.addPiece(new ElephantPiece(0, 6, ChessGame.Side.NORTH, board), 0, 6);
        board.addPiece(new ElephantPiece(0, 2, ChessGame.Side.NORTH, board), 0, 2);
        board.addPiece(new HorsePiece(0, 1, ChessGame.Side.NORTH, board), 0, 1);
        board.addPiece(new HorsePiece(0, 7, ChessGame.Side.NORTH, board), 0, 7);
        board.addPiece(new RookPiece(0, 0, ChessGame.Side.NORTH, board), 0, 0);
        board.addPiece(new RookPiece(0, 8, ChessGame.Side.NORTH, board), 0, 8);
        board.addPiece(new CannonPiece(2, 1, ChessGame.Side.NORTH, board), 2, 1);
        board.addPiece(new CannonPiece(2, 7, ChessGame.Side.NORTH, board), 2, 7);
        
        //This for loop places the soldier pieces to specified square with NORTH side assigned to each piece 
        for(int i = 0; i < 9; i++)
        {
            board.addPiece(new SoldierPiece(3, i, ChessGame.Side.NORTH, board), 3, i);
            i++;
        }

        board.addPiece(new XiangqiKingPiece(9, 4, ChessGame.Side.SOUTH, board), 9, 4);
        board.addPiece(new GuardPiece(9, 3, ChessGame.Side.SOUTH, board), 9, 3);
        board.addPiece(new GuardPiece(9, 5, ChessGame.Side.SOUTH, board), 9, 5);
        board.addPiece(new ElephantPiece(9, 6, ChessGame.Side.SOUTH, board), 9, 6);
        board.addPiece(new ElephantPiece(9, 2, ChessGame.Side.SOUTH, board), 9, 2);
        board.addPiece(new HorsePiece(9, 1, ChessGame.Side.SOUTH, board), 9, 1);
        board.addPiece(new HorsePiece(9, 7, ChessGame.Side.SOUTH, board), 9, 7);
        board.addPiece(new RookPiece(9, 0, ChessGame.Side.SOUTH, board), 9, 0);
        board.addPiece(new RookPiece(9, 8, ChessGame.Side.SOUTH, board), 9, 8);
        board.addPiece(new CannonPiece(7, 1, ChessGame.Side.SOUTH, board), 7, 1);
        board.addPiece(new CannonPiece(7, 7, ChessGame.Side.SOUTH, board), 7, 7);
        
        //This for loop places the soldier pieces to specified square with SOUTH side assigned to each piece
        for(int i = 0; i < 9; i++)
        {
            board.addPiece(new SoldierPiece(6, i, ChessGame.Side.SOUTH, board), 6, i);
            i++;
        }
    }
}
