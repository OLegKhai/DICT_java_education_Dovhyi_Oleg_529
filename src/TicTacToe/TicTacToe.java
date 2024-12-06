package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] grid = {
                {'_', '_', '_'},
                {'_', '_', '_'},
                {'_', '_', '_'}
        };

        printGrid(grid);

        boolean isXTurn = true;

        while (true) {

            System.out.println("Enter the coordinates: ");
            String coordinates = scanner.nextLine();

            if (!processMove(grid, coordinates, isXTurn ? 'X' : 'O')) {
                continue;
            }

            printGrid(grid);

            String result = analyzeGame(grid);
            if (!result.equals("Game not finished")) {
                System.out.println(result);
                break;
            }

            isXTurn = !isXTurn;
        }
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

    private static boolean processMove(char[][] grid, String input, char symbol) {
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

            grid[row][col] = symbol;
            return true;

        } catch (NumberFormatException e) {
            System.out.println("You should enter numbers!");
            return false;
        }
    }

    private static String analyzeGame(char[][] grid) {
        boolean xWins = checkWin(grid, 'X');
        boolean oWins = checkWin(grid, 'O');
        int emptyCount = count(grid, '_');

        if (xWins) return "X wins";
        if (oWins) return "O wins";
        if (emptyCount == 0) return "Draw";
        return "Game not finished";
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
