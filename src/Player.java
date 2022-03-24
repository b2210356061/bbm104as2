public class Player {
    private int position = 1, balance = 15000;

    public int getPosition(){
        return position;
    }

    public void move(int squares) {
        position = ((position + squares -1) % 40) +1;
    }

    public int getBalance() {
        return balance;
    }

    public void addBalance(int cash) {
        balance += cash;
    }

}
