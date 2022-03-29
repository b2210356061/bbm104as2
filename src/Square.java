public abstract class Square {
    protected int id;
    protected String name;

    // This method will throw an exception with the name of the player who went bankrupt.
    public abstract void takeAction(Player player, int dice)
            throws BankruptException;
}
