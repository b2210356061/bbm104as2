public class DummySquare extends Square {
    /**
     * This type of square does nothing other than printing when a player lands on
     * it
     * Just like "Free Parking" and "Go" squares.
     */
    private final String placeName;

    public DummySquare(String name) {
        placeName = name;
    }

    @Override
    public String takeAction(Player player, int dice) throws BankruptException {
        return player.getName() + " is in " + placeName;
    }
}
