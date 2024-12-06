package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter cells: ");
        String input = scanner.nextLine();

        char[][] grid = new char[3][3];
        for (int i = 0; i < 9; i++) {
            grid[i / 3][i % 3] = input.charAt(i);
        }

        printGrid(grid);

        String result = analyzeGame(grid);
        System.out.println(result);
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

    private static String analyzeGame(char[][] grid) {
        boolean xWins = checkWin(grid, 'X');
        boolean oWins = checkWin(grid, 'O');
        int xCount = count(grid, 'X');
        int oCount = count(grid, 'O');
        int emptyCount = count(grid, '_');

        if (xWins && oWins || Math.abs(xCount - oCount) > 1) {
            return "Impossible";
        } else if (xWins) {
            return "X wins";
        } else if (oWins) {
            return "O wins";
        } else if (emptyCount > 0) {
            return "Game not finished";
        } else {
            return "Draw";
        }
    }

    private static boolean checkWin(char[][] grid, char symbol) {
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == symbol && grid[i][1] == symbol && grid[i][2] == symbol) return true;
            if (grid[0][i] == symbol && grid[1][i] == symbol && grid[2][i] == symbol) return true;
        }
        return (grid[0][0] == symbol && grid[1][1] == symbol && grid[2][2] == symbol) ||
                (grid[0][2] == symbol && grid[1][1] == symbol && grid[2][0] == symbol);
    }

    private static int count(char[][] grid, char symbol) {
        int count = 0;
        for (char[] row : grid) {
            for (char cell : row) {
                if (cell == symbol) count++;
            }
        }
        return count;
    }
}
