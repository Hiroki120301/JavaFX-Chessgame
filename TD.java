
/**
 * Write a description of class TD here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TD
{
    public static void main(String [] args)
    {
        Xiangqi testGame = new Xiangqi(ChessGame.Side.NORTH, ChessGame.Side.SOUTH);
        ChessBoard testBoard2 = new SwingChessBoard(null, testGame);
        
        CannonPiece testPiece23 = new CannonPiece(2, 2, ChessGame.Side.NORTH, testBoard2);
        CannonPiece testPiece24 = new CannonPiece(2, 1, ChessGame.Side.SOUTH, testBoard2);
        CannonPiece testPiece25 = new CannonPiece(2, 3, ChessGame.Side.SOUTH, testBoard2);
        CannonPiece testPiece26 = new CannonPiece(3, 2, ChessGame.Side.SOUTH, testBoard2);
        CannonPiece testPiece27 = new CannonPiece(1, 2, ChessGame.Side.SOUTH, testBoard2);

        testBoard2.addPiece(testPiece23, testPiece23.getRow(), testPiece23.getColumn());
        testBoard2.addPiece(testPiece24, testPiece24.getRow(), testPiece24.getColumn());
        testBoard2.addPiece(testPiece25, testPiece25.getRow(), testPiece25.getColumn());
        testBoard2.addPiece(testPiece26, testPiece26.getRow(), testPiece26.getColumn());

        /*testPiece23.isLegalCaptureMove(2,1);
        testPiece23.isLegalCaptureMove(3,2);
        testPiece23.isLegalCaptureMove(2,3);*/
        testPiece23.isLegalCaptureMove(1,2);
    }
}
