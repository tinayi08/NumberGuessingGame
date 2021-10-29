import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    //when to do static vs non static
    private static JFrame frame;
    private static JPanel panel;
    private Display display;
    private static JButton guess;
    private static JLabel numOfGuesses;
    private JTextField guessField;
    private static JTextArea resultText = new JTextArea("");
    private static JFrame resultFrame;
    private static JPanel resultPanel;
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

        start.intro();
        start.enterAGuess();
        start.numOfGuesses();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); // should be at the end

    }

    public void intro() {

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

    public void enterAGuess() {

        JTextArea promptText = new JTextArea();
        promptText.setText("Please enter a guess:");
        promptText.setWrapStyleWord(true);
        promptText.setLineWrap(true);
        promptText.setOpaque(false);
        promptText.setEditable(false);
        promptText.setFocusable(false);
        promptText.setBounds(75, 150, 150,25);
        panel.add(promptText);

        guess = new JButton("Guess");
        guessField = new JTextField();
        guessField.setBounds(205, 145, 100, 25);
        guess.setBounds(145,185, 100, 25);
        panel.add(guess);
        panel.add(guessField);

    }

    public void numOfGuesses() {
        guess.addActionListener(this);
        numOfGuesses = new JLabel("Number of Guesses: 0");
        numOfGuesses.setBounds(125, 225, 250, 25);
        panel.add(numOfGuesses);
    }


    public void results() {
       // resultText = new JTextArea("");
        resultText.setWrapStyleWord(true);
        resultText.setLineWrap(true);
        resultText.setOpaque(false);
        resultText.setEditable(false);
        resultText.setFocusable(false);
        resultText.setBounds(75, 255, 250, 100);
        panel.add(resultText);

        if (numGuessed > display.numGenerator.randomNumber()) {
            resultText.setText("Your guess is incorrect, my number is smaller. Let's try again.");
        } else if (numGuessed < display.numGenerator.randomNumber()){
            resultText.setText("Your guess is incorrect, my number is larger. Let's try again.");
        } else {
            resultText.setText("Congrats, you have guessed it correctly.");
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        resultText.setText("");
        numGuessed = Integer.parseInt(guessField.getText());

        results();

        display.logic.count++;
        numOfGuesses.setText("Number of Guesses: " + display.logic.count);

    }
}
