package SnakeLadder;

public class Player {
    String id;
    int currPos;
    public Player(String id,int currPos){
        this.id=id;
        this.currPos=currPos;
    }
    public void setCurrPos(int pos){
        this.currPos=pos;
    }
}
