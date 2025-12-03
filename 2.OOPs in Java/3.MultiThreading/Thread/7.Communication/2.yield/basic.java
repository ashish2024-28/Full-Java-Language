
class yield1{
    yield1(){
    // jaha se call kro gy wahi pay ruk (pause) jaye ga
    System.out.println("\nPause from yield1 class");
    // try{
    //     Thread.yield();
    // } catch( InterruptedException e){
    //     System.out.println(e);
    // }
        Thread.yield();

    System.out.println("i am now working.... from yield1 class\n");
}
}

public class basic{

    public static void yield2(){
        // jaha se call kro gy wahi pay ruk (pause) jaye ga
        System.out.println("\nPause from yield2 method");
        // try{
        //     Thread.yield();
        // } catch( InterruptedException e){
        //     System.out.println(e);
        // }
        Thread.yield();

        System.out.println("i am now working.... from yield2 method\n");
    }
    
    public static void main(String[] a) throws InterruptedException{
        
        long Stattime = System.currentTimeMillis();
        // yield1 class 
        yield1 s = new yield1();
        
        System.out.println("Jay sri Ram");
        System.out.println("Going to Pause ");
        
        // jaha se call kro gy wahi pay ruk (pause) jaye ga
        Thread.yield();
        
        System.out.println("\ni am now working.... \n");

        //call method yield2 
        System.out.println("call yield()");
        yield2();


        long Endtime = System.currentTimeMillis();
        System.out.println("\nSystem.currentTimeMills() :- "+ (Endtime - Stattime));



    }

} 


