import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class prac30 {

    public static void main(String[] args) {
        // Read from console and write to file using BufferedReader and BufferedWriter
        System.out.println("23DIT012 Kris gadara"); 
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter("console_output.txt"))) {
             
            System.out.println("Enter text (type 'exit' to finish):");
            String line;
            while (!(line = consoleReader.readLine()).equalsIgnoreCase("exit")) {
                fileWriter.write(line);
                fileWriter.newLine();
            }
            System.out.println("Data has been written to console_output.txt");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Demonstrate character stream with FileReader and FileWriter
        try (FileReader fileReader = new FileReader("console_output.txt");
             FileWriter fileWriter = new FileWriter("copy_character_output.txt")) {

            int ch;
            while ((ch = fileReader.read()) != -1) {
                fileWriter.write(ch);
            }
            System.out.println("Character stream copy completed.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Demonstrate byte stream with FileInputStream and FileOutputStream
        try (FileInputStream fileInputStream = new FileInputStream("console_output.txt");
             FileOutputStream fileOutputStream = new FileOutputStream("copy_byte_output.txt")) {

            int b;
            while ((b = fileInputStream.read()) != -1) {
                fileOutputStream.write(b);
            }
            System.out.println("Byte stream copy completed.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
