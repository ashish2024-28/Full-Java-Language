public class Circle{
    public double r;
    static int circlecount = 0 ;
    public Circle(double r){
        this.r=r;
    }
    public Circle(Circle c){
        this(c.r); 
        System.out.println("circlecoutnt++ -> "+ ++circlecount );
    }
    public Circle(){
        this(0.1);
        System.out.println("circlecoutnt++ -> "+ ++circlecount );

    }
    public Circle bigger(Circle c){
        if(c.r>r) {
            return c;
          //  System.out.println("Circle c is bigger radius->"+ c.r);
        }
        else {
            return this; // this means current circle
           // System.out.println("Circle b is bigger radius->"+ this);
        }
    }
    public static Circle bigger(Circle a, Circle b){
        if(a.r>b.r){
            return a;
            //System.out.println("Circle b is bigger radius->"+ a.r);
        }
        else {
            return b;
          //  System.out.println("Circle b is bigger radius->"+ b.r);
        }
    }

    public static void main(String args[]){
        Circle a = new Circle (10.0);
        Circle b = new Circle (20.0);
        Circle c = a.bigger(b);
        Circle d = Circle.bigger(a,b);

        System.out.println("circle a "+ a + "\ncircle b "+b+"\ncircle c "+c+"\ncircle d "+d);


    }

}