import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Player{

    private char playerToken;
    private String name;
    private InputHandler input;


    public Player(){
        input = InputHandler.getInstance();
    }


    public void setName(String name){

        this.name = name;
    }

    public void setToken(char tokenChar){

        this.playerToken = tokenChar;
    }

    public char getToken(){
        return playerToken;
    }

    public int getMove(){
        int move = input.getIntInput();
        return move;
    }

    public String getName(){
        return this.name;
    }

}