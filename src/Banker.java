public class Banker extends User {
    /**
     * Constructs a banker with the given name
     * @param name : The name of the banker
     */
    public Banker(String name) {
        this.name = name;
        this.balance = 100000;
    }
}
