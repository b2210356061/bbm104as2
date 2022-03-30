public class DummySquare extends Square {
    // This type of square does nothing when a player lands on it
    // Just like "Free Parking" and "Jail" squares.
    @Override
    public String takeAction(Player player, int dice) throws BankruptException {
        return null;
    }
}
