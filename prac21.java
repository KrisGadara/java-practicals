interface Shape {     String getColor();      double getArea();    
    default void printDescription() { 
        System.out.println("This is a shape with color: " + getColor() + " and area: " + getArea()); 
    } 
}  class Circle implements Shape {     private double radius;     private String color; 
     public Circle(double radius, String color) { 

        this.radius = radius;         this.color = color; 
    } 
 
    @Override     public String getColor() {         return this.color; 
    } 
 
    @Override     public double getArea() {         return Math.PI * radius * radius; 
    }      public double getRadius() {         return this.radius; 
    } 
}  class Rectangle implements Shape {     private double length;     private double width;     private String color; 
     public Rectangle(double length, double width, String color) {         this.length = length;         this.width = width;         this.color = color; 
    } 
 
    @Override     public String getColor() {         return this.color; 
    } 
 
    @Override     public double getArea() {         return this.length * this.width; 
    }      public double getLength() {         return this.length; 
    }      public double getWidth() {         return this.width; 
    } 
} 
 class Sign {     private Shape shape;     private String text; 
     public Sign(Shape shape, String text) {         this.shape = shape;         this.text = text; 
    }      public void displaySign() {         shape.printDescription(); // Calls the default method from Shape interface 
        System.out.println("Sign Text: " + text); 
    } 
}  public class prac21 { 
    public static void main(String[] args) {         System.out.println("23DIT012 Kris gadara"); 
        System.out.println("--------------------"); 
        Shape circle = new Circle(5.0, "Red"); 
         
        Shape rectangle = new Rectangle(4.0, 6.0, "Blue");  
        Sign circleSign = new Sign(circle, "Welcome to Campus"); 
        Sign rectangleSign = new Sign(rectangle, "Event Today!");  
        System.out.println("Circle Sign:");         circleSign.displaySign();  
        System.out.println("\nRectangle Sign:");         rectangleSign.displaySign(); 
    } 
} 
 
 
