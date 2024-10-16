import java.util.Scanner;

public class prac23 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("23DIT012 Kris gadara"); 
        try {
            System.out.print("Enter the first integer (x): ");
            int x = Integer.parseInt(scanner.nextLine());
            

            
            System.out.print("Enter the second integer (y): ");
            int y = Integer.parseInt(scanner.nextLine());
            
            if (y == 0) {
                throw new ArithmeticException("Division by zero is not allowed.");
            }
            
            int result = x / y;
            System.out.println("The result of " + x + " divided by " + y + " is: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Error: Input is not a valid integer.");
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
