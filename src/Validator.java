import java.util.Scanner;

public class Validator {

    public int validRange(int guessedNumber) {
        Scanner scan = new Scanner(System.in);
        while (guessedNumber <= 0 || guessedNumber > 100) {
            System.out.println("Enter a valid number " +
                    "between 1 and 100");
            guessedNumber = scan.nextInt();
        }
        return guessedNumber;
    }
}
