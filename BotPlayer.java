import java.util.Random;

public class BotPlayer extends Player{

    private Random random = new Random();


    public BotPlayer() {
        super();
    }

    public int getMove(){
        int move = random.nextInt(6) + 1;
        return move;
    }
}
