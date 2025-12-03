// Example of method - overiding
class A{
    public void msg1(){
        System.out.println("Class A : public !");
    }
    public void msg11(){
        System.out.println("Class A : public !");
    }

    private void msg2(){
        System.out.println("Class A : private !");
    }
    private void msg22(){
        System.out.println("Class A : private !");
    }

    protected void msg3(){
        System.out.println("Class A : protected !");
    }
    protected void msg33(){
        System.out.println("Class A : protected !");
    }

    
}
public class methodOveriding extends A{
    void msg(){
        System.out.println("Class Main : Welcome !");
    }
    public void msg1(){ // if modifire is set to default it cannot overide
        System.out.println("Overriding public method !");
    }
    private void msg2(){
        System.out.println("Overriding private method !");
    }
    // if modifire is set to private it can be overidden
    protected void msg3(){
        System.out.println("Overriding protected method !");
    }
    public static void main(String args[]){
        methodOveriding obj = new methodOveriding();
        
        obj.msg11();
        System.out.println();
       // obj.msg22(); // not access because private 
        System.out.println();
        obj.msg33();
        System.out.println();

        obj.msg();
        System.out.println();
        obj.msg1();
        System.out.println();
        obj.msg2();
        System.out.println();
        obj.msg3();
        System.out.println();
       

    }
}
