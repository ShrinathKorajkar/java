package learn;

// import java.awt.*;
import javax.swing.*;

public class awt {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My Frame");
        frame.add(new JButton("cancel"));
        frame.add(new JButton("ok"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.setVisible(true);
    }
}