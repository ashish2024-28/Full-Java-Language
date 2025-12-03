// Example -1 of default access modifier.

class A{
    void msg(){
        System.out.println("Hi! i am in Class A");
    }
}

class default_aM{
    public static void main(String args[]){
        A obj = new A();
        obj.msg();
    }
}

// *-> also creat seprat class A file .java and save -> .class 
// then  also run min.