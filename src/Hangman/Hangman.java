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
