public class object{
    public static void printObject(Object ...obj){

        System.out.println("Print Object :-");
        for(Object o : obj){
            System.out.print(o + "\t");
        }
        System.out.println();
    }
    
    public static void main(String[] ashish){
        // for string
        printObject(1,2,1.111,9.999,true,false,"any value and string", "A");
        printObject(1,1.1,true,false,"any value and string", "A");
        printObject("\n");

    }
}