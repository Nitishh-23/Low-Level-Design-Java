package TicTacToe;

public class Main {
    public static void main(String[] args) {
        Game game=new Game();
        String winner=game.startGame();
        if(winner.equals("Tie")){
            System.out.println("Game Tied!");
        }
        else {
            System.out.println(winner+" wins the Game!");
        }
    }
}
