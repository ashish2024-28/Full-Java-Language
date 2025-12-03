//Accessing a package from a java built-in APIs
import java.util.Scanner;
import java.lang.*; // math class is defined in this package

class calculator{
    double i;
    double x;
    void square_root(){
        x = Math.sqrt(i);
    }
}

class AccessingPackage{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        calculator c = new calculator();
        System.out.print("Enter value to find square root : ");
        c.i = in.nextInt();
        c.square_root(); 
        System.out.println("Square root of : "+ c.i + " is : "+ c.x);
    }
}