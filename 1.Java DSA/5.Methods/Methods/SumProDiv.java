import java.util.Scanner;
public class SumProDiv{
    public static void AddSubProDiv(int a, int b){
       int Add = a + b;
        System.out.println("Addition is :"+Add);
       int Sub = a - b;
        System.out.println("Subtraction is :"+Sub);
       int Pro = a * b;
        System.out.println("Product is :"+Pro);
       double Div = a /b;
        System.out.println("Division is :"+Div);
       int Remainder = a%b;
        System.out.println("Remainder is :"+Remainder);
    }
    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any number :");
        int a = sc.nextInt();
        System.out.println("Enter any number :");
        int b = sc.nextInt();
        AddSubProDiv(a,b);

    }
}