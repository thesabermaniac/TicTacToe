import javax.swing.*;
import java.util.Scanner;


public class TicTacToeGameplay {
    int row;
    int column;
    char userSymbol = 'X';
    char cpuSymbol = 'O';
    boolean gameOver;
    boolean moveMade;
    TicTacToeBoard board;

    char status;
    /**'W' = Player 1 wins
       'L' = CPU wins
       'T' = Tie Game
       'A' = Active game
     */


    public TicTacToeGameplay(){
    }

    public void playGame(){
        String again = "y";
        while (again.equals("y")) {
            board = new TicTacToeBoard();
            gameOver = false;
            status = 'A';
            while (!(isGameOver())) {
                System.out.println(board.printBoard());
                userMove();

                while (!(isGameOver())) {
                    cpuMove();
                    break;
                }
            }
            if (status == 'W') {
                System.out.println(board.printBoard());
                again = JOptionPane.showInputDialog("Congratulations, you won. Would you like to play again (y/n) ? ");
            }
            else if (status == 'L') {
                System.out.println(board.printBoard());
                again = JOptionPane.showInputDialog("The CPU won this round. Would you like to play again (y/n) ? ");
            }
            else if (status == 'T') {
                System.out.println(board.printBoard());
                again = JOptionPane.showInputDialog("The game ended in a tie, do you want to try again (y/n) ? ");
            }
        }
    }

    public void userMove(){
        row = Integer.parseInt(JOptionPane.showInputDialog("Enter the row you want to move in (1-3)?"));
        column = Integer.parseInt(JOptionPane.showInputDialog("Enter the column you want to move in (1-3)?"));
        board.makeMove(row - 1, column - 1, userSymbol);
    }

    public void cpuMove(){
        moveMade = false;

        //check for opportunities to win
        //check if any diagonal is winnable
        if (board.getBoard()[0][0] == cpuSymbol &&
                board.getBoard()[1][1] == cpuSymbol &&
                board.getBoard()[2][2] == ' ') {
            board.makeMove(2, 2, cpuSymbol);
            moveMade = true;
        } else if (board.getBoard()[0][0] == cpuSymbol &&
                board.getBoard()[1][1] == ' ' &&
                board.getBoard()[2][2] == cpuSymbol) {
            board.makeMove(1, 1, cpuSymbol);
            moveMade = true;
        } else if (board.getBoard()[0][0] == ' ' &&
                board.getBoard()[1][1] == cpuSymbol &&
                board.getBoard()[2][2] == cpuSymbol) {
            board.makeMove(0, 0, cpuSymbol);
            moveMade = true;
        } else if (board.getBoard()[0][2] == cpuSymbol &&
                board.getBoard()[1][1] == cpuSymbol &&
                board.getBoard()[2][0] == ' ') {
            board.makeMove(2, 0, cpuSymbol);
            moveMade = true;
        } else if (board.getBoard()[0][2] == cpuSymbol &&
                board.getBoard()[1][1] == ' ' &&
                board.getBoard()[2][0] == cpuSymbol) {
            board.makeMove(1, 1, cpuSymbol);
            moveMade = true;
        } else if (board.getBoard()[0][2] == ' ' &&
                board.getBoard()[1][1] == cpuSymbol &&
                board.getBoard()[2][0] == cpuSymbol) {
            board.makeMove(0, 2, cpuSymbol);
            moveMade = true;
        }

        if(!moveMade) {
            for (int j = 0; j < board.getColumns(); j++) {
                //check if any row is winnable
                if (board.getBoard()[j][0] == cpuSymbol &&
                        board.getBoard()[j][1] == cpuSymbol &&
                        board.getBoard()[j][2] == ' ') {
                    board.makeMove(j, 2, cpuSymbol);
                    moveMade = true;
                    break;
                } else if (board.getBoard()[j][0] == cpuSymbol &&
                        board.getBoard()[j][1] == ' ' &&
                        board.getBoard()[j][2] == cpuSymbol) {
                    board.makeMove(j, 1, cpuSymbol);
                    moveMade = true;
                    break;
                } else if (board.getBoard()[j][0] == ' ' &&
                        board.getBoard()[j][1] == cpuSymbol &&
                        board.getBoard()[j][2] == cpuSymbol) {
                    board.makeMove(j, 0, cpuSymbol);
                    moveMade = true;
                    break;
                }

                //check if any column is winnable
                else if (board.getBoard()[0][j] == cpuSymbol &&
                        board.getBoard()[1][j] == cpuSymbol &&
                        board.getBoard()[2][j] == ' ') {
                    board.makeMove(2, j, cpuSymbol);
                    moveMade = true;
                    break;
                } else if (board.getBoard()[0][j] == cpuSymbol &&
                        board.getBoard()[1][j] == ' ' &&
                        board.getBoard()[2][j] == cpuSymbol) {
                    board.makeMove(1, j, cpuSymbol);
                    moveMade = true;
                    break;
                } else if (board.getBoard()[0][j] == ' ' &&
                        board.getBoard()[1][j] == cpuSymbol &&
                        board.getBoard()[2][j] == cpuSymbol) {
                    board.makeMove(0, j, cpuSymbol);
                    moveMade = true;
                    break;
                }
            }
        }

        if(!moveMade) {
            //check for opportunities to block user
            //check if any diagonal is blockable
            if (board.getBoard()[0][0] == userSymbol &&
                    board.getBoard()[1][1] == userSymbol &&
                    board.getBoard()[2][2] == ' ') {
                board.makeMove(2, 2, cpuSymbol);
                moveMade = true;
            } else if (board.getBoard()[0][0] == userSymbol &&
                    board.getBoard()[1][1] == ' ' &&
                    board.getBoard()[2][2] == userSymbol) {
                board.makeMove(1, 1, cpuSymbol);
                moveMade = true;
            } else if (board.getBoard()[0][0] == ' ' &&
                    board.getBoard()[1][1] == userSymbol &&
                    board.getBoard()[2][2] == userSymbol) {
                board.makeMove(0, 0, cpuSymbol);
                moveMade = true;
            } else if (board.getBoard()[0][2] == userSymbol &&
                    board.getBoard()[1][1] == userSymbol &&
                    board.getBoard()[2][0] == ' ') {
                board.makeMove(2, 0, cpuSymbol);
                moveMade = true;
            } else if (board.getBoard()[0][2] == userSymbol &&
                    board.getBoard()[1][1] == ' ' &&
                    board.getBoard()[2][0] == userSymbol) {
                board.makeMove(1, 1, cpuSymbol);
                moveMade = true;
            } else if (board.getBoard()[0][2] == ' ' &&
                    board.getBoard()[1][1] == userSymbol &&
                    board.getBoard()[2][0] == userSymbol) {
                board.makeMove(0, 2, cpuSymbol);
                moveMade = true;
            }
        }

        if(!moveMade) {
            for (int j = 0; j < board.getColumns(); ++j) {
                //check if any row is blockable
                if (board.getBoard()[j][0] == userSymbol &&
                        board.getBoard()[j][1] == userSymbol &&
                        board.getBoard()[j][2] == ' ') {
                    board.makeMove(j, 2, cpuSymbol);
                    moveMade = true;
                    break;
                }
                else if (board.getBoard()[j][0] == userSymbol &&
                        board.getBoard()[j][1] == ' ' &&
                        board.getBoard()[j][2] == userSymbol) {
                    board.makeMove(j, 1, cpuSymbol);
                    moveMade = true;
                    break;
                }
                else if (board.getBoard()[j][0] == ' ' &&
                        board.getBoard()[j][1] == userSymbol &&
                        board.getBoard()[j][2] == userSymbol) {
                    board.makeMove(j, 0, cpuSymbol);
                    moveMade = true;
                    break;
                }

                //check if any column is blockable
                else if (board.getBoard()[0][j] == userSymbol &&
                        board.getBoard()[1][j] == userSymbol &&
                        board.getBoard()[2][j] == ' ') {
                    board.makeMove(2, j, cpuSymbol);
                    moveMade = true;
                    break;
                } else if (board.getBoard()[0][j] == userSymbol &&
                        board.getBoard()[1][j] == ' ' &&
                        board.getBoard()[2][j] == userSymbol) {
                    board.makeMove(1, j, cpuSymbol);
                    moveMade = true;
                    break;
                } else if (board.getBoard()[0][j] == ' ' &&
                        board.getBoard()[1][j] == userSymbol &&
                        board.getBoard()[2][j] == userSymbol) {
                    board.makeMove(0, j, cpuSymbol);
                    moveMade = true;
                    break;
                }
            }
        }

        if(!moveMade) {
            for (int x = 0; x < board.getRows(); x++) {
                for (int y = 0; y < board.getColumns(); y++) {
                    if (board.getBoard()[x][y] == ' ') {
                        board.makeMove(x, y, cpuSymbol);
                        moveMade = true;
                        break;
                    }
                }
                if (moveMade) {
                    break;
                }
            }
        }
    }

    public boolean isGameOver() {
        gameOver = false;
        //check for CPU Win
        //check diagonals
        if (board.getBoard()[0][0] == cpuSymbol &&
                board.getBoard()[1][1] == cpuSymbol &&
                board.getBoard()[2][2] == cpuSymbol){
            gameOver = true;
            setStatus('L');
        }
        else if (board.getBoard()[0][2] == cpuSymbol &&
                board.getBoard()[1][1] == cpuSymbol &&
                board.getBoard()[2][0] == cpuSymbol){
            gameOver = true;
            setStatus('L');
        }

        for (int j = 0; j < board.getColumns(); j++) {
            //check rows
            if (board.getBoard()[j][0] == cpuSymbol &&
                    board.getBoard()[j][1] == cpuSymbol &&
                    board.getBoard()[j][2] == cpuSymbol) {
                gameOver = true;
                setStatus('L');

            }
            //check columns
            else if (board.getBoard()[0][j] == cpuSymbol &&
                    board.getBoard()[1][j] == cpuSymbol &&
                    board.getBoard()[2][j] == cpuSymbol) {
                gameOver = true;
                setStatus('L');
                break;
            }
        }

        //check for User Win
        //check diagonals
        if (board.getBoard()[0][0] == userSymbol &&
                board.getBoard()[1][1] == userSymbol &&
                board.getBoard()[2][2] == userSymbol){
            gameOver = true;
            setStatus('W');
        }
        else if (board.getBoard()[0][2] == userSymbol &&
                board.getBoard()[1][1] == userSymbol &&
                board.getBoard()[2][0] == userSymbol){
            gameOver = true;
            setStatus('W');
        }

        for(int j = 0; j < board.getColumns(); ++j) {
            //check rows
            if (board.getBoard()[j][0] == userSymbol &&
                    board.getBoard()[j][1] == userSymbol &&
                    board.getBoard()[j][2] == userSymbol) {
                gameOver = true;
                setStatus('W');
                break;
            }
            //check columns
            else if (board.getBoard()[0][j] == userSymbol &&
                    board.getBoard()[1][j] == userSymbol &&
                    board.getBoard()[2][j] == userSymbol) {
                gameOver = true;
                setStatus('W');
                break;
            }
        }

        if(!gameOver) {
            boolean tie = true;
            for (int x = 0; x < board.getRows(); x++) {
                for (int y = 0; y < board.getColumns(); y++) {
                    if (board.getBoard()[x][y] == ' ') {
                        tie = false;
                        gameOver = false;
                        setStatus('A');
                        break;
                    }
                }
                if (!tie) {
                    break;
                }
            }
            if (tie) {
                gameOver = true;
                setStatus('T');
            }
        }
        return gameOver;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char s){
        status = s;
    }
}
