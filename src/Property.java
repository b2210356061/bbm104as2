public class Property extends Square {
    enum Type {
        LAND, RAILROAD, COMPANY
    }

    private int cost;
    private Type type;
    private Player owner;

    public Property(int id, String name, int cost, Type type) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.type = type;
    }

    /**
     * Calculates the rent of this property
     * 
     * @param dice : The dice player has rolled
     * @return The amount of rent player should pay
     */
    private int calculateRent(int dice) {
        switch (type) {
            case LAND:
                if (cost <= 2000)
                    return (int) (cost * 0.4);
                else if (cost <= 3000)
                    return (int) (cost * 0.3);
                else
                    return (int) (cost * 0.35);

            case RAILROAD:
                return 25 * owner.getRailroadsOwned();

            case COMPANY:
                return 4 * dice;

            default:
                return 0;
        }
    }

    @Override
    public String takeAction(Player visitor, int dice) throws BankruptException {
        if (owner == null) { // Nobody owns this property
            if (visitor.getBalance() > cost) { // player will buy if he/she can afford it
                owner = visitor;
                owner.addProperty(this.name);
                visitor.removeBalance(cost);
                Monopoly.banker.addBalance(cost);
                if (type == Type.RAILROAD)
                    visitor.buyNewRailroad();

                return visitor.getName() + " bought " + this.name;
            } else { // The player couldn't afford to buy this property, meaning he/she went bankrupt
                throw new BankruptException();
            }
        } else if (owner != visitor) { // The other player owns this property
            int rent = calculateRent(dice);
            visitor.removeBalance(rent);
            owner.addBalance(rent);

            return visitor.getName() + " paid rent for " + this.name;
        } else { // The visitor already owns this property
            return visitor.getName() + " has " + this.name;
        }
    }
}
