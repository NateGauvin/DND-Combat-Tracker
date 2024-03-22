import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CharacterCreator {
    private JTextField nameField;
    private JTextField hpField;
    private JTextField strField;
    private JTextField dexField;
    private JTextField conField;
    private JTextField intField;
    private JTextField wisField;
    private JTextField chaField;
    private JTextField initBonusField;
    private JLabel updateLabel;
    private JButton generateCharacter;
    private JPanel mainPanel;
    private JTextField acField;
    private String characterName;
    private int userAC = 0, userHP = 0, userStr = 0, userDex = 0, userCon = 0, userInt = 0, userWis = 0, userCha = 0, userInitBonus = 0;

    CharacterCreator(InitiativeTracker initiativeTracker) {
        JFrame characterCreator = new JFrame("Character Creator");
        characterCreator.add(mainPanel);
        characterCreator.setSize(400,600);
        characterCreator.setVisible(true);
        nameField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                characterName = nameField.getText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                characterName = nameField.getText();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                characterName = nameField.getText();
            }
        });
        acField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (acField.getText().matches("[0-9]+")) {
                    userAC = Integer.parseInt(acField.getText());
                    if (userAC < 1 || userAC > 20) {
                        userAC = 0;
                        updateLabel.setText("This value must be between 1-20.");
                    }
                }
                else {
                    userAC = 0;
                    updateLabel.setText("This value must be between 1-20.");
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (acField.getText().matches("[0-9]+")) {
                    userAC = Integer.parseInt(acField.getText());
                    if (userAC < 1 || userAC > 20) {
                        userAC = 0;
                        updateLabel.setText("This value must be between 1-20.");
                    }
                }
                else {
                    userAC = 0;
                    updateLabel.setText("This value must be between 1-20.");
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (acField.getText().matches("[0-9]+")) {
                    userAC = Integer.parseInt(acField.getText());
                    if (userAC < 1 || userAC > 20) {
                        userAC = 0;
                        updateLabel.setText("This value must be between 1-20.");
                    }
                }
                else {
                    userAC = 0;
                    updateLabel.setText("This value must be between 1-20.");
                }
            }
        });
        hpField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (hpField.getText().matches("[0-9]+")) {
                    userHP = Integer.parseInt(hpField.getText());
                }
                else {updateLabel.setText("This value must be an integer.");}
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (hpField.getText().matches("[0-9]+")) {
                    userHP = Integer.parseInt(hpField.getText());
                }
                else {updateLabel.setText("This value must be an integer.");}
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (hpField.getText().matches("[0-9]+")) {
                    userHP = Integer.parseInt(hpField.getText());
                }
                else {updateLabel.setText("This value must be an integer.");}
            }
        });
        strField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (strField.getText().matches("[0-9]+")) {
                    userStr = Integer.parseInt(strField.getText());
                    if (userStr < 1 || userStr > 20) {
                        userStr = 0;
                        updateLabel.setText("This value must be between 1-20.");
                    }
                }
                else {
                    userStr = 0;
                    updateLabel.setText("This value must be between 1-20.");
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (strField.getText().matches("[0-9]+")) {
                    userStr = Integer.parseInt(strField.getText());
                    if (userStr < 1 || userStr > 20) {
                        userStr = 0;
                        updateLabel.setText("This value must be between 1-20.");
                    }
                }
                else {
                    userStr = 0;
                    updateLabel.setText("This value must be between 1-20.");
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (strField.getText().matches("[0-9]+")) {
                    userStr = Integer.parseInt(strField.getText());
                    if (userStr < 1 || userStr > 20) {
                        userStr = 0;
                        updateLabel.setText("This value must be between 1-20.");
                    }
                }
                else {
                    userStr = 0;
                    updateLabel.setText("This value must be between 1-20.");
                }
            }
        });
        dexField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (dexField.getText().matches("[0-9]+")) {
                    userDex = Integer.parseInt(dexField.getText());
                    if (userDex < 1 || userDex > 20) {
                        userDex = 0;
                        updateLabel.setText("This value must be between 1-20.");
                    }
                }
                else {
                    userDex = 0;
                    updateLabel.setText("This value must be between 1-20.");
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (dexField.getText().matches("[0-9]+")) {
                    userDex = Integer.parseInt(dexField.getText());
                    if (userDex < 1 || userDex > 20) {
                        userDex = 0;
                        updateLabel.setText("This value must be between 1-20.");
                    }
                }
                else {
                    userDex = 0;
                    updateLabel.setText("This value must be between 1-20.");
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (dexField.getText().matches("[0-9]+")) {
                    userDex = Integer.parseInt(dexField.getText());
                    if (userDex < 1 || userDex > 20) {
                        userDex = 0;
                        updateLabel.setText("This value must be between 1-20.");
                    }
                }
                else {
                    userDex = 0;
                    updateLabel.setText("This value must be between 1-20.");
                }
            }
        });
        conField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (conField.getText().matches("[0-9]+")) {
                    userCon = Integer.parseInt(conField.getText());
                    if (userCon < 1 || userCon > 20) {
                        userCon = 0;
                        updateLabel.setText("This value must be between 1-20.");
                    }
                }
                else {
                    userCon = 0;
                    updateLabel.setText("This value must be between 1-20.");
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (conField.getText().matches("[0-9]+")) {
                    userCon = Integer.parseInt(conField.getText());
                    if (userCon < 1 || userCon > 20) {
                        userCon = 0;
                        updateLabel.setText("This value must be between 1-20.");
                    }
                }
                else {
                    userCon = 0;
                    updateLabel.setText("This value must be between 1-20.");
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (conField.getText().matches("[0-9]+")) {
                    userCon = Integer.parseInt(conField.getText());
                    if (userCon < 1 || userCon > 20) {
                        userCon = 0;
                        updateLabel.setText("This value must be between 1-20.");
                    }
                }
                else {
                    userCon = 0;
                    updateLabel.setText("This value must be between 1-20.");
                }
            }
        });
        intField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (intField.getText().matches("[0-9]+")) {
                    userInt = Integer.parseInt(intField.getText());
                    if (userInt < 1 || userInt > 20) {
                        userInt = 0;
                        updateLabel.setText("This value must be between 1-20.");
                    }
                }
                else {
                    userInt = 0;
                    updateLabel.setText("This value must be between 1-20.");
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (intField.getText().matches("[0-9]+")) {
                    userInt = Integer.parseInt(intField.getText());
                    if (userInt < 1 || userInt > 20) {
                        userInt = 0;
                        updateLabel.setText("This value must be between 1-20.");
                    }
                }
                else {
                    userInt = 0;
                    updateLabel.setText("This value must be between 1-20.");
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (intField.getText().matches("[0-9]+")) {
                    userInt = Integer.parseInt(intField.getText());
                    if (userInt < 1 || userInt > 20) {
                        userInt = 0;
                        updateLabel.setText("This value must be between 1-20.");
                    }
                }
                else {
                    userInt = 0;
                    updateLabel.setText("This value must be between 1-20.");
                }
            }
        });
        wisField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (wisField.getText().matches("[0-9]+")) {
                    userWis = Integer.parseInt(wisField.getText());
                    if (userWis < 1 || userWis > 20) {
                        userWis = 0;
                        updateLabel.setText("This value must be between 1-20.");
                    }
                }
                else {
                    userWis = 0;
                    updateLabel.setText("This value must be between 1-20.");
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (wisField.getText().matches("[0-9]+")) {
                    userWis = Integer.parseInt(wisField.getText());
                    if (userWis < 1 || userWis > 20) {
                        userWis = 0;
                        updateLabel.setText("This value must be between 1-20.");
                    }
                }
                else {
                    userWis = 0;
                    updateLabel.setText("This value must be between 1-20.");
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (wisField.getText().matches("[0-9]+")) {
                    userWis = Integer.parseInt(wisField.getText());
                    if (userWis < 1 || userWis > 20) {
                        userWis = 0;
                        updateLabel.setText("This value must be between 1-20.");
                    }
                }
                else {
                    userWis = 0;
                    updateLabel.setText("This value must be between 1-20.");
                }
            }
        });
        chaField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (chaField.getText().matches("[0-9]+")) {
                    userCha = Integer.parseInt(chaField.getText());
                    if (userCha < 1 || userCha > 20) {
                        userCha = 0;
                        updateLabel.setText("This value must be between 1-20.");
                    }
                }
                else {
                    userCha = 0;
                    updateLabel.setText("This value must be between 1-20.");
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (chaField.getText().matches("[0-9]+")) {
                    userCha = Integer.parseInt(chaField.getText());
                    if (userCha < 1 || userCha > 20) {
                        userCha = 0;
                        updateLabel.setText("This value must be between 1-20.");
                    }
                }
                else {
                    userCha = 0;
                    updateLabel.setText("This value must be between 1-20.");
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (chaField.getText().matches("[0-9]+")) {
                    userCha = Integer.parseInt(chaField.getText());
                    if (userCha < 1 || userCha > 20) {
                        userCha = 0;
                        updateLabel.setText("This value must be between 1-20.");
                    }
                }
                else {
                    userCha = 0;
                    updateLabel.setText("This value must be between 1-20.");
                }
            }
        });
        initBonusField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (initBonusField.getText().matches("[0-9]+")) {
                    userInitBonus = Integer.parseInt(initBonusField.getText());
                }
                else {updateLabel.setText("This value must be an integer.");}
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (initBonusField.getText().matches("[0-9]+")) {
                    userInitBonus = Integer.parseInt(initBonusField.getText());
                }
                else {updateLabel.setText("This value must be an integer.");}
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (initBonusField.getText().matches("[0-9]+")) {
                    userInitBonus = Integer.parseInt(initBonusField.getText());
                }
                else {updateLabel.setText("This value must be an integer.");}
            }
        });
        generateCharacter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (characterName == null || userHP == 0 || userStr == 0 || userDex == 0 || userCon == 0 || userInt == 0 || userWis == 0 || userCha == 0) {
                    updateLabel.setText("Please enter valid stats or name.");
                    System.out.println(userDex + " " + userHP + " " + characterName);
                }
                else{
                    PlayerCharacter newEntity = new PlayerCharacter(characterName, userStr, userDex, userCon, userInt, userWis, userCha, userHP, userAC);
                    newEntity.setExternalInitiativeBonus(userInitBonus);
                    newEntity.printCharacter();
                    newEntity = null;
                    BasicConfirmDialog basicConfirmDialog = new BasicConfirmDialog("Character " + characterName + " has been created.");
                    characterCreator.setVisible(false);
                    characterCreator.dispose();
                }
            }
        });

    }
}
