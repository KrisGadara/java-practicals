public class pac20 {

    public static void main(String []args)
    {
        degree d = new degree();
        undergraduate u = new undergraduate();
        postgraduate p = new postgraduate();
        d.getdegree();
        u.print();
        p.print();
    }
    
}

class degree {

    void getdegree()
    {
     System.out.println("I got a degree");   
    }
}

class undergraduate extends degree{

    void print()
    {
        System.out.println("I am an undergraduate");
    }
}

class postgraduate extends degree 
{
     void print()
     {
        System.out.println("I am a postgraduate");
     }
 

}
