
public class Basic{
    public static void main(String args[]){
        // primitive type => boolean, int, float, char, byte, short, double, long
        int a = 10;

        // Wrapper Class => Boolean, Interger, Float, Character, Byte, Short, Double, Long

        // Two ways => autoboxing means primitive to wrapper
        Integer i = Integer.valueOf(a);
        Integer j =a ; //this concept called autoboxing

        // Two ways => Unboxing means convert Wrapper to primitive data type
        int b = i.intValue();
        int c = j;  //this concept called unboxing

        System.out.printf("\nint a = 10;\na = %d\n",a);
        System.out.printf("\nInteger i  = Integer.valueOf(a); \ni = %d\n",i);
        System.out.printf("\nInteger j = a; \nj = %d\n",j);
        System.out.printf("\nint b = i.intValue\nb = %d\n ",b);
        System.out.printf("\nint a = j;\nc = %d\n",c);
    }
}