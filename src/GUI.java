import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//TODO - add button for start over, quit, hint

public class GUI implements ActionListener {
    //when to do static vs non static
    private static JFrame frame;
    private static JPanel panel;
    private Display display;
    private static JButton guessButton;
    private static JButton playAgain;
    private static JButton quit;
    private static JLabel numOfGuessesLabel;
    private JTextField guessField;
    private static JTextArea resultText = new JTextArea("");
    private int numGuessed;

    public GUI() {
        display = new Display();
    }

    public static void main(String[] args) {
        GUI start = new GUI();

        frame = new JFrame();
        frame.setSize(400, 500);
        panel = new JPanel();
        frame.add(panel);

        panel.setLayout(null);

        frame.setTitle("Number Guessing Game");
        start.display.numGenerator.randomNumber();
        start.intro();
        start.enterAGuess();
        start.numOfGuesses();
        start.playAgain();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); // should be at the end

    }

    private void intro() {

        JTextArea introText = new JTextArea();
        introText.setText(display.introReturnStr());
        introText.setWrapStyleWord(true);
        introText.setLineWrap(true);
        introText.setOpaque(false);
        introText.setEditable(false);
        introText.setFocusable(false);
        introText.setBounds(75, 50, 250,100);
        panel.add(introText);

    }

    private void enterAGuess() {

        JTextArea promptText = new JTextArea();
        promptText.setText("Please enter a guess:");
        promptText.setWrapStyleWord(true);
        promptText.setLineWrap(true);
        promptText.setOpaque(false);
        promptText.setEditable(false);
        promptText.setFocusable(false);
        promptText.setBounds(75, 150, 150,25);
        panel.add(promptText);

        guessButton = new JButton("Guess");
        guessField = new JTextField();
        guessField.setBounds(205, 145, 100, 25);
        guessButton.setBounds(145,185, 100, 25);
        panel.add(guessButton);
        panel.add(guessField);

    }

    private void numOfGuesses() {
        guessButton.addActionListener(this);
        numOfGuessesLabel = new JLabel("Number of Guesses: 0");
        numOfGuessesLabel.setBounds(125, 225, 250, 25);
        panel.add(numOfGuessesLabel);
    }


    private void results() {
        resultText.setWrapStyleWord(true);
        resultText.setLineWrap(true);
        resultText.setOpaque(false);
        resultText.setEditable(false);
        resultText.setFocusable(false);
        resultText.setBounds(75, 255, 250, 100);
        panel.add(resultText);

        if (numGuessed > display.numGenerator.getRandomNum()) {
            resultText.setText("Your guess is incorrect, my number is smaller. Let's try again.");
        } else if (numGuessed < display.numGenerator.getRandomNum()){
            resultText.setText("Your guess is incorrect, my number is larger. Let's try again.");
        } else {
            resultText.setText("Congrats, you have guessed it correctly.");
            guessButton.setEnabled(false);
            //playAgain();

        }

    }


    private void playAgain() {
        playAgain = new JButton("Play Again");
        quit = new JButton("Quit");

        playAgain.setBounds(75,300, 125, 25);
        quit.setBounds(200,300, 125, 25);
        panel.add(playAgain);
        panel.add(quit);

        quitGame();
    }

    private void quitGame() {
        quit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                System.exit(0);
            }
        });
    }

    private void count() {
        numOfGuessesLabel.setText("Number of Guesses: " + display.logic.numberOfGuesses());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        resultText.setText("");
        numGuessed = Integer.parseInt(guessField.getText());

        results();
        count();
        System.out.println("num guessed " + numGuessed + "random number " + display.numGenerator.getRandomNum());
    }
}
