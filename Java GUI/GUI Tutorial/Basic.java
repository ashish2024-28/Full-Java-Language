
import javax.swing.*;

public class Basic{
    public static void main(String[] ashish){

    // 1. creat a JFrame class ka Object jo swing package me likha hai
        JFrame jf = new JFrame("Main Frame");

        // set width and height
        jf.setSize(1000,900);
        //
        jf.setLayout(null);

        // for visible => jf.setVisible(true);
        jf.setVisible(true); 

    // 2. creat Button => JButton class ka Object
        JButton jb = new JButton("Click me..");
        // insert image in button
        JButton jbi = new JButton(new ImageIcon("D:\\pp\\maharaj ji_b.jpg"));

        // set Btton ka direction => jb.setBounds(x,y,width,height);
        jb.setBounds(105,10,100,30);
        jbi.setBounds(0,150,900,600);

        // add on frame jf.add(jb);
        jf.add(jb);
        jf.add(jbi);


    // 3. creat Label => JLabel class ka Object
        JLabel jl = new JLabel("Label Click the Button.");
        jl.setBounds(0,0,100,50);
        jf.add(jl);


    // 4. creat TextField => JTExtField class ka Object
        JTextField jtf = new JTextField("Text Field \n User Name");
        jtf.setBounds(210,10,150,30);
        jf.add(jtf);


    // 5 creat PasswordField => JPasswordField class ka Object
        JPasswordField jpass =  new JPasswordField("Password");
        jpass.setBounds(370,10,100,30);
        jf.add(jpass);


    // 6 creat PasswordField => JPasswordField class ka Object
        JTextArea jTA =  new JTextArea("Text Area");
        jTA.setBounds(0,40,150,50);
        jf.add(jTA);


    // 7 creat Table => JTable class ka Object
        String[] Col = {"ID","Name","Salary"};
        String[][] data = {{"1","Radha","108cr"},{"2","Krishn","108cr"},{"3","Maharaj ji","108cr"}};

        JTable jtable =  new JTable(data,Col);
        jtable.setBounds(905,200,310,80);
        jf.add(jtable);


    // 8 creat CheckBox => JCheckBox class ka Object
        JLabel jl2 =  new JLabel("Select the favourit :- CheckBox");
        jl2.setBounds(905,295,150,20);
        jf.add(jl2);

        JCheckBox jcb1 = new JCheckBox("Java");
        jcb1.setBounds(905,320,100,15);
        jf.add(jcb1);

        JCheckBox jcb2 = new JCheckBox("C++");
        jcb2.setBounds(905,340,100,15);
        jf.add(jcb2);

        JCheckBox jcb3 = new JCheckBox("Python");
        jcb3.setBounds(905,360,100,15);
        jf.add(jcb3);

    // 9 creat RadioButton => JRadioButton class ka Object
        JLabel jl3 =  new JLabel("Gender :- RadioButton");
        jl3.setBounds(905,395,150,20);
        jf.add(jl3);

        JRadioButton jrb1 = new JRadioButton("Male");
        jrb1.setBounds(905,420,100,15);
        jf.add(jrb1);

        JRadioButton jrb2 = new JRadioButton("Female");
        jrb2.setBounds(905,440,100,15);
        jf.add(jrb2);


    // 10 creat ComboBox => JRadioButton class ka Object
        JLabel jl4 =  new JLabel("Gender ComboBox :- ");
        jl4.setBounds(905,475,150,20);
        jf.add(jl4);

        String[] CBData = {"Male","Female"};
        JComboBox jCheckb = new JComboBox(CBData);
        jCheckb.setBounds(905,500,100,20);
        jf.add(jCheckb);

    // 11 creat JOptionPane
        //jf => JFrame jf = new JFrame();
        JOptionPane.showMessageDialog(jf,"Radha Radha");
        //   Alert Symbol Massage
        JOptionPane.showMessageDialog(jf,"Radha Radha ..","Alert",JOptionPane.WARNING_MESSAGE);

        //User input
        String Name = JOptionPane.showInputDialog(jf,"Enter your name");
        JOptionPane.showConfirmDialog(jf, Name);
    // 12 creat MenuBar
        JMenuBar jmb = new JMenuBar();
        JMenu menu,submenu;
        JMenuItem jmi1,jmi2,jmi3,jmi4,jmi5;
        menu = new JMenu("Menu");
        submenu = new JMenu("Sub Menu");

        jmi1 = new JMenuItem("Items 1");
        jmi2 = new JMenuItem("Items 2");
        jmi3 = new JMenuItem("Items 3");
        jmi4 = new JMenuItem("Items 4");
        jmi5 = new JMenuItem("Items 5");

        menu.add(jmi1);
        menu.add(jmi2);
        menu.add(jmi3);

        submenu.add(jmi4);
        submenu.add(jmi5);

        menu.add(submenu);
        jmb.add(menu);

        jf.setJMenuBar(jmb);


    }
}