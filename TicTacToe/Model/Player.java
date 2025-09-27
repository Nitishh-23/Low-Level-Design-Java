package TicTacToe.Model;

public class Player {
    String name;
    PlayingPiece piece;
    public Player(String name, PlayingPiece piece){
        this.name=name;
        this.piece=piece;
    }
    public String getName(){
        return this.name;
    }
    public void setname(String name){
        this.name=name;
    }
    public PlayingPiece getPiece(){
        return this.piece;
    }
    public void setPiece(PlayingPiece piece){
        this.piece=piece;
    }
}
