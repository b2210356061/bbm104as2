
public class Main {
    public static void main(String[] args) {
        Monopoly game = new Monopoly(args[0]);
        game.readSquares();
        game.readCards();
        game.executeCommands();
    }
}
