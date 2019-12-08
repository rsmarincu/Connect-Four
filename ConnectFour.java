import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class ConnectFour {

    public static void main(String[] args) {
        new ConnectFour();
    }

    private ArrayList<Player> players;
    private InputHandler input;
    private Board board;

    public ConnectFour() {
        players = new ArrayList<Player>();
        input = InputHandler.getInstance();
        setPlayers();
        board = new Board(players);
        board.printBoard();

        PlayGame();


    }

    private void setPlayers() {

        System.out.println("Choose the number of player, between 2 and 4 players: ");
        int numberOfPlayers = input.getIntInput();

        if (!(2 <= numberOfPlayers & numberOfPlayers <= 4)) {
            System.out.println("Incorect number of players!");
            setPlayers();
        }
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Is this player a bot? [y/n]");
            boolean isbot = input.getBooleanInput();
            if (isbot) {
                Player player = new BotPlayer();
                String botName = "Bot " + i;
                player.setName(botName);
                System.out.println(player.getName());
                System.out.println("Set token for " + player.getName() + ".");
                char token = input.getCharInput();
                player.setToken(token);
                this.players.add(player);
                continue;
            }

            this.players.add(new Player());

            System.out.println("Set name for player " + i + ".");
            String name = input.getStringInput();
            this.players.get(i).setName(name);

            System.out.println("Set token for " + name + ".");
            char token = input.getCharInput();
            this.players.get(i).setToken(token);
        }
    }

    private void PlayGame() {

        boolean win = false;
        while (!win) {
            for (Player player : players) {
                int move = player.getMove();
                board.addCounter(player.getToken(), move);
                board.printBoard();
                win = board.checkWin();
                if (win) {
                    System.out.println(String.format("%s has won.", player.getName()));
                    break;
                }
            }
        }
    }
}
