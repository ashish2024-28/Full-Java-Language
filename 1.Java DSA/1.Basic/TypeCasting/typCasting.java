public class typCasting{
    public static void main(String args[]){
        // 1.Widening
        // final keywords for Constant
        final int a = 10;
        double b = a;
        System.out.format("Implicit Type Casting %nint = %d  double = %f %n",a,b);

        double c = 9.999;
        int d = (int)c;
        System.out.format("Explicit Type Casting %ndouble = %f  int = %d %n",c,d);

        int e = 123;
        String f = String.valueOf(e);
        System.out.format("Number to String %nint = %d  String = %s %n",e,f);

        
        String g = "123";
        int h = Integer.parseInt(g) ;
        System.out.format("String to Number %nString = %s  int = %d %n",g,h);
    }
}