import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;
  
  JLabel numberLabel;
  JLabel factorialLabel;

  JTextField numInput;
  JTextField ansInput;

  JButton calcButton;


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
    //initialize the mainJPanel
    mainPanel = new JPanel();
    //disable any layout helpers
    mainPanel.setLayout(null);
    //create the labels
    numberLabel = new JLabel("Enter Number");
    factorialLabel = new JLabel("Factorial(n)");
    //layout the labels with their cordiantes and size
    numberLabel.setBounds(10,10,100,20);
    factorialLabel.setBounds(220,10,100,20);
    //add labels to the main panel
    mainPanel.add(numberLabel);
    mainPanel.add(factorialLabel);
    //initialize the text fields
    numInput = new JTextField();
    ansInput = new JTextField();
    //layout the text fields with their cordinates and size
    numInput.setBounds(120,10,80,20);
    ansInput.setBounds(330,10,80,20);
    //diable the text areas so the user cant type in them
    ansInput.setEnabled(false);
    //add text fields to main panel
    mainPanel.add(numInput);
    mainPanel.add(ansInput);

    //initialize the button
    calcButton = new JButton("Calculate");
    //add action listener to buttons
    calcButton.addActionListener(this);
    //layout the calculation button to the main panel
    calcButton.setBounds(450,10,100,30);
    //add buttons to the main panel
    mainPanel.add(calcButton);
    //add main panel to frame
    frame.add(mainPanel);

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();
    if(command.equals("Calculate")){
    //get text from input box
    String firstText = numInput.getText();
    //convert string into integer
    int num = Integer.parseInt(firstText);
    //declare a variable for a total
    int total = 1;
    //create a for loop to Calculate factorialLabel
    for(int i = 1; i <= num; i++){
      //find total
      total = total * i;
    }
    //tell user their answer
    ansInput.setText("" + total);
  }
  }
  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
