import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class CharacterSelect {
    private JList<String> list1;
    private JPanel mainContainer;
    private JTextArea characterStats;
    private JButton addButton;
    private JLabel characterSelected;
    private JSplitPane splitPane;
    private String characterName;

    CharacterSelect(InitiativeTracker initiativeTracker) {
        File characterFolder = new File("Characters");

        File[] listOfCharacters = characterFolder.listFiles();
        if (listOfCharacters.length == 0) {return;}
        DefaultListModel characterList = new DefaultListModel<>();
        for(int i = 0; i < listOfCharacters.length; i++) {
            characterList.add(i,listOfCharacters[i].getName());
        }

        list1.setModel(characterList);
        JFrame characterSelect = new JFrame("Choose a character");
        characterSelected.setText("No character selected.");
        characterSelect.add(mainContainer);
        splitPane.setDividerLocation(224);
        characterSelect.setSize(400,600);
        characterSelect.setVisible(true);

        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    characterName = (String) list1.getSelectedValue();
                    characterSelected.setText("Add " + characterName.substring(0, characterName.length()-4) + "?");
                    int tempStr, tempDex, tempCon, tempInt, tempWis, tempCha, tempHP, tempAC;
                    try {
                        Scanner fileReader = new Scanner(new File("Characters\\" + characterName));


                    fileReader.nextLine();
                    fileReader.next();
                    tempStr = fileReader.nextInt();
                    fileReader.next();
                    tempDex = fileReader.nextInt();
                    fileReader.next();
                    tempCon = fileReader.nextInt();
                    fileReader.next();
                    tempInt = fileReader.nextInt();
                    fileReader.next();
                    tempWis = fileReader.nextInt();
                    fileReader.next();
                    tempCha = fileReader.nextInt();
                    fileReader.next();
                    tempHP = fileReader.nextInt();
                    fileReader.next();
                    tempAC = fileReader.nextInt();
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                    characterStats.setText(characterName.substring(0, characterName.length()-4) + ": \n" +
                            "HP: " + tempHP + "\n" +
                            "AC: " + tempAC + "\n" +
                            "Strength: " + tempStr + "\n" +
                            "Dexterity: " + tempDex + "\n" +
                            "Constitution: " + tempCon + "\n" +
                            "Intelligence: " + tempInt + "\n" +
                            "Wisdom: " + tempWis + "\n" +
                            "Charisma: " + tempCha + "\n");
                    characterStats.repaint();
                    characterSelected.repaint();
                }
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(characterName == null) {
                    characterSelected.setText("Please select a character.");
                    characterSelected.repaint();
                }
                else {
                    initiativeTracker.addPlayerToInitiativeGUI(characterName.substring(0, characterName.length()-4));
                    characterSelect.setVisible(false);
                    characterSelect.dispose();

                }
            }
        });
    }

}
