import java.util.Scanner;

public class Validator {


    public int validRange(int guessedNumber) {

        while (!(guessedNumber > 0) && !(guessedNumber < 100)) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter a valid number" +
                    "between 1 and 100");
            guessedNumber = scan.nextInt();
        }
        return guessedNumber;
    }
}
