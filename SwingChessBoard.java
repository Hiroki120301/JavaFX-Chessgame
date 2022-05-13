import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * This is an implementation of ChessBoard which is designed for swing 
 * It proceeds chess board functionality depends on javax.swing
 *
 * Hiroki Nakayama 
 * 
 */
public class SwingChessBoard implements ChessBoard
{

    private JFrame board;                          // the game board
    private JButton[][] squares;                   // the squares of the board
    private ChessPiece[][] pieces;                 // stores the pieces
    private ChessGame gameRules;                   // global rules for this particular game
    private SwingChessBoardDisplay swingBoardDisplay;        // rules for how to draw the chess board

    /*
     * This is a custom constructor of the SwingChess board class 
     * it takes board disply and the chess game as inputs 
     * it sets the initial fields and creates the board 
     */
    public SwingChessBoard(SwingChessBoardDisplay swingBoardDisplay, ChessGame chessGame)
    {
        this.gameRules = chessGame;
        
        this.swingBoardDisplay = swingBoardDisplay;

        // for Mac computers: this allows us to change a button background
        try 
        {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }
        catch (Exception e) 
        {
        }

        // initialize the board
        pieces = new ChessPiece[gameRules.getNumRows()][gameRules.getNumColumns()];
        
        //initializes the squares 
        squares = new JButton[gameRules.getNumRows()][gameRules.getNumColumns()];

        // create the board visuals on the event dispatch thread
        try {
            SwingUtilities.invokeAndWait(new Runnable() 
                {
                    public void run() {
                        board = new JFrame(); 

                        // create a grid for the squares and the listener for the user clicks
                        JPanel panel = new JPanel(new GridLayout(gameRules.getNumRows(), gameRules.getNumColumns()));
                        
                        //This is an instance of the action listener that will be set to each button 
                        ActionListener responder = new ChessAction();

                        // create the squares
                        for (int i = 0; i < gameRules.getNumRows(); i++) {
                            for (int j = 0; j < gameRules.getNumColumns(); j++) {
                                squares[i][j] = new JButton();
                                squares[i][j].addActionListener(responder);
                                swingBoardDisplay.displayEmptySquare(squares[i][j], i, j);
                                panel.add(squares[i][j]);
                                pieces[i][j] = null;
                            }
                        }
                        board.add(panel);
                        board.setSize(swingBoardDisplay.getSquareSize() * gameRules.getNumColumns(), swingBoardDisplay.getSquareSize() * gameRules.getNumRows());
                        board.setVisible(true);
                    }
                });
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /*
     * This method takes no inputs and returns the chess game 
     */
    public ChessGame getGameRules()
    {
     return gameRules;   
    }
    
    /*
     * This method takes the int row and int col as inputs 
     * it returns true if there is a piece at the specified square  
     */
    public boolean hasPiece(int row, int col) 
    {
        return (pieces[row][col] != null);
    }
    
    /*
     * It takes int row and int col as inpus 
     * it returns the piece if there is a piece exists at a apecifed square 
     */
    public ChessPiece getPiece(int row, int col)
    {
        return pieces[row][col];
    }

    /*
     * This method takes int row and int col as inputs 
     * it removes the piece form the specified square and it returns the piece that was removed from the board 
     */
    public ChessPiece removePiece(final int row, final int col) 
    {
        ChessPiece save = pieces[row][col]; //this stores the piecthat wile removed
        
        pieces[row][col] = null;

        Runnable removePiece = new Runnable() 
            {
                public void run() 
                {
                    swingBoardDisplay.displayEmptySquare(squares[row][col], row, col);
                }
            };    
            
        if (SwingUtilities.isEventDispatchThread())
            removePiece.run();
        else {
            try 
            {
                SwingUtilities.invokeAndWait(removePiece);
            }
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }

        return save;
    }

    /*
     * The method takes ChessPiece, int row, and int col as inputs 
     * it adds the piece to the specified square 
     */
    public void addPiece(final ChessPiece piece, final int row, final int col) {
        pieces[row][col] = piece; 
        
        piece.setLocation(row, col);

        Runnable addPiece = new Runnable() 
            {
                public void run() 
                {
                    swingBoardDisplay.displayFilledSquare(squares[row][col], row, col, piece);
                }
            };

        // run the code to change the display on the event dispatch to avoid drawing errors
        if (SwingUtilities.isEventDispatchThread())
            addPiece.run();
        else {
            try 
            {
                SwingUtilities.invokeAndWait(addPiece);
            }
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
    }

    /*
     * This is a nested class which implements ActionListener 
     * it sets action listener to each button and also has process first and second selection methods which handle the first selection and second selection of the button ona board
     */
    private class ChessAction implements ActionListener {
        private boolean firstPick = true;  // if true, we a selecting a piece
        private int pieceRow;              // remember row of selected piece
        private int pieceCol;              // remember column of selected piece

        /* this method handles the first selection of the button 
         * it takes row and column as inputs
         */
        private void processFirstSelection(int row, int col) 
        {
            if ((pieces[row][col] != null) && (getGameRules() == null || getGameRules().legalPieceToPlay(pieces[row][col], row, col))) {
                /*
                 * if this is the first pick and a square with a piece was picked,
                 * remember the piece's location and highlight the square.
                 */
                pieceRow = row;
                pieceCol = col;
                swingBoardDisplay.highlightSquare(true, squares[row][col], row, col, pieces[row][col]);
                firstPick = false;
            }
        }

        /*
         * it handles the second selection of the button 
         * it takes int row and column as inputs 
         */
        private void processSecondSelection(int row, int col) {
            if (row == pieceRow && col == pieceCol)
                return;
                
            //Thi indicates if the move can be made 
            boolean moveMade = getGameRules().makeMove(pieces[pieceRow][pieceCol], row, col);

            // if the move was made or if it was not made and the user select a new piece, then reset to choose a new move
            if (moveMade || getGameRules().canChangeSelection(pieces[pieceRow][pieceCol])) {
                swingBoardDisplay.highlightSquare(false, squares[pieceRow][pieceCol], pieceRow, pieceCol, pieces[pieceRow][pieceCol]);
                firstPick = true;
            }
        }

        /*
         *  it handles the button click itself 
         *  it class processFirstSelection or processSecondSelection depends on which click the button isgetting 
         */
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton)e.getSource();//This stores the button that was clicked 
            
            int col = -1; //This stores the column of th ebutton 
            
            int row = -1;//This stores the row of the button 

            // first find which button (board square) was clicked.
            for (int i = 0; i < squares.length; i++) {
                for (int j = 0; j < squares[i].length; j++) {
                    if (squares[i][j] == b) {
                        row = i;
                        col = j;
                    }
                }
            }

            if (firstPick) {
                processFirstSelection(row, col);
            }
            else {
                processSecondSelection(row, col);
            }
        }
    }
}
