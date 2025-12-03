public class queue{
    static int rear =-1;
    static int Queue[] = new int[5] ;

    // add or Enqueue
    public static void Enque (int data){
        if(rear == Queue.length-1){
            System.out.println("Queue is Full , Overflow!");
            return ;
        }
        
        else{
            System.out.printf("Enque element is : %d \n",Queue[++rear] = data);
            // return Queue[rear];
        }
    
    }
    public static int Deque (){
        if(rear == -1){
            System.out.println("Queue is Empty , Underflow!");
            return -1;
        }
        else{
            int front = Queue[0];
            System.out.printf("Deque element is : %d \n", front);
            for(int i = 0; i < rear; i++){
                Queue[i] = Queue[i+1];
            }
            rear--;
            return front;
            
        }
    
    }
    
    public static void Peek (){
        if(rear == -1){
            System.out.println("Queue is Empty");
        }
        else{
        System.out.println("Peek element is "+ Queue[0]);
        }
        
    }

    public static void QueuePrint (){
        if(rear == -1){
            System.out.println("Queue is Empty , Not Print any data");
        }
        else{
            for(int i=0; i <= rear; i++){
                System.out.print(Queue[i] + "\t");
            }
                System.out.print("\n");
        }

    }

    public static void main (String args[]){
        Enque(10);
        Enque(20);
        Enque(30);
        Enque(40);
        Enque(50);
        Peek();
        Enque(60);
        Peek();
        QueuePrint();

        Deque();
        Deque();
        Deque();
        Deque();
        Peek();
        Deque();
        Deque();
        Peek();

        QueuePrint();

    }
}