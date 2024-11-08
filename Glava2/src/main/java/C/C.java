package C;

import java.util.*;
import java.util.stream.IntStream;

public class C {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Романов Альберт Б762-2");
        System.out.println("06.06.24 16:66");
        System.out.println("07.07.24 17:77");

        System.out.print("Введите размерность матрицы n: ");
        int n = scanner.nextInt();

        int[][] matrix = generateMatrix(n);

        System.out.println("Сгенерированная матрица:");
        printMatrix(matrix);

        // 1. Упорядочить строки/столбцы по значениям k-й строки/столбца
        System.out.print("Введите номер строки или столбца для сортировки: ");
        int k = scanner.nextInt();
        sortMatrixByRowOrColumn(matrix, k);
        System.out.println("Матрица после сортировки по строке/столбцу " + k + ":");
        printMatrix(matrix);

        // 2. Циклический сдвиг матрицы
        System.out.print("Введите число позиций для сдвига: ");
        int shift = scanner.nextInt();
        System.out.print("Введите направление сдвига (вправо, влево, вверх, вниз): ");
        String direction = scanner.next();
        shiftMatrix(matrix, shift, direction);
        System.out.println("Матрица после сдвига:");
        printMatrix(matrix);

        // 3. Наибольшая последовательность возрастающих/убывающих элементов
        int maxSequence = findMaxIncreasingDecreasingSequence(matrix);
        System.out.println("Максимальная последовательность возрастающих/убывающих элементов: " + maxSequence);

        // 4. Сумма элементов между первым и вторым положительными элементами каждой строки
        System.out.println("Суммы между первым и вторым положительными элементами каждой строки:");
        for (int i = 0; i < n; i++) {
            int sum = sumBetweenFirstTwoPositives(matrix[i]);
            System.out.println("Строка " + i + ": " + sum);
        }

        // 5. Заполнение матрицы от 1 до k
        System.out.print("Введите k для заполнения матрицы:");
        k = scanner.nextInt();
        fillMatrixNxN(matrix, k);
        System.out.println("Матрица, заполненная числами от 1 до " + k + ":");
        printMatrix(matrix);

        // 6. Округление всех элементов
        roundMatrix(matrix);
        System.out.println("Матрица после округления:");
        printMatrix(matrix);

        // 7. Поворот матрицы на 90, 180 или 270 градусов
        System.out.print("Введите угол поворота матрицы (90, 180, 270): ");
        int angle = scanner.nextInt();
        matrix = rotateMatrix(matrix, angle);
        System.out.println("Матрица после поворота на " + angle + " градусов:");
        printMatrix(matrix);

        // 8. Определитель (для n=2 или n=3)
        if (n == 2 || n == 3) {
            int determinant = calculateDeterminant(matrix);
            System.out.println("Определитель матрицы: " + determinant);
        } else {
            System.out.println("Определитель поддерживается только для размерности 2 или 3.");
        }

        // 9. Вычитание среднего по строке
        int[][] meanSubtractedMatrix = subtractRowMean(matrix);
        System.out.println("Матрица после вычитания среднего значения строк:");
        printMatrix(meanSubtractedMatrix);

    }

    private static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rand.nextInt(2 * n + 1) - n;
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    private static void sortMatrixByRowOrColumn(int[][] matrix, int k) {
    }

    private static void shiftMatrix(int[][] matrix, int shift, String direction) {
    }

    private static int findMaxIncreasingDecreasingSequence(int[][] matrix) {
        return 0;
    }

    private static int sumBetweenFirstTwoPositives(int[] row) {
        int first = -1, second = -1, sum = 0;
        for (int i = 0; i < row.length; i++) {
            if (row[i] > 0) {
                if (first == -1) {
                    first = i;
                } else if (second == -1) {
                    second = i;
                    break;
                }
            }
        }
        if (first != -1 && second != -1) {
            for (int i = first + 1; i < second; i++) {
                sum += row[i];
            }
        }
        return sum;
    }

    private static void fillMatrixNxN(int[][] matrix, int k) {
        for (int i = 0, num = 1; i < matrix.length && num <= k; i++) {
            for (int j = 0; j < matrix[i].length && num <= k; j++) {
                matrix[i][j] = num++;
            }
        }
    }

    private static void roundMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Math.round(matrix[i][j]);
            }
        }
    }

    private static int[][] rotateMatrix(int[][] matrix, int angle) {
        return matrix;
    }

    private static int calculateDeterminant(int[][] matrix) {
        return 0;
    }

    private static int[][] subtractRowMean(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            double mean = Arrays.stream(matrix[i]).average().orElse(0);
            for (int j = 0; j < matrix[i].length; j++) {
                result[i][j] = matrix[i][j] - (int)mean;
            }
        }
        return result;
    }
}

