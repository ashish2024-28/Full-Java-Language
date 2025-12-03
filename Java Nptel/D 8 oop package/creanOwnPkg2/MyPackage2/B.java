package MyPackage2;

 import MyPackage1.*;

public class B { // class with default protection
    public B(){ // default constructor with default assess
       MyPackage1.X x = new MyPackage1.X();
        //creat an object of class of X
        System.out.println("I am constructor from class B of MyPackage2"); // n is not public in X; cannot be accessed from outside package
        // System.out.println("access from B Pkg2 default x.n = "+x.n);
            // default variable but is not accessible in this package
        // System.out.println("access from B Pkg2 private p = "+x.p); //Error :
        // System.out.println("access from B Pkg2 protected q = "+x.q); // Error :
        System.out.println("access from B Pkg2 public r = "+x.r);
        


    }
}