import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class GuessState {
    private ST<Integer, String> st = new ST<Integer, String>(); // Symbol table to store states as keys and their numbers as values.
    private String[] states = {"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware",
            "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland",
            "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire",
            "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon",
            "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia",
            "Washington", "West Virginia", "Wisconsin", "Wyoming"}; // States in alphabetical order

    private int correctAns, stateNumber; // variables to count correct answers provided and state number respectively
    private Stack<Integer> index = new Stack<Integer>(); // a stack of the possible indexes to be used as state numbers
    private String[] userAnswer = new String[1]; // a string array to store user response.
    public int numberOfQuestions; // counts the number of questions

    // Constructor for the GuessState object
    public GuessState() {
        int[] array = new int[50];

        // Arranges states and their number in  the symbol table and fills an array with integers from 1 to 50.
        for (int i = 0; i < 50; i++) {
            st.put(i + 1, states[i]);
            array[i] = i + 1;
        }
        // Creates a list from the array values
        List<Integer> list = new ArrayList<>();
        for (int i : array) {
            list.add(i);
        }
        Collections.shuffle(list); // shuffles the element of the list

        // fills the stack with elements of the list
        for (int i = 0; i < array.length; i++) {
            index.push(list.get(i));
        }

    }

    // Generates questions for the user.
    public String questionGenerator() {
        stateNumber = index.pop();

        StringBuilder question = new StringBuilder();
        question.append("What is the state numbered " + (stateNumber) + "?");
        numberOfQuestions++;
        return question.toString();
    }

    // checks the answer provided by the user and returns 1 or -1
    public int checkAnswer(String ans) {
        userAnswer[0] = ans;

        if (st.get(stateNumber).equalsIgnoreCase(userAnswer[0])) {
            correctAns++;
            return 1;
        }
        return -1;

    }

    // returns the number of correct questions answered out of all the questions asked
    public String result() {
        return "You answered " + correctAns + " questions correct out of "
                + numberOfQuestions + " questions.";
    }

    // checks the correctness of an answer, prints the right answer if the user's response is wrong
    // or asks the user to continue playing if the answer is correct
    public String showIncorrectAns() {
        StringBuilder correction = new StringBuilder();
        if (checkAnswer(userAnswer[0]) == -1) {
            correction.append("That is incorrect\nThe correct answer is " + states[stateNumber - 1]);
            return correction.toString();
        }
        correctAns--;
        return "That's correct. Continue playing";
    }

    // Test Client
    public static void main(String[] args) {
        GuessState s = new GuessState();
        //System.out.println(s.st.get("New Jersey"));
        System.out.println(s.questionGenerator());
        //System.out.println(s.stateNumber);
        //System.out.println(s.st.get(s.stateNumber));

        System.out.println(s.checkAnswer(StdIn.readString()));

        System.out.println(s.showIncorrectAns());
        //System.out.println(s.result());
        //System.out.println(s.st.get("New Jersey"));


    }

}
