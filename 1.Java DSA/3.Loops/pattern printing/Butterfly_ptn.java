import java.util.*;

public class Butterfly_ptn {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter value (3 -> min) for butterfly pattern :");
        int n = sc.nextInt();
         for(int i=1;i<=n;i++){ //n/2
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            for(int j=1;j<=2*(n-i);j++){  //n-2*i
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
         for(int i=n;i>=1;i--){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            for(int j=1;j<=2*(n-i);j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }


    }
}