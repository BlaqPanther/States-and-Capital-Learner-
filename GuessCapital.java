import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class GuessCapital {
    private ST<String, String> st = new ST<String, String>(); // Symbol table to store states as keys and their capitals as values.
    private String[] states = {"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware",
            "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland",
            "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire",
            "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon",
            "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia",
            "Washington", "West Virginia", "Wisconsin", "Wyoming"}; // States in alphabetical order

    private String[] capitals = {"Montgomery", "Juneau", "Phoenix", "Little Rock", "Sacramento", "Denver", "Hartford", "Dover",
            "Tallahassee", "Atlanta", "Honolulu", "Boise", "Springfield", "Indianapolis", "Des Moines", "Topeka", "Frankfort",
            "Baton Rouge", "Augusta", "Annapolis", "Boston", "Lansing", "St. Paul", "Jackson", "Jefferson City", "Helena",
            "Lincoln", "Carson City", "Concord", "Trenton", "Santa Fe", "Albany", "Raleigh", "Bismarck", "Columbus", "Oklahoma City",
            "Salem", "Harrisburg", "Providence", "Columbia", "Pierre", "Nashville", "Austin", "Salt Lake City", "Montpelier", "Richmond",
            "Olympia", "Charleston", "Madison", "Cheyenne"}; // Capitals in corresponding order to the arrangement of their states.
    private int correctAns, stateNumber; // variables to count correct answers provided and state number respectively
    public int numberOfQuestions; // counts the number of questions
    private Stack<Integer> index = new Stack<Integer>(); // a stack of the possible indexes to be used as state numbers
    private String[] userAnswer = new String[1]; // a string array to store user response.

    // Constructor for the GuessCapital object
    public GuessCapital() {
        int[] array = new int[50];

        // Arranges states and their capitals in  the symbol table and fills an array with integers from 1 to 50.
        for (int i = 0; i < 50; i++) {
            st.put(states[i], capitals[i]);
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
        question.append("What is the capital city of state " + (stateNumber) + "?");
        numberOfQuestions++;
        return question.toString();


    }

    // checks the answer provided by the user and returns 1 or -1
    public int checkAnswer(String ans) {
        userAnswer[0] = ans;

        if (st.get(states[stateNumber - 1]).equalsIgnoreCase(userAnswer[0])) {
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
    // or asks the user to continue playing if the answer is correct.
    public String showIncorrectAns() {
        StringBuilder correction = new StringBuilder();
        if (checkAnswer(userAnswer[0]) == -1) {
            correction.append("That is incorrect\nThe correct answer is " + capitals[stateNumber - 1]);
            return correction.toString();
        }
        correctAns--;
        return "That's correct. Continue playing";
    }

    // Test client
    public static void main(String[] args) {
        GuessCapital s = new GuessCapital();
        //System.out.println(s.st.get("New Jersey"));
        Picture p = new Picture("States_of_the_USA_by_numbers.jpg");
        p.show();
        for (int i = 0; i < 3; i++) {
            System.out.println(s.questionGenerator());
            s.checkAnswer(StdIn.readString());
        }
        System.out.println(s.showIncorrectAns());
        System.out.println(s.correctAns);
        //System.out.println(s.st.get("New Jersey"));


        s.userAnswer[0] = StdIn.readLine();
        System.out.println(s.st.get("Missouri").equals(s.userAnswer[0]));


    }
}
