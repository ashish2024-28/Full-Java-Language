class Circle{
    double pi =22/7.0;
    double radius;

    Circle(double radius){
        this.radius = radius;
    }
    Circle(){

    }

    double Area(double radius){
        return pi * radius * radius;
    }
    double Area(){
        return pi * this.radius * this.radius;
    }

    double Circumference(double radius){
        return 2 *pi *radius;
    }
    double Circumference(){
        return 2 *pi *radius;
    }

}

class Rectangle{
    int lenths; int breadth;
    Rectangle(){

    }
    Rectangle(int lenths, int breadth){
        this.lenths=lenths;this.breadth=breadth;
    }

    void AreaRect(){
        System.out.println("print by Recctangle class call function\nArea of rectangle : "+ (this.lenths * this.breadth));
    }
    int AreaRect(int l, int b){
        return l * b; 
    }

    int ParemeterRect(){
       return 2*(this.lenths+this.breadth);
    }
    void ParemeterRect(int l ,int b){
        System.out.println("print by Recctangle class call function\nParemeter of Rectangle : " + 2*(l+b));
    }
    void InfoRect(){
        this.AreaRect(); 
        this.ParemeterRect(this.lenths,this.breadth);
    }
}

class A{
    A(){
        this(5);
        System.out.println("hello a");
    }
    A(int x){
        System.out.println(x);
    }
}

public class Area_circle{
    public static void main(String args[]){
        Circle c1 = new Circle();
        c1.radius = 10;
        System.out.println("\nCircumference : "+ c1.Circumference() + "\nArea :"+c1.Area());

        Circle c2 = new Circle(20);
        System.out.println("\nCircumference : "+ c2.Circumference() + "\nArea :"+c2.Area());
        
        Circle c3 = new Circle();
        System.out.println("\nCircumference : "+ c3.Circumference(50) + "\nArea :"+c3.Area(10));

        Circle c4 = new Circle(0);
        System.out.println("\nCircumference : "+ c4.Circumference(50) + "\nArea :"+c4.Area());

        System.out.println("Rectangle class :- \n");

        Rectangle r1 = new Rectangle();
        r1.lenths=10; r1.breadth=10;
        r1.AreaRect();
        System.out.println("Area of Rectangle : " + r1.AreaRect(20,20));
        System.out.println("Paremeter of Rectangle : " + r1.ParemeterRect());
        r1.ParemeterRect(20,20);

        System.out.println();
        Rectangle r2 = new Rectangle(100,200);
        r2.lenths=10; r2.breadth=10;
        r2.AreaRect();
        System.out.println("Area of Rectangle : " + r2.AreaRect(1,2));
        System.out.println("Paremeter of Rectangle : " + r2.ParemeterRect());
        r2.ParemeterRect(20,20);
        
        System.out.println("\nUse of this in class's function --> \n");
        r2.InfoRect();

        System.out.println("\nMath.PI use direct : "+Math.PI +"\n"); // value of pi = 3.141592653589793

        A a = new A();
        A b = new A(4);


    }
}