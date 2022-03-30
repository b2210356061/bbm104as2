public class GoToJailSquare extends Square {
    @Override
    public String takeAction(Player player, int dice) throws BankruptException {
        player.moveTo(11);
        player.setJailCount(3);
        return player.getName() + " went to jail";
    }
}
