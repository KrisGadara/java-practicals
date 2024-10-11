import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class prac27 {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Prac25 <filename> <character>");
            return;
        }

        String fileName = args[0];
        char characterToCount = args[1].charAt(0);

        if (args[1].length() != 1) {
            System.out.println("Error: The second argument must be a single character.");
            return;
        }

        try {
            int count = countCharacterOccurrences(fileName, characterToCount);
            System.out.println("The character '" + characterToCount + "' appears " + count + " times in " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading file " + fileName + ": " + e.getMessage());
        }
    }

    public static int countCharacterOccurrences(String fileName, char characterToCount) throws IOException {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int ch;
            while ((ch = reader.read()) != -1) {
                if ((char) ch == characterToCount) {
                    count++;
                }
            }
        }
        return count;
    }
}
