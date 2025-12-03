// Step 1: define a class that entends Thread
class PrintTask extends Thread {
    private final char targetChar;
    private final int n;
    PrintTask(char targetChar, int n){
        this.targetChar = targetChar;
        this.n = n;
    }

    // Step 2: Override the  run() method
    public void run(){
        // Task
        for(int i = 1; i<=n; i++){
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
        PrintTask t1 = new PrintTask('*',100);
        PrintTask t2 = new PrintTask('#',100);        
        PrintTask t3 = new PrintTask('!',100);        
        
        // class run() 
        // Priority levels : From 1(Lowest)=> MIN_PRIORITY
        //                   to 10(Heighest) => MAX_PRIORITY 
        //                   and 5(default value) =>   NORM_PRIORITY 
        // NOTE :- Donot guarantee of Priority
        t1.start();                 t1.setPriority(5);
        t2.start();                 t2.setPriority(1);    
        t3.start();                 t3.setPriority(10);

    
        long Endtime = System.currentTimeMillis();

        System.out.print("\nSystem.currentTimeMills() :-  "+ Endtime + " - "+ Stattime +" = "+ (Endtime - Stattime) +"\n");

        

    }
}