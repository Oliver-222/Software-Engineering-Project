package factorapi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultFrame extends JFrame implements ActionListener {

    private final String result;
    //Labels: Will need labels for all data we want to display, and to tell the user which areas show which data

    //These will be final, since they're just text to put on the frame
    private final JLabel inputLabel = new JLabel("Input:");
    private final JLabel cfLabel = new JLabel("Common factors:");
    private final JLabel calcLabel = new JLabel("Calculated factors:");

    //These will eventually hold the actual data we need
    static JLabel inputData;
    static JLabel cfData;

    static JLabel oddIndices;
    static JLabel evenIndices;

    //These panels will hold all of our components
    static JPanel leftPanel;
    static JPanel rightPanel;
    static JPanel cfPanel;
    static JPanel calcPanel;
    static JPanel oddPanel;
    static JPanel evenPanel;

    public ResultFrame(String input){
        this.setTitle("Results");
        result = input;
        inputData = new JLabel();
        cfData = new JLabel();

        oddIndices = new JLabel();
        evenIndices = new JLabel();
        leftPanel = new JPanel();
        rightPanel = new JPanel();
        cfPanel = new JPanel();
        calcPanel = new JPanel();
        oddPanel = new JPanel();
        evenPanel = new JPanel();

        //Create a Font so we can specify font size
        Font myFont = new Font(Font.SERIF, Font.PLAIN, 18);
        Font boldFont = new Font(Font.SERIF, Font.BOLD, 18);
        inputData.setFont(myFont);
        cfData.setFont(myFont);
        oddIndices.setFont(myFont);
        evenIndices.setFont(myFont);
        inputLabel.setFont(boldFont);
        cfLabel.setFont(boldFont);
        calcLabel.setFont(boldFont);

    }

    //Will parse the result into the data we want
    public void parseData(){
        //Will separate the result into the left and right side of the colon.
        //[0] will be the input, [1] will be all the factors
        String[] splitInputAndResult = result.split(":");
        //Grab the user input from the split array
        inputData.setText(splitInputAndResult[0]);

        String factors = splitInputAndResult[1];
        String[] splitFactors = factors.split(",");
        //For the visual, I want to put the two factors side by side.
        //To do this, I will display the odd indices on the left, and the even indices on the right
        //This works because our engine lists the factors in sorted pairs.
        //We just have to loop through the factors, and add the first element of the pair to the oddIndices, and the
        //second element of the pair to evenIndices
        //Also, I want to tell the user if their input is divisible by a few common factors:
        //2, 3, 4, 5, 6, 7, 8, 9, 10
        //If any of these appear as an even index, we will add these to our cfData (commonFactorsData)
        //Note: JLabel for some reason doesn't work with the normal "\n" for a new line.
        //It needs to use some html things: you have to put <html> on either side of the string, and use <br> where you
        //would've used \n.
        String evenText = "<html>";
        String oddText = "<html>";
        String commonText = "<html>";
        for(int i = 0; i < splitFactors.length; i++){
            if(i%2==0){
                String evenFactor = splitFactors[i];
                int evenInt = Integer.parseInt(evenFactor);
                //Add the new factor to the other factors
                //evenIndices.setText(evenIndices.getText() + "\n" + evenFactor);
                evenText += evenFactor + "<br>";
                //If the factor is one of our common ones, add its text to the label
                if(evenInt <= 10 && evenInt > 1){
                    //cfData.setText(cfData.getText() + "\n" + evenFactor);
                    commonText += evenFactor + "<br>";
                }

            } else {
                //oddIndices.setText(oddIndices.getText() + "\n" + splitFactors[i]);
                oddText += splitFactors[i] + "<br>";
            }
        }
        evenText += "<html>";
        oddText += "<html>";
        commonText += "<html>";
        evenIndices.setText(evenText);
        oddIndices.setText(oddText);
        cfData.setText(commonText);
        //Now, these pairs will be lined up in the proper labels.
        //All of our labels now contain the proper data

    }

    public void createFrame(){

        //This method will create our frame and add our components in the desired format.
        //Arbitrary values for size, subject to change
        this.setSize(500, 600);
        //Make sure it closes properly
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Set our layout to BoxLayout, and have it add our components on the horizontal.
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        //JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        //Add everything to the left panel
        leftPanel.add(inputLabel);
        leftPanel.add(inputData);
        leftPanel.add(cfLabel);
        cfPanel.setBackground(Color.lightGray);
        cfPanel.add(cfData);
        leftPanel.add(cfPanel);
        leftPanel.setVisible(true);

        //JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        //Add everything to the right panel
        rightPanel.add(calcLabel);
        calcPanel.setLayout(new BoxLayout(calcPanel, BoxLayout.X_AXIS));
        //evenPanel.setBackground(Color.GRAY);
        evenPanel.add(evenIndices);
        oddPanel.add(oddIndices);
        //oddPanel.setBackground(Color.DARK_GRAY);
        calcPanel.add(evenPanel);
        calcPanel.add(oddPanel);
        rightPanel.add(calcPanel);
        rightPanel.setVisible(true);

        //Add our left and right panels to the frame
        panel.add(leftPanel);
        panel.add(rightPanel);
        this.add(panel);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
