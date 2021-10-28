import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    private static JFrame frame;
    private static JLabel label;
    private static JPanel panel;
    private Display display;
    private static JButton guess;
    private static JLabel enterGuess;
    private static JLabel numOfGuesses;


    public GUI() {
        display = new Display();
    }

    public static void main(String[] args) {
        GUI start = new GUI();

        frame = new JFrame();
        frame.setSize(400, 300);
        panel = new JPanel();
        frame.add(panel);
        //panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30)); //unsure if necessary

//        panel.setLayout(new GridLayout(0, 1));
        panel.setLayout(null);

        frame.setTitle("Number Guessing Game");
//        frame.pack();
//
        start.intro();
        start.enterAGuess();
        start.numOfGuesses();

        //frame.add(panel,BorderLayout.CENTER);
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
        JTextField guessField = new JTextField();
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


    @Override
    public void actionPerformed(ActionEvent e) {
        display.logic.count++;
        numOfGuesses.setText("Number of Guesses: " + display.logic.count);
    }
}
