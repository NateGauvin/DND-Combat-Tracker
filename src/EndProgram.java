import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndProgram {
    private JPanel panel1;
    private JButton yesButton;
    private JButton noButton;

    EndProgram() {
        JFrame endProgram = new JFrame("End Program?");
        endProgram.add(panel1);
        endProgram.setSize(300,200);
        endProgram.setVisible(true);
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                endProgram.setVisible(false);
                endProgram.dispose();
            }
        });
    }
}
