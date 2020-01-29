import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static String[] options = {"paper", "rock", "scissors"};
    public static String playerChoice = "";
    public static boolean isValid = false;
    public static boolean replay = true;

    public static void main(String[] args) {
        // Main game loop
        while (replay) {
            String validatedChoice = userInput();
            String computerChoice = computerInput();
            result(validatedChoice, computerChoice);
            wantReplay();
        }
    }


    public static String userInput() {
        Scanner userInputScanner = new Scanner(System.in);
        System.out.println("Welcome to the Rock Paper Scissors game!\nWhat is your name? ");
        String name = userInputScanner.nextLine();
        System.out.println("Hi " + name + "!");

        // Validate user input
        while (true) {
            System.out.println("Pick your choice!");
            playerChoice = userInputScanner.nextLine().toLowerCase();
            for (String s : options) {
                if (!s.equals(playerChoice)) {
                    continue;
                } else {
                    isValid = true;
                }
            }
            if (isValid) {
                return playerChoice;
            } else {
                System.out.println("This is not a valid choice!");
                isValid = false;
            }
        }
    }


    public static String computerInput() {
        return options[new Random().nextInt(options.length)];
    }

    public static void result(String validatedChoice, String computerInput) {
        if (validatedChoice.equals(computerInput)) {
            System.out.println("It's a draw! Try again");
        } else if (validatedChoice.equals("rock") && computerInput.equals("paper")) {
            System.out.println("You lost!");
        } else if (validatedChoice.equals("paper") && computerInput.equals("scissors")) {
            System.out.println("You lost!");
        } else if (validatedChoice.equals("scissors") && computerInput.equals("rock")) {
            System.out.println("You lost!");
        } else {
            System.out.println("You won!");
        }
    }

    public static void wantReplay() {
        Scanner userInputScanner = new Scanner(System.in);
        System.out.println("Do you want to play again? Yes or No");
        String playerDecision = userInputScanner.nextLine().toLowerCase();
        if (playerDecision.equals("no")) {
            System.out.println("Thank you for playing with me.");
            replay = false;
        } else if (playerDecision.equals("yes")) {
            replay = true;
        } else {
            System.out.println("I don't understand your response, goodbye.");
            replay = false;
        }
    }
}
