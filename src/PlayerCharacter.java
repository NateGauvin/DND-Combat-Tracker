import java.io.IOException;
import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import javax.swing.*;

public class PlayerCharacter implements Comparable<PlayerCharacter> {
    private int strength, dexterity, constitution, intelligence, wisdom, charisma, maxHitPoints, currHitPoints, initiativeValue, armorClass;
    private String name;
    private int externalInitiativeBonus;
    private final Random rand = new Random();

    PlayerCharacter() {}

    PlayerCharacter(String inputName, int inputStrength, int inputDexterity, int inputConstitution, int inputIntelligence, int inputWisdom, int inputCharisma, int inputHitPoints, int inputArmorClass) {
        this.name = inputName;
        this.strength = inputStrength;
        this.dexterity = inputDexterity;
        this.constitution = inputConstitution;
        this.intelligence = inputIntelligence;
        this.wisdom = inputWisdom;
        this.charisma = inputCharisma;
        this.maxHitPoints = inputHitPoints;
        this.currHitPoints = inputHitPoints;
        this.armorClass = inputArmorClass;
        externalInitiativeBonus = 0;
        initiativeValue = 0;
    }

    public void takingDamage(int damageTaken, boolean negativeDamage) {
        currHitPoints = currHitPoints - damageTaken;
        if(currHitPoints <=0 && !negativeDamage) {currHitPoints = 0;}
        System.out.println(name + " has " + currHitPoints + " hp left.");
        if(currHitPoints <= 0) {System.out.println(); System.out.println(name + " is down!");}
    }

    public void healing(int healingAmt) {
        currHitPoints = currHitPoints + healingAmt;
        if (currHitPoints >= maxHitPoints) {currHitPoints = maxHitPoints;}
        System.out.println(name + " has " + currHitPoints + " hp.");
    }

    public void calculateInitiative() {
        this.initiativeValue = rand.nextInt(19) + 1 + (dexterity - 10) / 2 + externalInitiativeBonus;
    }

    @Override
    public int compareTo(PlayerCharacter otherEntity) {
        if(this.initiativeValue > otherEntity.initiativeValue) {return 1;}
        else if(this.initiativeValue == otherEntity.initiativeValue) {
            if(this.dexterity > otherEntity.dexterity) {return 1;}
            else if(this.dexterity == otherEntity.dexterity) {
                int temp = rand.nextInt(2);
                if(temp == 0) {return 1;}
                else {return -1;}
            }
        }
        return -1;
    }

    public void printCharacter() {
        FileWriter printer = null;
        File file = null;
        try {
            file = new File("Characters\\" + name + ".txt");
            if(!file.exists()) {file.createNewFile();}
            printer = new FileWriter(file);
            printer.write("Name: " + name + "\n");
            printer.write("STR: " + strength + "\n");
            printer.write("DEX: " + dexterity + "\n");
            printer.write("CON: " + constitution + "\n");
            printer.write("INT: " + intelligence + "\n");
            printer.write("WIS: " + wisdom + "\n");
            printer.write("CHA: " + charisma + "\n");
            printer.write("HP: " + maxHitPoints + "\n");
            printer.write("AC: " + armorClass + "\n");
            printer.write("External_Initiative_Bonus: " + externalInitiativeBonus + "\n");
            printer.flush();
            printer.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void generateSheet() {
        StatSheet characterSheet = new StatSheet(this);
    }

    public String getName() {
        return name;
    }

    public void setExternalInitiativeBonus(int inputInitiativeBonus) {
        this.externalInitiativeBonus = inputInitiativeBonus;
    }

    public void setInitiativeValue(int inputInit) {
        this.initiativeValue = inputInit;
    }

    public int getInitiativeValue() {
        return initiativeValue;
    }

    public int getCurrHitPoints() {
        return currHitPoints;
    }

    public int getMaxHitPoints() {return maxHitPoints;}

    public int getArmorClass() {
        return armorClass;
    }

    public int getStrength() {return strength;}

    public int getConstitution() {return constitution;}

    public int getDexterity() {return dexterity;}

    public int getIntelligence() {return intelligence;    }

    public int getWisdom() {return wisdom;}

    public int getCharisma() {return charisma;}

    public int calculateModifier(int stat) {
        if (stat >= 10) {
            return (stat-10) / 2;
        }
        return switch (stat) {
            case 9, 8 -> -1;
            case 7, 6 -> -2;
            case 5, 4 -> -3;
            case 3, 2 -> -4;
            default -> -1;
        };
    }
}
