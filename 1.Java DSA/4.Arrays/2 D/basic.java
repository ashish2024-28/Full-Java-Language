// type [][] arrayName = new type [row][columns];

import java.util.*;
public class basic{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter rows of matrix :");
        int row = sc.nextInt();
        System.out.println("enter columns of matrix :");
        int col = sc.nextInt();
        int [][] matrix = new int [row][col];
        System.out.println("enter matrix :");    
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                System.out.print("enter "+(i+1)+","+(j+1) +" :");
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("Matrix are :");
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                System.out.print(matrix[i][j]+"  ");
            }
            System.out.println();
        }
    }
}