import java.io.BufferedReader; import java.io.FileReader; import java.io.IOException; 
 public class prac27 { 
    public static void main(String[] args) {       
          System.out.println("23DIT012 Kris gadara");     
              System.out.println("--------------------");      
                 if (args.length != 2) { 
            System.out.println("Usage: java pr27 <character> <filename>");    
                     return; 
        } 
 
        char characterToCount = args[0].charAt(0);       
          String filename = args[1];         int count = 0; 
         try (BufferedReader br = new BufferedReader(new FileReader(filename)))
{ 
            String line;            
             while ((line = br.readLine()) != null) {           
                     for (char c : line.toCharArray()) {                   
                          if (c == characterToCount) {      
                                               count++; 
                    } 
                } 
            } 
        } catch (IOException e) { 
            System.err.println("Error reading file: " + e.getMessage()); 
        } 
 
        System.out.println("The character '" + characterToCount + "' appears "
+ count + " times in the file '" + filename + "'."); 
    } }
