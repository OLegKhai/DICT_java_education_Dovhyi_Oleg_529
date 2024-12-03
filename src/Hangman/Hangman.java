import java.util.*;

public class Hangman {
    public static void main(String[] args) {
        System.out.println("HANGMAN");

        String[] words = {"python", "java", "javascript", "kotlin"};

        Random random = new Random();
        String secretWord = words[random.nextInt(words.length)];

        char[] currentWord = new char[secretWord.length()];
        Arrays.fill(currentWord, '-');

        int attemptsLeft = 8;
        Set<Character> guessedLetters = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        while (attemptsLeft > 0) {
            System.out.println(String.valueOf(currentWord));
            System.out.println("Attempts left: " + attemptsLeft);
            System.out.print("Input a letter: > ");
            char guess = scanner.nextLine().toLowerCase().charAt(0);

            if (guessedLetters.contains(guess)) {
                System.out.println("You've already guessed this letter.");
            } else {

                guessedLetters.add(guess);

                if (secretWord.indexOf(guess) >= 0) {

                    for (int i = 0; i < secretWord.length(); i++) {
                        if (secretWord.charAt(i) == guess) {
                            currentWord[i] = guess;
                        }
                    }
                } else {
                    // Неправильный ответ
                    System.out.println("That letter doesn't appear in the word.");
                }

                attemptsLeft--;
            }

            if (String.valueOf(currentWord).equals(secretWord)) {
                System.out.println(secretWord);
                System.out.println("You survived!");
                return;
            }
        }

        System.out.println("Thanks for playing!");
        System.out.println("We'll see how well you did in the next stage.");
    }
}

