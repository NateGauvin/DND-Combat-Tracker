import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu {
    private JPanel panel1;
    private JButton addButton;
    private JButton createButton;
    private JButton startButton;

    public MainMenu(InitiativeTracker initiativeTracker) {
        JFrame mainMenu = new JFrame("Main Menu");
        mainMenu.add(panel1);
        mainMenu.setSize(400,600);
        mainMenu.setVisible(true);
        mainMenu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CharacterSelect characterSelect = new CharacterSelect(initiativeTracker);
            }
        });
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CharacterCreator characterCreator = new CharacterCreator(initiativeTracker);
            }
        });
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenu.setVisible(false);
                mainMenu.dispose();
                RollOrDMInitiative rollOrDMInitiative = new RollOrDMInitiative(initiativeTracker);
            }
        });
    }
}
