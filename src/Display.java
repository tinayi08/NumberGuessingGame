import java.util.InputMismatchException;
import java.util.Scanner;

public class Display {

    private Validator validator;
    public NumberGenerator numGenerator;
    public GameLogic logic;
    private int guess;

    public Display() {
        validator = new Validator();
        numGenerator = new NumberGenerator();
        logic = new GameLogic();
    }

    public void run() {
        intro();
        numGenerator.randomNumber();
        enterAGuess();
        result();
    }

    public void intro() {
        System.out.println("Welcome to the random number game. " +
                "I have selected number between 1 and 100. " +
                "Let's see if you can guess it.");
    }

    public String introReturnStr() {
        String intro = "Welcome to the random number game. " +
                "I have selected number between 1 and 100. " +
                "Let's see if you can guess it.";
        return intro;
    }

    private void enterAGuess() {
        System.out.println("\nPlease enter your guess:");
        Scanner scan = new Scanner(System.in);
        boolean isValid = false;
        while (!isValid) {
            try {
                guess = scan.nextInt();
                this.guess = validator.validRange(guess);
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid entry:");
                scan.next();
            }
        }


    }

    public int enterAGuessForGUI(String guess) {
        int numGuessed = 0;
        boolean isValid = false;
        while (!isValid) {
            try {
                numGuessed = validator.validRange(numGuessed);
                numGuessed = Integer.parseInt(guess); // 0
                isValid = true;
            } catch (NumberFormatException n) {
                System.out.println("error");
                guess = "0";
            }
        }
        return numGuessed;

    }
    private void result() {
        while (guess != numGenerator.randomNum) {
            logic.biggerOrSmaller(numGenerator.randomNum, guess);
            enterAGuess();
            logic.numberOfGuesses();;

        }
        System.out.println("Congrats, you have guessed it correctly in " + logic.getCount() + " tries!");
    }

    public void result(int guess) {
        while (guess != numGenerator.randomNum) {
            logic.biggerOrSmaller(numGenerator.randomNum, guess);
            enterAGuess();
            logic.numberOfGuesses();;

        }
        System.out.println("Congrats, you have guessed it correctly in " + logic.getCount() + " tries!");
    }


}
