package app;

import javax.swing.*;
import java.awt.*;

public class UserInterface extends JFrame {
    UserInterface(){
        this.setTitle("Finding possible paths to your destination");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(13000, 550);
        this.setLayout(null);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.cyan);

    }
}
