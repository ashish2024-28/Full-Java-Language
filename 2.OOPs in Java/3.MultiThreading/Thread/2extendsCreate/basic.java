
// extends Thread
public class basic {

    public static void main(String[] a){
    
        long Stattime = System.currentTimeMillis();
        
        // first task
        first t1 = new first();
        
        // sec task
        sec t2 = new sec();
        
        // third task
        third t3 = new third();

        System.out.println("\nStarting First Thread");
        t1.start();

        System.out.println("\nStarting second Thread");
        t2.start();

        System.out.println("\nStarting Trird Thread");
        t3.start();

        // // call
        // t1.run();
        // t2.run();
        // t3.run();
        


        long Endtime = System.currentTimeMillis();
        System.out.println("\nSystem.currentTimeMills() :-  " +  (Endtime - Stattime));

        

    }

}