import java.util.ArrayList;

public class Player extends User {
    private int position = 1, railroadsOwned = 0, jailCount = 0;
    private ArrayList<String> properties;

    public Player(String name) {
        this.name = name;
        this.balance = 15000;
        properties = new ArrayList<String>();
    }

    public int getPosition() {
        return position;
    }

    public void setJailCount(int count) {
        jailCount = count;
    }

    public String moveBy(int dice) throws BankruptException {
        if (jailCount > 0) {
            // Cannot move if the player is at jail
            jailCount -= 1;
            logAction(dice, name + " in jail (count=" + (3 - jailCount) + ")");
            return "";
        }

        int newPosition = ((position + dice - 1) % 40) + 1;
        if (newPosition < position && dice > 0) {
            // The player has passed the Go square by moving forward
            addBalance(200);
            Monopoly.banker.removeBalance(200);
        }
        position = newPosition;
        String action = Monopoly.squares[position].takeAction(this, dice);

        if (dice == -3) {
            // If this method was called by the "Go back 3 spaces" card, return the
            // action as a sub action, which will be concatenated with the super action
            return action;
        }

        // For all the other cases, just log the action
        logAction(dice, action);
        return "";
    }

    public String moveTo(int newPosition) throws BankruptException {
        /*
         * This method is only called in these 3 situations:
         * 1) An "Advance to Go" card was activated
         * 2) An "Advance to Leicester Square" card was activated
         * 3) Player moved to the "Go to Jail" square
         */
        if (newPosition < position && newPosition != 11 && newPosition != 1) {
            // The player has passed the Go square (not on it) and didn't go to jail
            addBalance(200);
            Monopoly.banker.removeBalance(200);
        }
        // The 1st situation is already handled at GoSquare class
        position = newPosition;

        // Return the outcome of the sub action, it will be concatenated with the
        // super-action
        // and then get printed on the same line
        return Monopoly.squares[position].takeAction(this, 0);
    }

    /**
     * @return The total number of railroads owned by the player
     */
    public int getRailroadsOwned() {
        return railroadsOwned;
    }

    /**
     * Adds a new railroad to the player's possessions
     */
    public void buyNewRailroad() {
        railroadsOwned += 1;
    }

    public void addProperty(String property) {
        properties.add(property);
    }

    public String getProperties() {
        return (properties.size() == 0 ? "" : " ") + String.join(",", properties);
    }

    void logAction(int dice, String action) {
        String data = name + "\t" + dice + "\t" + position + "\t" + Monopoly.players[0].getBalance() + "\t"
                + Monopoly.players[1].getBalance() + "\t" + action;
        Logger.log(data);
    }
}
