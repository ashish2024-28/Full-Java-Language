public class Car{
    int price;
    String model;
    String color;
    float maxSpeed;
    float traveKM;
    float currentFuel;
    int noOfWheels;
    int noOfSeats;

    // start the car 
    public Car start(){
        if(currentFuel == 0){
            System.out.println("Car is out of fuel, can not start");
        }
        else{
            System.out.println("Car is Started  bruhmmm bruhmm..... ready for drive");
        }
        return this;

    }
    // public void start(){
    //     if(currentFuel == 0){
    //         System.out.println("Car is out of fuel, can not start");
    //     }
    //     else{
    //         System.out.println("Car is Started  bruhmmm bruhmm..... ready for drive");
    //     }

    // }

    public void drive(){
        if(currentFuel < 5){
            System.out.println("Car is in reserved mode , pleas refuel");
        }
        else{
            System.out.println("Car is running..... ");
        }
    }
    
    // Stop
    // public void stop(){
        
    // }

    // backward
    // public void backwark(){
        
    // }
    public void addFuel(float fuel){
        currentFuel += fuel;
    }

    public float getCurrentFuel(){
        return currentFuel;
    }
    
}
