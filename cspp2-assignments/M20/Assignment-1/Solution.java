import java.util.Scanner;
/**
 * Class for question.
 */
class Question {
    /**
     * { var_description }.
     */
    private String questiontext;
    /**
     * { var_description }.
     */
    private String[] choices;
    /**
     * { var_description }.
     */
    private int correctAnswer;
    /**
     * { var_description }.
     */
    private int maxMarks;
    /**
     * { var_description }.
     */
    private int penalty;
    /**
     * { var_description }.
     */
    private int response;
    /**
     * Constructs the object.
     */
    Question() {

    }
    /**
     * Constructs the object.
     *
     * @param      question1       The question 1
     * @param      choices1        The choices 1
     * @param      correctAnswer1  The correct answer 1
     * @param      maxMarks1       The maximum marks 1
     * @param      penalty1        The penalty 1
     */
    Question(final String question1, final String[] choices1,
             final int correctAnswer1, final int maxMarks1,
              final int penalty1) {
        questiontext = question1;
        choices = choices1;
        correctAnswer = correctAnswer1;
        maxMarks = maxMarks1;
        penalty = penalty1;
    }
    /**
     * { function_description }.
     *
     * @param      choice  The choice
     *
     * @return     { description_of_the_return_value }
     */
    public boolean evaluateResponse(final String choice) {
        for (int i = 0; i < choices.length; i++) {
            if (choice.equals(choices[correctAnswer - 1])) {
                return true;
            }
        }
        return false;
    }
    /**
     * Gets the correct answer.
     *
     * @return     The correct answer.
     */
    public String getCorrectAnswer() {
        return choices[correctAnswer - 1];
    }
    /**
     * Gets the question text.
     *
     * @return     The question text.
     */
    public String getQuestionText() {
        return questiontext;
    }
    /**
     * Gets the choice.
     *
     * @return     The choice.
     */
    public String[] getChoice() {
        return choices;
    }
    /**
     * Gets the maximum marks.
     *
     * @return     The maximum marks.
     */
    public int getMaxMarks() {
        return maxMarks;
    }
    /**
     * Gets the penalty.
     *
     * @return     The penalty.
     */
    public int getPenalty() {
        return penalty;
    }
    /**
     * Sets the response.
     *
     * @param      answer  The answer
     */
    public void setResponse(final String answer) {
        if (evaluateResponse(answer)) {
            response = maxMarks;
        } else {
            response = penalty;
        }
    }
    /**
     * Gets the response.
     *
     * @return     The response.
     */
    public int getResponse() {
        return response;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        return s;
    }
}
/**
 * Class for quiz.
 */
class Quiz {
    /**
     * { var_description }.
     */
    private final int onehundred = 100;
    /**
     * { var_description }.
     */
    private Question[] questions;
    /**
     * { var_description }.
     */
    private int size;
    /**
     * { var_description }.
     */
    private final int ten = 10;
    /**
     * Constructs the object.
     */
    Quiz() {
        questions = new Question[ten];
        size = 0;
    }
    // public addtoQuestionClass(Question obj) {

    // }
    /**
     * Adds a question.
     *
     * @param      q     The question
     */
    public void addQuestion(final Question q) {
        questions[size++] = q;
    }
    /**
     * Gets the question.
     *
     * @param      index  The index
     *
     * @return     The question.
     */
    public Question getQuestion(final int index) {
        return questions[index];
    }
    /**
     * Shows the report.
     *
     * @return     { description_of_the_return_value }
     */
    // public String showReport() {
    //     String s = "";
    //     return s;
    // }
    public int getsize() {
        return size;
    }

}
/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
    * Constructs the object.
    */
    private Solution() {
        // leave this blank
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this Quiz
        Quiz q = new Quiz();
        // code to read the test cases input file
        Scanner s = new Scanner(System.in);
        // check if there is one more line to process
        while (s.hasNext()) {
            // read the line
            String line = s.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
            case "LOAD_QUESTIONS":
                System.out.println("|----------------|");
                System.out.println("| Load Questions |");
                System.out.println("|----------------|");
                loadQuestions(s, q, Integer.parseInt(tokens[1]));
                break;
            case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                startQuiz(s, q, Integer.parseInt(tokens[1]));
                break;
            case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                displayScore(q);
                break;
            default:
                break;
            }
        }
    }
    /**
     * Loads questions.
     *
     * @param      scan       The scan
     * @param      quiz       The quiz
     * @param      q          The question count
     *
     */
    public static void loadQuestions(final Scanner scan,
                                     final Quiz quiz, final int q) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        final int three = 3, five = 5, one = 1, two = 2, four = 4, zero = 0;
        if (q == 0) {
            System.out.println("Quiz does not have questions");
        } else {
            for (int i = 0; i < q; i++) {
                String line = scan.nextLine();
                String[] token = line.split(":");
                String[] data = token[1].split(",");
                if (token.length != five
                    || token[zero].equals(null) || token[zero].equals("")) {
                    System.out.println("Error! Malformed question");
                    // break;
                    continue;

                }
                if (data.length < two) {
                    System.out.println(
                        token[zero] + " does not have enough answer choices");
                    continue;
                }
                if (!(Integer.parseInt(token[two]) <= data.length
                        && Integer.parseInt(token[two]) > zero)) {
                    System.out.println(
                "Error! Correct answer choice number is out of range for "
                        + token[zero]);
                    continue;
                }
                if (Integer.parseInt(token[four]) > zero) {
                    System.out.println("Invalid penalty for " + token[zero]);
                    continue;
                }
                if (Integer.parseInt(token[three]) <= zero) {
                    System.out.println("Invalid max marks for " + token[zero]);
                    continue;
                }


                quiz.addQuestion(new Question(token[zero],
                 data, Integer.parseInt(token[two]),
        Integer.parseInt(token[three]), Integer.parseInt(token[four])));

            }
            if (quiz.getsize() != 0) {
                System.out.println(q + " are added to the quiz");
            }
        }
    }
    /**
     * Starts a quiz.
     *
     * @param      scan  The scan
     * @param      quiz  The quiz
     * @param      q     The answer count
     */
    public static void startQuiz(final Scanner scan,
                                 final Quiz quiz, final int q) {
        // write your code here to display the quiz questions on the console.
        // read the user responses from the console using scanner object.
        // store the user respone in the question object
        String[] respone = new String[q];
        int questioncount = quiz.getsize();
        for (int i = 0; i < questioncount; i++) {
            Question que = quiz.getQuestion(i);
            System.out.println(que.getQuestionText()
             + "(" + que.getMaxMarks() + ")");
            String[] choice = que.getChoice();
            for (int j = 0; j < choice.length - 1; j++) {
                System.out.print(choice[j] + "\t");

            } System.out.println(choice[choice.length - 1]);
            System.out.println();
            que.setResponse(scan.nextLine());
        }
    }
    /**
     * Displays the score report.
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report using quiz object.
        Question qu;
        int total = 0;
        for (int i = 0; i < quiz.getsize(); i++) {
            qu = quiz.getQuestion(i);
            System.out.println(qu.getQuestionText());
            if (qu.getResponse() > 0) {
                System.out.println(" Correct Answer! - Marks Awarded: "
                 + qu.getResponse());
            } else {
                System.out.println(" Wrong Answer! - Penalty: "
                 + qu.getResponse());
            }
            total += qu.getResponse();

        }
        if (quiz.getsize() != 0) {
            System.out.println("Total Score: " + total);
        }

    }
}
