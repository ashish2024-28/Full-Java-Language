/*
public static retutnType functionName(type arg1,type arg2,....){
    // operations
}
*/
import java.util.Scanner;
public class basic{

    public static void PrintInformation(String name,int age){
       System.out.println(name);
       System.out.println(age);
       return;
    }
    public static void main(String args[]){
        System.out.println("Enter name :");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        System.out.println("Enter age :");
        int age  = sc.nextInt();
        PrintInformation(name,age);
    }
} 