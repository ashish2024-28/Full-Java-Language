
class PrintTask implements Runnable{
    private final char targetChar;
    private final int n;
    PrintTask(char targetChar, int n){
        this.targetChar = targetChar;
        this.n = n;
    }

    // Override
    public void run(){
        //Print Task
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


        PrintTask p1 = new PrintTask('*',10);
        
        PrintTask p2 = new PrintTask('$',10);

        PrintTask p3 = new PrintTask('#',10);


        // Thread
        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);
        Thread t3 = new Thread(p3);

        t1.start();
        t2.start();
        t3.start();


        long Endtime = System.currentTimeMillis();
        System.out.print("\nSystem.currentTimeMills() :-  "+ Endtime + " - "+ Stattime +" = "+ (Endtime - Stattime) +"\n");

    }

}