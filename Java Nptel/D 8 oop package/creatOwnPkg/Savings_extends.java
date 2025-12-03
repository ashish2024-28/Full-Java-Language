import java.util.Scanner;
import myPackage.BankAccount;

class Savings extends BankAccount{
    String branch;
    int customerID;

    Savings(){
    }
    Savings(String branch, String name, long mobNo, int id, double bal ){
        super(name,mobNo,bal);
        this.branch=branch;
        customerID=id;
    }
    public void AccInfo(){
        System.out.println("\nWelcom To "+branch+" Bank branch.");
        System.out.println("Account Holder Name : " + name);
        System.out.println("Customer ID : " + customerID);
        System.out.println("Mobile Number : +91 " + mobNo);
        if(bal<0){
        System.out.println("Sorry! Negative Balance \nPlease contact the bank branch. \n.....Thankyou..... ");
        }
        else System.out.println("Total Balance : $" + bal + "\n.....Thankyou..... \n");

    }
}
public class Savings_extends {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.print("How Many Account You Needed. Enter : ");
        int n = in.nextInt();
        in.nextLine(); // consume newline character 
        // when not use this the you enter number then take space and continue without press enter
        Savings acc[] = new Savings[n];
        acc[0] = new Savings("Vrindavan","Radha Rani Ji",108,1234567890,108108);
        for(int i=1; i<n ; i++){
            acc[i] = new Savings(); // Creat a new BankAccount object.

            System.out.println("Enter branch name : ");
            acc[i].branch = in.nextLine();
            System.out.print("Enter Account Holder Name : ");
            acc[i].name = in.nextLine();
            System.out.print("Enter Customer ID : ");
            acc[i].customerID = in.nextInt();
            System.out.print("Enter Mobile Number : " );
            acc[i].mobNo = in.nextLong();
            System.out.print("Enter Account Balance : ");
            acc[i].bal= in.nextInt();
            
        }
        for(int i=0; i<n ; i++){
            acc[i].AccInfo();
            System.out.println();
        }
    }
}