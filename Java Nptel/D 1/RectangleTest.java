// import java.applet.*;
// import java.awt.*;

// public class RectangleTest extends Applet {
//         int x,y,w,h;
//     public void init (){
//         x = Integer.parseInt(getParameter ("xValue"));
//         y = Integer.parseInt(getParameter ("yValue"));
//         w = Integer.parseInt(getParameter ("wValue"));
//         h = Integer.parseInt(getParameter ("hValue"));

//     }
//     public void paint(Graphics g){
//         g.drawString("this is a rectangle ");
//         g.drawRect (x,y,w,h);
       
//     }
// }

//by chatgpt
//(For Older Java Versions with Applet)
/*

import java.applet.*;
import java.awt.*;

public class RectangleTest extends Applet {
    int x, y, w, h;

    public void init() {
        try {
            String xVal = getParameter("xValue");
            String yVal = getParameter("yValue");
            String wVal = getParameter("wValue");
            String hVal = getParameter("hValue");

            // Default values in case parameters are missing
            x = (xVal != null) ? Integer.parseInt(xVal) : 50;
            y = (yVal != null) ? Integer.parseInt(yVal) : 50;
            w = (wVal != null) ? Integer.parseInt(wVal) : 100;
            h = (hVal != null) ? Integer.parseInt(hVal) : 50;
        } catch (NumberFormatException e) {
            x = 50; y = 50; w = 100; h = 50; // Fallback values
        }
    }

    public void paint(Graphics g) {
        g.drawString("This is a rectangle", 20, 20); // Proper text placement
        g.drawRect(x, y, w, h);
    }
}  */


import javax.swing.*;
import java.awt.*;

public class RectangleTest extends JFrame {
    int x = 50, y = 50, w = 100, h = 50;

    public RectangleTest() {
        setTitle("Rectangle Drawing");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawString("This is a rectangle ", 50, 50);
        g.drawRect(x, y, w, h);
    }

    public static void main(String[] args) {
        new RectangleTest();
    }
}
