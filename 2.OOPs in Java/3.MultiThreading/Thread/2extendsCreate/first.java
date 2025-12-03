
// extends Thread
public class first extends Thread{
    // override run
    public void run(){
        // sec task
        for(int i = 1; i<= 1000; i++){
            System.out.printf("%d* ",i);
        }
        System.out.println("\n* sec task is completed\n");
        System.out.println("\n"+Thread.currentThread().getName()+"\n");
    }

}
