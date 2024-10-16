import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class prac29 {

    public static void main(String[] args) {
        
        System.out.println("23DIT012 Kris gadara");         
        if (args.length != 2) {
            System.out.println("Usage: java FileCopy <sourcefile> <destinationfile>");
            return;
        }

        String sourceFile = args[0];
        String destinationFile = args[1];

        try {
            copyFile(sourceFile, destinationFile);
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            System.out.println("Error copying file: " + e.getMessage());
        }
    }

    public static void copyFile(String sourceFile, String destinationFile) throws IOException {
        try (FileReader reader = new FileReader(sourceFile);
             FileWriter writer = new FileWriter(destinationFile)) {
            int ch;
            while ((ch = reader.read()) != -1) {
                writer.write(ch);
            }
        }
    }
}
