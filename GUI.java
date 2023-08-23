import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    public static void main(String[] args) {
        // Creates a new JFrame object
        JFrame frame = new JFrame();

        // Creates a new JLabel that displays a welcome message on the GUI
        JLabel labelone = new JLabel("Welcome to USA states and capitals learner!");
        // Centering the JLabel and setting the font color as white
        labelone.setHorizontalAlignment(JLabel.CENTER);
        labelone.setForeground(Color.white);

        // Creates a new JLabel that tells user to choose a game mode
        JLabel labeltwo = new JLabel("Choose your mode");
        // Centering the JLabel and setting the font color as white
        labeltwo.setHorizontalAlignment(JLabel.CENTER);
        labeltwo.setForeground(Color.white);

        // Creates a new JButton named "States" for the states mode
        JButton buttonStates = new JButton("States");
        // Sets the border around the button and the font color as blue
        buttonStates.setBackground(Color.blue);
        buttonStates.setOpaque(true);
        buttonStates.setForeground(Color.blue);

        // Creates a new JButton named "Capitals" for the capitals mode
        JButton buttonCapitals = new JButton("Capitals");
        // Sets the border around the button and the font color as blue
        buttonCapitals.setBackground(Color.blue);
        buttonCapitals.setOpaque(true);
        buttonCapitals.setForeground(Color.blue);

        // Action listener for the capitals button that executes code for the capitals game mode
        buttonCapitals.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code for capitals mode
                GuessCapital s = new GuessCapital();
                int count = 0;
                Picture p = new Picture("States_of_the_USA_by_numbers.jpg");
                p.show();
                for (int i = 0; i < 50; i++) {
                    System.out.println(s.questionGenerator());
                    String response = StdIn.readLine();
                    if (response.equalsIgnoreCase("Quit")) {
                        s.numberOfQuestions--;
                        System.out.println(s.result());
                        break;
                    }
                    s.checkAnswer(response);
                    System.out.println(s.showIncorrectAns());
                    count++;
                }
                if (count == 50) System.out.println(s.result());


            }


        });

        // Action listener for the states button that executes code for the states game mode
        buttonStates.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // code for states mode
                GuessState t = new GuessState();
                int count = 0;
                Picture p = new Picture("States_of_the_USA_by_numbers.jpg");
                p.show();
                for (int i = 0; i < 50; i++) {
                    System.out.println(t.questionGenerator());
                    String response = StdIn.readLine();
                    if (response.equalsIgnoreCase("Quit")) {
                        t.numberOfQuestions--;
                        System.out.println(t.result());
                        break;
                    }
                    t.checkAnswer(response);
                    System.out.println(t.showIncorrectAns());
                    count++;
                }
                if (count == 50) System.out.println(t.result());


            }
        });


        // Creates a new JPanel object and sets up its border and layout
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        // Adding components to the JPanel, including the labels and buttons
        panel.add(labelone);
        panel.add(labeltwo);
        panel.add(buttonStates);
        panel.add(buttonCapitals);
        // Setting the panel color to red
        panel.setBackground(Color.RED);

        // Adding the panel to the JFrame and centering it
        frame.add(panel, BorderLayout.CENTER);
        // GUI closes when exited out of
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Title of the GUI/JFrame
        frame.setTitle("USA States and Capitals Learner");
        frame.pack();
        frame.setVisible(true);

    }
}
