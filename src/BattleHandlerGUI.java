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
    private JButton endButton;
    private JButton statsButton;
    private JButton refreshButton;
    private int turnValue = 0;
    private PlayerCharacter currentTurn;
    BattleHandlerGUI(InitiativeTracker initiativeTracker) {
        JFrame battleHandlerGUI = new JFrame("Combat");
        battleHandlerGUI.add(panel1);
        battleHandlerGUI.setSize(600,600);
        battleHandlerGUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
        battleHandlerGUI.setVisible(true);
        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DiceRoller diceRoller = new DiceRoller();
            }
        });
        healingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HealingGUI healingGUI = new HealingGUI(initiativeTracker);
            }
        });
        damageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DamageGUI damageGUI = new DamageGUI(initiativeTracker);
            }
        });
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initiativeList.setText(null);
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
            }
        });
        statsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StatSheetChoice statSheetChoice = new StatSheetChoice(initiativeTracker);
            }
        });
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turnValue++;
                if(turnValue == initiativeTracker.getEntityListSize()) {turnValue = 0;}
                initiativeList.setText(null);
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
            }
        });
        endButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EndProgram endProgram = new EndProgram();
            }
        });
    }
}
