import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class DiceRoller {
    private JPanel panel1;
    private JTextField diceNumber;
    private JButton rollButton;
    private JLabel returnRoll;
    private int upperBound = 0;

    DiceRoller() {
        Random rand = new Random();
        JFrame diceRoller = new JFrame("Dice Roller");
        diceRoller.add(panel1);
        diceRoller.setSize(300,200);
        diceRoller.setVisible(true);
        diceNumber.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (diceNumber.getText().matches("[0-9]+")) {
                    upperBound = Integer.parseInt(diceNumber.getText());
                }
                else {
                    returnRoll.setText("Please enter a positive integer.");
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (diceNumber.getText().matches("[0-9]+")) {
                    upperBound = Integer.parseInt(diceNumber.getText());
                }
                else {
                    returnRoll.setText("Please enter a positive integer.");
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (diceNumber.getText().matches("[0-9]+")) {
                    upperBound = Integer.parseInt(diceNumber.getText());
                }
                else {
                    returnRoll.setText("Please enter a positive integer.");
                }
            }
        });
        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (upperBound >= 1) {
                    returnRoll.setText("You have rolled a: " + rand.nextInt(upperBound + 1));
                }
                else {returnRoll.setText("Please enter a positive value.");}
            }
        });
    }
}
