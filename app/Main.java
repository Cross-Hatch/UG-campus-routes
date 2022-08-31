package app;

import javax.swing.*;
import java.awt.*;

public class Main {
        public static Map graph = new Map();

    public static void main(String[] args) {


        Locations mainGate = new Locations("Main Gate");
        Locations UGFireService = new Locations("UG Fire Service");
        Locations greatHall = new Locations("Great Hall");
        Locations nb= new Locations("N Block");
        Locations jqb = new Locations("JQB");
        Locations pentHall = new Locations("Pentagon Hall");
        Locations balmeLibrary = new Locations("Balme Library");
        Locations nnb = new Locations("NNB");
        Locations ugcs = new Locations("UGCS");
        Locations CSDepartment = new Locations("CS Department");
        Locations athleticOval = new Locations("Athletic Oval");
        Locations voltaHall = new Locations("Volta Hall");
        Locations akuafoHall = new Locations("Akuafo Hall");
        Locations legonHall = new Locations("Legon Hall");
        Locations nightMarket = new Locations("Night Market");
        Locations diasporaHalls = new Locations("Diaspora");
        Locations businessSchool = new Locations("Business School");
        Locations lawSchool = new Locations("Law School");
        Locations commonWealthHall = new Locations("Common Wealth Hall");


        graph.addVertex(mainGate);
        graph.addVertex(greatHall);
        graph.addVertex(nb);
        graph.addVertex(UGFireService);
        graph.addVertex(jqb);
        graph.addVertex(pentHall);
        graph.addVertex(balmeLibrary);
        graph.addVertex(nnb);
        graph.addVertex(ugcs);
        graph.addVertex(CSDepartment);
        graph.addVertex(athleticOval);
        graph.addVertex(voltaHall);
        graph.addVertex(akuafoHall);
        graph.addVertex(legonHall);
        graph.addVertex(nightMarket);
        graph.addVertex(diasporaHalls);
        graph.addVertex(businessSchool);
        graph.addVertex(lawSchool);
        graph.addVertex(commonWealthHall);


        graph.addEdge(new Extent(mainGate, jqb, 300));
        graph.addEdge(new Extent(mainGate, UGFireService, 240));
        graph.addEdge(new Extent(mainGate, akuafoHall, 500));

        graph.addEdge(new Extent(UGFireService, akuafoHall, 650));

        graph.addEdge(new Extent(greatHall, commonWealthHall, 100));

        graph.addEdge(new Extent(nb, balmeLibrary, 600));
        graph.addEdge(new Extent(nb, businessSchool, 500));
        graph.addEdge(new Extent(nb, nnb, 500));
        graph.addEdge(new Extent(nb, CSDepartment, 500));
        graph.addEdge(new Extent(nb, ugcs, 500));

        graph.addEdge(new Extent(voltaHall, businessSchool, 200));
        graph.addEdge(new Extent(voltaHall, commonWealthHall,450));
        graph.addEdge(new Extent(voltaHall, legonHall, 190));

        graph.addEdge(new Extent(businessSchool, ugcs, 70));

        graph.addEdge(new Extent(legonHall, akuafoHall, 400));
        graph.addEdge(new Extent(legonHall, athleticOval, 450));
        graph.addEdge(new Extent(legonHall, commonWealthHall, 750));
        graph.addEdge(new Extent(legonHall, nightMarket, 1200));

//        graph.addEdge(new Extent(jqb, balmeLibrary, 850));
        graph.addEdge(new Extent(jqb, akuafoHall, 700));
        graph.addEdge(new Extent(jqb, lawSchool, 350));

        graph.addEdge(new Extent(lawSchool, pentHall, 900));

        graph.addEdge(new Extent(ugcs, balmeLibrary, 200));
        graph.addEdge(new Extent(ugcs, voltaHall, 350));
//        graph.addEdge(new Extent(ugcs, CSDepartment, 550));
//        graph.addEdge(new Extent(ugcs, nb, 650));

        graph.addEdge(new Extent(CSDepartment, balmeLibrary, 650));
        graph.addEdge(new Extent(CSDepartment, nb, 550));
        graph.addEdge(new Extent(CSDepartment, akuafoHall, 850));
        graph.addEdge(new Extent(CSDepartment, lawSchool, 650));

        graph.addEdge(new Extent(balmeLibrary, athleticOval, 600));
        graph.addEdge(new Extent(balmeLibrary, akuafoHall, 270));
        graph.addEdge(new Extent(balmeLibrary, legonHall, 500));

        graph.addEdge(new Extent(athleticOval, akuafoHall, 550));
        graph.addEdge(new Extent(athleticOval, nightMarket, 800));

        graph.addEdge(new Extent(akuafoHall, nightMarket, 1000));

        graph.addEdge(new Extent(nightMarket, diasporaHalls, 850));


        String[] places =
                {"Main Gate","Law school", "Night Market", "UG Fire Service", "CS Department", "Athletic Oval"
                        ,"Diaspora","Volta Hall","Akuafo Hall","Business School", "Legon Hall", "Great Hall",
                        "NNB", "N Block", "JQB", "Balme Library","UGCS", "Pentagon Hall"};
        UserInterface userInterface = new UserInterface();

        JLabel currentLocation = new JLabel();
        currentLocation.setText("Select current location:");
        currentLocation.setBounds(100, 50, 200, 40);
        currentLocation.setFont(new Font("Serif", Font.BOLD, 20));
        userInterface.add(currentLocation);

        JLabel destinationLocation = new JLabel();
        destinationLocation.setText("Select destination:");
        destinationLocation.setBounds(100, 150, 200, 40);
        destinationLocation.setFont(new Font("Serif", Font.BOLD, 20));
        userInterface.add(destinationLocation);

        JComboBox<String> sourceCombo = new JComboBox<>(places);
        sourceCombo.setBounds(550, 50, 200, 30);
        userInterface.add(sourceCombo);

        JComboBox<String> destinationCombo = new JComboBox<>(places);
        destinationCombo.setBounds(550, 150, 200, 30);
        userInterface.add(destinationCombo);

        JLabel info = new JLabel();
        info.setText("Shortest Path: ");
        info.setBounds(100, 300, 250, 40);
        info.setFont(new Font("Serif",Font.BOLD, 20));
        userInterface.add(info);

        JLabel shortestPathDisplay = new JLabel();
        shortestPathDisplay.setBounds(300, 300, 900, 40);
        shortestPathDisplay.setBorder(new RoundedBorder(10));
        shortestPathDisplay.setFont(new Font("Serif",Font.BOLD, 20));
        userInterface.add(shortestPathDisplay);

        JLabel distanceDisplay = new JLabel();
        distanceDisplay.setBounds(250, 340, 400, 40);
        userInterface.add(distanceDisplay);

        JButton button = new JButton("Get possible paths");
        button.setBounds(580, 230, 130, 25);
        button.setBorder(new RoundedBorder(10));
        button.setFocusable(false);

        userInterface.add(button);
        userInterface.setVisible(true);

        button.addActionListener( e ->  {
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
        });

    }
}