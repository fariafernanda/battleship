import java.util.Random;

import printer.GameBoardPrinter;

public class BatalhaNavalApp {

    public final static int ROWS = 10;
    public final static int COLUMNS = 10;
    final static int SHIPS = 10;

    static int[][] playerGameBoard = new int[ROWS][COLUMNS];
    static int[][] computerGameBoard = new int[ROWS][COLUMNS];

    static final int BLANK_SPACE = 0;
    static final int SUBMARINE = 1;
    static final int RIGHT_SHOT = 2;
    static final int MISSED_SHOT = 3;

  

   

    public static int[][] insertShipsAtGameBoardRandomly() {
        int[][] newGameBoard = new int[ROWS][COLUMNS];
        int numberOfShipsLeft = SHIPS;
        int x= 0, y= 0;
        Random randomNumber = new Random();
        do {
            x = 0;
            y = 0;
            for(int[] row : newGameBoard) {
                for (int cell : row) {
                    if (randomNumber.nextInt(100) <= 10) {
                        if(cell == BLANK_SPACE) {
                            newGameBoard[x][y] = SUBMARINE;
                            numberOfShipsLeft--;
                            break;
                        }
                        if(numberOfShipsLeft < 0) {
                            break;
                        }
                    }
                    y++;
                }
                y = 0;
                x++;
                if(numberOfShipsLeft <= 0) {
                    break;
                }
            }
        } while (numberOfShipsLeft > 0);
        return newGameBoard;
    }
   
    public static void initializingShipsOnGame() {
        playerGameBoard = insertShipsAtGameBoardRandomly();
        computerGameBoard = insertShipsAtGameBoardRandomly();
    }

    public static void showGameBoard( int[][] gameBoard) {
     
     
        StringBuilder currentRow;
        char rowLetter = 'A';
        for(int[] row : gameBoard) {
            currentRow = new StringBuilder("| " + (rowLetter++) + " |");

            for (int cell : row) {
                switch(cell) {
                    case BLANK_SPACE :
                        currentRow.append("   |");
                        break;

                    case SUBMARINE :
                           currentRow.append(" N |");
                        break;

                    case RIGHT_SHOT :
                        currentRow.append(" * |");
                        break;

                    case MISSED_SHOT :
                        currentRow.append(" - |");
                        break;
                }
            }
            System.out.println(currentRow);
        }
    }
    
    public static void main(String[] args){


     

       
        GameBoardPrinter.printHeaderGameBoard();
        insertShipsAtGameBoardRandomly();
        initializingShipsOnGame();
        showGameBoard(playerGameBoard);
        GameBoardPrinter.printFooterGameBoard();
        
    }
}
