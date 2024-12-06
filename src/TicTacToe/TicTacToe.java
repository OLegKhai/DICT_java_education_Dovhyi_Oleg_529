package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Зчитування стану гри
        System.out.println("Enter cells: ");
        String input = scanner.nextLine();

        // Перетворення на ігрове поле
        char[][] grid = new char[3][3];
        for (int i = 0; i < 9; i++) {
            grid[i / 3][i % 3] = input.charAt(i);
        }

        // Друк ігрового поля
        printGrid(grid);

        // Запропонувати користувачеві зробити хід
        while (true) {
            System.out.println("Enter the coordinates: ");
            String coordinates = scanner.nextLine();

            // Обробка введення
            if (processMove(grid, coordinates)) {
                break;
            }
        }

        // Друк оновленого поля
        printGrid(grid);
    }

    private static void printGrid(char[][] grid) {
        System.out.println("---------");
        for (char[] row : grid) {
            System.out.print("| ");
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    private static boolean processMove(char[][] grid, String input) {
        String[] parts = input.split(" ");
        if (parts.length != 2) {
            System.out.println("You should enter numbers!");
            return false;
        }

        try {
            int row = Integer.parseInt(parts[0]) - 1;
            int col = Integer.parseInt(parts[1]) - 1;

            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Coordinates should be from 1 to 3!");
                return false;
            }

            if (grid[row][col] != '_') {
                System.out.println("This cell is occupied! Choose another one!");
                return false;
            }

            grid[row][col] = 'X'; // Додаємо хід користувача
            return true;

        } catch (NumberFormatException e) {
            System.out.println("You should enter numbers!");
            return false;
        }
    }
}
