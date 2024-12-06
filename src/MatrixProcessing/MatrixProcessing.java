package MatrixProcessing;

import java.util.Scanner;

public class MatrixProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Меню выбора операции
            System.out.println("\nВыберите операцию:");
            System.out.println("1. Сложение матриц");
            System.out.println("2. Умножение матрицы на константу");
            System.out.println("3. Умножение двух матриц");
            System.out.println("4. Транспонирование матрицы");
            System.out.println("5. Вычисление определителя матрицы");
            System.out.println("0. Выход");
            System.out.print("Ваш выбор: ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Завершение работы программы.");
                break;
            }

            switch (choice) {
                case 1:
                    addMatrices(scanner);
                    break;
                case 2:
                    multiplyMatrixByConstant(scanner);
                    break;
                case 3:
                    multiplyMatrices(scanner);
                    break;
                case 4:
                    transposeMatrix(scanner);
                    break;
                case 5:
                    calculateDeterminant(scanner);
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private static void calculateDeterminant(Scanner scanner) {
        System.out.println("Введите размеры матрицы:");
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        if (n != m) {
            System.out.println("ERROR: Определитель можно вычислить только для квадратных матриц.");
            return;
        }

        int[][] matrix = readMatrix(scanner, n, m);
        int determinant = calculateDeterminant(matrix);

        System.out.println("Определитель матрицы: " + determinant);
    }

    private static int calculateDeterminant(int[][] matrix) {
        int n = matrix.length;

        // Базовый случай: матрица 1x1
        if (n == 1) {
            return matrix[0][0];
        }

        // Базовый случай: матрица 2x2
        if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        // Рекурсивный случай: разложение по первой строке
        int determinant = 0;
        for (int j = 0; j < n; j++) {
            determinant += Math.pow(-1, j) * matrix[0][j] * calculateDeterminant(getMinor(matrix, 0, j));
        }

        return determinant;
    }

    private static int[][] getMinor(int[][] matrix, int rowToRemove, int colToRemove) {
        int n = matrix.length;
        int[][] minor = new int[n - 1][n - 1];
        int rowOffset = 0;

        for (int i = 0; i < n; i++) {
            if (i == rowToRemove) {
                rowOffset = -1;
                continue;
            }

            int colOffset = 0;
            for (int j = 0; j < n; j++) {
                if (j == colToRemove) {
                    colOffset = -1;
                    continue;
                }

                minor[i + rowOffset][j + colOffset] = matrix[i][j];
            }
        }

        return minor;
    }

    private static void transposeMatrix(Scanner scanner) {
        System.out.println("Выберите способ транспонирования:");
        System.out.println("1. Относительно главной диагонали");
        System.out.println("2. Относительно побочной диагонали");
        System.out.println("3. Относительно вертикальной оси");
        System.out.println("4. Относительно горизонтальной оси");
        System.out.print("Ваш выбор: ");
        int choice = scanner.nextInt();

        System.out.println("Введите размеры матрицы:");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = readMatrix(scanner, n, m);

        int[][] result = null;

        switch (choice) {
            case 1:
                result = transposeMainDiagonal(matrix);
                break;
            case 2:
                result = transposeSideDiagonal(matrix);
                break;
            case 3:
                result = transposeVertical(matrix);
                break;
            case 4:
                result = transposeHorizontal(matrix);
                break;
            default:
                System.out.println("Неверный выбор.");
                return;
        }

        printMatrix(result);
    }

    private static int[][] transposeMainDiagonal(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    private static int[][] transposeSideDiagonal(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[m - j - 1][n - i - 1] = matrix[i][j];
            }
        }
        return result;
    }

    private static int[][] transposeVertical(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][m - j - 1] = matrix[i][j];
            }
        }
        return result;
    }

    private static int[][] transposeHorizontal(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[n - i - 1][j] = matrix[i][j];
            }
        }
        return result;
    }

    private static void multiplyMatrixByConstant(Scanner scanner) {
        System.out.println("Введите размеры матрицы:");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = readMatrix(scanner, n, m);

        System.out.println("Введите константу:");
        int constant = scanner.nextInt();

        int[][] result = multiplyMatrix(matrix, constant);
        printMatrix(result);
    }

    private static void addMatrices(Scanner scanner) {
        System.out.println("Введите размеры первой матрицы:");
        int n1 = scanner.nextInt();
        int m1 = scanner.nextInt();
        int[][] matrixA = readMatrix(scanner, n1, m1);

        System.out.println("Введите размеры второй матрицы:");
        int n2 = scanner.nextInt();
        int m2 = scanner.nextInt();
        int[][] matrixB = readMatrix(scanner, n2, m2);

        if (n1 != n2 || m1 != m2) {
            System.out.println("ERROR");
        } else {
            int[][] result = addMatrices(matrixA, matrixB);
            printMatrix(result);
        }
    }

    private static void multiplyMatrices(Scanner scanner) {
        System.out.println("Введите размеры первой матрицы:");
        int n1 = scanner.nextInt();
        int m1 = scanner.nextInt();
        int[][] matrixA = readMatrix(scanner, n1, m1);

        System.out.println("Введите размеры второй матрицы:");
        int n2 = scanner.nextInt();
        int m2 = scanner.nextInt();

        if (m1 != n2) {
            System.out.println("ERROR: Количество столбцов первой матрицы должно быть равно количеству строк второй.");
            return;
        }

        int[][] matrixB = readMatrix(scanner, n2, m2);

        int[][] result = multiplyMatrices(matrixA, matrixB);
        printMatrix(result);
    }

    private static int[][] multiplyMatrix(int[][] matrix, int constant) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = matrix[i][j] * constant;
            }
        }
        return result;
    }

    private static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
        int n1 = matrixA.length;
        int m1 = matrixA[0].length;
        int m2 = matrixB[0].length;
        int[][] result = new int[n1][m2];

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m2; j++) {
                for (int k = 0; k < m1; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return result;
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

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
