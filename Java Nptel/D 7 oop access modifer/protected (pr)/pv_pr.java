// simple ex if access modifier. in a class hieerarchy .private and procted;
// Creat a superclass.
class A{
    int i; // public by default
    // private int j; // private not access any other class 
    public int j;
    void setij(int i,int j){
        this.i = i; this.j=j;
    }
}
//A's j is not accessible here 
class B extends A{
    int total;
    B(int i, int j){
        this.i=i; this.j=j;
    }
    void sum(){
        System.out.println("Sum of class A : i+j = " + (i + j));
    }
}
class pv_pr{
    public static void main(String args[]){
        B subob = new B(5,10);
        subob.sum();
        subob.setij(10,20);
        subob.sum();
    }
}