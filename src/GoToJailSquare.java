public class GoToJailSquare extends Square {
    @Override
    public void takeAction(Player player, int dice) throws BankruptException {
        player.moveTo(11);
        player.setJailCount(3);
    }
}
