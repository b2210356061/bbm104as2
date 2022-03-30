public abstract class Square {
    protected int id;
    protected String name;

    /**
     *
     * @param player : The player of interest
     * @param dice   : The dice rolled
     * @return Returns the action to be logged
     * @throws BankruptException if a player wents bankrupt, with the player's name
     *                           as the message
     */
    public abstract String takeAction(Player player, int dice)
            throws BankruptException;
}
