class Person{
    int age;
    String Name;

    // constructor
    Person(String Name, int age){
        this.age = age;  this.Name=Name;
    }
    // printinfo
    public void printInfo(){
        System.out.printf(" Name :- %S \t Age :- %d \n",this.Name,this.age);
    }
}
// single level inheritance
class Student extends Person{
    Student(String Name, int age){
        super(Name,age);
        // this.Name = Name; this.age = age;
    }
} 
// multi level inheritance
/*
class Player extends Student{
    public void Player(){
        System.out.println("Students Playing");
        System.out.println("Students Playing Cricket");
    }  
}
*/
// hierarchial  inheritance
class Teacher  extends Person{
    Teacher(String Name, int age){
    super(Name,age);
    }
    public void TeacherInfo(){
        System.out.println(" Guru Par bramha.");
    }
    public void printInfo(){
        System.out.println(" Working in Teaching line...");
        System.out.printf(" Name :- %S \t Age :- %d \n",this.Name,this.age);
    }

}
public class Basic{
    public static void main(String[] ashish){
        Person p1 = new Person("Radha Rani",18);
        p1.printInfo();

        Person p2 = new Student("Krishn ",18);
        p2.printInfo();

        Student p3 = new Student("Ashish",18);
        p3.printInfo();
        
        // error
        try{     
        Student p4 = (Student) new Person("Maharaj ji",18);
        p4.printInfo();
        }catch (Exception e){
            System.out.println(e);
        }finally{
            System.out.println("Successufuly complet!");
        }

        Teacher t = new Teacher("Maharaj ji",18);
        t.printInfo();
        t.TeacherInfo();
    }
}