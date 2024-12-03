package Hangman;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {

        System.out.println("HANGMAN");
        System.out.println("The game will be available soon.");

        String secretWord = "java";

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
