import java.util.Scanner;

public class Display {

    Validator validator;
    NumberGenerator numGenerator;
    GameLogic logic;
    int guess;

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

    public void enterAGuess() {
        System.out.println("Please enter your guess:");
        Scanner scan = new Scanner(System.in);
        guess = scan.nextInt();
        this.guess = validator.validRange(guess);

    }

    public void result() {
        while (guess != numGenerator.randomNum) {
            logic.biggerOrSmaller(numGenerator.randomNum, guess);
            enterAGuess();
        }
        System.out.println("Congrats, you have guessed correctly!");
    }


}
