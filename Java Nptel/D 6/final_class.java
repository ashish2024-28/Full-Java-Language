// final class inheritance - an example
/*
final class Bike {}

class Honda1 extends Bike {
    void run() {
        system.out.println("Running safely 100 kmperh.");
    }
}
 
//  error when running...
final class final_class{
    public static void main(String args[]){
        Honda1 honda  = new Honda1();
        honda.run();
    }
}
*/

// An abstract class with a final method 
abstract class Base {
    final void fun(){
        System.out.println("final fun() is called");
    }
}

class Derived extends Base{}

// an abstract class with final method
class Derived2 extends Base {
    Derived2(){
        System.out.println("Derived2 constructor is called");
    }

    /*error: fun() in Derived2 cannot override fun() in Base
      void fun(){ -> because void fun(){} also in abstract class Base with final (keyword).
          ^
     overridden method is final  */

    // void fun(){
    //    System.out.println("Derived fun() is called");
    // }
}

class final_class{
    public static void main(String args[]){
        Base b = new Derived();
        b.fun();

        System.out.println();
        Base b2 =  new Derived2();
        b2.fun();
    }
}