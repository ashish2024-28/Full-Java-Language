// import java.lang.*;
public class Driver{
    public static void main(String[] args){
        // Car myCar = new Car();
        Car myCar;
        myCar = new Car();

        // myCar.start();
        // myCar.drive();
        // myCar.stop();
        // myCar.backward();
        
        // // Access the class with method
        // System.out.println("Access the class with method\n"+myCar.getCurrentFuel());
        // System.out.println(myCar.color);
        // System.out.println(myCar.noOfWheels);
        // System.out.println(myCar.noOfSeats);
        // System.out.println(myCar.maxSpeed);
        
        // //set the class and method variable values
        // myCar.noOfWheels = 4;
        // myCar.color = "red";
        // myCar.maxSpeed = 200;
        // myCar.noOfSeats = 5;
        // myCar.addFuel(5);

        // // again access  
        // System.out.println("set the class variable values and again access \n"+myCar.color);
        // System.out.println(myCar.noOfWheels);
        // System.out.println(myCar.noOfSeats);
        // System.out.println(myCar.maxSpeed);
        // System.out.println(myCar.currentFuel);

        // // access the methods
        // myCar.start();
        // myCar.drive();
        // myCar.getCurrentFuel();
        // myCar.drive();
        // myCar.stop();
        // myCar.backward();
        // System.out.println(myCar.getCurrentFuel());

        Car myCar2 = new Car();

        myCar.addFuel(5);
        myCar2.addFuel(5);
        myCar.start();
        myCar.drive();
        // myCar2.start().drive();
        Car startedCar = myCar2.start();
        startedCar.drive();

        myCar.addFuel(5);
        myCar2.addFuel(15);


        System.out.println(myCar.getCurrentFuel());
        System.out.println(myCar2.getCurrentFuel());



    }
}