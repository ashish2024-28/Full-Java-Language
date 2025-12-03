public class PrintDifferent{
    public static void main(String args[]){
        System.out.println("Using println:");
        System.out.println("Name   Age  GPA");
        System.out.println("Ashish 20   8.5");
        System.out.println("Ravi   19   9.2");

        System.out.println("\nUsing printf/format:");
        System.out.printf("%-10s %5s %6s%n", "Name", "Age", "GPA");
        System.out.format("%-10s %5d %6.2f%n", "Ashish", 20, 8.5);
        System.out.format("%-10s %5d %6.2f%n", "Ravi", 19, 9.2);

// 💡 printf and format align the table nicely.
// 💡 println looks messy for tabular data.

// 👉 Output:

// Using println:
// Name   Age  GPA
// Ashish 20   8.5
// Ravi   19   9.2

// Using printf/format:
// Name          Age   GPA
// Ashish         20   8.50
// Ravi           19   9.20

    }
}