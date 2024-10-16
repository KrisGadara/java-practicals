public class prac24 { 
    public static void main(String[] args) {     
            System.out.println("23DIT012 Kris gadara");   
                  System.out.println("--------------------");         try {             throw new Exception("This is a custom exception");  
        } catch (Exception e) { 
            System.out.println("Caught Exception: " + e.getMessage()); 
        } 
    } 
} 
