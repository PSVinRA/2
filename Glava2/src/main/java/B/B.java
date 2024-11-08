package B;

import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Романов Альберт Б762-2");
        System.out.println("06.06.24 16:66");
        System.out.println("07.07.24 17:77");

        // 1. Вывести на экран таблицу умножения.
        System.out.println("Таблица умножения:");
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }

        // 2. Вывести элементы массива в обратном порядке.
        System.out.println("\nВведите размер массива:");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println("Массив в обратном порядке:");
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        // 3. Определить принадлежность некоторого значения k интервалам (n, m], [n,m), (n, m), [n, m].
        System.out.println("\nВведите значения n, m и k:");
        int nInt = scanner.nextInt();
        int mInt = scanner.nextInt();
        int k = scanner.nextInt();
        System.out.println("k принадлежит (n, m]: " + (k > nInt && k <= mInt));
        System.out.println("k принадлежит [n, m): " + (k >= nInt && k < mInt));
        System.out.println("k принадлежит (n, m): " + (k > nInt && k < mInt));
        System.out.println("k принадлежит [n, m]: " + (k >= nInt && k <= mInt));

        // 4. Вывести на экран все числа от 1 до 100, которые делятся на 3 без остатка.
        System.out.println("\nЧисла от 1 до 100, делящиеся на 3:");
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        // 5. Сколько значащих нулей в двоичной записи числа 129?
        int number = 129;
        String binaryString = Integer.toBinaryString(number);
        long significantZeros = binaryString.chars().filter(c -> c == '0').count();
        System.out.println("\nЧисло 129 в двоичной записи: " + binaryString);
        System.out.println("Количество значащих нулей: " + significantZeros);

        // 6. В системе счисления с некоторым основанием десятичное число 81 записывается в виде 100. Найти это основание.
        int decimalNumber = 81;
        int base = 2;
        while (true) {
            String representation = Integer.toString(decimalNumber, base);
            if (representation.equals("100")) {
                break;
            }
            base++;
        }
        System.out.println("\nОснование системы счисления для 81, записанного как 100: " + base);

        // 7. Написать код программы, которая бы переводила числа из десятичной системы счисления в любую другую.
        System.out.println("\nВведите число и основание для перевода:");
        int decimalToConvert = scanner.nextInt();
        int targetBase = scanner.nextInt();
        System.out.println("Число " + decimalToConvert + " в системе с основанием " + targetBase + ": " +
                Integer.toString(decimalToConvert, targetBase));

        // 8. Написать код программы, которая бы переводила числа одной любой системы счисления в любую другую.
        System.out.println("\nВведите число, его основание и целевое основание:");
        String numberToConvert = scanner.next();
        int sourceBase = scanner.nextInt();
        targetBase = scanner.nextInt();
        int decimalValue = Integer.parseInt(numberToConvert, sourceBase);
        System.out.println("Число " + numberToConvert + " из системы " + sourceBase +
                " в системе с основанием " + targetBase + ": " +
                Integer.toString(decimalValue, targetBase));

        // 9. Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу. Осуществить проверку корректности ввода чисел.
        System.out.println("\nВведите номер месяца (1-12):");
        int monthNumber = scanner.nextInt();
        if (monthNumber < 1 || monthNumber > 12) {
            System.out.println("Некорректный номер месяца.");
        } else {
            String[] months = {
                    "Январь", "Февраль", "Март", "Апрель", "Май", "Июнь",
                    "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"
            };
            System.out.println("Месяц: " + months[monthNumber - 1]);
        }

        scanner.close();
    }
}
