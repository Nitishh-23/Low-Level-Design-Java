package TicTacToe.Model;


public class Board {
    public int size;
    public PlayingPiece[][] board;
    public Board(int size){
        this.size=size;
        board=new PlayingPiece[size][size];
    }
    public boolean addPiece(int row,int col,PlayingPiece piece){
        if(board[row][col]!=null){
            return false;
        }
        board[row][col]=piece;
        return  true;
    }
    public int getEmptyCells(){
        int ans=0;
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j]==null){
                    ans++;
                }
            }
        }
        return ans;
    }
    public void print(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(j==0) System.out.print("|");
                System.out.print(board[i][j]==null?" |":board[i][j].type.toString()+"|");
            }
            System.out.println();
            System.out.println("-------");
        }
    }
}
