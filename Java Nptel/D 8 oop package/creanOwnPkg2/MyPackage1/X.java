// Defining package MyPackage1

package MyPackage1;
public class X{
    int n = 1;
    private int p = 2;
    protected int q = 3;
    public int r = 4;
    //A constructor of the class protection
    // access all modifier
    public X(){
        System.out.println("I am constructor from class X : ");
        System.out.println("default n = "+n);
        System.out.println("private p = "+p);
        System.out.println("protected q = "+q);
        System.out.println("public r = "+r);
        


    }
}
