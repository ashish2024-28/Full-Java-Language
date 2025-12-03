package MyPackage1;

public class Y extends X{
    public Y(){
        System.out.println("I am constructor from class Y : ");
        System.out.println("default n = "+n);
        // System.out.println("private p = "+p); // Error p is a private
        // member of X. Not accessiable outside X.
        System.out.println("protected q = "+q);
        System.out.println("public r = "+r);
        
    }
}