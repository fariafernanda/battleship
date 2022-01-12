import gameboard.GameBoard;
import printer.GameBoardPrinter;

public class BatalhaNavalApp {

    public final static int ROWS = 10;
    public final static int COLUMNS = 10;
   
    static int[][] playerGameBoard = new int[ROWS][COLUMNS];
    static int[][] computerGameBoard = new int[ROWS][COLUMNS];


       
    
    public static void main(String[] args){

           
               
        GameBoardPrinter.printHeaderGameBoard();
        GameBoard.insertShipsAtGameBoardRandomly();
        GameBoard.initializingShipsOnGame();
        GameBoard.showGameBoard(playerGameBoard);
        GameBoardPrinter.printFooterGameBoard();
        
    }
}
