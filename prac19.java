public class prac19 {

    public static void main(String[] args)
    {
        square s =new square();
        s.print();
        s.print1();
        System.out.println("23DIT012-Kris gadara");         
    }
    
}

class shape
{
    void print()
    {
        System.out.println("This is a shape");
    }
}

class rectangle extends shape
{
    void print1()
    {
        System.out.println("This is  rectangular shape");
    }
}

class circle extends shape
{

    void print2()
    {
        System.out.println("This is a circular shape");
    }
}

class square extends rectangle{

    void print3()
    {
        System.out.println("square is a rectangle");
    }
}
