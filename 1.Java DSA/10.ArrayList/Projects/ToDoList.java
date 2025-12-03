import java.util.Scanner;
import java.util.ArrayList;

public class ToDoList{
    public static void main(String[] ashish){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();
        Boolean isTrue = true;
        while(isTrue){
            System.out.println("--------Menu--------");
            System.out.println("1:-----Add Task-----");
            System.out.println("2-----View Task-----");
            System.out.println("3-----Remove Task-----");
            System.out.println("4-----Exit-----");
            Boolean mT = true;
          while(mT){
                System.out.print("Which Operation Do you want to Perform :- ");
                int choice = sc.nextInt(); // after nextInt -> nextLine (here create problem when enter value then pass the nextLine) so use consume
                sc.nextLine(); //Consume

                switch(choice){
                    case 1 :
                        System.out.print("Enter Task to Add :- ");
                        String task = sc.nextLine();
                        tasks.add(task);
                        System.out.println("Task Added Successfully.");
                        break;
                        
                case 2 :
                        System.out.println("Your Tasks :- ");
                        for(int i = 0; i < tasks.size(); i++ ){
                                System.out.println(i+1 +"."+ tasks.get(i));
                        }
                        break;
                    
                case 3 :
                        System.out.print("Enter S.No of Task which you want to remove :- ");
                        int sNo = sc.nextInt();
                        if(sNo > tasks.size() || sNo < tasks.size()  ){
                            tasks.remove(sNo-1);
                            System.out.println("Task is deleted Successfuly");
                            break;                      
                        }else{
                            System.out.println("Please Enter valid Task S.NO. to remove");
                            break;
                        }

                    case 4 :
                        isTrue = false;
                        break;

                    default : 
                        System.out.println("Please Enter valid Input !");
                        

                }

             
            }   
        }
    }
}