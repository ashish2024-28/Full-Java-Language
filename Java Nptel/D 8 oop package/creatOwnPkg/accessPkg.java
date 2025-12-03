// save the following code as accessPkg.java in a sub-directory

import myPackage.myClass;
import myPackage.MyName;
import myPackage.BankAccount;
// import myPkg.myClass;


class accessPkg{
    public static void main(String args[]){
        System.out.println("myPackage.myClass");
        myClass c = new myClass();
        c.msg();
        c.myName();

        System.out.println();
        myPkg.myClass cp2 = new myPkg.myClass();
        cp2.msg();

        System.out.println("\nmyPackage.MyName\n");
        MyName name = new MyName("radha");
        name.printMyName();

        System.out.println("\nmyPackage.BankAccount\n");
        BankAccount bnk = new BankAccount("Radha ji",12345678,108);
        bnk.AccInfo();
        
        System.out.println();
        BankAccount bnk2 = new BankAccount("krishn ji",12345678,108);
        bnk2.AccInfo();

        System.out.println();
        BankAccount bnk3 = new BankAccount("Pramanand maharaj ji",12345678,108);
        bnk3.AccInfo();
        
        System.out.println("\nPrint using By array and loop\n");
        BankAccount bnk4[] = new BankAccount[4];
        bnk4[0] = new BankAccount("Radha ji",12345678,108);
        bnk4[1] = new BankAccount("krishn ji",12345678,108);
        bnk4[2] = new BankAccount("Pramanand maharaj ji",12345678,108);
        bnk4[3] = new BankAccount("ashish",9693032585L,-1);

        for(int i=0 ;i<4; i++){
            // bnk4[i].show();
            System.out.println("The memory address -> " + bnk4[i]);
            bnk4[i].AccInfo();
            System.out.println();
        }
        
        
    }
}