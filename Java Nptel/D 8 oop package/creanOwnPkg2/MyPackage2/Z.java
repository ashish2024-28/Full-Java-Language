package MyPackage2;
import MyPackage1.*;
public class Z extends MyPackage1.X{
    public Z(){
        System.out.println("I am constructor z from MyPackag2 impore MyPackage1.");
        //  System.out.println("access from Z constructor default n = "+n);  // Error:
            //Default is not accessible outside its package.
        //  System.out.println("private p = "+p);  // Error :
            //  not access private of X
        System.out.println("access from Z constructor protected q = "+q); // Error :
            // Protected member is accessible by inheritance
        System.out.println("access from Z constructor public r = "+r);
        
    }
}