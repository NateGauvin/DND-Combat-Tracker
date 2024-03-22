import java.util.InputMismatchException;
import java.util.Scanner;

// test change

public class Main {
    public static void main(String[] args) {
        InitiativeTracker initiativeTracker = new InitiativeTracker();

        NegativeHPDialog negativeHPDialog = new NegativeHPDialog(initiativeTracker);

        Scanner inputScanner = new Scanner(System.in);
        while(!negativeHPDialog.areWeDoneHere()) {System.out.print("");}
        System.out.println("Welcome to the Initiative and Stat Tracker!");
        System.out.println();
        MainMenu mainMenu = new MainMenu(initiativeTracker);
        String answer;
        boolean dialogueFinished = false;
        while(!dialogueFinished) {
            System.out.println("How would you like to proceed?");
            System.out.println("> Add");
            System.out.println("> Create");
            System.out.println("> Start");
            try {
                System.out.println();
                answer = inputScanner.next();
                System.out.println();
                if (answer.equalsIgnoreCase("add")) {
                    System.out.println();
                    System.out.println("Would you like to add a party or a character?");
                    System.out.println();
                    answer = inputScanner.next();
                    System.out.println();
                    if (answer.equalsIgnoreCase("party")) {initiativeTracker.addPartyToInitiative(inputScanner);}
                    else if(answer.equalsIgnoreCase("character")) {initiativeTracker.addPlayerToInitiative(inputScanner);}
                    else {System.out.println("That is not an available option."); System.out.println();}
                } else if (answer.equalsIgnoreCase("create")) {
                    initiativeTracker.createEntity(inputScanner);
                } else if (answer.equalsIgnoreCase("start")) {
                    dialogueFinished = true;
                } else {
                    System.out.println("That is not an available option.");
                    System.out.println();
                }
            } catch(InputMismatchException e) {System.out.println("Please only enter one word as an answer."); System.out.println();}
        }
        System.out.flush();
        dialogueFinished = false;
        while(!dialogueFinished) {
            System.out.println("Please enter 'Combat' if you would like to begin combat.");
            System.out.println("Please enter 'End' if you would like to end the program.");
            System.out.println();
            try {
                answer = inputScanner.next();
                System.out.println();
                if (answer.equalsIgnoreCase("combat")) {
                    initiativeTracker.combatTracker(inputScanner);
                }

                else if (answer.equalsIgnoreCase("end")) {
                    dialogueFinished = true;
                } else {
                    System.out.println("That is not an option.");
                    System.out.println();
                }
            } catch(InputMismatchException e) {System.out.println("Please only enter one word as an answer."); System.out.println();}
        }

        System.out.flush();
        System.out.println();
        System.exit(0);
    }
}