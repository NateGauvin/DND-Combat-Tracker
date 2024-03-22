import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitiativeCollector {
    private JPanel panel1;
    private JButton button1;
    private JTextField textField1;
    private JLabel rollLabel;
    private int initiativeValue = 0, currentCount;

    InitiativeCollector(InitiativeTracker initiativeTracker, int counter) {
        currentCount = counter;
        JFrame initiativeCollector = new JFrame("Initiative");
        initiativeCollector.add(panel1);
        initiativeCollector.setSize(400,300);
        initiativeCollector.setVisible(true);
        rollLabel.setText("What did " + initiativeTracker.getPlayerCharacter(counter).getName() + " roll?");
        textField1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                initiativeValue = Integer.parseInt(textField1.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                initiativeValue = Integer.parseInt(textField1.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                initiativeValue = Integer.parseInt(textField1.getText());
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (initiativeValue < 1) {
                    rollLabel.setText("Please enter a positive value.");
                }
                else {
                    initiativeTracker.getPlayerCharacter(counter).setInitiativeValue(initiativeValue);
                    currentCount++;
                    if(currentCount == initiativeTracker.getEntityListSize()) {
                        initiativeTracker.sortInitiative();
                        BattleHandlerGUI battleHandlerGUI = new BattleHandlerGUI(initiativeTracker);
                    }
                    else {
                        InitiativeCollector nextCollector = new InitiativeCollector(initiativeTracker, currentCount);
                    }
                    initiativeCollector.setVisible(false);
                    initiativeCollector.dispose();
                }
            }
        });
    }
}
