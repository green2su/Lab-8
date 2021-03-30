import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GuessingGame implements ActionListener 
{
  JTextField userGuess;
  JButton buttonGuess;
  JButton buttonAgain;
  Random r = new Random();
  int randomNum = r.nextInt(100) + 1;
  JLabel jlabPrompt, jlabRange, jlabLastGuess;
    GuessingGame() 
    {       
       
    JFrame frame = new JFrame("Guessing Game");

    frame.setLayout(new FlowLayout());

    frame.setSize(240, 120);

    userGuess = new JTextField(10);
    // Set the action commands for the text field.
    userGuess.setActionCommand("myTF");
    // Create the Reverse button.
    buttonGuess = new JButton("Guess");
    buttonAgain = new JButton("Play Again");
    // Add action listeners.
    userGuess.addActionListener(this);
    buttonGuess.addActionListener(this);
    buttonAgain.addActionListener(this);
    // Create the labels.
    jlabPrompt = new JLabel("Enter your guess: ");
    jlabRange = new JLabel("");
    jlabLastGuess = new JLabel("");
    // Add the components to the content pane.
    frame.add(jlabPrompt);
    frame.add(userGuess);
    frame.add(buttonGuess);
    frame.add(jlabRange);
    frame.add(jlabLastGuess);
    frame.add(buttonAgain);
    //frame.add(jlabContents);       
    // Display the frame.
    frame.setVisible(true); 
  }

  public void actionPerformed(ActionEvent ae) 
  { 
    if(ae.getActionCommand().equals("Guess")) 
    { 
      int guess = Integer.parseInt(userGuess.getText());

      if (guess == randomNum)
      {
        jlabRange.setText("You got it!");
        jlabLastGuess.setText("Last Guess was: " + guess);
      }

      else if (guess > randomNum)
      {
        jlabRange.setText("Too High!");
        jlabLastGuess.setText("Last guess was: " + guess);
      }
    
      else if (guess < randomNum)
      {
        jlabRange.setText("Too Low!");
        jlabLastGuess.setText("Last guess was: " + guess);
      }
    }

    else if(ae.getActionCommand().equals("Play Again"))
    {
      randomNum = r.nextInt(100) + 1;
      jlabRange.setText("");
      jlabLastGuess.setText("");
      userGuess.setText("");
    }
    
    else 
    {
      // Enter was pressed while focus was in the 
      // text field. 
      jlabLastGuess.setText("You pressed ENTER. Text is: " + userGuess.getText()); 
      jlabRange.setText("");
      jlabLastGuess.setText("");
      userGuess.setText("");

    } 
  }
} 

