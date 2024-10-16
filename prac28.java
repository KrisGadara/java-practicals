import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class prac28 {

    public static void main(String[] args) {
        
        System.out.println("23DIT012 Kris gadara");     
        if (args.length != 2) {
            System.out.println("Usage: java WordSearch <filename> <word>");
            return;
        }

        String fileName = args[0];
        String wordToSearch = args[1];

        try {
            int occurrences = countWordOccurrences(fileName, wordToSearch);
            System.out.println("The word '" + wordToSearch + "' appears " + occurrences + " times in " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading file " + fileName + ": " + e.getMessage());
        }

        Integer exampleNumber = 123;
        int primitiveNumber = exampleNumber;
        System.out.println("Wrapper class Integer contains: " + exampleNumber);
        System.out.println("Primitive int value: " + primitiveNumber);
    }

    public static int countWordOccurrences(String fileName, String wordToSearch) throws IOException {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equalsIgnoreCase(wordToSearch)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
