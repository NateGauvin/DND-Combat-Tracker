import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BasicConfirmDialog {
    private JPanel panel1;
    private JButton closeButton;
    private JLabel displayText;

    BasicConfirmDialog(String message) {
        JFrame basicConfirmDialog = new JFrame("Confirmed");
        basicConfirmDialog.add(panel1);
        displayText.setText(message);
        basicConfirmDialog.setSize(300,200);
        basicConfirmDialog.setVisible(true);

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                basicConfirmDialog.setVisible(false);
                basicConfirmDialog.dispose();
            }
        });
    }
}
