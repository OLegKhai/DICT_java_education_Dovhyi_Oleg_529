package TicTacToe;

public class TicTacToe {
    public static void main(String[] args) {
        // Ігрове поле
        char[][] grid = {
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'X', 'X', 'O'}
        };

        // Друк ігрового поля
        printGrid(grid);
    }

    private static void printGrid(char[][] grid) {
        for (char[] row : grid) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
