import java.util.Random;

public class NumberGenerator {

    public int getRandomNum() {
        return randomNum;
    }

    //static int randomNum;
    int randomNum;

    public int randomNumber() {
        Random random = new Random();
        randomNum = random.nextInt(101);
        System.out.println("random number inside numGenerator class is " + randomNum);
        return randomNum;
    }
}
