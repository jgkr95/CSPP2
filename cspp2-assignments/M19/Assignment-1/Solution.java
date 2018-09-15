import java.util.Scanner;
import java.util.Arrays;

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
			// System.out.println("line  "+line);
			String[] tokens = line.split(" ");
			// based on the list operation invoke the corresponding method
			// System.out.println("Tokens"+Arrays.toString(tokens));
			// if(!tokens[1].equals(null)) {
			// 	Question[] questionquiz =
			// 	 new Question[Integer.parseInt(tokens[1])];
			// 	public int count=0;
			// }
			switch (tokens[0]) {
			case "LOAD_QUESTIONS":
				System.out.println("|----------------|");
				System.out.println("| Load Questions |");
				System.out.println("|----------------|");
				// Question[] questionquiz =
				//  new Question[Integer.parseInt(tokens[1])];
				// public int count=0;
				loadQuestions(s, q, Integer.parseInt(tokens[1]));
				// System.out.println(Integer.parseInt(tokens[1]));
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
	 * @param      s              The scanner object for user input
	 * @param      quiz           The quiz object
	 * @param      questionCount  The question count
	 */
	public static void loadQuestions(final Scanner s,
	 final Quiz quiz, final int questionCount) {
		// write your code here to read the questions from the console
		// tokenize the question line and create the question object
		// add the question objects to the quiz class
		// System.out.println(s);
		// System.out.println(quiz);
		// System.out.println(questionCount);
		// questionCount=s.nextInt();
		String question;

		// Quiz[] quiz
		if (questionCount == 0) {
			System.out.println("Quiz does not have questions");
		} else {
			for (int i = 0; i < questionCount; i++) {
				question = s.nextLine();
				String[] token = question.split(":");
				// System.out.println("-"+token[0]+"-");
				if (token.length != 5 ||
				 token[0].equals(null) || token[0].equals("")) {
					System.out.println("Error! Malformed question");
					continue;

				}
				String[] choices = token[1].split(",");
				if (choices.length < 2) {
					System.out.println(
						token[0] + " does not have enough answer choices");
					continue;
				}
				if (!(Integer.parseInt(token[2]) < choices.length 
					&& Integer.parseInt(token[2]) > 0)) {
					System.out.println(
		"Error! Correct answer choice number is out of range for " + token[0]);
					continue;
				}
				if (Integer.parseInt(token[4]) > 0) {
					System.out.println("Invalid penalty for " + token[0]);
					continue;
				}
				if (Integer.parseInt(token[3]) <= 0) {
					System.out.println("Invalid max marks for " + token[0]);
					continue;
				}
				// questionquiz[count++] =new Question(token[0],choices,
				// token[2],Integer.parseInt(token[3]),Integer.parseInt(token[4]));
			}
		}
	}

	/**
	 * Starts a quiz.
	 *
	 * @param      s            The scanner object for user input
	 * @param      quiz         The quiz object
	 * @param      answerCount  The answer count
	 */
	public static void startQuiz(final Scanner s,
	 final Quiz quiz, final int answerCount) {
		// write your code here to display the quiz questions
		// read the user responses from the console
		// store the user respones in the quiz object
		// System.out.println(s);
		// System.out.println(quiz);
		// System.out.println(answerCount);
		//    for(int j=0;j<count;j++) {
		//     System.out.println(questionquiz[j].questiontext);
		//     for(int i=0;i<questionquiz[j].choices.length;i++) {
		//     	System.out.println(questionquiz[j].choices[i]+"	");
		//     }
		//     System.out.println();
		// }
	}

	/**
	 * Displays the score report
	 *
	 * @param      quiz     The quiz object
	 */
	public static void displayScore(final Quiz quiz) {
		// write your code here to display the score report
	}
	// public void toString() {
	// 	return this.
	// }
}
/**
 * Class for question.
 */
class Question {
	public String questiontext;
	public String[] choices;
	public String correctchoice;
	public int marks;
	public int penalty;
	public int marksawarded;
	/**
	 * Constructs the object.
	 *
	 * @param      questiontex   The questiontex
	 * @param      choice        The choice
	 * @param      correctchoic  The correctchoic
	 * @param      mark          The mark
	 * @param      penalt        The penalt
	 */
	Question(String questiontex, String[] choice, String correctchoic, int mark, int penalt) {
		this.questiontext = questiontex;
		this.choices = choice;
		this.correctchoice = correctchoic;
		this.marks = mark;
		this.penalty = penalt;
	}
/**
 * class Quiz.
 */
}
class Quiz {

}
