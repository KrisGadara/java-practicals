import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class prac26 {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No files specified.");
            return;
        }

        for (String fileName : args) {
            try {
                int lineCount = countLines(fileName);
                System.out.println(fileName + ": " + lineCount + " lines");
            } catch (IOException e) {
                System.out.println("Error reading file " + fileName + ": " + e.getMessage());
            }
        }
    }

    public static int countLines(String fileName) throws IOException {
        int lineCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
            }
        }
        return lineCount;
    }
}
