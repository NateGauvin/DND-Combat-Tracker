import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BattleHandlerGUI {
    private JPanel panel1;
    private JButton rollButton;
    private JButton damageButton;
    private JButton healingButton;
    private JButton nextButton;
    private JTextArea initiativeList;
    private JTextArea combatLog;
    private JButton endButton;
    private JSplitPane splitPane;
    private int turnValue = 0;
    private PlayerCharacter currentTurn;

    BattleHandlerGUI(InitiativeTracker initiativeTracker) {
        JFrame battleHandlerGUI = new JFrame("Combat");
        battleHandlerGUI.setSize(400,600);
        splitPane.setDividerLocation(224);
        battleHandlerGUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        battleHandlerGUI.setVisible(true);
        for(int i = 0; i < initiativeTracker.getEntityListSize(); i++) {
            if(turnValue == i) {
                initiativeList.append(" >\t" + initiativeTracker.getPlayerCharacter(i).getName() + "\t Max: " +
                        initiativeTracker.getPlayerCharacter(i).getMaxHitPoints() + "\t HP: " +
                        initiativeTracker.getPlayerCharacter(i).getCurrHitPoints() + "\t AC: " +
                        initiativeTracker.getPlayerCharacter(i).getArmorClass() + "\n");
                currentTurn = initiativeTracker.getPlayerCharacter(i);
            }
            else {initiativeList.append(">\t" + initiativeTracker.getPlayerCharacter(i).getName() + "\t Max: " +
                    initiativeTracker.getPlayerCharacter(i).getMaxHitPoints() + "\t HP: " +
                    initiativeTracker.getPlayerCharacter(i).getCurrHitPoints() + "\t AC: " +
                    initiativeTracker.getPlayerCharacter(i).getArmorClass() + "\n");}
        }


        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DiceRoller diceRoller = new DiceRoller();
            }
        });
    }
}
