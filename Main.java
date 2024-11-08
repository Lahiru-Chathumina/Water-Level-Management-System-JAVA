import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// Step 1 Add Observer /////////////////////////////////////////////////////////// 01 ////////////////////////////
class WaterLevelObserver {
    public void update(int waterLevel) {
    }
}

// Step 2 Add specific observer ///////////////////////////////////////////////////02 ////////////////////////////
class Alarm extends WaterLevelObserver {
    private JTextArea displayArea;

    public Alarm(JTextArea displayArea) {  // Const
        this.displayArea = displayArea;
    }

    public void update(int waterLevel) {
        // Step 3 add  Display alarm state in the text area ////////////////////////03///////////////////////////////
        displayArea.append(waterLevel >= 50 ? "Alarm ON\n" : "Alarm Off\n");
    }
}

class Splitter extends WaterLevelObserver {
    private JTextArea displayArea;

    public Splitter(JTextArea displayArea) {  // Cons
        this.displayArea = displayArea;
    }

    public void update(int waterLevel) {
        // Step 4 Display splitter genaret//////////////////////////////////////////////04///////////////////////////
        displayArea.append(waterLevel >= 75 ? "Splitter ON\n" : "Splitter Off\n");
        displayArea.append("------------------------------------------------------------------------");

    }
}

class Display extends WaterLevelObserver {
    private JTextArea displayArea;

    public Display(JTextArea displayArea) {  //data cons
        this.displayArea = displayArea;
    }

    public void update(int waterLevel) {
        // Step 5: Display water level//////////////////////////////////////////////05///////////////////////////////
        displayArea.append("Water Level: " + waterLevel + "\n");
    }
}

class SMSSender extends WaterLevelObserver {
    private JTextArea displayArea;

    public SMSSender(JTextArea displayArea) {  //data cons
        this.displayArea = displayArea;
    }

    public void update(int waterLevel) {
        // Step 6 Add Display SMS sending message ////////////////////////////////////////06 /////////////////////////
        displayArea.append("Send sMS: " + waterLevel + "\n");


    }
}
// Step 7 Add Define ControlRoom class to manage observers////////////////////////////////07//////////////////////////
class ControlRoom {
    private ArrayList<WaterLevelObserver> observerList;
    private int waterLevel;

    ControlRoom() {
        observerList = new ArrayList<>();
    }

    public void addWaterLevelObserver(WaterLevelObserver ob) {
        observerList.add(ob);  // Step 8: Add an observer to the list///////////////////08/////////////////////////////
    }

    public void setWaterLevel(int waterLevel) {
        // Step 9 add water level and notify observers if it changes////////////////////09/////////////////////////////
        if (this.waterLevel != waterLevel) {
            this.waterLevel = waterLevel;
            notifyObservers();
        }
    }

    public void notifyObservers() {
        // Step Add Notify each observer about the water level change//////////////////10////////////////////////
        for (WaterLevelObserver ob : observerList) {
            ob.update(waterLevel);
        }
    }
}

// Step 11 Create GUI for Water Level MS///////////////////////////////////////////////11///////////////////////////
class WaterLevelMS extends JFrame {
    private ControlRoom controlRoom;
    private JLabel waterLevelLabel;
    private JSlider waterLevelSlider;
    private JTextArea displayArea;

    public WaterLevelMS() {
        controlRoom = new ControlRoom();

        // Step 12 add configure JTextArea /////////////////////////////////////////////12///////////////////////
        ////////////////////////////////////////////////////////////////////
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        // Step 13 Add observers //ControlRoom //////////////////////////////////////////13/////////////////////////
        controlRoom.addWaterLevelObserver(new Alarm(displayArea));
        controlRoom.addWaterLevelObserver(new Display(displayArea));
        controlRoom.addWaterLevelObserver(new SMSSender(displayArea));
        controlRoom.addWaterLevelObserver(new Splitter(displayArea));

        // Step 14 Create a label to show current water level///////////////////////////////14///////////////////////
        waterLevelLabel = new JLabel("Water Level: 0", SwingConstants.CENTER);
        add(waterLevelLabel, BorderLayout.NORTH);

        // Step 15 Create and configure JSlider for water level control/////////////////////15////////////////////////////////
        waterLevelSlider = new JSlider(0, 100, 0);
        waterLevelSlider.setMajorTickSpacing(10);
        waterLevelSlider.setPaintTicks(true);
        waterLevelSlider.setPaintLabels(true);
        waterLevelSlider.addChangeListener(e -> {
            // Step 16 Update water level label and ControlRoom when slider is moved///////16///////////////////////////////
            int waterLevel = waterLevelSlider.getValue();
            waterLevelLabel.setText("Water Level: " + waterLevel);
            controlRoom.setWaterLevel(waterLevel);
        });
        add(waterLevelSlider, BorderLayout.SOUTH);

        // Step 17 JFrame settings ///////////////////////////////////////////////////////17///////////////////////////
        setTitle("Water Level MS");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

// Step 18
class Demo {
    public static void main(String[] args) {
        new WaterLevelMS();

    }
}
