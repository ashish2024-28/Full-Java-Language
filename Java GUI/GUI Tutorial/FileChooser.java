import javax.swing.*;
// import javax.swing.filechooser.*;
public class FileChooser {
    public static void main(String[] args) {

//      JFileChooser jfc = new JFileChooser();
        JFileChooser jfc = new JFileChooser("c:");

        jfc.showSaveDialog(null);
//        int i = jfc.showSaveDialog(null);



    }
}