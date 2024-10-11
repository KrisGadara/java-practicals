public class prac18 {
   public static void main(String[] args) {
      rectangal re;
      re = new rectangal(5, 10);
      re.putdata();
      squer sq;
      sq = new squer(5);
      sq.putdata();
   }
}
class rectangal{
   int length;
   int width;
   int area;
   int perimeter;
   public
    rectangal(int length, int width){
      this.length = length;
      this.width = width;
      this.area = length * width;
      this.perimeter = 2 * (length + width);
    }
    void putdata()
    {
      System.out.println("area:-"+area+"\nprimeter"+perimeter);
    }
}
class squer extends rectangal{
  
   public
    squer(int side){
      super(side,side);
    }
    
}
