package SnakeLadder;
import  java.util.*;
public class Dice {
    int diceCount;
    public Dice(int diceCount){
        this.diceCount=diceCount;
    }
    public int rollDice(){
        int c=0;
        int sum=0;
        Random r=new Random();
        while(c<diceCount){
            sum+=r.nextInt(6)+1;
            c++;
        }
        return  sum;
    }

}
