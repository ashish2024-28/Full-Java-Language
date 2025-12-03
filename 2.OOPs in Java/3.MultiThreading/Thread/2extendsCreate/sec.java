

// extends Thread
public class sec extends Thread{
    // override run
    public void run(){
        // first task
        for(int i = 1; i<= 1000; i++){
            System.out.printf("%d# ",i);
        }
        System.out.println("\n# first task is completed\n");
        System.out.println("\n"+Thread.currentThread().getName()+"\n");
    }

}
