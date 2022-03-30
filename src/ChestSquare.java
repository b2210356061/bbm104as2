public class ChestSquare extends Square {
    private static int index = 0;

    @Override
    public String takeAction(Player player, int dice) throws BankruptException {
        Player otherPlayer = player.getName().equals("Player 2") ? Monopoly.players[0] : Monopoly.players[1];
        String action = Monopoly.chestCards.get(index).action.apply(player, otherPlayer);

        String value = Monopoly.chanceCards.get(index).getValue();
        index += 1;
        // Continue from the first card if all cards were played
        if (index == Monopoly.chestCards.size())
            index = 0;

        return player.getName() + " draw " + value + " " + action;
    }
}
