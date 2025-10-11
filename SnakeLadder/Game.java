package SnakeLadder;

import java.util.ArrayDeque;
import java.util.Deque;

public class Game {
    Board board;
    Dice dice;
    Deque<Player>dq;
    int n;
    public Game(int size){
        n=size;
        init();
    }
    public void init(){
        board=new Board(n,5,4);
        dice=new Dice(1);
        dq=new ArrayDeque<>();
        addPlayers();
    }
    public void addPlayers(){
        Player p1=new Player("P1",0);
        Player p2=new Player("P2",0);
        dq.addFirst(p2);
        dq.addFirst(p1);
    }

    public void startGame(){
        Player winner=null;
        int total=board.board.length*board.board.length;
        total-=1;
        while(winner==null) {
            Player curr = dq.removeFirst();
            int points = dice.rollDice();
            int pos = curr.currPos;
            System.out.println("Current player is "+curr.id+" in position "+(pos+1)+" scored "+points);
            pos += points;
            if (pos >= total) {
                winner = curr;
                pos=total;
            } else {
                Cell c = board.getCell(pos, n);
                if (c.jump != null) {
                    int end = c.jump.end;
                    if (end > pos) {
                        System.out.println("Ladder encountered");
                    } else {
                        System.out.println("Snake encountered");
                    }
                    pos = end;
                }
                if (pos >= total) {
                    winner = curr;
                    pos=total;
                }
            }
            curr.setCurrPos(pos);
            System.out.println(curr.id+" moves to "+(pos+1));
            dq.addLast(curr);
        }
        System.out.println("Winner is :"+winner.id);
    }
}
