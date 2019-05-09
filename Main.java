public class Main {
    public static void main(String[] args) {
        TicTacToeGameplay myGame = new TicTacToeGameplay();
        myGame.playGame();
        System.out.println(myGame.board.printBoard());
    }
}
