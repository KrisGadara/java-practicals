import java.util.Scanner;

class Parent {
    void printParent() {
        System.out.println("This is parent class");
        
    }
}

class Child extends Parent {
    void printChild() {
        System.out.println("This is child class");
    }
}

public class inherit1 {
    public static void main(String[] args) {
      
       
        Parent parentObj = new Parent();
        parentObj.printParent();

       
        Child childObj = new Child();
        childObj.printChild(); 
       
        childObj.printParent();
        System.out.println("23dit012 Kris gadara");
    }
}
