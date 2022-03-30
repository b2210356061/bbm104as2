public class ChestSquare extends Square {
    private static int index = 0;

    @Override
    public void takeAction(Player player, int dice) throws BankruptException {
        Player otherPlayer =
                player.getName().equals("Player 2") ? Monopoly.players[0] : Monopoly.players[1];
        Monopoly.chestCards.get(index).action.apply(player, otherPlayer);

        index += 1;
        // Continue from the first card if all cards were played
        if (index == Monopoly.chestCards.size()) index = 0;
    }
}
