import java.util.*;

public class Hangman {
    public static void main(String[] args) {
        System.out.println("HANGMAN");

        String[] words = {"python", "java", "javascript", "kotlin"};

        Random random = new Random();
        String secretWord = words[random.nextInt(words.length)];

        char[] currentWord = new char[secretWord.length()];
        Arrays.fill(currentWord, '-');

        int lives = 8;
        Set<Character> guessedLetters = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        while (lives > 0) {
            System.out.println(String.valueOf(currentWord));
            System.out.print("Input a letter: > ");
            char guess = scanner.nextLine().toLowerCase().charAt(0);

            if (guessedLetters.contains(guess)) {
                System.out.println("No improvements");
                lives--;
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
                    lives--;
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
