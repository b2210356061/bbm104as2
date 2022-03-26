import java.io.*;

public class Logger {
    public static final String SEPERATOR =
            "-----------------------------------------------------------------------------------------------------------";

    public static void log(String data) {
        File file = new File("output.txt");
        boolean isNewFile = !file.exists();
        try (FileWriter writer = new FileWriter(file, true)) {
            if (!isNewFile) writer.write("\n");
            writer.write(data);
        } catch (Exception e) {
            System.out.println("An error occurred while writing to output.txt}\n" + e.toString());
        }
    }
}