import java.util.ArrayList;

public class Player extends User {
    private int position = 1, railroadsOwned = 0, jailCount = 0;
    private ArrayList<String> properties;

    public Player(String name) {
        this.name = name;
        this.balance = 15000;
        properties = new ArrayList<String>();
    }

    public void setJailCount(int count) {
        jailCount = count;
    }

    public void moveBy(int dice) throws BankruptException {
        if (jailCount > 0) {
            // Cannot move if the player is at jail
            jailCount -= 1;
            return;
        }

        int newPosition = ((position + dice - 1) % 40) + 1;
        if (newPosition < position && dice > 0) {
            // The player has passed the Go square by moving forward
            addBalance(200);
            Monopoly.banker.removeBalance(200);
        }
        position = newPosition;
        Monopoly.squares.get(position).takeAction(this, dice);
    }

    public void moveTo(int newPosition) throws BankruptException {
        /* This method is only called in these 3 situations:
        1) An "Advance to Go" card was activated
        2) An "Advance to Leicester Square" card was activated
        3) Player moved to the "Go to Jail" square
        */
        if (newPosition < position && newPosition != 11 && newPosition != 1) {
            // The player has passed the Go square (not on it) and didn't go to jail
            addBalance(200);
            Monopoly.banker.removeBalance(200);
        }
        // The 1st situation is already handled at GoSquare class
        position = newPosition;
        Monopoly.squares.get(position).takeAction(this, 0);
    }

    public int getRailroadsOwned() {
        return railroadsOwned;
    }

    public void buyNewRailroad() {
        railroadsOwned += 1;
    }

    public void addProperty(String property) {
        properties.add(property);
    }

    public String getProperties() {
        return String.join(",", properties);
    }
}
