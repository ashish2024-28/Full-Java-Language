// Example -1 public access modifier

// public class A -> error: class A is public, should be declared in a file named A.java
class A {
    public int data = 40;
    public void msg(){
        System.out.println("Class A: Hell0 java!");
    }
}

public class pu_aM {
    public static void main(String args[]){
        A obj = new A(); // ok : data is public
        System.out.println("class A data access : "+obj.data);
        obj.msg(); //ok : msg is public
    }
}