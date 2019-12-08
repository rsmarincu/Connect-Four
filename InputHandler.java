import java.io.BufferedReader;
import java.io.InputStreamReader;

public final class InputHandler {

    private static final InputHandler singleInstance = new InputHandler();

    public BufferedReader input;

    private InputHandler(){
        input = new BufferedReader(new InputStreamReader(System.in));
    }

    public static InputHandler getInstance(){
        return singleInstance;
    }

    public String getStringInput(){
        String toReturn = null;
        try{
            toReturn = input.readLine();
        }
        catch(Exception e){

        }
        return toReturn;
    }

    public int getIntInput(){
        String toReturn = null;

        int integerToReturn = 36000000;

        try{
            toReturn = input.readLine();
            integerToReturn = Integer.parseInt(toReturn);
        }
        catch(Exception e){

        }
        return integerToReturn;
    }

    public char getCharInput(){
        String toReturn = null;

        char token = ' ';

        try{
            toReturn = input.readLine();
            token = toReturn.charAt(0);
        }
        catch(Exception e){

        }
        return token;
    }

    public boolean getBooleanInput(){
        String toReturn = null;
        boolean bool = false;
        try{
            toReturn = input.readLine();
            if (toReturn.charAt(0) == 'y'){
                bool = true;
            }
            else{
                bool = false;
            }
        }
        catch(Exception e){

        }
        return bool;
    }

}
