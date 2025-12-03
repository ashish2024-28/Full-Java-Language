class BaseClass{
    public int pu = 10;
    private int pv =20; //the most restricted access. Only code inside the class can see or change .  It's like a secret diary that only the owner can read.
    protected int pr =30; // 
    int de = 40; // implicit default access modifier

    public int getpublic(){
        return pu;
    }
    public void setpublic(int pu){
        this.pu =pu;
    }

    private int getprivate(){
        return pv;
    }
    private void setprivate(int pv){
        this.pv = pv;
    }

    protected int getprotected(){
        return pr;
    }
    protected void setprotected(int pr){
        this.pr =pr;
    } 

    int getdefault(){
        return de;
    }
    void setdefault(int de){
        this.de =de;
    }

}
public class All_access_mf extends BaseClass{  // It's like a child inheriting traits from a parent. 
 //  This means All_access_mf gets all the variables and methods of BaseClass (except the private ones).
    public static void main(String args[]){
        BaseClass rr = new BaseClass();
        rr.pr = 0;
        All_access_mf subClassObj = new All_access_mf();
        
        //Access Modifiers -> Public (pu) -> can directly access 
        System.out.println("Value of public (pu) is : " + subClassObj.pu);
        subClassObj.setpublic(100);
        System.out.println("Value of public (pu) is : "+ subClassObj.getpublic());
        System.out.println();
        
        //Access Modifiers -> Private (pv) -> can't directly access it.
        // System.out.println("Value of private (pv) is : " + subClassObj.pv);
        // subClassObj.setprivate(200);
        // System.out.println("Value of private (pv) is : "+ subClassObj.getprivate());
        // System.out.println();
        
        //Access Modifiers -> Protected (pr) -> Because All_access_mf inherits from BaseClass, it can access pr.
        System.out.println("Value of protected (pr) is : " + subClassObj.pr);
        subClassObj.setprotected(300);
        System.out.println("Value of protected (pr) is : "+ subClassObj.getprotected());
        System.out.println();

        //Access Modifiers -> default (de) -> Because All_access_mf is in the same package as BaseClass, it can access 
        System.out.println("Value of default (de) is : " + subClassObj.de);
        subClassObj.setdefault(400);
        System.out.println("Value of default (de) is : "+ subClassObj.getdefault());
        System.out.println();

    }
}


/*
Imagine a house (BaseClass) with different rooms:

The living room (public) is open to everyone.
The secret safe (private) is only accessible to the house owner.
The family room (protected) is accessible to the family and their children.
The neighborhood garden (default) is accessible to everyone in the neighborhood.
The child's house (All_access_mf) can access the living room, family room, and neighborhood garden, but not the secret safe.
*/