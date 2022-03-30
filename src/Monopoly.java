import java.util.ArrayList;

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

}
