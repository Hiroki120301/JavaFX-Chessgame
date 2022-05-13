
/**
 * This is a vertical move interface
 *
 * Hiroki Nakayama
 */
public interface Vertical
{
    /* This method takes three integer inputs and chess piece 
     * it checks if the piece can do the vertical move to the selected row and column
     * it returns false if the piece is trying to move more than the their range of movement
     */
    default boolean isAllowedVertical(int toRow, int toColumn, ChessPiece piece, int distanceLimit)
    {
        ChessBoard board = piece.getChessBoard();// this local variable stores the chess bpard that the piece belongs to 
        
        if(piece.getSide().equals(ChessGame.Side.NORTH) || piece.getSide().equals(ChessGame.Side.SOUTH))
        {
            if(toRow - piece.getRow() <= distanceLimit && (toRow - piece.getRow()) > 0)
            {
                
                //This method checks if there is no piece between piece's current position and its destination
                for(int row = piece.getRow() + 1; row < toRow; row++)
                {
                    if(board.hasPiece(row, piece.getColumn()))
                    {
                        return false;   
                    }
                }
                if(toColumn == piece.getColumn())
                {
                    return true;   
                }
            }
            else if (piece.getRow() - toRow <= distanceLimit && (piece.getRow() - toRow) > 0)
            {
                
                //This method checks if there is no piece between piece's current position and its destination
                for(int row = piece.getRow() - 1; row > toRow; row--)
                {
                    if(board.hasPiece(row, piece.getColumn()))
                    {
                        return false;   
                    }
                }
                if(toColumn == piece.getColumn())
                {
                    return true;   
                }
            }
        }
        else
        {
            if(toColumn - piece .getColumn() <= distanceLimit && (toColumn - piece.getColumn()) > 0)
            {
                
                //This method checks if there is no piece between piece's current position and its destination
                for(int col = piece.getColumn() + 1; col < toColumn; col++)
                {
                    if(board.hasPiece(piece.getRow(), col))
                    {
                        return false;   
                    }
                }
                if(toRow == piece.getRow())
                {
                    return true;   
                }
            }
            else if (piece.getColumn() - toColumn <= distanceLimit && (piece.getColumn() - toColumn) > 0)
            {
                //This method checks if there is no piece between piece's current position and its destination
                for(int col = piece.getColumn() - 1; col < toColumn; col--)
                {
                    if(board.hasPiece(piece.getRow(), col))
                    {
                        return false;   
                    }
                }
                if(toRow == piece.getRow())
                {
                    return true;   
                }
            }
        }
        return false;
    }
}

