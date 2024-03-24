import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NegativeHPDialog {
    private JButton no;
    private JButton yes;
    private JPanel panel;
    private boolean done = false;

    NegativeHPDialog(InitiativeTracker initiativeTracker) {
        JFrame dialog = new JFrame("Negative HP");
        dialog.add(panel);
        dialog.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        dialog.setSize(500,400);
        dialog.setVisible(true);
        no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initiativeTracker.setNegativeDamage(false);
                dialog.setVisible(false);
                dialog.dispose();
                MainMenu mainMenu = new MainMenu(initiativeTracker);
            }
        });
        yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initiativeTracker.setNegativeDamage(true);
                dialog.setVisible(false);
                dialog.dispose();
                MainMenu mainMenu = new MainMenu(initiativeTracker);
            }
        });
    }
}
