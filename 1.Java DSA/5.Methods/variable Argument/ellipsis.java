public class ellipsis{
    public static void printMany(String ...elements){

        System.out.println("Print String value :-");
        for(String e : elements){
            System.out.print(e + "\t");
        }
        System.out.println();
    }
    public static void printArray(int ...elements){

        System.out.println("Print Array value :-");
        for(int e : elements){
            System.out.print(e + "\t");
        }
        System.out.println();
    }
    public static void main(String[] ashish){
        // for string
        printMany("1","2","any value");
        printMany("\n");
        printMany(new String[]{"one","two","any value"});

        // for int
        printArray(1,3,2,4,5,6,7,8,9,11);
        printArray();
    }
}