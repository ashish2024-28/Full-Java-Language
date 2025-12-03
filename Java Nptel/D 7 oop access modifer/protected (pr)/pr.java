class A{
    protected int rollNo = 29;
    A(){

    }
    A(int rollNo){
        this.rollNo = rollNo;
    }
    protected void msg(){
        System.out.println("Class A : constructor rollNo :"+rollNo);
    }
    protected void msg(int rollNo){
        this.rollNo=rollNo;
        System.out.println("Class A : constructor rollNo :"+rollNo);
    }
}
public class pr{
    public static void main(String args[]){
        A obj = new A();
        obj.msg();
        System.out.println("access rollNo form main : "+obj.rollNo);
        obj.msg(20);

        A obj2 = new A(30);
        System.out.println("\naccess rollNo form main : "+obj2.rollNo);
        obj2.msg();
        obj2.msg(100);
    }
}