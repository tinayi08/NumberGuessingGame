import javax.swing.*;
import java.awt.*;

public class GUI {

    private static JFrame frame;
    private static JLabel label;
    private static JPanel panel;
    private Display display;
    private static GridBagConstraints c;

    public GUI() {
        display = new Display();
    }

    public static void main(String[] args) {
        GUI start = new GUI();

        frame = new JFrame();
        panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(30,200,10,200));
        c = new GridBagConstraints();
        c.insets = new Insets(10,10,10,10);
        frame.add(panel);
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        start.intro();
        start.enterAGuess();

        frame.setVisible(true);
    }

    public void intro() {
        //JLabel intro = new JLabel("<html>" + display.introReturnStr() + "</html>");

        JTextArea introText = new JTextArea();
        introText.setText(display.introReturnStr());
        introText.setWrapStyleWord(true);
        introText.setLineWrap(true);
        introText.setColumns(1000);
        introText.setOpaque(false);
        introText.setEditable(false);
        introText.setFocusable(false);

        //panel.add(introText, BorderLayout.CENTER);

        c.gridx = 0;
        c.gridy = 1;
        panel.add(introText, c);


    }

    public void enterAGuess() {

        JTextArea promptText = new JTextArea();
        promptText.setText("Please enter a guess:");
        promptText.setWrapStyleWord(true);
        promptText.setLineWrap(true);
        promptText.setOpaque(false);
        promptText.setEditable(false);
        promptText.setFocusable(false);
        panel.add(promptText);
        JButton guess = new JButton("Guess");

        c.gridx = 0;
        c.gridy = 2;
        panel.add(promptText,c);
        c.gridx = 0;
        c.gridy = 3;
        panel.add(guess,c);

    }


}
