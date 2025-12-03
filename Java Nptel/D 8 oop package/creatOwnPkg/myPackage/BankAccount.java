package myPackage; // Adding another class into mypackage

public class BankAccount{
    public String name;
    public long mobNo;
    public double bal;

    public BankAccount(){}

    public BankAccount(String n, long m, double b){
        name = n;  mobNo = m ; bal = b;
    }

    public void AccInfo(){
        System.out.println("\nWelcom To My Bank.");
        System.out.println("Account Holder Name : " + name);
        System.out.println("Mobile Number : +91 " + mobNo);
        if(bal<0){
        System.out.println("Sorry! Negative Balance \nPlease contact the bank branch. \n.....Thankyou..... ");
        }
        else System.out.println("Total Balance : $" + bal + "\n.....Thankyou..... \n");

    }
}
