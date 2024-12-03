import java.util.Scanner;
import java.util.Random;

public class Hangman {
    public static void main(String[] args) {

        System.out.println("HANGMAN");

        String[] words = {"python", "java", "javascript", "kotlin"};

        Random random = new Random();
        String secretWord = words[random.nextInt(words.length)];

        Scanner scanner = new Scanner(System.in);
        System.out.print("Guess the word: > ");
        String userGuess = scanner.nextLine().toLowerCase();
        if (userGuess.equals(secretWord)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }

        scanner.close();
    }
}
