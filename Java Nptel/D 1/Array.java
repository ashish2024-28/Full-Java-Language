import java.util.*;
public class Array{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of Array : ");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("Enter  Array element : ");        
        for(int i=0;i<n;i++){
            System.out.printf("enter %d : " ,(i+1));
            a[i]=sc.nextInt();        
        }
        System.out.println("\nAll Array Elements are :");
          for(int i=0;i<n;i++){
            System.out.print(a[i]+ "  ");       
        }

    }
}