
interface I1 {

    public static final double PI = 3.1413434567;
    static final double lambda = 0.04; // ok : public id implicit

    // int x; // Declaration of any instance variable is Not allowed
    // int x = 100; // initialization of variable is necessary

    //private static final int p = 444;
            // Error: private/protected is Not allowed
    // abstract public static void method(); // Static method is not allowed

    void methodI2 (); // public abstract by default
        
}
class A1 implements I1 {
    public int a1 = 555;
    public void methodI1(){
        System.out.println("From I1 " + PI);
    }
    public void methodI2(){
        System.out.println("Again from I1 " + lambda);
    }
}

// here is main class
public class A1ImpI1 {
    public static void main(String args[]){
        A1 a = new A1();
        a.methodI1();
        a.methodI2();
    }
}