import java.util.*;//use both ArrayList and Vector or more

import java.util.ArrayList; // We're using the ArrayList "list"

public class ArrayListExample {
    public static void main(String[] args) {

        // 1. Creating an ArrayList
        ArrayList<String> fruits = new ArrayList<>(); // Creates a list that holds text (Strings)

        // 2. Adding Elements
        fruits.add("Apple"); // Adds "Apple" to the list
        fruits.add("Banana"); // Adds "Banana" to the list
        fruits.add("Cherry"); // Adds "Cherry" to the list
        fruits.add(1, "Orange"); // Adds "Orange" at index 1 (between "Apple" and "Banana")

        // 3. Getting Elements
        String firstFruit = fruits.get(0); // Gets the first element ("Apple")
        System.out.println("First fruit: " + firstFruit);

        // 4. Checking Size
        int size = fruits.size(); // Gets the number of elements in the list
        System.out.println("List size: " + size);

        // 5. Removing Elements
        fruits.remove(2); // Removes the element at index 2 (which was "Banana")
        System.out.println("List after removing: " + fruits);

        fruits.remove("Apple"); //removes the first object that equals "Apple"
        System.out.println("List after removing Apple: " + fruits);

        // 6. Checking if Empty
        boolean isEmpty = fruits.isEmpty(); // Checks if the list is empty
        System.out.println("Is the list empty? " + isEmpty);

        // 7. Finding an Element
        int index = fruits.indexOf("Cherry"); // Finds the index of "Cherry"
        System.out.println("Index of Cherry: " + index);

        // 8. Checking if an Element Exists
        boolean containsOrange = fruits.contains("Orange"); // Checks if "Orange" is in the list
        System.out.println("Contains Orange? " + containsOrange);

        // 9. Iterating through the List
        System.out.println("Iterating through the List:");
        for (String fruit : fruits) { // A "for-each" loop to go through each element
            System.out.println(fruit);
        }

        // 10. Clearing the List
        fruits.clear(); // Removes all elements from the list
        System.out.println("List after clearing: " + fruits);

        //11. Setting an element
        fruits.add("Grape");
        fruits.add("Kiwi");
        fruits.set(1, "Lemon"); //sets the element at index 1 to "Lemon".
        System.out.println("List after setting index 1 to Lemon: " + fruits);

        //12. Sublist
        fruits.add("Mango");
        ArrayList<String> subFruits = new ArrayList<>(fruits.subList(0,2)); //creates a new arraylist with a section of the original.
        System.out.println("Sublist: " + subFruits);
    }
}