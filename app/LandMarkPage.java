package app;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class LandMarkPage extends JFrame {

    private JLabel label;
    private final JButton backButton;

    LandMarkPage(){

        backButton = new JButton();
        backButton.setText("Back");
        backButton.setBounds(0,0,100,30);
        backButton.setFocusable(false);
        backButton.setBorder(new RoundedBorder(10));
        backButton.addActionListener(this::mainPage);
        this.add(backButton);

        label = new JLabel();
        label.setBounds(10,10,300,100);
        label.setText("Hello from this side!");
        this.add(label);

        this.setLayout(null);
        this.setBounds(0,0,420,420);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void mainPage(ActionEvent actionEvent){
        if (actionEvent.getSource() == backButton){
            this.dispose();
            new UserInterface();
        }
    }

}
