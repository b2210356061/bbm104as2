public class Player extends User {
    private int position = 1, railroadsOwned = 0;

    public Player(String name) {
        this.name = name;
        this.balance = 15000;
    }

    public int getPosition() {
        return position;
    }

    public void move(int squares) {
        position = ((position + squares - 1) % 40) + 1;
    }

    public int getRailroadsOwned() {
        return railroadsOwned;
    }

    public void buyNewRailroad() {
        railroadsOwned += 1;
    }
}
