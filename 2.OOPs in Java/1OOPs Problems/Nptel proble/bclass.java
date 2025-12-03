class Pen{
    String color; String type;
    public void write(){
        System.out.println("writing anything!.");
    }
    public void printInfo(String color , String type){
        this.color = color; this.type = type;
        System.out.println(this.color +" , " + this.type);
    }
}

// student information 
class Student{
    String name;  int age;
    Student(String name, int age){
        this.name = name ; this.age = age;
        System.out.println("Perametrise Constructor -> "+this.name +" , "+age );

    }
    public void printStudentInfo(int age){
        System.out.println("call by functon -> " + this.name +" , " + age );
    }
  Student(){
         System.out.println("Constructor called.");
    }
    Student(int age){
         System.out.println("age "+age+" Constructor called.");
    }
}

public class bclass{
    public static void main(String args[]){
        Pen pen1 = new Pen();
        pen1.color = "blue";
        pen1.type = "gel";
      //  System.out.println(pen1.color); System.out.println(pen1.type); pen1.write(); // call seprately

        Pen pen2 = new Pen();
        //pen2.printInfo("red","ball"); System.out.println(pen2.color); System.out.println(pen2.type); // call seprately

        // student information 
         Student s2 = new Student();

         Student s1 = new Student("ashish",18);
         System.out.println("main say call ->"+s1.name + " , "+s1.age);

         Student s4 = new Student("Abhishek",16);
         Student s3 = new Student(17);

         // call by class function
         s1.printStudentInfo(12);
         s4.printStudentInfo(13);


         
     }
}