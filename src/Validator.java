import java.util.Scanner;

public class Validator {

    public int validRange(int guessedNumber, int beginNum, int endNum) {
        Scanner scan = new Scanner(System.in);
        while (guessedNumber <= 0 || guessedNumber > 100) {
            System.out.println("Enter a valid number " +
                    "between " + beginNum + " and " + endNum + ".");
            guessedNumber = scan.nextInt();
        }
        return guessedNumber;
    }

    public int validRangeGUI(String guess, int beginNum, int endNum) {
        int guessedNumber = Integer.parseInt(guess);
        while (guessedNumber <= 0 || guessedNumber > 100) {
            System.out.println("Enter a valid number " +
                    "between " + beginNum + " and " + endNum + ".");
            guessedNumber = Integer.parseInt(guess);;
        }
        return guessedNumber;
    }
}
