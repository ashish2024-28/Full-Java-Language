import myInterface.*;

// A class that implements interface.

class useInterface implements anInterface {
    public void display(){
        System.out.println("Fine!");
    }

    // the main method()
    public static void main(String[] args) {
        useInterface t = new useInterface();
        t.display();
        System.out.println("The final value a in myInterface :" +a);
    }
}