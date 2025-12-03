import java.util.*;
public class a3D_array{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter 3D array size 'i' :");
        int i = in.nextInt();
        System.out.print("Enter 3D array size 'j' :");
        int j = in.nextInt();
        System.out.print("Enter 3D array size 'k' :");
        int k = in.nextInt();

        int[][][] a3D= new int[i][j][k];
        System.out.println("\nEnter 3D array value :");
        for(int x=0; x<i; x++){
            for(int y=0; y<j; y++){
                for(int z=0; z<k; z++){
                    System.out.printf("enter %d,%d,%d: ",(x+1),(y+1),(z+1));
                    a3D[x][y][z] = in.nextInt();
                }
            }
        }
    

        System.out.println("\nAll 3D Array Elements are :");
        for(int x=0; x<i; x++){
            for(int y=0; y<j; y++){
                for(int z=0; z<k; z++){
                    System.out.print(a3D[x][y][z] +" ");
                }
                System.out.println();
            }
          System.out.println();
        }
    }
    
}