import java.io.BufferedReader; import java.io.FileReader; import java.io.IOException; 
 public class prac26 { 
    public static void main(String[] args) {        
         System.out.println("23DIT012 Kris gadara");        
          System.out.println("--------------------");       
            if (args.length == 0) { 
            System.out.println("Usage: java prac26 <file1> <file2> ... <fileN>"); 
            return; 
        } 
         for (String fileName : args) { 
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {                 int lineCount = 0;                 while (reader.readLine() != null) {                     lineCount++; 
                } 
                System.out.println(fileName + ": " + lineCount + " lines"); 
            } catch (IOException e) { 
                System.out.println("Error reading file " + fileName + ": " + e.getMessage()); 
            } 
        } 
    } 
} 
 
