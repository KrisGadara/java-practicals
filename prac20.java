public class prac20 { 
    public static void main(String[] args) {         
        System.out.println("23DIT012 Kris gadara"); 
        System.out.println("--------------------");  
               degree D = new degree();         undergraduate U = new undergraduate();         postgraduate P = new postgraduate(); 
        D.getdegree();        
         U.getdegree(); 
        P.getdegree(); 
 
    } 
     } class degree{ 
    void getdegree(){ 
        System.out.println("I got degree"); 
 
    } } class undergraduate extends degree{     
        void getdegree(){ 
        System.out.println("I am undergraduate"); 
 
    } 
 } class postgraduate extends degree{    
     void getdegree(){ 
        System.out.println("I am postgraduate"); 
    } 
 
} 
 
