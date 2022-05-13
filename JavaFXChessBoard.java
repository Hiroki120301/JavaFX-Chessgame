import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.stage.Stage;
import java.util.List;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
/**
 * This is a javaFX chess board class
 *
 * Hiroki Nakayama
 */
public class JavaFXChessBoard extends Application implements ChessBoard
{
    //This field stores the chess game associated with this chess board 
    private ChessGame chessGame;

    //This stores the squares of the board 
    private Button [][] buttons;

    //This stores the grid pane 
    private GridPane gridPane;

    //This stores the pieces
    private ChessPiece[][] pieces;

    //This stores the board display associated with this chess board 
    private JavaFXChessBoardDisplay boardDisplay;

    private boolean firstPick = true;  // this distinguishes if the button is clicked for the first time or second time 

    private int pieceRow; //This stores the selected row 

    private int pieceColumn;//this stores the selected column

    /*
     * this is an overriden version of the start method from application 
     * This takes Stage as inputs and does not return anything 
     */
    public void start(Stage primaryStage)
    {
        //This stores the user input on which game the user wants to play 
        Application.Parameters parameters = getParameters();
        
        //This stores the inputed variable
        List<String> typeOfChessGame = parameters.getRaw();

        //This stores te argument of the first comman line 
        String type = typeOfChessGame.get(0);
        
        if(type == "chess")
        {
            chessGame = new EuropeanChess(ChessGame.Side.NORTH, ChessGame.Side.SOUTH);
            boardDisplay = new JavaFXEuropeanChessDisplay();
            pieces = new ChessPiece[chessGame.getNumRows()][chessGame.getNumColumns()];
        }
        else if(type == "xiangqi")
        {
            chessGame = new Xiangqi(ChessGame.Side.NORTH, ChessGame.Side.SOUTH);
            boardDisplay = new JavaFXXiangqiDisplay(10, 9);
            pieces = new ChessPiece[chessGame.getNumRows()][chessGame.getNumColumns()];
        }

        try
        {
            buttons = new Button[chessGame.getNumRows()][chessGame.getNumColumns()];
            gridPane = new GridPane();

            /* this loop goes through every single button stored in the buttons 
             * it initializes every single element stores in the array of buttons and add them to the grid pane
             */
            for(int row = 0; row < chessGame.getNumRows(); row++)
            {
                for(int col = 0; col < chessGame.getNumColumns(); col++)
                {
                    buttons[row][col] = new Button();
                    buttons[row][col].setOnAction(new ButtonAction());
                    boardDisplay.displayEmptySquare(buttons[row][col], row, col);
                    gridPane.add(buttons[row][col], row, col);   
                    pieces[row][col] = null;
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        primaryStage.setScene(new Scene(gridPane));
        primaryStage.setTitle("ChessGame");
        primaryStage.show();
        
        getGameRules().startGame(this);
    }

    /*
     * This method takes no inputs and returns the game ruel stored in the chessGame
     */
    public ChessGame getGameRules()
    {
        return chessGame;   
    }

    /*
     * This method takes int row and column as inputs 
     * it returns true if the piece exists at the specified square
     */
    public boolean hasPiece(int row, int col) 
    {
        return (pieces[row][col] != null);
    }

    /*
     * This method takes int row and columns as inputs 
     * it returns piece at the selected square
     */
    public ChessPiece getPiece(int row, int col) {
        return pieces[row][col];
    }

    /*
     * This is an overriden version of addPiece from the chess board class
     */
    public void addPiece(final ChessPiece piece, final int row, final int col) 
    {
        pieces[row][col] = piece;
        piece.setLocation(row, col);

        boardDisplay.displayFilledSquare(buttons[row][col], row, col, piece);
    }

    /*
     * This method takes int row and int column as inputs 
     * it removes the piece from the selected square and returns the piece that was removed 
     */
    public ChessPiece removePiece(final int row, final int col) 
    {
        //This stores the piece that will be rmeoved
        ChessPiece save = pieces[row][col];
        
        pieces[row][col] = null;

        boardDisplay.displayEmptySquare(buttons[row][col], row, col);

        return save;
    }

    /*
     * This is a nested class of the ButtonAction 
     * it handles the first button clicks 
     */
    private class ButtonAction implements EventHandler<ActionEvent> 
    {
        /* 
         * This method takes action event as an input and returns nothing 
         */
        public void handle(ActionEvent e) 
        {
            int row = -1; //this stores the row of the button clicked 
            
            int col = -1; //This stores the column of the button clicked
            
            Button b = (Button) e.getSource(); // this stores the button clicked

            //This method goes through each button to find which button was clicked
            for (int r = 0; r < buttons.length; r++) {
                for (int c = 0; c < buttons[r].length; c++) {
                    if (buttons[r][c] == b) {
                        row = r;
                        col = c;
                    }
                }
            }

            if (firstPick) 
            {
                processFirstSelection(row, col);
            }
            else 
            {
                processSecondSelection(row, col);
            }
        }

        /* 
         * This method take row and column as inputs 
         * it handles the first click 
         */
        private void processFirstSelection(int row, int col)
        {
            if(pieces[row][col] != null && (chessGame == null || chessGame.legalPieceToPlay(pieces[row][col], row, col)))
            {
                pieceRow = row;
                pieceColumn = col;
                firstPick = false;
                boardDisplay.highlightSquare(true, buttons[row][col], row, col, pieces[row][col]);
            }
        }

        /* 
         * This method takes row and column 
         * this method handles the second selection 
         */
        private void processSecondSelection(int row, int col)
        {
            if(row == pieceRow && col == pieceColumn)
            {
                return;
            }

            //This indicates if the move can be made
            boolean moveCanBeMade = chessGame.makeMove(pieces[pieceRow][pieceColumn], row, col);
            
            if(moveCanBeMade || chessGame.canChangeSelection(pieces[pieceRow][pieceColumn]))
            {
                boardDisplay.highlightSquare(false, buttons[pieceRow][pieceColumn], pieceRow, pieceColumn, pieces[pieceRow][pieceColumn]);
                firstPick = true;
            }
        }
    }

    /* 
     * This is a main method 
     * it calls a lauch method from Application class
     */
    public static void main (String [] args)
    {
        Application.launch(args);
    }
}
