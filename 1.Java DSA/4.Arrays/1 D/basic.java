    // Arrays is a list of items of the same type store
//  type[] arrayName = new type [size];
//   int [] marks[5] = new int [size];

import java.util.Scanner;
public class basic {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("radha radha \n enter size of arrya : ");
        int n = sc.nextInt();
        int[] array = new int [n];
        //int m[n];
        System.out.println("enter "+n+" array element :");
        for(int i=0 ; i<n ; i++){
            System.out.print("enter "+ (i+1) +" :");
            array[i] = sc.nextInt();
           
        }
        //Traversing array 
        System.out.println("All array are : ");
        for(int i=0 ; i<n ; i++){
            System.out.print(array[i]+ " ");
        }
        sc.close();
        // time complixity of program is O(n);
    }
}