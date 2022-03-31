import java.io.*;

public class Logger {
    public static final String SEPERATOR = "-----------------------------------------------------------------------------------------------------------";

    public static void log(String data) {
        File file = new File("output.txt");
        boolean isNewFile = !file.exists();
        try (FileWriter writer = new FileWriter(file, true)) {
            if (!isNewFile)
                writer.write("\n");
            writer.write(data);
        } catch (Exception e) {
            System.out.println("An error occurred while writing to output.txt}\n" + e.toString());
        }
    }

    public static void logStatus() {
        int balance1 = Monopoly.players[0].getBalance(), balance2 = Monopoly.players[1].getBalance();
        String winner;
        if (balance1 > balance2)
            winner = "Winner Player 1";
        else if (balance2 > balance1)
            winner = "Winner Player 2";
        else
            winner = "No winner, it's a tie";

        log(SEPERATOR);
        log("Player 1\t" + balance1 + "\thave:" + Monopoly.players[0].getProperties());
        log("Player 2\t" + balance2 + "\thave:" + Monopoly.players[1].getProperties());
        log("Banker\t" + Monopoly.banker.getBalance());
        log(winner);
        log(SEPERATOR);
    }
}