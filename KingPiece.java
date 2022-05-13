/**
 * This is a king piece class
 *
 * Hiroki Nakayama
 */
public class KingPiece extends ChessPiece implements Horizontal, Vertical, Diagnol
{
    //This field stores how many moves the piece has completed
    private int moveCount = 0;

    //This field stores if the king piece has doen castle move 
    private boolean castleMove = false;

    //This field stores the rook piece which the king has done the castle move with 
    private RookPiece castlePiece = null;

    /* this is the custom constructor of the pawn piece class
     * it takes the row and column of the piece, the side of the piece and the board that the piece belngs to as inputs 
     */
    public KingPiece(int row, int column, ChessGame.Side Side, ChessBoard chessBoard)
    {
        super(row, column,Side,chessBoard);
        super.setLabel("K");
    }

    //This method returns the symbol of the king piece
    @Override
    public String getLabel()
    {
        return "K";
    }

    /* This method takes two integer inputs 
     * it checks if the selected row and column are in the range of pawn's movement 
     * it returns true if it is, otherwise returns false
     */
    public boolean isLegalNonCaptureMove(int toRow, int toColumn)
    {
        ChessBoard board = this.getChessBoard();//this stores the board which the piece belongs to 
        
        //These if else statements check if the king is allowed to do the casle move when the user chooses to move the piece two spaces right or left
        if(moveCount == 0 && (toColumn - this.getColumn() == 2 || this.getColumn() - toColumn == 2) && 
          (this.getSide().equals(ChessGame.Side.NORTH) || this.getSide().equals(ChessGame.Side.SOUTH)))
        {
            if(board.getPiece(this.getRow(), 0) instanceof RookPiece && board.getPiece(this.getRow(), 0).getSide() == this.getSide())
            {
                castlePiece = (RookPiece)board.getPiece(this.getRow() , 0); //This local variable stores the the piece that the king is doing castle move with
                if(castlePiece.getMoveCount() == 0)
                {
                    
                    //This loop checks if the space between king and rook has not been threatened or there is no other piece between them 
                    for(int i = this.getColumn() - 1; i > 0; i--)
                    {
                        if(board.hasPiece(this.getRow(), i))
                        {
                            return false;   
                        }
                        else if (this.getChessBoard().squareThreatened(this.getRow(), i, this))
                        {
                            return false;   
                        }
                    }
                    castleMove = true;
                    return true;
                }
            }
            else if(toColumn - this.getColumn() == 2 && board.hasPiece(this.getRow(), board.getGameRules().getNumColumns() - 1) && 
                    board.getPiece(this.getRow() , board.getGameRules().getNumColumns()-1) instanceof RookPiece && 
                    board.getPiece(this.getRow() , board.getGameRules().getNumColumns()-1).getSide() == this.getSide())
            {
                castlePiece = (RookPiece)board.getPiece(this.getRow() , board.getGameRules().getNumColumns()-1); //This local variable stores the the piece that the king is doing castle move with
                if(castlePiece.getMoveCount() == 0)
                {
                    
                    //This loop checks if the space between king and rook has not been threatened or there is no other piece between them
                    for(int i = this.getColumn() + 1; i < board.getGameRules().getNumColumns() - 1; i++)
                    {
                        if(board.hasPiece(this.getRow(), i))
                        {
                            return false;   
                        }
                        else if (this.getChessBoard().squareThreatened(this.getRow(), i, this))
                        {
                            return false;   
                        }
                    }
                    castleMove = true;
                    return true;
                }
            }

        }
        else if (moveCount == 0 && (toRow - this.getRow() == 2 || this.getRow() - toRow == 2) && 
                (this.getSide().equals(ChessGame.Side.EAST) || this.getSide().equals(ChessGame.Side.WEST)))
        {
            if(board.getPiece(0 , this.getColumn()) instanceof RookPiece && board.getPiece(0 , this.getColumn()).getSide() == this.getSide())
            {
                castlePiece = (RookPiece)board.getPiece(0 , this.getColumn());//This local variable stores the the piece that the king is doing castle move with
                if(castlePiece.getMoveCount() == 0)
                {
                    
                    //This loop checks if the space between king and rook has not been threatened or there is no other piece between them
                    for(int i = this.getRow() - 1; i > 0; i--)
                    {
                        if(board.hasPiece(i, this.getColumn()))
                        {
                            return false;   
                        }
                        else if (this.getChessBoard().squareThreatened(i, this.getColumn(), this))
                        {
                            return false;   
                        }
                    }
                    castleMove = true;
                    return true;
                }
            }
            else if(board.getPiece(board.getGameRules().getNumRows() - 1 , this.getColumn()) instanceof RookPiece && board.getPiece(board.getGameRules().getNumRows() - 1, this.getColumn()).getSide() == this.getSide())
            {
                castlePiece = (RookPiece)board.getPiece(board.getGameRules().getNumRows() - 1 , this.getColumn());//This local variable stores the the piece that the king is doing castle move with
                if(castlePiece.getMoveCount() == 0)
                {
                    for(int i = this.getRow() + 1; i < board.getGameRules().getNumRows() - 1; i++)
                    {
                        //This loop checks if the space between king and rook has not been threatened or there is no other piece between them
                        if(board.hasPiece(i, this.getColumn()))
                        {
                            return false;   
                        }
                        else if (this.getChessBoard().squareThreatened(i, this.getColumn(), this))
                        {
                            return false;   
                        }
                    }
                    castleMove = true;
                    return true;
                }
            }
        }
        else if(this.isAllowedHorizontal(toRow, toColumn, this, 1) || this.isAllowedVertical(toRow, toColumn, this, 1) || this.isAllowedDiagnol(toRow, toColumn, this, 1))
        {
            return true;   
        }
        return false;
    }

    /* This method checks if the kings has done castle move successsfully 
     * if so, it moves the rook piece stored in castlePiece to the space between the current and previous position of the king piece 
     */
    @Override
    public void moveDone()
    {
        
        //if the king has dones castle and move therook to where it's suppsoed to be based on its side
        if(castleMove == true && (this.getSide() == ChessGame.Side.SOUTH || this.getSide() == ChessGame.Side.NORTH))
        {
            if((this.getColumn()) < ((this.getChessBoard().getGameRules().getNumColumns() - 1) / 2))
            {
                this.getChessBoard().removePiece(castlePiece.getRow(), castlePiece.getColumn());
                this.getChessBoard().addPiece(castlePiece, this.getRow(), this.getColumn() + 1);
            }
            else if ((this.getColumn()) > ((this.getChessBoard().getGameRules().getNumColumns() - 1)/ 2))
            {
                this.getChessBoard().removePiece(castlePiece.getRow(), castlePiece.getColumn());
                this.getChessBoard().addPiece(castlePiece, this.getRow(), this.getColumn() - 1);
            }       
            castleMove = false;
        }
        else if(castleMove == true && (this.getSide() == ChessGame.Side.EAST || this.getSide() == ChessGame.Side.WEST))
        {
            if((this.getRow()) < ((this.getChessBoard().getGameRules().getNumRows() - 1) / 2 ))
            {
                this.getChessBoard().removePiece(castlePiece.getRow(), castlePiece.getColumn());
                this.getChessBoard().addPiece(castlePiece, this.getRow() + 1, this.getColumn());
            }
            else if ((this.getColumn()) > ((this.getChessBoard().getGameRules().getNumColumns() - 1) / 2))
            {
                this.getChessBoard().removePiece(castlePiece.getRow(), castlePiece.getColumn());
                this.getChessBoard().addPiece(castlePiece, this.getRow() - 1, this.getColumn());
            }
            castleMove = false;
        }
        moveCount++;
    }
}

