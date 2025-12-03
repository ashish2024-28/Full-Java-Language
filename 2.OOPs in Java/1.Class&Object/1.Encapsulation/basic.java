class Person{
    private int age;
    public String Name;
    protected double Salary; 

    // constructor
    Person(String Name, int age, double Salary){
        this.age = age;  this.Salary=Salary; this.Name=Name;
    }
    // Setter to set Salary
    public void setSalary(double Salary){
        this.Salary = Salary;
    }
    // Getter to get Salary
    public double getSalary(){
        return this.Salary ;
    }
    // Setter to set age
    public void setAge(int age){
        this.age = age;
    }
    // Getter to get Age
    public int getAge(){
        return this.age ;
    }
    // printinfo
    public void printInfo(){
        System.out.printf(" Name :- %S\n ",this.Name);
    }

}

public class basic{
    public static void main(String[] ashish){
        Person p1 = new Person("Ashish",18,999);
        p1.printInfo();
        System.out.printf("Age :- %d\n Salary :- %.2f\n",p1.getAge(),p1.getSalary());

        p1.setAge(22);
        p1.setSalary(99999);
        p1.printInfo();
        System.out.printf("Age :- %d\n Salary :- %.2f\n",p1.getAge(),p1.getSalary());
    }
}