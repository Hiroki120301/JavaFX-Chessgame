
/**
 * This is a diagnol move interface 
 *
 * Hiroki Nakayama
 */
public interface Diagnol
{
    /* This method takes three integer inputs and chess piece 
     * it checks if the piece can do the diagnol move to the selected row and column
     * it returns false if the piece is trying to move more than the their range of movement
     */
    default boolean isAllowedDiagnol (int toRow, int toCol, ChessPiece piece, int distanceLimit)
    {
        if(toCol - piece.getColumn() == toRow - piece.getRow())
        {
            if(toCol - piece.getColumn() <= distanceLimit && (toCol > piece.getColumn()))
            {
                ChessBoard board = piece.getChessBoard();// this local variable stores the chess bpard that the piece belongs to

                int col = piece.getColumn() + 1; // This local variable stores the next column of the piece
                
                //This loop checks if there is no piece between piece's current position and its destination
                for(int row = piece.getRow() + 1; row < toRow; row++)
                {
                    if(board.hasPiece(row, col))
                    {
                        return false;   
                    }
                    col++;
                }
                return true;  
            }
        }
        if((piece.getColumn() - toCol) == (piece.getRow() - toRow))
        {
            if(piece.getColumn() - toCol <= distanceLimit && (piece.getColumn() > toCol))
            {
                ChessBoard board = piece.getChessBoard();// this local variable stores the chess bpard that the piece belongs to

                int col = piece.getColumn() - 1;// This local variable stores the next column of the piece

                //This loop checks if there is no piece between piece's current position and its destination
                for(int row = piece.getRow() - 1; row > toRow; row--)
                {
                    if(board.hasPiece(row, col))
                    {
                        return false;   
                    }
                    col--;
                }
                return true;
            }
        }
        if(toCol - piece.getColumn() == piece.getRow() - toRow)
        {
            if(toCol - piece.getColumn() <= distanceLimit && toCol > piece.getColumn())
            {
                ChessBoard board = piece.getChessBoard();// this local variable stores the chess bpard that the piece belongs to
                int col = piece.getColumn() + 1;// This local variable stores the next column of the piece

                //This loop checks if there is no piece between piece's current position and its destination
                for(int row = piece.getRow() - 1; row > toRow; row--)
                {
                    if(board.hasPiece(row, col))
                    {
                        return false;   
                    }
                    col++;
                }
                return true;   
            }
        }
        if(piece.getColumn() - toCol == toRow - piece.getRow())
        {
            if(piece.getColumn() - toCol <= distanceLimit && piece.getColumn() > toCol)
            {
                ChessBoard board = piece.getChessBoard();// this local variable stores the chess bpard that the piece belongs to
                
                int col = piece.getColumn() - 1;// This local variable stores the next column of the piece

                //This loop checks if there is no piece between piece's current position and its destination
                for(int row = piece.getRow() + 1; row < toRow; row++)
                {
                    if(board.hasPiece(row, col))
                    {
                        return false;   
                    }
                    col--;
                }
                return true;   
            }
        }
        return false;
    }
}
