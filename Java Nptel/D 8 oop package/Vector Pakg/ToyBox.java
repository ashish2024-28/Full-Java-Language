import java.util.Vector;

public class ToyBox {
    public static void main(String[] args) {
        // Create a Vector to hold toy names
        Vector<String> myToys = new Vector<>();

        // Add some toys to the Vector
        myToys.add("Teddy Bear");
        myToys.add("Toy Car");
        myToys.add("Building Blocks");

        // Print out the toys
        System.out.println("My toys are: " + myToys);

        // Add another toy
        myToys.add("Doll");
        System.out.println("My toys are now: " + myToys);

        // Get the first toy
        System.out.println("The first toy is: " + myToys.get(0));

        //remove a toy
        myToys.remove("Toy Car");
        System.out.println("after removing toy car, my toys are: " + myToys);
    }
}
