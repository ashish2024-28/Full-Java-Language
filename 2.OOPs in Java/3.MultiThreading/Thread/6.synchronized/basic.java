        
class Counter {

    private int Count = 0;

    // synchronized method => means ak baar may ak hi access kare gaa baki wait kre gaa 
    // public synchronized void increment(){
    public void increment(){
        Count++;
    }

    // method to get current Count
    // public int getCount(){return Count;}
    public void getCount(){System.out.println("Current Count is :- " + Count);  }

}

class Syn extends Thread{
    private final Counter counter;

    public Syn(Counter counter){
        this.counter = counter;
    }

    // Override
    public void run(){
        for(int a = 0; a<10000; a++){
            counter.increment();
        }
    }

}

public class basic{

    public static void cc(Counter counter,int w){
        System.out.printf("Counter %d\n",w);
        for(int a = 0; a<10; a++){
            counter.increment();
            counter.getCount();

        }
    }

    public static void main(String[] a) throws InterruptedException{

        long Stattime = System.currentTimeMillis();

       Counter c = new Counter();
        cc(c,1);
        cc(c,2);
        cc(c,3);
        cc(c,4);


        Syn t1 = new Syn(c);
        Syn t2 = new Syn(c);
        Syn t3 = new Syn(c);
        Syn t4 = new Syn(c);



        t1.start();
        // t1.join();
        System.out.println("\nt1.start() without t1.join() so Count is : ");
        c.getCount();
        
        t2.start();
        t2.join();
        System.out.println("\nt2.start() with t2.join() so Count is : ");
        c.getCount();

        t3.start();
        c.getCount();
        t4.start();
        c.getCount();
        
        // use throws InterruptedException or try catch
        try{ t3.join(); } catch(InterruptedException e){ System.out.println("Thread interrupted "+ e.getMessage()); }
        c.getCount();
        try{ t4.join(); } catch(InterruptedException e){ System.out.println("Thread interrupted "+ e.getMessage()); }
        c.getCount();

        // System.out.println("final count is :- "+ c.getCount());


        long Endtime = System.currentTimeMillis();
        System.out.print("\nSystem.currentTimeMills() :-  "+ Endtime + " - "+ Stattime +" = "+ (Endtime - Stattime));



    }

} 


