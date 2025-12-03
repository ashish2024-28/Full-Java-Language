// Vector is a way to store a list of items, and that list can change in size
import java.util.*;//use both ArrayList and Vector or more
import java.util.Vector; // We're using the Vector "box"

public class vectorPkg {
    public static void main(String[] args) {

        // 1. Creating a Vector
        Vector<Integer> numbers = new Vector<>(); // Creates a Vector that holds whole numbers (Integers)

        // 2. Adding Elements
        numbers.add(10); // Adds 10 to the Vector
        numbers.add(20); // Adds 20 to the Vector
        numbers.add(30); // Adds 30 to the Vector
        numbers.add(2, 25); // Adds 25 at index 2 (between 20 and 30)

        // 3. Getting Elements
        int firstNumber = numbers.get(0); // Gets the first element (10)
        System.out.println("First number: " + firstNumber);

        // 4. Checking Size
        int size = numbers.size(); // Gets the number of elements in the Vector
        System.out.println("Vector size: " + size);

        // 5. Removing Elements
        numbers.remove(1); // Removes the element at index 1 (which was 20)
        System.out.println("Vector after removing: " + numbers);

        numbers.remove(Integer.valueOf(30)); //removes the first object that equals 30.
        System.out.println("Vector after removing 30: " + numbers);

        // 6. Checking if Empty
        boolean isEmpty = numbers.isEmpty(); // Checks if the Vector is empty
        System.out.println("Is the Vector empty? " + isEmpty);

        // 7. Finding an Element
        int index = numbers.indexOf(25); // Finds the index of 25
        System.out.println("Index of 25: " + index);

        // 8. Checking if an Element Exists
        boolean contains25 = numbers.contains(25); // Checks if 25 is in the Vector
        System.out.println("Contains 25? " + contains25);

        //9. Iterating through the Vector
        System.out.println("Iterating through the Vector:");
        for (int num : numbers) { // A "for-each" loop to go through each element
            System.out.println(num);
        }

        // 10. Clearing the Vector
        numbers.clear(); // Removes all elements from the Vector
        System.out.println("Vector after clearing: " + numbers);

        //11. Setting an element
        numbers.add(5);
        numbers.add(10);
        numbers.set(1, 15); //sets the element at index 1 to 15.
        System.out.println("Vector after setting index 1 to 15: " + numbers);

    }
}
