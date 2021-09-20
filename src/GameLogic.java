public class GameLogic {


    public void biggerOrSmaller(int randomNumber, int guess) {
        System.out.println("guess inside biggerOrSmaller " + guess);
        if (guess > randomNumber) {
            guessIsWrong("smaller.");
        } else
        guessIsWrong("bigger.");

    }

    private void guessIsWrong(String biggerOrSmaller) {
        System.out.println("Your guess is incorrect, my number is " + biggerOrSmaller + " Let's try again.");
    }

}
