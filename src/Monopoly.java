import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Monopoly {
    private String pathCommand;
    public static ArrayList<Square> squares;
    public static ArrayList<Card> chanceCards, chestCards;
    public static Banker banker;
    public static Player[] players = new Player[2];

    public Monopoly(String pathCommand) {
        this.pathCommand = pathCommand;
        banker = new Banker("banker");
        players[0] = new Player("Player 1");
        players[1] = new Player("Player 2");
    }

    public void readSquares() {
        PropertyJsonReader pReader = new PropertyJsonReader();
        squares = pReader.getSquares();
    }

    public void readCards() {
        ListJsonReader lReader = new ListJsonReader();
        chanceCards = lReader.getChanceCards();
        chestCards = lReader.getChestCards();
    }

    private Stream<String> getCommands() {
        File file = new File(pathCommand);
        ArrayList<String> commands = new ArrayList<String>();
        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine().trim();
                commands.add(line);
            }
        } catch (Exception e) {
            System.out.println("An error occurred while reading from " + pathCommand);
        }
        return commands.stream();
    }

    private void logStatus() {
        Logger.log(Logger.SEPERATOR);
        Logger.log("Player 1\t" + players[0].getBalance() + "\thave: " + players[0].getProperties());
        Logger.log("Player 2\t" + players[1].getBalance() + "\thave: " + players[1].getProperties());
        Logger.log("Banker\t" + banker.getBalance());
        Logger.log(Logger.SEPERATOR);
    }

    public void executeCommands() {
        getCommands().forEach(line -> {
            try {
                if (line.equals("show()")) {
                    logStatus();
                } else {
                    Player player = line.startsWith("Player 1") ? players[0] : players[1];
                    int dice = Integer.parseInt(line.split(";")[1]);

                    player.moveBy(dice);
                }

            } catch (BankruptException e) {
                String bankruptee = e.getMessage();
            }
        });
    }
}
