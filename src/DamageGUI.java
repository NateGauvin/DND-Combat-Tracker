import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DamageGUI {
    private JPanel panel1;
    private JTextField damageField;
    private JList list1;
    private JButton confirmButton;
    private JLabel damageLabel;
    private String characterName;
    private int damageTaken = 0;
    private PlayerCharacter playerCharacter;

    DamageGUI(InitiativeTracker initiativeTracker) {
        JFrame damageGUI = new JFrame("Taking Damage");
        damageGUI.add(panel1);
        DefaultListModel characterList = new DefaultListModel<String>();
        for(int i = 0; i < initiativeTracker.getEntityListSize(); i++) {
            characterList.add(i, initiativeTracker.getPlayerCharacter(i).getName());
        }
        list1.setModel(characterList);
        damageGUI.setSize(200,300);
        damageGUI.setVisible(true);
        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    characterName = (String) list1.getSelectedValue();
                }
            }
        });
        damageField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (damageField.getText().matches("[0-9]+")) {
                    damageTaken = Integer.parseInt(damageField.getText());
                }
                else {
                    damageLabel.setText("Please enter a positive integer.");
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (damageField.getText().matches("[0-9]+")) {
                    damageTaken = Integer.parseInt(damageField.getText());
                }
                else {
                    damageLabel.setText("Please enter a positive integer.");
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (damageField.getText().matches("[0-9]+")) {
                    damageTaken = Integer.parseInt(damageField.getText());
                }
                else {
                    damageLabel.setText("Please enter a positive integer.");
                }
            }
        });

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (damageTaken < 0) {
                    damageLabel.setText("Please enter a positive integer.");
                }
                else if (characterName == null) {
                    damageLabel.setText("Please select a character.");
                }
                else {
                    for (int i = 0; i < initiativeTracker.getEntityListSize(); i++) {
                        if (initiativeTracker.getPlayerCharacter(i).getName().equals(characterName)) {
                            initiativeTracker.getPlayerCharacter(i).takingDamage(damageTaken, initiativeTracker.getNegativeDamage());
                            playerCharacter = initiativeTracker.getPlayerCharacter(i);
                        }
                    }
                    damageGUI.setVisible(false);
                    damageGUI.dispose();
                    BasicConfirmDialog basicConfirmDialog = new BasicConfirmDialog(characterName + " has " + playerCharacter.getCurrHitPoints() + " health left.");
                }
            }
        });
    }
}
