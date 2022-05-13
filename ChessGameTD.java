
/**
 * This is a main method of the chess game 
 *
 * Hiroki Nakayama
 */
public class ChessGameTD
{
    public static void main(String [] args)
    {
        //This line makes the instance of the european chess 
        EuropeanChess testGame = new EuropeanChess(ChessGame.Side.NORTH, ChessGame.Side.SOUTH);

        //This makes the instance of display
        EuropeanChessDisplay testDisplay = new EuropeanChessDisplay();

        //This makes the instance of the chess board 
        ChessBoard testBoard = new SwingChessBoard(testDisplay, testGame);

        testGame.startGame(testBoard);
    }
}
