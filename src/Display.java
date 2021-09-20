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
        this.guess = scan.nextInt();
        System.out.println("random number in enterAGuess " + numGenerator.randomNum);
//        System.out.println("Random number 2 " + numGenerator.randomNumber());
        //int guess = validator.validRange();
        //return guess;
    }

    public void result() {
        System.out.println("1");
        while (guess != numGenerator.randomNum) {
            System.out.println("2");
            logic.biggerOrSmaller(numGenerator.randomNum, guess);
            System.out.println("3");
            enterAGuess();
            System.out.println("4");
        }
        System.out.println("Congrats, you have guessed correctly!");

    }


}
