package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import static app.Main.graph;

public class LandMarkPage extends JFrame {

    private final JButton backButton;
    private final JComboBox<String> sourceCombo;
    private final JComboBox<String> landMarkeCombo;
    private final JComboBox<String> destinationCombo;
    private final JLabel shortestPathDisplay;
    private final JLabel distanceDisplay;

    LandMarkPage(){

        backButton = new JButton();
        backButton.setText("Back");
        backButton.setBounds(0,0,100,30);
        backButton.setFocusable(false);
        backButton.setBorder(new RoundedBorder(10));
        backButton.addActionListener(this::mainPage);
        this.add(backButton);

        JLabel currentLocation = new JLabel();
        currentLocation.setText("Select current location:");
        currentLocation.setBounds(100, 50, 200, 40);
        currentLocation.setFont(new Font("Serif", Font.BOLD, 20));
        this.add(currentLocation);

        JLabel landMarkLocation = new JLabel();
        landMarkLocation.setText("Select desired landmark:");
        landMarkLocation.setBounds(100, 150, 250, 40);
        landMarkLocation.setFont(new Font("Serif", Font.BOLD, 20));
        this.add(landMarkLocation);

        JLabel destinationLocation = new JLabel();
        destinationLocation.setText("Select destination:");
        destinationLocation.setBounds(100, 250, 200, 40);
        destinationLocation.setFont(new Font("Serif", Font.BOLD, 20));
        this.add(destinationLocation);

        String[] places =
                {"Main Gate","Law school", "Night Market", "UG Fire Service", "CS Department", "Athletic Oval"
                        ,"Diaspora","Volta Hall","Akuafo Hall","Business School", "Legon Hall", "Great Hall",
                        "NNB", "N Block", "JQB", "Balme+ Library","UGCS", "Pentagon Hall"};

        sourceCombo = new JComboBox<>(places);
        sourceCombo.setBounds(550, 50, 200, 30);
        this.add(sourceCombo);

        landMarkeCombo = new JComboBox<>(places);
        landMarkeCombo.setBounds(550,150,200,30);
        this.add(landMarkeCombo);

        destinationCombo = new JComboBox<>(places);
        destinationCombo.setBounds(550, 250, 200, 30);
        this.add(destinationCombo);

        JLabel info = new JLabel();
        info.setText("Shortest Path: ");
        info.setBounds(100, 400, 250, 40);
        info.setFont(new Font("Serif",Font.BOLD, 20));
        this.add(info);

        shortestPathDisplay = new JLabel();
        shortestPathDisplay.setBounds(300, 400, 900, 40);
        shortestPathDisplay.setBorder(new RoundedBorder(10));
        shortestPathDisplay.setFont(new Font("Serif",Font.BOLD, 20));
        this.add(shortestPathDisplay);

        distanceDisplay = new JLabel();
        distanceDisplay.setBounds(250, 470, 400, 40);
        this.add(distanceDisplay);

        JButton getPossiblePaths = new JButton("Get possible paths");
        getPossiblePaths.setBounds(580, 350, 130, 25);
        getPossiblePaths.setBorder(new RoundedBorder(10));
        getPossiblePaths.setFocusable(false);
        this.add(getPossiblePaths);

        getPossiblePaths.addActionListener(this::getPaths);

        this.setLayout(null);
        this.setSize(1300,550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    public void mainPage(ActionEvent actionEvent){
        if (actionEvent.getSource() == backButton){
            this.dispose();
            new UserInterface();
        }
    }

    private void getPaths(ActionEvent actionEvent) {
        try {
            String theOrigin = sourceCombo.getSelectedItem().toString();
            String theEnd = destinationCombo.getSelectedItem().toString();

            Locations sourceDijkstra = graph.getNodeByName(theOrigin);
            Locations destinationDijkstra = graph.getNodeByName(theEnd);

            Dijkstra.findShortestPath(graph, sourceDijkstra, destinationDijkstra);
            String path = Dijkstra.getShortestPath(sourceDijkstra, destinationDijkstra);
            shortestPathDisplay.setText(path);

            distanceDisplay.setText("Approximate distance: "+Dijkstra.getTotalDistance(destinationDijkstra));
        }catch (NullPointerException exception){
            System.out.println(exception.getMessage());
        }
    }

}
