import java.util.HashMap;

public class Card {
    // This method, action, will be called when this card is activated and return
    // the resulting action
    public ThrowingBiFunction<Player, Player, String> action;
    private String value;

    /**
     * Sets the action for a new card
     * 
     * @param item : The value of the card
     */
    public Card(String item) {
        item = item.trim();
        value = item;
        HashMap<String, Integer> financeWithBanker = new HashMap<String, Integer>() {
            {
                put("Pay poor tax of $15", -15);
                put("Your building loan matures - collect $150", 150);
                put("You have won a crossword competition - collect $100", 100);
                put("Bank error in your favor - collect $75", 75);
                put("Doctor's fees - Pay $50", -50);
                put("Income Tax refund - collect $20", 20);
                put("Life Insurance Matures - collect $100", 100);
                put("Pay Hospital Fees of $100", -100);
                put("Pay School Fees of $50", -50);
                put("You inherit $100", 100);
                put("From sale of stock you get $50", 50);
            }
        };

        HashMap<String, Integer> financeWithOtherPlayer = new HashMap<String, Integer>() {
            {
                put("It is your birthday Collect $10 from each player", 10);
                put("Grand Opera Night - collect $50 from every player for opening night seats", 50);
            }
        };

        if (financeWithBanker.containsKey(item)) {
            // Situations including payment between the player and the banker
            int diff = financeWithBanker.get(item);
            action = (player, __) -> {
                if (diff > 0) {
                    // The banker pays the player
                    player.addBalance(diff);
                    Monopoly.banker.removeBalance(diff);
                } else {
                    // Player pays the banker
                    player.removeBalance(diff);
                    Monopoly.banker.addBalance(diff);
                }
                return "";
            };
        } else if (financeWithOtherPlayer.containsKey(item)) {
            // Situations in which other player pays the current player
            int diff = financeWithOtherPlayer.get(item);
            action = (player, otherPlayer) -> {
                otherPlayer.removeBalance(diff);
                player.addBalance(diff);
                return "";
            };
        } else {
            // Other situations including movement
            if (item.equals("Go back 3 spaces")) {
                action = (player, __) -> {
                    String subAction = player.moveBy(-3);
                    return " " + subAction;
                };
            } else if (item.equals("Advance to Go (Collect $200)")) {
                action = (player, __) -> {
                    player.moveTo(1);
                    return "";
                };
            } else if (item.equals("Advance to Leicester Square")) {
                action = (player, __) -> {
                    String subAction = player.moveTo(27);
                    return " " + subAction;
                };
            }
        }
    }

    /**
     * @return The value of the card
     */
    public String getValue() {
        return value;
    }
}
