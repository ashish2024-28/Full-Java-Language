import java.util.*;
public class arr{
    public static void main(String[] ashish){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the value of row = column : ");
        int n = sc.nextInt();

        int[][] arr = new int[n][n];

        for(int i=0; i<n ; i++){
            for(int j=0; j<n; j++){
                System.out.printf("Enter value of index[%d][%d] : ",i,j);
                arr[i][j] = sc.nextInt();
            }
        }

        for(int j=0; j<n ; j++){
            for(int i=n-1; i>=0; i--){
                System.out.printf("%d ",arr[i][j]);
            }
            System.out.println();
        }
    }
}