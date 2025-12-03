
// extends Thread
public class third extends Thread{
    // override run
    public void run(){
        // third task
        for(int i = 1; i<= 1000; i++){
            System.out.printf("%d* ",i);
        }
        System.out.println("\n* third task is completed");
        System.out.println("\n"+Thread.currentThread().getName()+"\n");

    }

}
