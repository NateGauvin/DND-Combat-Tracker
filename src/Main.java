import java.util.InputMismatchException;
import java.util.Scanner;

// test change

public class Main {
    public static void main(String[] args) {
        InitiativeTracker initiativeTracker = new InitiativeTracker();
        NegativeHPDialog negativeHPDialog = new NegativeHPDialog(initiativeTracker);
    }
}