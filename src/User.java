public abstract class User {
    protected String name;
    protected int money;

    public final String getName(){
        return name;
    }

    public abstract int getBalance();
    public abstract void addBalance(int diff);
}
