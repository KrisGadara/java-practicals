public interface Shape 
{
    String getColor();
    double calculateArea();
    default void displayDetails() {
    System.out.println("Color: " + getColor());
    }
}

class Circle implements Shape {
    private double radius;
    private String color;

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle implements Shape {
    private double length;
    private double width;
    private String color;

    public Rectangle(double length, double width, String color) {
        this.length = length;
        this.width = width;
        this.color = color;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

class Sign {
    private Shape shape;
    private String text;

    public Sign(Shape shape, String text) {
        this.shape = shape;
        this.text = text;
    }

    public void displaySign() {
        shape.displayDetails();
        System.out.println("Text: " + text);
        System.out.println("Area: " + shape.calculateArea());
    }
}

public class Shape {
    public static void main(String[] args) {
        Shape circle = new Circle(5.0, "Red");
        Shape rectangle = new Rectangle(4.0, 6.0, "Blue");

        Sign circleSign = new Sign(circle, "Hello, World!");
        Sign rectangleSign = new Sign(rectangle, "Welcome to the Campus Center!");

        circleSign.displaySign();
        System.out.println();
        rectangleSign.displaySign();
    }
}