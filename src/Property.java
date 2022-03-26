public class Property extends Square {
    enum Type { LAND, RAILROAD, COMPANY }
    private int cost;
    private Type type;
    private Player owner;

    public Property(int id, String name, int cost, Type type) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.type = type;
    }

    private int calculateRent(int dice) {
        switch (type) {
            case LAND:
                if (cost <= 200)
                    return (int) (cost * 0.4);
                else if (cost <= 300)
                    return (int) (cost * 0.3);
                else
                    return (int) (cost * 0.35);

            case COMPANY:
                return 4 * dice;

            case RAILROAD:
                return 25 * owner.getRailroadsOwned();
            default:
                return 0;
        }
    }

    @Override
    public void takeAction(Player visitor, int dice) throws Exception {
        if (owner == null) { // Nobody owns this property
            if (visitor.getBalance() >= cost) { // player will buy if he/she can afford it
                owner = visitor;
                visitor.removeBalance(cost);
            }
        } else { // The other player owns this property
            int rent = calculateRent(dice);
            visitor.removeBalance(rent);
        }
    }
}
