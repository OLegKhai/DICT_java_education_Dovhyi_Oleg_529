import java.util.*;

public class Hangman {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("HANGMAN");
            System.out.print("Type \"play\" to play the game, \"exit\" to quit: > ");
            String choice = scanner.nextLine().toLowerCase();

            if (choice.equals("play")) {
                playGame(scanner);
            } else if (choice.equals("exit")) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid input. Please type \"play\" or \"exit\".");
            }
        }
    }

    public static void playGame(Scanner scanner) {

        String[] words = {"python", "java", "javascript", "kotlin"};

        Random random = new Random();
        String secretWord = words[random.nextInt(words.length)];

        char[] currentWord = new char[secretWord.length()];
        Arrays.fill(currentWord, '-');

        int lives = 8;
        Set<Character> guessedLetters = new HashSet<>();

        while (lives > 0) {
            System.out.println(String.valueOf(currentWord));
            System.out.println("Lives remaining: " + lives);
            System.out.print("Input a letter: > ");
            String input = scanner.nextLine();

            if (input.length() != 1) {
                System.out.println("You should input a single letter");
                continue;
            }

            char guess = input.charAt(0);

            if (!Character.isLowerCase(guess) || !Character.isAlphabetic(guess) || guess < 'a' || guess > 'z') {
                System.out.println("Please enter a lowercase English letter");
                continue;
            }

            if (guessedLetters.contains(guess)) {
                System.out.println("You've already guessed this letter");
                continue;
            }

            guessedLetters.add(guess);

            if (secretWord.indexOf(guess) >= 0) {
                boolean improved = false;
                for (int i = 0; i < secretWord.length(); i++) {
                    if (secretWord.charAt(i) == guess) {
                        if (currentWord[i] == '-') {
                            currentWord[i] = guess;
                            improved = true;
                        }
                    }
                }

                if (!improved) {
                    System.out.println("No improvements");
                }
            } else {

                System.out.println("That letter doesn't appear in the word");
                lives--;
            }

            if (String.valueOf(currentWord).equals(secretWord)) {
                System.out.println(secretWord);
                System.out.println("You guessed the word!");
                System.out.println("You survived!");
                return;
            }
        }

        System.out.println("You lost!");
    }
}
