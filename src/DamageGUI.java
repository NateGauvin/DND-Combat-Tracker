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

    DamageGUI(InitiativeTracker initiativeTracker) {
        JFrame damageGUI = new JFrame("Taking Damage");
        damageGUI.add(panel1);
        DefaultListModel characterList = new DefaultListModel<String>();
        for(int i = 0; i < initiativeTracker.getEntityListSize(); i++) {
            characterList.add(i, initiativeTracker.getPlayerCharacter(i).getName());
        }
        list1.setModel(characterList);
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
                damageTaken = Integer.parseInt(damageField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                damageTaken = Integer.parseInt(damageField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                damageTaken = Integer.parseInt(damageField.getText());
            }
        });

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (damageTaken < 0) {
                    damageLabel.setText("Please enter a positive integer.");
                }
                else if ()
            }
        });
    }
}
