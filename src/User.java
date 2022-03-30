public abstract class User {
    protected String name;
    protected int balance;

    public final String getName() {
        return name;
    }

    public final int getBalance(){
        return balance;
    }

    public final void addBalance(int diff) {
        balance += diff;
    }

    public final void removeBalance(int diff) throws BankruptException {
        if (balance < 0) throw new BankruptException(name);
        balance -= diff;
    }
}
