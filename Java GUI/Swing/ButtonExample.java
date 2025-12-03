import javax.swing.*; // import Swing library
import java.awt.event.*; // import event handling package

public class ButtonExample{
    public static void main(String[] args){

        // step 1; creat the JFrame(window)
        JFrame frame = new JFrame(" title -> Button Example");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //step 2; creat a JButton (button)
        JButton button = new JButton(" here -> Click Me! please");

        //step 3; set button position and size 
        button.setBounds(120, 190, 200, 50);// (x,y,width,height)
      
       //step 4; Add an ActionListener to detect clicks
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(frame, "Button clicked ! 🎉 msg pop when click");
            }
        });

        //step 5; Add button to the frame
        frame.setLayout(null); // Disable default layout
        frame.add(button);

        // step 6; make the frame visible
        frame.setVisible(true);
    }
}
