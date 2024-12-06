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
}
