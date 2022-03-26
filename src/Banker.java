public class Banker extends User {
    // The balance for banker is static because there's only one banker in the game
    private static int balance = 100000;

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
    }
}
