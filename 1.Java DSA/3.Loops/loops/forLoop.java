import java.util.*;
public class forLoop{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Size of Array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++ ){
            System.out.printf("arr[%d] = ",i+1);
            arr[i] = sc.nextInt();
        }
        
        System.out.println("Array Element is :- ");

        // this use for array elements; 
        for(int x : arr ){
            System.out.format("%d ",x);
        }
        
    }
}