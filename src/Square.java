public abstract class Square {
    protected int id;
    protected String name;

    /**
     * Executes the predefined action of the square
     * 
     * @param player : The player of interest
     * @param dice   : The dice player has rolled
     * @return Returns the action to be logged
     * @throws BankruptException if a player wents bankrupt
     */
    public abstract String takeAction(Player player, int dice)
            throws BankruptException;
}
