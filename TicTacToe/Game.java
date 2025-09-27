package TicTacToe;

import TicTacToe.Model.*;

import java.util.*;

public class Game {
    Deque<Player>players;
    Board board;
    public Game(){
        initialise();
    }
    public void initialise(){
        players=new ArrayDeque<>();
        board=new Board(3);
        PlayingPiece pieceX=new PieceX();
        PlayingPiece pieceO=new PieceO();
        Player p1=new Player("P1", pieceX);
        Player p2=new Player("P2", pieceO);
        players.addLast(p1);
        players.addLast(p2);
    }
    public String startGame(){
        Scanner sc=new Scanner(System.in);
        board.print();
        while (board.getEmptyCells()>0){
            Player p=players.removeFirst();
            PlayingPiece curr=p.getPiece();
            System.out.println(p.getName()+" Enter row and column of your piece: ");
            String pos=sc.nextLine();
            int r=pos.charAt(0)-'0',c=pos.charAt(2)-'0';
            while(!board.addPiece(r, c, curr)){
                System.out.println("incorrect position! please try again");
                pos=sc.nextLine();
                r=pos.charAt(0)-'0';
                c=pos.charAt(2)-'0';
            }
            board.print();
            if(isWinner(r,c,p)){
                return p.getName();
            }
            players.addLast(p);
        }
        return "Tie";
    }
    public boolean isWinner(int r, int c, Player p) {
        PlayingPiece curr = p.getPiece();
        boolean ans = true;

        // 1. Row Check (Your original code was correct)
        for (int i = 0; i < board.size; i++) {
            if (board.board[r][i] == null || board.board[r][i].type != curr.type) {
                ans = false;
                break;
            }
        }
        if (ans) return true;

        // 2. Column Check (Your original code was correct)
        ans = true;
        for (int i = 0; i < board.size; i++) {
            if (board.board[i][c] == null || board.board[i][c].type != curr.type) {
                ans = false;
                break;
            }
        }
        if (ans) return true;

        // 3. Main Diagonal Check (FIX: Added a condition to only check if the move is on the diagonal)
        if (r == c) {
            ans = true;
            for (int i = 0, j = 0; i < board.size && j < board.size; i++, j++) {
                if (board.board[i][j] == null || board.board[i][j].type != curr.type) {
                    ans = false;
                    break;
                }
            }
            if (ans) return true;
        }

        // 4. Anti-Diagonal Check (FIX: Added a condition to only check if the move is on the diagonal)
        if (r + c == board.size - 1) {
            ans = true;
            for (int i = 0, j = board.size - 1; i < board.size && j >= 0; i++, j--) {
                if (board.board[i][j] == null || board.board[i][j].type != curr.type) {
                    ans = false;
                    break;
                }
            }
            return ans;
        }

        // (FIX: Removed the two redundant loops that were here)

        // If no win condition was met, the player is not a winner.
        return false;
    }
}
