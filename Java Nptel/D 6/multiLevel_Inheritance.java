// Example of multi Level Inheritance.
// start wit box
class Box {
    private double width;
    private double height;
    private double depth;

    // constructor used when all dimensions specificed
    Box(double w, double h, double d){
        width = w; height = h; depth = d;
    }

    //computer and return volume
    double volume(){
        return width * height * depth;
    }
}

//Add weight.
class BoxWeight extends Box {
    double weight; // weight of box
    //constructor when all parameters are specified
    BoxWeight(double w, double h, double d, double m){
        super(w, h, d); //call superclass constructor
        weight = m;
    }
}

// Add shipping costs
class Shipment extends BoxWeight{
    double cost;

    // constructor when all paremeters are specified
    Shipment(double w, double h, double d, double m, double c){
        super(w,h,d,m); // call superclass constructor
        cost = c;
    }
}
class multiLevel_Inheritance{
    public static void main(String args[]){
        Shipment s1 = new Shipment(10, 20, 15, 10,3.41);
        double vol;
        vol = s1.volume();
        System.out.println("volume of shipment1 is : " +vol);
        System.out.println("Weight of shipment1 is : "+s1.weight);
        System.out.println("Shipping cost :$" + s1.cost);
        System.out.println();

        Shipment s2 = new Shipment(2,3,4,0.76,1.28);
        vol = s2.volume();
        System.out.println("volume of shipment2 is : " +vol);
        System.out.println("Weight of shipment2 is : "+s2.weight);
        System.out.println("Shipping cost :$" + s2.cost);
        System.out.println();


    }
}