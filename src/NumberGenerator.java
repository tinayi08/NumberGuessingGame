import java.util.Random;

public class NumberGenerator {

    //static int randomNum;
    int randomNum;
    int begRange;
    int endRange;

    public int getRandomNum() {
        return randomNum;
    }



    public int randomNumber() {
        Random random = new Random();
        randomNum = random.nextInt(101);
        //System.out.println("random number inside numGenerator class is " + randomNum);
        return randomNum;
    }
}
