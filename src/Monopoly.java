import java.util.LinkedList;

public class Monopoly {
    private String pathCommand;
    public static LinkedList<Square> squares;
    public static Banker banker;

    public Monopoly(String pathCommand) {
        this.pathCommand = pathCommand;
        banker = new Banker("banker");
    }

    public void readSquares() {
        PropertyJsonReader pReader = new PropertyJsonReader();
        squares = pReader.getSquares();
    }

    public void readCards() {}
}
