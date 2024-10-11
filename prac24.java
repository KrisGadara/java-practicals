class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

public class prac24 {

    public static void main(String[] args) {
        try {
            throwCustomException();
        } catch (CustomException e) {
            System.out.println("Caught an exception: " + e.getMessage());
        }
    }

    public static void throwCustomException() throws CustomException {
        throw new CustomException("This is a custom exception message.");
    }
}
