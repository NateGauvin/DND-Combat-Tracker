import javax.swing.*;

public class StatSheet {
    private JPanel sheet;
    private JLabel characterName;
    private JTextPane characterStr;
    private JTextPane characterCon;
    private JTextPane characterDex;
    private JTextPane characterInt;
    private JTextPane characterWis;
    private JTextPane characterCha;

    StatSheet(PlayerCharacter playerCharacter) {
        JFrame statSheet = new JFrame(playerCharacter.getName() + "'s Stats");
        characterName.setText(playerCharacter.getName());
        characterStr.setText("Strength: " + playerCharacter.getStrength() + " | " + playerCharacter.calculateModifier(playerCharacter.getStrength()));
        characterCon.setText("Constitution: " + playerCharacter.getConstitution() + " | " + playerCharacter.calculateModifier(playerCharacter.getConstitution()));
        characterDex.setText("Dexterity: " + playerCharacter.getDexterity() + " | " + playerCharacter.calculateModifier(playerCharacter.getDexterity()));
        characterInt.setText("Intelligence: " + playerCharacter.getIntelligence() + " | " + playerCharacter.calculateModifier(playerCharacter.getIntelligence()));
        characterWis.setText("Wisdom: " + playerCharacter.getWisdom() + " | " + playerCharacter.calculateModifier(playerCharacter.getWisdom()));
        characterCha.setText("Charisma: " + playerCharacter.getCharisma() + " | " + playerCharacter.calculateModifier(playerCharacter.getCharisma()));
        statSheet.add(sheet);
        statSheet.setSize(400,600);
        statSheet.setVisible(true);
    }
}
