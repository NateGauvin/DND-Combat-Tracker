import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StatSheetChoice {
    private JPanel panel1;
    private JList list1;
    private JButton confirmButton;
    private JLabel choiceLabel;
    private String characterName;

    StatSheetChoice(InitiativeTracker initiativeTracker) {
        JFrame statGUI = new JFrame("Stat Choices");
        statGUI.add(panel1);
        DefaultListModel characterList = new DefaultListModel<String>();
        for(int i = 0; i < initiativeTracker.getEntityListSize(); i++) {
            characterList.add(i, initiativeTracker.getPlayerCharacter(i).getName());
        }
        list1.setModel(characterList);
        statGUI.setSize(300,300);
        statGUI.setVisible(true);
        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    characterName = (String) list1.getSelectedValue();
                }
            }
        });
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (characterName == null) {
                    choiceLabel.setText("Please select a character.");
                }
                else {
                    for (int i = 0; i < initiativeTracker.getEntityListSize(); i++) {
                        if (initiativeTracker.getPlayerCharacter(i).getName().equals(characterName)) {
                            initiativeTracker.getPlayerCharacter(i).generateSheet();
                        }
                    }
                    statGUI.setVisible(false);
                    statGUI.dispose();
                }
            }
        });
    }
}
