public class Player extends User {
    private int position = 1, railroadsOwned = 0;

    public Player(String name) {
        this.name = name;
        this.balance = 15000;
    }

    public int getPosition() {
        return position;
    }

    public void moveBy(int dice) throws BankruptException {
        position = ((position + dice - 1) % 40) + 1;
        Monopoly.squares.get(position).takeAction(this, dice);
    }

    public int getRailroadsOwned() {
        return railroadsOwned;
    }

    public void buyNewRailroad() {
        railroadsOwned += 1;
    }
}
