import javax.swing.*;

public class TicTacToeBoard implements BoardInterface {
    private int rows;
    private int columns;
    private char[][] board;
    private String verticalSeparator;
    private String boardDesign = "";

    public TicTacToeBoard(){
        setRows(3);
        setColumns(3);
        board = new char[rows][columns];
        initBoard();
        verticalSeparator = "|";
    }


    @Override
    public int getRows() {
        return rows;
    }

    @Override
    public int getColumns() {
        return columns;
    }

    public char[][] getBoard(){
        return board;
    }

    @Override
    public void setRows(int r) {
        rows = r;
    }

    @Override
    public void setColumns(int c) {
        columns = c;
    }

    @Override
    public boolean isValidMove(int destRow, int destCol) {
        int row;
        int column;
        char userSymbol = 'X';
        boolean validMove;
        if(board[destRow][destCol] == ' '){
            validMove = true;
        }
        else{
            validMove = false;
            JOptionPane.showMessageDialog(null, "Invalid move. Please try again.");
            row = Integer.parseInt(JOptionPane.showInputDialog("Enter the row you want to move in (1-3)?"));
            column = Integer.parseInt(JOptionPane.showInputDialog("Enter the column you want to move in (1-3)?"));
            makeMove(row - 1, column - 1, userSymbol);
        }
        return validMove;
    }

    @Override
    public void makeMove(int destRow, int destCol, char symbol) {
        if(isValidMove(destRow, destCol)){
            board[destRow][destCol] = symbol;
        }
    }


    public void initBoard(){
        int height = 3;
        int width = 3;

        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                board[i][j] = ' ';
            }
        }
    }

    @Override
    public String printBoard() {
        int height = 3;
        int width = 3;
        boardDesign = "";

        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                boardDesign += board[i][j];
                if(j < width - 1) {
                    boardDesign += verticalSeparator;
                }
            }
            boardDesign += '\n';

            /**if(i < height - 1) {
                boardDesign += horizontalSeparator;
                boardDesign += '\n';
            }*/

        }
        return boardDesign;
    }
}
