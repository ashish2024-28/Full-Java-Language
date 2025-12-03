import java.util.*;

public class SwitchCase{
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter First Number : ");
        double x = sc.nextDouble();

        System.out.print("Enter Second Number : ");
        double y = sc.nextDouble();
        
        System.out.println("Enter the Operator to perform the operation \n(+,-,*,/,%) : ");
        char ch = sc.next().charAt(0);

        switch(ch) {
            case '+' : 
                System.out.printf("%.2f %c %.2f = %.2f ",x,ch,y,x+y);
                break;
            case '-' : 
                System.out.printf("%.2f %c %.2f = %.2f ",x,ch,y,x-y);
                break;
            case '*' : 
                System.out.printf("%.2f %c %.2f = %.2f ",x,ch,y,x*y);
                break;
            case '/' :
                System.out.printf("%.2f %c %.2f = %.2f ",x,ch,y,x/y);
                break;
            case '%' :
                System.out.printf("%.2f %% %.2f = %.2f%n ",x ,y, x % y);
                break;
            default: 
                System.out.println("Enter Correct Operator!");
        } 
        sc.close();
    }
}
