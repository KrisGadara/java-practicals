/*1. User-Defined Exception Program */

class UserDefinedException extends Exception {
    public UserDefinedException(String message) {
        super(message);
    }
}

public class prac25 {

    public static void main(String[] args) {
        try {
            methodThatThrowsException();
        } catch (UserDefinedException e) {
            System.out.println("Caught an exception: " + e.getMessage());
        }
        System.out.println("23DIT012 Kris gadara");   
    }

    public static void methodThatThrowsException() throws UserDefinedException {
        throw new UserDefinedException("This is a user-defined exception.");
    }
}

/*2. Program Differentiating Checked and Unchecked Exceptions 

 public class Prac25 {

    public static void main(String[] args) {
        // Checked Exception Example
        try {
            throw new java.io.IOException("This is a checked exception.");
        } catch (java.io.IOException e) {
            System.out.println("Caught a checked exception: " + e.getMessage());
        }

        // Another Checked Exception Example
        try {
            throw new java.sql.SQLException("This is another checked exception.");
        } catch (java.sql.SQLException e) {
            System.out.println("Caught another checked exception: " + e.getMessage());
        }

        // Unchecked Exception Example
        try {
            throw new ArithmeticException("This is an unchecked exception.");
        } catch (ArithmeticException e) {
            System.out.println("Caught an unchecked exception: " + e.getMessage());
        }

        // Another Unchecked Exception Example
        try {
            throw new NullPointerException("This is another unchecked exception.");
        } catch (NullPointerException e) {
            System.out.println("Caught another unchecked exception: " + e.getMessage());
        }
    }
}

*/