package MyPackage1;
 import MyPackage1.X;

public class A{  // class with default protection
    public A(){   //default constructor with default access
        X x = new X();
        System.out.println("Same package creat and import package A constructor ....");
        System.out.println("default n = "+x.n);
        // System.out.println("private p = "+x.p);  // Error not access
        System.out.println("protected q = "+x.q);
        System.out.println("public r = "+x.r);
        
    }
}