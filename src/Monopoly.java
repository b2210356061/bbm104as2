import java.io.*;
import java.util.*;

public class Monopoly {
    private String pathCommand;
    public static Square[] squares;
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

    private ArrayList<String> getCommands() {
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
        return commands;
    }

    public void executeCommands() {
        int lastDice = 0;
        Player lastPlayer = null;
        for (String line : getCommands()) {
            try {
                if (line.equals("show()")) {
                    Logger.logStatus();
                } else {
                    lastPlayer = line.startsWith("Player 1") ? players[0] : players[1];
                    lastDice = Integer.parseInt(line.split(";")[1]);

                    lastPlayer.moveBy(lastDice);
                }

            } catch (BankruptException e) {
                lastPlayer.logAction(lastDice, lastPlayer.getName() + " goes bankrupt");
                break;
            }
        }
        Logger.logStatus();
    }
}
