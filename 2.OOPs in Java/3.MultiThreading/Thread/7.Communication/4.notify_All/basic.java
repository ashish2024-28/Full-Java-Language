
class notify{
    notify(long sec){
    // jaha se call kro gy wahi pay so (notify) jaye ga
    System.out.println("\ni going to notify from sleep class");
    try{
        Thread.notify(sec);
    } catch( InterruptedException e){
        System.out.println(e);
    }
    System.out.println("i am now walkup from sleep class\n");
    }
}

public class basic{

    public static void notify(long sec){
        // jaha se call kro gy wahi pay so (sleep) jaye ga
        System.out.println("\ni going to sleep from sleep method");
        try{
            Thread.notify(sec);
        } catch( InterruptedException e){
            System.out.println(e);
        }
        System.out.println("i am now walkup from sleep method\n");
    }

    public static void main(String[] a) throws InterruptedException{

        long Stattime = System.currentTimeMillis();
        // sleep class 
        notify s = new notify(5000);

        System.out.println("Jay sri Ram");
        System.out.println("I am going to sleep");
        
        // jaha se call kro gy wahi pay so (sleep) jaye ga
        Thread.notify(5000);

        //call method sleep 
        System.out.println("call sleep(2000)");
        notify(5000);

        System.out.println("Jay sri Ram");
        System.out.println("I am now wakup");

        long Endtime = System.currentTimeMillis();
        System.out.println("\nSystem.currentTimeMills() :- "+ (Endtime - Stattime));



    }

} 


