public class needOfMultithreading {
    public static void main(String[] a){

        long Stattime = System.currentTimeMillis();

        // first task
        for(int i = 1; i<= 1000; i++){
            System.out.printf("%d* ",i);
        }
        // second task
        for(int i = 1; i<= 1000; i++){
            System.out.printf("%d# ",i);
        }
        // third task
        for(int i = 1; i<= 1000; i++){
            System.out.printf("%d$ ",i);
        }

        long Endtime = System.currentTimeMillis();

        System.out.print("\nSystem.currentTimeMills() :-  "+ Endtime + " - "+ Stattime +" = "+ (Endtime - Stattime));

        

    }
}