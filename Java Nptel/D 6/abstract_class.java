// A simple abstract class example.
abstract class Base{
    abstract void fun();
}

class Derived extends Base {
    void fun(){
        System.out.println("Derived fun() is called ");
    }
}                                      

// An abstract class without any abstract method
abstract class Base2{
    void fun(){
        System.out.println("Base fun() is called ");
    }
}

class Derived2 extends Base2 {
    Derived2(){
        super.fun();
        System.out.println("Derived constructor is called");
    }
    void fun(){
        super.fun();
        System.out.println("Derived fun() is called ");
    }
}


class abstract_class{
    public static void main(String args[]){
        // Uncommnting the following line will cause compiler error as the
        // line tries to create an instance of abstract class.
        // Base b = new Base();

        // we can have reference of Base type.
        Base b = new Derived();
        b.fun();

        System.out.println();
        Derived2 d = new Derived2();
        d.fun();
    }
}