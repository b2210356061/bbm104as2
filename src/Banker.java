public class Banker extends User {
    /**
     * Constructs a banker with the given name
     * 
     * I could've implemented a singleton pattern here to ensure that there's only
     * one banker object at a time but I'm just too lazy
     * 
     * @param name : The name of the banker
     */
    public Banker(String name) {
        this.name = name;
        this.balance = 100000;
    }
}
