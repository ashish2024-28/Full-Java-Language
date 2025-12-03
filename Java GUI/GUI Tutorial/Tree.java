import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class Tree {
    public static void main(String[] args) {

        JFrame jf = new JFrame("Tree Frame");
        jf.setSize(400,400);
        jf.setVisible(true);

        DefaultMutableTreeNode style = new DefaultMutableTreeNode("Style");
        DefaultMutableTreeNode color = new DefaultMutableTreeNode("Color");
        DefaultMutableTreeNode font = new DefaultMutableTreeNode("font");

        style.add(color);
        style.add(font);

        DefaultMutableTreeNode red = new DefaultMutableTreeNode("Red");
        DefaultMutableTreeNode green = new DefaultMutableTreeNode("green");
        DefaultMutableTreeNode blue = new DefaultMutableTreeNode("blue");
        DefaultMutableTreeNode black = new DefaultMutableTreeNode("black");

        color.add(red);
        color.add(green);
        color.add(blue);
        red.add(black);

        JTree tree = new JTree(style);

        jf.add(tree);
//        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




    }
}