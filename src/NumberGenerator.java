import java.util.Random;

public class NumberGenerator {


    int randomNum;
    int begRange = 0;
    int endRange = 100;

    public int getBegRange() {
        return begRange;
    }

    public int getEndRange() {
        return endRange;
    }

    public int getRandomNum() {
        return randomNum;
    }



    public int randomNumber() {
        Random random = new Random();
        randomNum = random.nextInt(getEndRange()+1);
        //System.out.println("random number inside numGenerator class is " + randomNum);
        return randomNum;
    }
}
