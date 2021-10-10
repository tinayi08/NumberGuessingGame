import javax.swing.*;
import java.awt.*;

public class GUI {

    private static JFrame frame;
    private static JLabel label;
    private static JPanel panel;
    private Display display;

    public GUI() {
        display = new Display();
    }

    public static void main(String[] args) {
        GUI start = new GUI();

        frame = new JFrame();

        panel = new JPanel();
        frame.setSize(600, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        start.intro();
        frame.setVisible(true);
    }

    public void intro() {
        //JLabel intro = new JLabel("<html>" + display.introReturnStr() + "</html>");

        JTextArea textArea = new JTextArea(20, 20);
        textArea.setText(display.introReturnStr());
        textArea.setWrapStyleWord(false);
        textArea.setLineWrap(true);
        textArea.setOpaque(false);
        textArea.setEditable(false);
        textArea.setFocusable(false);

        panel.add(textArea, BorderLayout.CENTER);


    }


}
