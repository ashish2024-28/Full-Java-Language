
// class wait1{
//     wait1(){
//     // jaha se call kro gy wahi pay wait kre ga
//     System.out.println("\nwait from  class wait1");
//     try{
//         Thread.wait();
//     } catch( InterruptedException e){
//         System.out.println(e);
//     }
//     System.out.println("i am now walkup from sleep class\n");
//     }
// }

public class basic extends Thread{

    // public static void wait(long sec){
    //     // jaha se call kro gy wahi pay so (sleep) jaye ga
    //     System.out.println("\ni going to sleep from sleep method");
    //     try{
    //         Thread.wait(sec);
    //     } catch( InterruptedException e){
    //         System.out.println(e);
    //     }
    //     System.out.println("i am now walkup from sleep method\n");
    // }

    public static void main(String[] a) throws InterruptedException{

        long Stattime = System.currentTimeMillis();
        // sleep class 
        // wait s = new wait(5000);

        System.out.println("Jay sri Ram");
        System.out.println("call wait() in main method");
        
        // jaha se call kro gy wahi pay wait kre ga
        Thread.wait();
        
        // //call method wait 
        // System.out.println("call wait()");
        // wait();
        
        Thread.notify();

        System.out.println("Jay sri Ram");
        System.out.println("I am now working");

        long Endtime = System.currentTimeMillis();
        System.out.println("\nSystem.currentTimeMills() :- "+ (Endtime - Stattime));



    }

} 


