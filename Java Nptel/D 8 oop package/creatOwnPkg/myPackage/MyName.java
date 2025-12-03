package myPackage;

public class MyName{
    String name ;
    public MyName(String name){
        this.name = name;
        System.out.println("Your Name is " + name);

    }
    public void printMyName(){
        System.out.println("Your Name is " + this.name);
    }
}