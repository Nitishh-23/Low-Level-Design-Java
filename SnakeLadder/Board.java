package SnakeLadder;
import java.util.*;
public class Board {
    Cell[][] board;
    public Board(int size,int snakes,int ladders){
        init(size);
        addJumps(size,snakes,ladders);
    }
    public void init(int n){
        board=new Cell[n][n];
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = new Cell();
            }
        }
    }
    public void addJumps(int n,int snakes,int ladders){
        int total=n*n;
        Random r=new Random();
        while(snakes>0){
            int st=r.nextInt(total);
            int end=r.nextInt(total);
            if(end>=st){
                continue;
            }
            Cell c=getCell(st,n);
            c.setJump(new Jump(st,end));
            snakes--;
        }
        while(ladders>0){
            int st=r.nextInt(total);
            int end=r.nextInt(total);
            if(st>=end){
                continue;
            }
            Cell c=getCell(st,n);
            c.setJump(new Jump(st,end));
            ladders--;
        }
    }
    public Cell getCell(int curr,int n){
        int r=curr/n;
        int c=curr%n;
        if(r%2==1){
            c=n-1-c;
        }
        return  board[r][c];
    }
}
