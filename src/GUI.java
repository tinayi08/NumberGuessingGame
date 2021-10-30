import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//TODO - TRy catch for invalid entry

public class GUI implements ActionListener {
    //when to do static vs non static
    private static JFrame frame;
    private static JPanel panel;
    private Display display;
    private static JButton guessButton;
    private static JButton restartButton;
    private static JButton quitButton;
    private static JLabel numOfGuessesLabel;
    private JTextField guessField;
    private static JTextArea resultText = new JTextArea("");
    private static JTextArea hintText = new JTextArea("");
    private int numGuessed;
    private static JButton hintButton;
    private static JTextArea errorText;

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
        start.startGame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); // should be at the end

    }

    private void startGame() {
        introSetUp();
        enterAGuessSetUp();
        numOfGuessesSetUp();
        do {
            display.numGenerator.randomNumber();
            hint();
            guessButton.addActionListener(this);
            playAgain();
        } while (restartGame());

    }

    private void introSetUp() {

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

    private void enterAGuessSetUp() {

        JTextArea promptText = new JTextArea();
        promptText.setText("Please enter a guess:");
        promptText.setWrapStyleWord(true);
        promptText.setLineWrap(true);
        promptText.setOpaque(false);
        promptText.setEditable(false);
        promptText.setFocusable(false);
        promptText.setBounds(75, 150, 150,25);
        panel.add(promptText);

//        errorText = new JTextArea("");
//        errorText.setWrapStyleWord(true);
//        errorText.setLineWrap(true);
//        errorText.setOpaque(false);
//        errorText.setEditable(false);
//        errorText.setFocusable(false);
//        errorText.setBounds(75, 150, 150,25);
//        panel.add(promptText);

        guessButton = new JButton("Guess");
        guessField = new JTextField();
        guessField.setBounds(205, 145, 100, 25);
        guessButton.setBounds(145,185, 100, 25);
        panel.add(guessButton);
        panel.add(guessField);

    }

    private void numOfGuessesSetUp() {
        //guessButton.addActionListener(this);
        numOfGuessesLabel = new JLabel("Number of Guesses: 0");
        numOfGuessesLabel.setBounds(125, 225, 250, 25);
        panel.add(numOfGuessesLabel);
    }

    public int validEntry () {

        String s = "";
        boolean isValid = false;
        while (!isValid) {
            try {
                s = guessField.getText();
                numGuessed = Integer.parseInt(s);
                isValid = true;
            } catch (NumberFormatException e) {
                resultText.setText("Enter a valid entry");
                guessField.setText("0");

            }
        }
        return numGuessed;

    }


    private void results() {
        resultText.setWrapStyleWord(true);
        resultText.setLineWrap(true);
        resultText.setOpaque(false);
        resultText.setEditable(false);
        resultText.setFocusable(false);
        resultText.setBounds(75, 255, 250, 100);
        panel.add(resultText);

        //numGuessed = validEntry(guessField.getText());
        numGuessed = validEntry();
        //numGuessed = Integer.parseInt(guessField.getText());


        if (numGuessed > display.numGenerator.getRandomNum()) {
            resultText.setText("Your guess is incorrect, my number is smaller. Let's try again.");
        } else if (numGuessed < display.numGenerator.getRandomNum()){
            resultText.setText("Your guess is incorrect, my number is larger. Let's try again.");
        } else if (numGuessed == display.numGenerator.getRandomNum() && !hintButton.isEnabled()) {
            resultText.setText("Good job, cheater.");
            guessButton.setEnabled(false);
        } else {
            resultText.setText("Congrats, you have guessed it correctly.");
            guessButton.setEnabled(false);
        }
    }

    private void hint() {
        hintButton = new JButton("Hint");
        hintButton.setBounds(145,400, 100, 25);
        panel.add(hintButton);
        hintText.setWrapStyleWord(true);
        hintText.setLineWrap(true);
        hintText.setOpaque(false);
        hintText.setEditable(false);
        hintText.setFocusable(false);
        hintText.setBounds(155, 430, 250, 25);
        panel.add(hintText);

        hintButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                hintText.setText("Answer: " + display.numGenerator.getRandomNum());
                hintButton.setEnabled(false);
            }
        });
    }

    private void playAgain() {
        restartButton = new JButton("Play Again");
        quitButton = new JButton("Quit");

        restartButton.setBounds(75,300, 125, 25);
        quitButton.setBounds(200,300, 125, 25);
        panel.add(restartButton);
        panel.add(quitButton);
        quitGame();

    }

    private boolean restartGame() {

        restartButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                display.numGenerator.randomNumber();
                display.logic.setCount(0);
                guessButton.setEnabled(true);
                resultText.setText("");
                hintText.setText("");
                count(0);
                guessField.setText(null);
                hintButton.setEnabled(true);
            }
        });
        if (restartButton.isSelected()) {
            return true;
        }
        return false;
    }

    private void quitGame() {
        quitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                System.exit(0);
            }
        });
    }

    private void count(int numOfGuesses) {
        numOfGuessesLabel.setText("Number of Guesses: " + numOfGuesses);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        resultText.setText("");
        //numGuessed = Integer.parseInt(guessField.getText());
        results();
        count(display.logic.numberOfGuesses());

    }
}
