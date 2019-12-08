import java.util.ArrayList;
import java.util.Arrays;

public class Board{

    private char[][] board;
    private ArrayList<Player> players;
    private int height;
    private int width;
    private int winCondition;

    public Board(ArrayList<Player> players){
        this.height = 6;
        this.width = 7;
        this.board = new char[height][width];
        this.players = players;
        this.winCondition = 4;
    }

    public void printBoard(){

        boolean match = false;

        char[] tokens = new char[players.size()];

        for (int i=0; i<players.size(); i++){
            tokens[i] = players.get(i).getToken();
        }

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++){
                for (char t : tokens){
                    if (t == board[i][j]){
                        match = true;
                        break;
                    }
                }
                if (match)
                {
                    System.out.print(String.format("| %c ", board[i][j]));
                    match = false;
                }
                else{
                    System.out.print("|   ");
                }
            }
            System.out.println("|");
        }
        System.out.println("  1   2   3   4   5   6   7");
    }

    public void addCounter(char token, int position){

        for (Player player : players){
            if(player.getToken() == token){
                for (int i=height-1; i>=0; i--){
                    if(board[i][position-1] == 0){
                        board[i][position-1] = token;
                        return;
                    }
                }
            }
        }
    }


    public boolean checkWin(){

        boolean win = false;

        for (Player player : players){
            win = checkHorizontalWin(player);
            if (win) return true;
            win = checkVerticalWin(player);
            if (win) return true;
            win = checkForwardDiagonalWin(player);
            if (win) return true;
            win = checkBackwardDiagonalWin(player);
            if (win) return true;
        }

        return win;
    }

    private boolean checkHorizontalWin(Player player){

        char toCheck = player.getToken();

        int count  = 0;

        for (int i=0; i<height; i++){
            for (int j=0; j<width; j++){
                if (board[i][j] == toCheck){
                    count = count + 1;
                    if (count >= winCondition){
                        return true;
                    }
                }
                else{
                    count = 0;
                }
            }
        }
        return false;
    }

    private boolean checkVerticalWin(Player player){

        char toCheck = player.getToken();

        int count  = 0;

        for (int i=0; i<width; i++){
            for (int j=0; j<height; j++){
                if (board[j][i] == toCheck){
                    count = count + 1;
                    if (count >= winCondition){
                        return true;
                    }
                }
                else{
                    count = 0;
                }
            }
        }
        return false;
    }

    private boolean checkBackwardDiagonalWin(Player player) {
        char toCheck = player.getToken();
        int count = 0;
        for (int i = 0; i <= height - winCondition; i++) {
            for (int j = 0; j <= width - winCondition; j++) {
                for (int k = 0; k < winCondition; k++) {
                    if (board[i + k][j + k] == toCheck) {
                        count = count + 1;
                        if (count >= winCondition) {
                            return true;
                        }
                    }
                    else{
                        count = 0;
                    }
                }
            }
        }
        return false;
    }

    private boolean checkForwardDiagonalWin(Player player) {

        char toCheck = player.getToken();

        int count = 0;

        for (int i = height-1; i >= 3 ; i--) {
            for (int j = 0; j <= width - winCondition; j++) {
                for (int k = 0; k < winCondition; k++) {
                    if (board[i - k][j + k] == toCheck) {
                        count = count + 1;
                        if (count >= winCondition) {
                            return true;
                        }
                    }
                    else{
                        count = 0;
                    }
                }
            }
        }
        return false;
    }

    public void setWinCondition(int n){
        this.winCondition = n;
    }
}