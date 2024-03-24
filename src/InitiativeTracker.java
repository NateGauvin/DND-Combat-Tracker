import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;
import java.util.Collections;



public class InitiativeTracker {
    private boolean negativeDamage;

    public void setNegativeDamage(boolean bool) {
        this.negativeDamage = bool;
    }
    public boolean getNegativeDamage() {return negativeDamage;}
    private final ArrayList<PlayerCharacter> entityList = new ArrayList<>();
    public void createEntity(Scanner userInput) {
        System.out.println("This is to create an entity that is not recorded in the system.");
        System.out.println();
        try {
            System.out.println("What is the name of this entity? Please keep your entry to one word.");
            System.out.println();
            String tempName = userInput.next();
            System.out.println();
            System.out.println("For stat entries, please only enter integer values.");
            System.out.println();
            System.out.println("What is the strength of this entity?");
            System.out.println();
            int tempStr = userInput.nextInt();
            System.out.println();
            System.out.println("What is the dexterity of this entity?");
            System.out.println();
            int tempDex = userInput.nextInt();
            System.out.println();
            System.out.println("What is the constitution of this entity?");
            System.out.println();
            int tempCon = userInput.nextInt();
            System.out.println();
            System.out.println("What is the intelligence of this entity?");
            System.out.println();
            int tempInt = userInput.nextInt();
            System.out.println();
            System.out.println("What is the wisdom of this entity?");
            System.out.println();
            int tempWis = userInput.nextInt();
            System.out.println();
            System.out.println("What is the charisma of this entity?");
            System.out.println();
            int tempCha = userInput.nextInt();
            System.out.println();
            System.out.println("What is the max HP of this entity?");
            System.out.println();
            int tempHP = userInput.nextInt();
            System.out.println();
            System.out.println("What is the armor class of this entity?");
            System.out.println();
            int tempAC = userInput.nextInt();
            System.out.println("Please enter this entity's initiative bonus, if it has any. Most will not.");
            System.out.println();
            int tempInit = userInput.nextInt();
            System.out.println();
            PlayerCharacter newEntity =  new PlayerCharacter(tempName, tempStr, tempDex, tempCon, tempInt, tempWis, tempCha, tempHP, tempAC);
            newEntity.setExternalInitiativeBonus(tempInit);
            entityList.add(newEntity);
            System.out.println("The entity has been created and added to the initiative list. Would you like to record this character? Yes or no.");
            String answer = userInput.next();
            if(answer.equalsIgnoreCase("yes")) {
                newEntity.printCharacter();
                System.out.println();
                System.out.println("The character has been recorded.");
            }
            else {System.out.println(); System.out.println("The character has not been recorded, and will be deleted upon program end.");}
        } catch(InputMismatchException e) {
            System.out.println();
            System.out.println("You have entered an invalid value and will be returned to the main menu.");
        }
    }
    public void addPartyToInitiative(Scanner userInput) {
        boolean foundParty = false;
        Scanner fileReader = null;
        String tempPartyName = null;
        String tempName = null;
        int partySize = 0;

        while (!foundParty) {
            System.out.println("Which recorded party would you like to add to initiative?");
            System.out.println("This is case-sensitive.");
            try {
                System.out.println();
                tempPartyName = userInput.next();
                System.out.println();
            } catch(InputMismatchException e) {System.out.println(); System.out.println("Please only enter one word as an answer.");}
            try {
                fileReader = new Scanner(new File("Parties\\" + tempPartyName + ".txt"));
                foundParty = true;
            } catch (Exception e) {
                System.out.println();
                System.out.println("Could not find party file.");
                return;
            }
        }
        try{
            fileReader.next();
            partySize = fileReader.nextInt();
        } catch (InputMismatchException e) {System.out.println("There is an error with the party size."); fileReader.close(); return;}
        for(int i = 0; i < partySize; i++) {
            fileReader.nextLine();
            int tempStr, tempDex, tempCon, tempInt, tempWis, tempCha, tempHP, tempAC;
            try {
                fileReader.next();
                tempName = fileReader.next();
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
                boolean placed = false;
                int counter = 1;
                int checkSum = 0;
                String searchName = tempName;
                while(!placed) {
                    checkSum++;
                    for(PlayerCharacter playerCharacter : entityList) {
                        if(playerCharacter.getName().equals(searchName)) {
                            counter++;
                            searchName = tempName + "_" + Integer.toString(counter);
                        }
                    }
                    if(checkSum == counter) {placed = true;}
                }
                if(counter != 1) {tempName = tempName + "_" + Integer.toString(counter);}
                PlayerCharacter playerCharacter = new PlayerCharacter
                        (tempName,
                                tempStr,
                                tempDex,
                                tempCon,
                                tempInt,
                                tempWis,
                                tempCha,
                                tempHP,
                                tempAC);
                fileReader.next();
                playerCharacter.setExternalInitiativeBonus(fileReader.nextInt());
                entityList.add(playerCharacter);
                System.out.println("Player " + tempName + " added.");
                System.out.println();
            } catch(Exception e) {
                System.out.println();
                System.out.println("Error when reading file, player not recorded.");
            }
        }
        System.out.println("Party " + tempPartyName + " added.");
        System.out.println();
        fileReader.close();
    }
    public void addPlayerToInitiative(Scanner userInput) {
        boolean foundPlayer = false;
        Scanner fileReader = null;
        String tempName = null;

        while (!foundPlayer) {
            System.out.println("Which recorded player would you like to add to initiative?");
            System.out.println("This is case-sensitive.");
            try {
                System.out.println();
                tempName = userInput.next();
                System.out.println();
            } catch(InputMismatchException e) {System.out.println(); System.out.println("Please only enter one word as an answer.");}
            try {
                fileReader = new Scanner(new File("Characters\\" + tempName + ".txt"));
                foundPlayer = true;
            } catch (Exception e) {
                System.out.println();
                System.out.println("Could not find player file.");
                return;
            }
        }
        int tempStr, tempDex, tempCon, tempInt, tempWis, tempCha, tempHP, tempAC;
        try {
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
            boolean placed = false;
            int counter = 1;
            int checkSum = 0;
            String searchName = tempName;
            while(!placed) {
                checkSum++;
                for(PlayerCharacter playerCharacter : entityList) {
                    if(playerCharacter.getName().equals(searchName)) {
                        counter++;
                        searchName = tempName + "_" + Integer.toString(counter);
                    }
                }
                if(checkSum == counter) {placed = true;}
            }
            if(counter != 1) {tempName = tempName + "_" + Integer.toString(counter);}
            PlayerCharacter playerCharacter = new PlayerCharacter
                    (tempName,
                            tempStr,
                            tempDex,
                            tempCon,
                            tempInt,
                            tempWis,
                            tempCha,
                            tempHP,
                            tempAC);
            fileReader.next();
            playerCharacter.setExternalInitiativeBonus(fileReader.nextInt());
            entityList.add(playerCharacter);
            System.out.println("Player " + tempName + " added.");
            System.out.println();
        } catch(Exception e) {
            System.out.println();
            System.out.println("Error when reading file, player not recorded.");
        }finally {fileReader.close();}
    }
    public void sortInitiative() {
        Collections.sort(entityList, Collections.reverseOrder());
    }
    public void addPlayerToInitiativeGUI(String characterName) {
        boolean foundPlayer = false;
        Scanner fileReader = null;
        String tempName = null;

        while (!foundPlayer) {
                tempName = characterName;
            try {
                fileReader = new Scanner(new File("Characters\\" + tempName + ".txt"));
                foundPlayer = true;
            } catch (Exception e) {
                System.out.println();
                System.out.println("Could not find player file.");
                return;
            }
        }
        int tempStr, tempDex, tempCon, tempInt, tempWis, tempCha, tempHP, tempAC;
        try {
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
            boolean placed = false;
            int counter = 1;
            int checkSum = 0;
            String searchName = tempName;
            while(!placed) {
                checkSum++;
                for(PlayerCharacter playerCharacter : entityList) {
                    if(playerCharacter.getName().equals(searchName)) {
                        counter++;
                        searchName = tempName + "_" + Integer.toString(counter);
                    }
                }
                if(checkSum == counter) {placed = true;}
            }
            if(counter != 1) {tempName = tempName + "_" + Integer.toString(counter);}
            PlayerCharacter playerCharacter = new PlayerCharacter
                    (tempName,
                            tempStr,
                            tempDex,
                            tempCon,
                            tempInt,
                            tempWis,
                            tempCha,
                            tempHP,
                            tempAC);
            fileReader.next();
            playerCharacter.setExternalInitiativeBonus(fileReader.nextInt());
            entityList.add(playerCharacter);
        } catch(Exception e) {
            System.out.println();
            System.out.println("Error when reading file, player not recorded.");
        }finally {fileReader.close();}
    }
    public void rollForInitiativeProgram() {
        for (PlayerCharacter playerCharacter : entityList) {
            playerCharacter.calculateInitiative();
        }
        Collections.sort(entityList, Collections.reverseOrder());
    }
    public void rollForInitiativePlayers(Scanner userInput) {
        int tempInit = 0;
        for(PlayerCharacter playerCharacter : entityList) {
            boolean correctInput = false;
            while(!correctInput) {
                System.out.println("What did " + playerCharacter.getName() + " roll? Please enter an integer value.");
                System.out.println();
                try {
                    tempInit = userInput.nextInt();
                    correctInput = true;
                } catch (InputMismatchException e) {
                    System.out.println();
                    System.out.println("Please enter an integer value.");
                }
                System.out.println();
            }
            playerCharacter.setInitiativeValue(tempInit);
        }
        Collections.sort(entityList, Collections.reverseOrder());
    }
    public PlayerCharacter getPlayerCharacter(int i) {
        return entityList.get(i);
    }
    public int getEntityListSize() {
        return entityList.size();
    }
    private PlayerCharacter findCharacter(String queryName) {
        for(PlayerCharacter playerCharacter : entityList) {
            if(playerCharacter.getName().equalsIgnoreCase(queryName)) {return playerCharacter;}
        }
        return null;
    }
    public void combatTracker(Scanner userInput) {
        String answer;
        boolean dialogueFinished = false;
        System.out.println("Now it's time to roll for initiative! You can either ask your players for rolls, or roll it yourself.");
        while(!dialogueFinished) {
            System.out.println("> Players");
            System.out.println("> DM");
            System.out.println();
            try {
                answer = userInput.next();
                System.out.println();
                if (answer.equalsIgnoreCase("players")) {
                    rollForInitiativePlayers(userInput);
                    dialogueFinished = true;
                } else if (answer.equalsIgnoreCase("dm")) {
                    rollForInitiativeProgram();
                    dialogueFinished = true;
                } else {
                    System.out.println("That is not an available option");
                }
            } catch(InputMismatchException e) {System.out.println("Please only enter one word as an answer.");}
        }

        boolean battleComplete = false;
        boolean decisionMade = false;
        int turnValue = 0;
        PlayerCharacter currentTurn;
        while(!battleComplete) {
            decisionMade = false;
            for(int i = 0; i < entityList.size(); i++) {
                if(turnValue == i) {
                    System.out.println(" >\t" + entityList.get(i).getName() + "\t Max: " +
                            entityList.get(i).getMaxHitPoints() + "\t HP: " +
                            entityList.get(i).getCurrHitPoints() + "\t AC: " +
                            entityList.get(i).getArmorClass()
                    );
                    currentTurn = entityList.get(i);
                }
                else {System.out.println(">\t" + entityList.get(i).getName() + "\t Max: " +
                        entityList.get(i).getMaxHitPoints() + "\t HP: " +
                        entityList.get(i).getCurrHitPoints() + "\t AC: " +
                        entityList.get(i).getArmorClass());}
            }
            while(!decisionMade) {
                System.out.println();
                System.out.println("What happens this turn?");
                System.out.println("> Damage");
                System.out.println("> Healing");
                System.out.println("> Add");
                System.out.println("> Remove");
                System.out.println("> Stats");
                System.out.println("> Next");
                System.out.println("> End");
                System.out.println();
                try {
                    answer = userInput.next();
                    System.out.println();
                    if (answer.equalsIgnoreCase("damage")) {
                        System.out.println("Who took damage?");
                        System.out.println();
                        answer = userInput.next();
                        System.out.println();
                        PlayerCharacter damageRecipient = findCharacter(answer);
                        int damageTaken;
                        if (damageRecipient == null) {
                            System.out.println("This character does not exist.");
                        } else {
                            System.out.println("How much damage did " + damageRecipient.getName() + " take?");
                            System.out.println();
                            damageTaken = userInput.nextInt();
                            damageRecipient.takingDamage(damageTaken, negativeDamage);
                        }
                        System.out.println();
                    }
                    else if (answer.equalsIgnoreCase("healing")) {
                        int healingAmt;
                        System.out.println("Who was healed?");
                        System.out.println();
                        answer = userInput.next();
                        System.out.println();
                        PlayerCharacter healingRecipient;
                        healingRecipient = findCharacter(answer);
                        if (healingRecipient == null) {
                            System.out.println("This character does not exist.");
                        } else {
                            System.out.println("How much was " + healingRecipient.getName() + " healed for?");
                            System.out.println();
                            healingAmt = userInput.nextInt();
                            healingRecipient.healing(healingAmt);
                        }
                        System.out.println();
                    }
                    else if (answer.equalsIgnoreCase("add")) {
                        int size = entityList.size();
                        addPlayerToInitiative(userInput);
                        int tempInit;
                        System.out.println("If the player is rolling for initiative, please enter their roll.");
                        System.out.println("If they are not, enter 0.");
                        System.out.println();
                        tempInit = userInput.nextInt();
                        if (tempInit == 0) {
                            for (PlayerCharacter playerCharacter : entityList) {
                                if (playerCharacter.getInitiativeValue() == 0) {
                                    playerCharacter.calculateInitiative();
                                }
                            }
                        } else {
                            for (PlayerCharacter playerCharacter : entityList) {
                                if (playerCharacter.getInitiativeValue() == 0) {
                                    playerCharacter.setInitiativeValue(tempInit);
                                }
                            }
                        }
                        System.out.println();
                        if (entityList.size() != size) {
                            Collections.sort(entityList);
                            System.out.println("Character added, initiative sorted.");
                        } else {
                            System.out.println("No character added.");
                        }
                        System.out.println();
                    }
                    else if (answer.equalsIgnoreCase("remove")) {
                        System.out.println("Who would you like to remove? Please be case-sensitive.");
                        System.out.println();
                        answer = userInput.next();
                        System.out.println();
                        int size = entityList.size();
                        for (int i = 0; i < entityList.size(); i++) {
                            if (entityList.get(i).getName().equals(answer)) {
                                entityList.remove(i);
                                System.out.println(answer + " removed.");
                            }
                        }
                        if(size == entityList.size()) {System.out.println("Character does not exist.");}
                        System.out.println();
                    }
                    else if (answer.equalsIgnoreCase("stats")) {
                        System.out.println("Whose stats would you like to view? Please be case-sensitive.");
                        System.out.println();
                        answer = userInput.next();
                        System.out.println();
                        boolean playerStatsFound = false;
                        for (int i = 0; i < entityList.size(); i++) {
                            if (entityList.get(i).getName().equals(answer)) {
                                entityList.get(i).generateSheet();
                                playerStatsFound = true;
                            }
                        }
                        if (!playerStatsFound) {System.out.println("Character does not exist."); System.out.println();}
                    }
                    else if (answer.equalsIgnoreCase("next")) {decisionMade = true; System.out.println();}
                    else if (answer.equalsIgnoreCase("end")) {
                        decisionMade = true;
                        battleComplete = true;
                        System.out.println();
                    }
                    else {
                        System.out.println("That is not an option.");
                        System.out.println();
                    }
                } catch(InputMismatchException e) {System.out.println("Please only enter one word as an answer.");
                    userInput.next();
                    System.out.println();
                }
            }
            turnValue++;
            if(turnValue == entityList.size()) {turnValue = 0;}
        }
        for(PlayerCharacter playerCharacter : entityList) {playerCharacter.setInitiativeValue(0);}
    }
}
