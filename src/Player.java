public class Player extends User {
    private int position = 1, balance = 15000, railroadsOwned = 0;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public void addBalance(int diff) {
        balance += diff;
    }

    @Override
    public void removeBalance(int diff) throws Exception {
        balance -= diff;
        if (balance < 0) throw new Exception(name);
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

    public void boughtNewRailroad() {
        railroadsOwned += 1;
    }
}
