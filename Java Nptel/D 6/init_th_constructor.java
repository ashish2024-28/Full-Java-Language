// Inheritance ex: initializing through constructor.
class Box{
    double width;
    double height;
    double depth;

    Box(){
        width = 0.0;
        height = 0.0;
        depth = 0.0;
    }

    Box(double w, double h, double d){
        width = w;
        height = h;
        depth = d;
    }
    double volume(){
        return width * height * depth;
    }
}
// here, Box is extended to include weight.
class BoxWeight extends Box {
    double weight;
    // constructor for Boxweight
    BoxWeight(double w, double h, double d, double m){
        width = w;
        height = h;
        depth = d;
        weight = m;
    }
}
//default constructor
class BoxWeight2 extends Box {
    double weight2;
    // constructor for Boxweight
    BoxWeight2(){  
        super(); // call the default constructor in the super class
        weight2 = 0.0;
    }
    BoxWeight2(double w, double h, double d, double m){
        super(w, h, d); // call the overloaded constructor in the super class
        weight2 = m;
    }
}
 class init_th_constructor{
    public static void main(String args[]){
        Box b = new Box();
        BoxWeight bw = new BoxWeight(2,3,4,0.1);
        double vol = b.volume();
        System.out.println("call constructor Box. Volume of Box is "+ vol );
        System.out.println();

        vol = bw.volume();
        System.out.println("call constructor  BoxWeight. Volume of box is "+ vol);
        System.out.println("call constructor  BoxWeight. Wight of Box is "+ bw.weight);


        Box b1 = new Box(10,20,15);
        vol = b1.volume();
        System.out.println("call constructor Box. Volume of Box is "+ vol );
        System.out.println();
        


        BoxWeight2 bw2 = new BoxWeight2(2,3,4,0.1);
        vol = bw2.volume();
        System.out.println("call constructor  BoxWeight. Volume of box is "+ vol);
        System.out.println("call constructor  BoxWeight. Wight of Box is "+ bw2.weight2);
    
    }
}