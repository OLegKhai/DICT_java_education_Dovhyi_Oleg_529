import java.util.Scanner;
import java.util.Random;

public class Hangman {
    public static void main(String[] args) {

        System.out.println("HANGMAN");

        String[] words = {"python", "java", "javascript", "kotlin"};

        Random random = new Random();
        String secretWord = words[random.nextInt(words.length)];

        String hint = secretWord.substring(0, 2) + "-".repeat(secretWord.length() - 2);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Guess the word " + hint + ": > ");
        String userGuess = scanner.nextLine().toLowerCase();

        if (userGuess.equals(secretWord)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }

        scanner.close();
    }
}
