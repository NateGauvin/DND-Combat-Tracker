import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HealingGUI {
    private JPanel panel1;
    private JButton confirmButton;
    private JList list1;
    private JTextField healField;
    private JLabel healingLabel;
    private String characterName;
    private int healingAmt = 0;
    private PlayerCharacter playerCharacter;

    HealingGUI(InitiativeTracker initiativeTracker) {
        JFrame healingGUI = new JFrame("Healing");
        healingGUI.add(panel1);
        DefaultListModel characterList = new DefaultListModel<String>();
        for(int i = 0; i < initiativeTracker.getEntityListSize(); i++) {
            characterList.add(i, initiativeTracker.getPlayerCharacter(i).getName());
        }
        list1.setModel(characterList);
        healingGUI.setSize(200,300);
        healingGUI.setVisible(true);
        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    characterName = (String) list1.getSelectedValue();
                }
            }
        });
        healField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (healField.getText().matches("[0-9]+")) {
                    healingAmt = Integer.parseInt(healField.getText());
                }
                else {
                    healingLabel.setText("Please enter a positive integer.");
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (healField.getText().matches("[0-9]+")) {
                    healingAmt = Integer.parseInt(healField.getText());
                }
                else {
                    healingLabel.setText("Please enter a positive integer.");
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (healField.getText().matches("[0-9]+")) {
                    healingAmt = Integer.parseInt(healField.getText());
                }
                else {
                    healingLabel.setText("Please enter a positive integer.");
                }
            }
        });

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (healingAmt < 0) {
                    healingLabel.setText("Please enter a positive integer.");
                }
                else if (characterName == null) {
                    healingLabel.setText("Please select a character.");
                }
                else {
                    for (int i = 0; i < initiativeTracker.getEntityListSize(); i++) {
                        if (initiativeTracker.getPlayerCharacter(i).getName().equals(characterName)) {
                            initiativeTracker.getPlayerCharacter(i).healing(healingAmt);
                            playerCharacter = initiativeTracker.getPlayerCharacter(i);
                        }
                    }
                    healingGUI.setVisible(false);
                    healingGUI.dispose();
                    BasicConfirmDialog basicConfirmDialog = new BasicConfirmDialog(characterName + " now has " + playerCharacter.getCurrHitPoints() + " health.");
                }
            }
        });
    }
}