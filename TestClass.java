import org.junit.*;
import static org.junit.Assert.*;
/**
 * Write a description of class TestClass here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestClass
{
    @Test
    public void testfXiangqiClass()
    {
        Xiangqi testGame = new Xiangqi(ChessGame.Side.NORTH, ChessGame.Side.SOUTH);
        ChessBoard testBoard = new SwingChessBoard(null, testGame);
        XiangqiKingPiece testPiece = new XiangqiKingPiece(0, 4, ChessGame.Side.NORTH, testBoard);
        XiangqiKingPiece testPiece2 = new XiangqiKingPiece(9, 4, ChessGame.Side.SOUTH, testBoard);
        CannonPiece testPiece3 = new CannonPiece(2, 4, ChessGame.Side.SOUTH, testBoard);
        CannonPiece testPiece4 = new CannonPiece(5, 4, ChessGame.Side.SOUTH, testBoard);

        testBoard.addPiece(testPiece, testPiece.getRow(), testPiece.getColumn());
        testBoard.addPiece(testPiece2, testPiece2.getRow(), testPiece2.getColumn());

        testBoard.addPiece(testPiece3, testPiece3.getRow(), testPiece3.getColumn());
        assertEquals(true, testGame.makeMove(testPiece3, 3 , 4));
        assertEquals(false, testGame.makeMove(testPiece3, 3 , 5));

        testBoard.addPiece(testPiece4, testPiece4.getRow(), testPiece4.getColumn());
        assertEquals(true, testGame.makeMove(testPiece3, 3 , 5));

        Xiangqi testGame3 = new Xiangqi(ChessGame.Side.NORTH, ChessGame.Side.SOUTH);
        ChessBoard testBoard3 = new SwingChessBoard(null, testGame);

        Xiangqi testGame2 = new Xiangqi(ChessGame.Side.NORTH, ChessGame.Side.SOUTH);
        ChessBoard testBoard2 = new SwingChessBoard(null, testGame2);

        testGame2.startGame(testBoard2);
        assertEquals(true, testBoard2.getPiece(0,4) instanceof XiangqiKingPiece);
        assertEquals(true, testBoard2.getPiece(0,3) instanceof GuardPiece);
        assertEquals(true, testBoard2.getPiece(0,5) instanceof GuardPiece);
        assertEquals(true, testBoard2.getPiece(0,2) instanceof ElephantPiece);
        assertEquals(true, testBoard2.getPiece(0,6) instanceof ElephantPiece);
        assertEquals(true, testBoard2.getPiece(0,1) instanceof HorsePiece);
        assertEquals(true, testBoard2.getPiece(0,7) instanceof HorsePiece);
        assertEquals(true, testBoard2.getPiece(0,0) instanceof RookPiece);
        assertEquals(true, testBoard2.getPiece(0,8) instanceof RookPiece);
        assertEquals(true, testBoard2.getPiece(2,1) instanceof CannonPiece);
        assertEquals(true, testBoard2.getPiece(2,7) instanceof CannonPiece);
        assertEquals(true, testBoard2.getPiece(3,0) instanceof SoldierPiece);
        assertEquals(true, testBoard2.getPiece(3,2) instanceof SoldierPiece);
        assertEquals(true, testBoard2.getPiece(3,4) instanceof SoldierPiece);
        assertEquals(true, testBoard2.getPiece(3,6) instanceof SoldierPiece);
        assertEquals(true, testBoard2.getPiece(3,8) instanceof SoldierPiece);

        assertEquals(true, testBoard2.getPiece(9,4) instanceof XiangqiKingPiece);
        assertEquals(true, testBoard2.getPiece(9,3) instanceof GuardPiece);
        assertEquals(true, testBoard2.getPiece(9,5) instanceof GuardPiece);
        assertEquals(true, testBoard2.getPiece(9,2) instanceof ElephantPiece);
        assertEquals(true, testBoard2.getPiece(9,6) instanceof ElephantPiece);
        assertEquals(true, testBoard2.getPiece(9,1) instanceof HorsePiece);
        assertEquals(true, testBoard2.getPiece(9,7) instanceof HorsePiece);
        assertEquals(true, testBoard2.getPiece(9,0) instanceof RookPiece);
        assertEquals(true, testBoard2.getPiece(9,8) instanceof RookPiece);
        assertEquals(true, testBoard2.getPiece(7,1) instanceof CannonPiece);
        assertEquals(true, testBoard2.getPiece(7,7) instanceof CannonPiece);
        assertEquals(true, testBoard2.getPiece(6,0) instanceof SoldierPiece);
        assertEquals(true, testBoard2.getPiece(6,2) instanceof SoldierPiece);
        assertEquals(true, testBoard2.getPiece(6,4) instanceof SoldierPiece);
        assertEquals(true, testBoard2.getPiece(6,6) instanceof SoldierPiece);
        assertEquals(true, testBoard2.getPiece(6,8) instanceof SoldierPiece);

        assertEquals(10, testGame.getNumRows());
        assertEquals(9, testGame.getNumColumns());
    }

    @Test
    public void testEuropeanChess()
    {
        EuropeanChess testGame = new EuropeanChess(ChessGame.Side.NORTH, ChessGame.Side.SOUTH);
        SwingChessBoard testBoard = new SwingChessBoard(null, testGame);

        testGame.startGame(testBoard);

        assertEquals(true, testBoard.getPiece(0,4) instanceof KingPiece);
        assertEquals(true, testBoard.getPiece(0,3) instanceof QueenPiece);
        assertEquals(true, testBoard.getPiece(0,2) instanceof BishopPiece);
        assertEquals(true, testBoard.getPiece(0,5) instanceof BishopPiece);
        assertEquals(true, testBoard.getPiece(0,1) instanceof KnightPiece);
        assertEquals(true, testBoard.getPiece(0,6) instanceof KnightPiece);
        assertEquals(true, testBoard.getPiece(0,0) instanceof RookPiece);
        assertEquals(true, testBoard.getPiece(0,7) instanceof RookPiece);
        assertEquals(true, testBoard.getPiece(1,0) instanceof PawnPiece);
        assertEquals(true, testBoard.getPiece(1,1) instanceof PawnPiece);
        assertEquals(true, testBoard.getPiece(1,2) instanceof PawnPiece);
        assertEquals(true, testBoard.getPiece(1,3) instanceof PawnPiece);
        assertEquals(true, testBoard.getPiece(1,4) instanceof PawnPiece);
        assertEquals(true, testBoard.getPiece(1,5) instanceof PawnPiece);
        assertEquals(true, testBoard.getPiece(1,6) instanceof PawnPiece);
        assertEquals(true, testBoard.getPiece(1,7) instanceof PawnPiece);

        assertEquals(true, testBoard.getPiece(7,4) instanceof KingPiece);
        assertEquals(true, testBoard.getPiece(7,3) instanceof QueenPiece);
        assertEquals(true, testBoard.getPiece(7,2) instanceof BishopPiece);
        assertEquals(true, testBoard.getPiece(7,5) instanceof BishopPiece);
        assertEquals(true, testBoard.getPiece(7,1) instanceof KnightPiece);
        assertEquals(true, testBoard.getPiece(7,6) instanceof KnightPiece);
        assertEquals(true, testBoard.getPiece(7,0) instanceof RookPiece);
        assertEquals(true, testBoard.getPiece(7,7) instanceof RookPiece);
        assertEquals(true, testBoard.getPiece(6,0) instanceof PawnPiece);
        assertEquals(true, testBoard.getPiece(6,1) instanceof PawnPiece);
        assertEquals(true, testBoard.getPiece(6,2) instanceof PawnPiece);
        assertEquals(true, testBoard.getPiece(6,3) instanceof PawnPiece);
        assertEquals(true, testBoard.getPiece(6,4) instanceof PawnPiece);
        assertEquals(true, testBoard.getPiece(6,5) instanceof PawnPiece);
        assertEquals(true, testBoard.getPiece(6,6) instanceof PawnPiece);
        assertEquals(true, testBoard.getPiece(6,7) instanceof PawnPiece);

        assertEquals(8, testGame.getNumRows());
        assertEquals(8, testGame.getNumColumns());
    }

    @Test
    public void testXiangqiKingPieceMethods() 
    {
        Xiangqi testGame = new Xiangqi(ChessGame.Side.NORTH, ChessGame.Side.SOUTH);
        SwingChessBoard testBoard = new SwingChessBoard(null, testGame);
        XiangqiKingPiece testPiece = new XiangqiKingPiece(2, 4, ChessGame.Side.NORTH, testBoard);
        XiangqiKingPiece testPiece2 = new XiangqiKingPiece(9, 3, ChessGame.Side.SOUTH, testBoard);
        XiangqiKingPiece testPiece3 = new XiangqiKingPiece(1, 4, ChessGame.Side.NORTH, testBoard);

        testBoard.addPiece(testPiece, testPiece.getRow(), testPiece.getColumn());

        assertEquals(true, testPiece.isLegalNonCaptureMove(2,3));
        assertEquals(true, testPiece.isLegalNonCaptureMove(1,4));
        assertEquals(true, testPiece.isLegalNonCaptureMove(2,5));
        assertEquals(false, testPiece.isLegalNonCaptureMove(3,4));
        assertEquals(false, testPiece.isLegalNonCaptureMove(3,3));
        assertEquals(false, testPiece.isLegalNonCaptureMove(3,5));
        assertEquals(false, testPiece.isLegalNonCaptureMove(1,3));
        assertEquals(false, testPiece.isLegalNonCaptureMove(1,5));

        testBoard.addPiece(testPiece2, testPiece2.getRow(), testPiece2.getColumn());
        assertEquals(false, testPiece2.isLegalNonCaptureMove(9,2));
        assertEquals(true, testPiece2.isLegalNonCaptureMove(9,4));
        assertEquals(true, testPiece2.isLegalNonCaptureMove(8,3));

        testBoard.addPiece(testPiece3, testPiece3.getRow(), testPiece3.getColumn());
        assertEquals(true, testPiece3.isLegalNonCaptureMove(0,4));
        assertEquals(true, testPiece3.isLegalNonCaptureMove(1,3));
        assertEquals(true, testPiece3.isLegalNonCaptureMove(1,5));
    }

    @Test
    public void testGuardPieceMethods() 
    {
        Xiangqi testGame = new Xiangqi(ChessGame.Side.NORTH, ChessGame.Side.SOUTH);
        ChessBoard testBoard = new SwingChessBoard(null, testGame);
        GuardPiece testPiece = new GuardPiece(1, 4, ChessGame.Side.NORTH, testBoard);
        GuardPiece testPiece2 = new GuardPiece(7, 3, ChessGame.Side.SOUTH, testBoard);
        GuardPiece testPiece3 = new GuardPiece(7, 5, ChessGame.Side.SOUTH, testBoard);

        testBoard.addPiece(testPiece, testPiece.getRow(), testPiece.getColumn());
        testBoard.addPiece(testPiece2, testPiece2.getRow(), testPiece2.getColumn());
        testBoard.addPiece(testPiece3, testPiece3.getRow(), testPiece3.getColumn());
        
        assertEquals(true, testPiece.isLegalNonCaptureMove(2,3));
        assertEquals(true, testPiece.isLegalNonCaptureMove(2,5));
        assertEquals(true, testPiece.isLegalNonCaptureMove(0,3));
        assertEquals(true, testPiece.isLegalNonCaptureMove(0,5));

        testGame.makeMove(testPiece, 2, 3);

        assertEquals(false, testPiece.isLegalNonCaptureMove(3,2));
        assertEquals(false, testPiece.isLegalNonCaptureMove(1,2));
        assertEquals(false, testPiece.isLegalNonCaptureMove(3,4));

        testGame.makeMove(testPiece, 1, 4);
        testGame.makeMove(testPiece, 2, 5);

        assertEquals(false, testPiece.isLegalNonCaptureMove(6,1));
        
        assertEquals(false, testPiece2.isLegalNonCaptureMove(8,2));
        assertEquals(false, testPiece2.isLegalNonCaptureMove(6,2));
        assertEquals(false, testPiece2.isLegalNonCaptureMove(6,4));
        assertEquals(false, testPiece3.isLegalNonCaptureMove(8,6));

    }

    @Test
    public void testElephantPieceMethods() 
    {
        Xiangqi testGame = new Xiangqi(ChessGame.Side.NORTH, ChessGame.Side.SOUTH);
        ChessBoard testBoard = new SwingChessBoard(null, testGame);

        ElephantPiece testPiece = new ElephantPiece(2, 4, ChessGame.Side.NORTH, testBoard);

        ElephantPiece testPiece2 = new ElephantPiece(3, 3, ChessGame.Side.SOUTH, testBoard);
        ElephantPiece testPiece3 = new ElephantPiece(3, 5, ChessGame.Side.SOUTH, testBoard);
        ElephantPiece testPiece4 = new ElephantPiece(1, 5, ChessGame.Side.SOUTH, testBoard);
        ElephantPiece testPiece5 = new ElephantPiece(1, 3, ChessGame.Side.SOUTH, testBoard);

        ElephantPiece testPiece6 = new ElephantPiece(4, 4, ChessGame.Side.SOUTH, testBoard);
        ElephantPiece testPiece7 = new ElephantPiece(5, 4, ChessGame.Side.SOUTH, testBoard);

        testBoard.addPiece(testPiece, testPiece.getRow(), testPiece.getColumn());
        assertEquals(true, testPiece.isLegalNonCaptureMove(4,2));
        assertEquals(true, testPiece.isLegalNonCaptureMove(0,2));
        assertEquals(true, testPiece.isLegalNonCaptureMove(0,6));
        assertEquals(true, testPiece.isLegalNonCaptureMove(4,6));

        testBoard.addPiece(testPiece2, testPiece2.getRow(), testPiece2.getColumn());
        testBoard.addPiece(testPiece3, testPiece3.getRow(), testPiece3.getColumn());
        testBoard.addPiece(testPiece4, testPiece4.getRow(), testPiece4.getColumn());
        testBoard.addPiece(testPiece5, testPiece5.getRow(), testPiece5.getColumn());

        assertEquals(false, testPiece.isLegalNonCaptureMove(4,2));
        assertEquals(false, testPiece.isLegalNonCaptureMove(0,2));
        assertEquals(false, testPiece.isLegalNonCaptureMove(0,6));
        assertEquals(false, testPiece.isLegalNonCaptureMove(4,6));

        testBoard.addPiece(testPiece6, testPiece6.getRow(), testPiece6.getColumn());
        testBoard.addPiece(testPiece6, testPiece6.getRow(), testPiece6.getColumn());

        assertEquals(false, testPiece6.isLegalNonCaptureMove(6,2));
        assertEquals(false, testPiece6.isLegalNonCaptureMove(6,6));
        assertEquals(false, testPiece7.isLegalNonCaptureMove(3,2));
        assertEquals(false, testPiece7.isLegalNonCaptureMove(3,6));
    }
    
    @Test 
    public void testHorsePiece()
    {
        Xiangqi testGame = new Xiangqi(ChessGame.Side.NORTH, ChessGame.Side.SOUTH);
        ChessBoard testBoard = new SwingChessBoard(null, testGame);

        HorsePiece testPiece = new HorsePiece(5, 4, ChessGame.Side.SOUTH, testBoard);
        
        HorsePiece testPiece2 = new HorsePiece(5, 3, ChessGame.Side.SOUTH, testBoard);
        HorsePiece testPiece3= new HorsePiece(6, 4, ChessGame.Side.SOUTH, testBoard);
        HorsePiece testPiece4 = new HorsePiece(5, 5, ChessGame.Side.SOUTH, testBoard);
        HorsePiece testPiece5 = new HorsePiece(4, 4, ChessGame.Side.SOUTH, testBoard);
        
        testBoard.addPiece(testPiece, testPiece.getRow(), testPiece.getColumn());

        assertEquals(true, testPiece.isLegalNonCaptureMove(7, 5));
        assertEquals(true, testPiece.isLegalNonCaptureMove(7, 3));
        assertEquals(true, testPiece.isLegalNonCaptureMove(6, 2));
        assertEquals(true, testPiece.isLegalNonCaptureMove(4, 2));
        assertEquals(true, testPiece.isLegalNonCaptureMove(3, 3));
        assertEquals(true, testPiece.isLegalNonCaptureMove(3, 5));
        assertEquals(true, testPiece.isLegalNonCaptureMove(6, 6));
        assertEquals(true, testPiece.isLegalNonCaptureMove(4, 6));
        
        testBoard.addPiece(testPiece2, testPiece2.getRow(), testPiece2.getColumn());
        testBoard.addPiece(testPiece3, testPiece3.getRow(), testPiece3.getColumn());
        testBoard.addPiece(testPiece4, testPiece4.getRow(), testPiece4.getColumn());
        testBoard.addPiece(testPiece5, testPiece5.getRow(), testPiece5.getColumn());
        
        assertEquals(false, testPiece.isLegalNonCaptureMove(7, 5));
        assertEquals(false, testPiece.isLegalNonCaptureMove(7, 3));
        assertEquals(false, testPiece.isLegalNonCaptureMove(6, 2));
        assertEquals(false, testPiece.isLegalNonCaptureMove(4, 2));
        assertEquals(false, testPiece.isLegalNonCaptureMove(3, 3));
        assertEquals(false, testPiece.isLegalNonCaptureMove(3, 5));
        assertEquals(false, testPiece.isLegalNonCaptureMove(6, 6));
        assertEquals(false, testPiece.isLegalNonCaptureMove(4, 6));
    }

    @Test
    public void testCannonPieceMethods() 
    {
        Xiangqi testGame = new Xiangqi(ChessGame.Side.NORTH, ChessGame.Side.SOUTH);
        ChessBoard testBoard = new SwingChessBoard(null, testGame);

        CannonPiece testPiece = new CannonPiece(2, 4, ChessGame.Side.SOUTH, testBoard);

        CannonPiece testPiece2 = new CannonPiece(2, 3, ChessGame.Side.SOUTH, testBoard);
        CannonPiece testPiece3 = new CannonPiece(2, 5, ChessGame.Side.SOUTH, testBoard);
        CannonPiece testPiece4 = new CannonPiece(1, 4, ChessGame.Side.SOUTH, testBoard);
        CannonPiece testPiece5 = new CannonPiece(3, 4, ChessGame.Side.SOUTH, testBoard);

        CannonPiece testPiece6 = new CannonPiece(4, 4, ChessGame.Side.NORTH, testBoard);
        CannonPiece testPiece7 = new CannonPiece(2, 2, ChessGame.Side.NORTH, testBoard);
        CannonPiece testPiece8 = new CannonPiece(0, 4, ChessGame.Side.NORTH, testBoard);
        CannonPiece testPiece9 = new CannonPiece(2, 6, ChessGame.Side.NORTH, testBoard);

        testBoard.addPiece(testPiece, testPiece.getRow(), testPiece.getColumn());

        assertEquals(true, testPiece.isLegalNonCaptureMove(3,4));
        assertEquals(true, testPiece.isLegalNonCaptureMove(2,3));
        assertEquals(true, testPiece.isLegalNonCaptureMove(1,4));
        assertEquals(true, testPiece.isLegalNonCaptureMove(2,5));

        assertEquals(true, testPiece.isLegalNonCaptureMove(4,4));
        assertEquals(true, testPiece.isLegalNonCaptureMove(2,2));
        assertEquals(true, testPiece.isLegalNonCaptureMove(0,4));
        assertEquals(true, testPiece.isLegalNonCaptureMove(2,6));

        testBoard.addPiece(testPiece2, testPiece2.getRow(), testPiece2.getColumn());
        testBoard.addPiece(testPiece3, testPiece3.getRow(), testPiece3.getColumn());
        testBoard.addPiece(testPiece4, testPiece4.getRow(), testPiece4.getColumn());
        testBoard.addPiece(testPiece5, testPiece5.getRow(), testPiece5.getColumn());

        assertEquals(false, testPiece.isLegalNonCaptureMove(4,4));
        assertEquals(false, testPiece.isLegalNonCaptureMove(2,2));
        assertEquals(false, testPiece.isLegalNonCaptureMove(0,4));
        assertEquals(false, testPiece.isLegalNonCaptureMove(2,6));

        testBoard.addPiece(testPiece6, testPiece6.getRow(), testPiece6.getColumn());
        testBoard.addPiece(testPiece7, testPiece7.getRow(), testPiece7.getColumn());
        testBoard.addPiece(testPiece8, testPiece8.getRow(), testPiece8.getColumn());
        testBoard.addPiece(testPiece9, testPiece9.getRow(), testPiece9.getColumn());

        assertEquals(true, testPiece.isLegalCaptureMove(4,4));
        assertEquals(true, testPiece.isLegalCaptureMove(2,2));
        assertEquals(true, testPiece.isLegalCaptureMove(0,4));
        assertEquals(true, testPiece.isLegalCaptureMove(2,6));

        ChessBoard testBoard2 = new SwingChessBoard(null, testGame);

        CannonPiece testPiece10 = new CannonPiece(6, 5, ChessGame.Side.NORTH, testBoard2);
        CannonPiece testPiece11 = new CannonPiece(8, 5, ChessGame.Side.SOUTH, testBoard2);
        CannonPiece testPiece12 = new CannonPiece(7, 5, ChessGame.Side.SOUTH, testBoard2);
        CannonPiece testPiece13 = new CannonPiece(5, 5, ChessGame.Side.SOUTH, testBoard2);
        CannonPiece testPiece14 = new CannonPiece(4, 5, ChessGame.Side.SOUTH, testBoard2);
        CannonPiece testPiece15 = new CannonPiece(3, 5, ChessGame.Side.SOUTH, testBoard2);
        CannonPiece testPiece16 = new CannonPiece(9, 5, ChessGame.Side.SOUTH, testBoard2);
        CannonPiece testPiece17 = new CannonPiece(6, 2, ChessGame.Side.SOUTH, testBoard2);
        CannonPiece testPiece18 = new CannonPiece(6, 3, ChessGame.Side.SOUTH, testBoard2);
        CannonPiece testPiece19 = new CannonPiece(6, 4, ChessGame.Side.SOUTH, testBoard2);
        CannonPiece testPiece20 = new CannonPiece(6, 6, ChessGame.Side.SOUTH, testBoard2);
        CannonPiece testPiece21 = new CannonPiece(6, 7, ChessGame.Side.SOUTH, testBoard2);
        CannonPiece testPiece22 = new CannonPiece(6, 8, ChessGame.Side.SOUTH, testBoard2);

        testBoard2.addPiece(testPiece10, testPiece10.getRow(), testPiece10.getColumn());
        testBoard2.addPiece(testPiece11, testPiece11.getRow(), testPiece11.getColumn());
        testBoard2.addPiece(testPiece12, testPiece12.getRow(), testPiece12.getColumn());
        testBoard2.addPiece(testPiece13, testPiece13.getRow(), testPiece13.getColumn());
        testBoard2.addPiece(testPiece14, testPiece14.getRow(), testPiece14.getColumn());
        testBoard2.addPiece(testPiece15, testPiece15.getRow(), testPiece15.getColumn());
        testBoard2.addPiece(testPiece16, testPiece16.getRow(), testPiece16.getColumn());
        testBoard2.addPiece(testPiece17, testPiece17.getRow(), testPiece17.getColumn());
        testBoard2.addPiece(testPiece18, testPiece18.getRow(), testPiece18.getColumn());
        testBoard2.addPiece(testPiece19, testPiece19.getRow(), testPiece19.getColumn());
        testBoard2.addPiece(testPiece20, testPiece20.getRow(), testPiece20.getColumn());
        testBoard2.addPiece(testPiece21, testPiece21.getRow(), testPiece21.getColumn());
        testBoard2.addPiece(testPiece22, testPiece22.getRow(), testPiece22.getColumn());

        assertEquals(false, testPiece10.isLegalCaptureMove(6,2));
        assertEquals(false, testPiece10.isLegalCaptureMove(3,5));
        assertEquals(false, testPiece10.isLegalCaptureMove(6,8));
        assertEquals(false, testPiece10.isLegalCaptureMove(9,5));

        CannonPiece testPiece23 = new CannonPiece(2, 2, ChessGame.Side.NORTH, testBoard2);
        CannonPiece testPiece24 = new CannonPiece(2, 1, ChessGame.Side.SOUTH, testBoard2);
        CannonPiece testPiece25 = new CannonPiece(2, 3, ChessGame.Side.SOUTH, testBoard2);
        CannonPiece testPiece26 = new CannonPiece(3, 2, ChessGame.Side.SOUTH, testBoard2);
        CannonPiece testPiece27 = new CannonPiece(1, 2, ChessGame.Side.SOUTH, testBoard2);

        testBoard2.addPiece(testPiece23, testPiece23.getRow(), testPiece23.getColumn());
        testBoard2.addPiece(testPiece24, testPiece24.getRow(), testPiece24.getColumn());
        testBoard2.addPiece(testPiece25, testPiece25.getRow(), testPiece25.getColumn());
        testBoard2.addPiece(testPiece26, testPiece26.getRow(), testPiece26.getColumn());
        testBoard2.addPiece(testPiece27, testPiece27.getRow(), testPiece27.getColumn());

        assertEquals(true, testPiece23.isLegalCaptureMove(2,1));
        assertEquals(true, testPiece23.isLegalCaptureMove(3,2));
        assertEquals(true, testPiece23.isLegalCaptureMove(2,3));
        assertEquals(true, testPiece23.isLegalCaptureMove(1,2));
    }

    @Test
    public void testSoldierPieceMethods() 
    {
        Xiangqi testGame = new Xiangqi(ChessGame.Side.NORTH, ChessGame.Side.SOUTH);
        ChessBoard testBoard = new SwingChessBoard(null, testGame);
        SoldierPiece testPiece = new SoldierPiece(4, 4, ChessGame.Side.NORTH, testBoard);
        SoldierPiece testPiece2 = new SoldierPiece(5, 1, ChessGame.Side.SOUTH, testBoard);

        testBoard.addPiece(testPiece, testPiece.getRow(), testPiece.getColumn());
        testBoard.addPiece(testPiece2, testPiece2.getRow(), testPiece2.getColumn());

        assertEquals(true, testPiece.isLegalNonCaptureMove(5,4));
        assertEquals(false, testPiece.isLegalNonCaptureMove(4,3));
        assertEquals(false, testPiece.isLegalNonCaptureMove(4,5));
        testGame.makeMove(testPiece, 5, 4);
        assertEquals(true, testPiece.isLegalNonCaptureMove(5,5));
        assertEquals(true, testPiece.isLegalNonCaptureMove(5,3));
        assertEquals(false, testPiece.isLegalNonCaptureMove(4,4));

        assertEquals(true, testPiece2.isLegalNonCaptureMove(4,1));
        assertEquals(false, testPiece2.isLegalNonCaptureMove(5,0));
        assertEquals(false, testPiece2.isLegalNonCaptureMove(5,2));
        testGame.makeMove(testPiece2, 4, 1);
        assertEquals(true, testPiece2.isLegalNonCaptureMove(3,1));
        assertEquals(true, testPiece2.isLegalNonCaptureMove(4,2));
        assertEquals(true, testPiece2.isLegalNonCaptureMove(4,0));
    }
    
    
}
