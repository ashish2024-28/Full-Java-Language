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
    public static void main(String[] a) throws InterruptedException {
        System.out.println("Main Method\n");

        long Stattime = System.currentTimeMillis();

        // step 3: create an Instance of your class
        PrintTask t1 = new PrintTask('*',100);
        PrintTask t2 = new PrintTask('#',100);        
        PrintTask t3 = new PrintTask('!',100);        
        PrintTask t4 = new PrintTask('*',100);
        PrintTask t5 = new PrintTask('#',100);        
        PrintTask t6 = new PrintTask('!',100);        

        // class run() 
        t1.start();
        // join menas jab tak thread complet na ho tab tak wait karo
        t1.join();
        
        t2.start();
        // join menas jab tak thread complet na ho tab tak wait karo
        t2.join();
        
        t3.start();
        // join menas jab tak thread complet na ho tab tak wait karo
        t3.join();


        t4.start();
        // join(milliseconds) 
        // join(milliseconds,nanosecond) 
        t4.join(1);
        
        t5.start();
        t5.join(1,1);
        
        
        t6.start();
        t6.join(10,11);



        long Endtime = System.currentTimeMillis();

        System.out.print("\nSystem.currentTimeMills() :-  "+ Endtime + " - "+ Stattime +" = "+ (Endtime - Stattime) +"\n");

        

    }
}