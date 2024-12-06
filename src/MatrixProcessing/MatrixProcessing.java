package MatrixProcessing;

import java.util.Scanner;

public class MatrixProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Считываем первую матрицу
        System.out.println("Введите размеры первой матрицы:");
        int n1 = scanner.nextInt();
        int m1 = scanner.nextInt();
        int[][] matrixA = readMatrix(scanner, n1, m1);

        // Считываем вторую матрицу
        System.out.println("Введите размеры второй матрицы:");
        int n2 = scanner.nextInt();
        int m2 = scanner.nextInt();
        int[][] matrixB = readMatrix(scanner, n2, m2);

        // Проверка возможности сложения
        if (n1 != n2 || m1 != m2) {
            System.out.println("ERROR");
        } else {
            int[][] result = addMatrices(matrixA, matrixB);
            printMatrix(result);
        }
    }

    private static int[][] readMatrix(Scanner scanner, int n, int m) {
        int[][] matrix = new int[n][m];
        System.out.println("Введите элементы матрицы:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static int[][] addMatrices(int[][] matrixA, int[][] matrixB) {
        int n = matrixA.length;
        int m = matrixA[0].length;
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        return result;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
