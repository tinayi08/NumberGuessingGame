public class GameLogic {

    int count = 0;

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void biggerOrSmaller(int randomNumber, int guess) {
        if (guess > randomNumber) {
            guessIsWrong("smaller.");
        } else
        guessIsWrong("bigger.");
    }

    private void guessIsWrong(String biggerOrSmaller) {
        System.out.println("Your guess is incorrect, my number is " + biggerOrSmaller + " Let's try again.");
    }

    public int numberOfGuesses() {
        count++;
        return this.count;

    }

}
