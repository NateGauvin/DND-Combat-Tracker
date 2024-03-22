import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RollOrDMInitiative {
    private JPanel panel1;
    private JButton yesButton;
    private JButton noButton;

    RollOrDMInitiative(InitiativeTracker initiativeTracker) {
        JFrame rollOrDMInitiative = new JFrame("Initiative");
        rollOrDMInitiative.add(panel1);
        rollOrDMInitiative.setSize(300,200);
        rollOrDMInitiative.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        rollOrDMInitiative.setVisible(true);
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rollOrDMInitiative.setVisible(false);
                rollOrDMInitiative.dispose();
                int counter = 0;
                InitiativeCollector initiativeCollector = new InitiativeCollector(initiativeTracker, counter);
            }
        });

        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rollOrDMInitiative.setVisible(false);
                rollOrDMInitiative.dispose();
                initiativeTracker.rollForInitiativeProgram();
                BattleHandlerGUI battleHandlerGUI = new BattleHandlerGUI(initiativeTracker);
            }
        });
    }
}
