public class BankruptException extends Exception {
    /**
     * An exception to throw when a player goes bankrupt
     *
     * @param bankruptee : The name of the player who went bankrupt. Can be accessed
     *                   via exception.getMessage() method
     */
    public BankruptException(String bankruptee) {
        super(bankruptee);
    }
}
