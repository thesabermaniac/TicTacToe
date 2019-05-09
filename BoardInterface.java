public interface BoardInterface
{
    int getRows();
    int getColumns();
    void setRows(int r);
    void setColumns(int c);
    boolean isValidMove(int destRow, int destCol);
    void makeMove(int destRow, int destCol, char symbol);
    String printBoard();
    //boolean isGameOver();
    //String getStatus();
}
