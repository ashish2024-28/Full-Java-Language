// Note:- in a class use private constructor then not access   
// Example of Private access modifer 
class A{
    private  int data = 40;
    private String name = "Ashsh.";
    public void msg(){
        System.out.println("Class A : access.");
    }
    public void pv_acces(){
        System.out.println("\nAccess Class A -> private data is : "+data);
        System.out.println("Access Class A -> private name is "+name);

    }
}

public class pv_aM{
    public static void main(String args[]){
        
        // Note :- not use any access modifier in main 
        //  private int x = 10; public y = 20;

        A obj = new A(); // ok class A is public
       // System.out.println(obj.data); // compile time error -> data is private
        obj.msg(); // ok msg is public 

        obj.pv_acces();    
    }
}