import javax.swing.*;
// import javax.swing.filechooser.*;
import java.awt.*;

public class Set_Icon {
    public static void main(String[] args) {

        JFrame jf = new JFrame("Set Icon");
        jf.setSize(400,400);
        jf.setVisible(true);

    // Change the incon from java to new icon
        Image icon = Toolkit.getDefaultToolkit().getImage("D:\\pp\\kj.jpg");

        jf.setIconImage(icon);

    }
}