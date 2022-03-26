public abstract class User {
    protected String name;
    protected int balance;

    public final String getName() {
        return name;
    }

    public abstract int getBalance();
    public abstract void addBalance(int diff);
    public abstract void removeBalance(int diff) throws Exception;
}
