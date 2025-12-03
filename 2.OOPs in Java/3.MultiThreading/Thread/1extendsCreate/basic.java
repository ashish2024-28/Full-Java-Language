// Step 1: define a class that entends Thread
class PrintTask extends Thread {
    private final char targetChar;
    PrintTask(char targetChar){
        this.targetChar = targetChar;
    }

    // Step 2: Override the  run() method
    public void run(){
        // Task
        for(int i = 1; i<=1000; i++){
            System.out.printf("%d:%c ",i,targetChar);
        }
        System.out.printf("\n%c Task Done\n",targetChar);
        System.out.println("\n"+Thread.currentThread().getName()+"\n");

    }
}

public class basic {
    public static void main(String[] a){
        System.out.println("Main Method\n");

        long Stattime = System.currentTimeMillis();

        // step 3: create an Instance of your class
        PrintTask t1 = new PrintTask('*');
        t1.start();
        
        PrintTask t2 = new PrintTask('#');
        t2.start();
        
        // // 
        // t1.start();
        // t2.start();

        long Endtime = System.currentTimeMillis();

        System.out.print("\nSystem.currentTimeMills() :-  "+ Endtime + " - "+ Stattime +" = "+ (Endtime - Stattime) +"\n");

        

    }
}