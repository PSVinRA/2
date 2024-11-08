package A;

import java.util.*;
import java.util.stream.Collectors;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Романов Альберт Б762-2");
        System.out.println("06.06.24 16:66");
        System.out.println("07.07.24 17:77");

        System.out.println("Введите количество чисел:");
        int n = scanner.nextInt();
        String[] numbers = new String[n];
        System.out.println("Введите числа:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.next();
        }

        // 1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину
        String shortest = Arrays.stream(numbers).min(Comparator.comparingInt(String::length)).orElse("");
        String longest = Arrays.stream(numbers).max(Comparator.comparingInt(String::length)).orElse("");
        System.out.println("Самое короткое число: " + shortest + " (длина " + shortest.length() + ")");
        System.out.println("Самое длинное число: " + longest + " (длина " + longest.length() + ")");

        // 2. Упорядочить и вывести числа в порядке возрастания (убывания) значений их длины.
        List<String> sortedAsc = Arrays.stream(numbers)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        List<String> sortedDesc = Arrays.stream(numbers)
                .sorted(Comparator.comparingInt(String::length).reversed())
                .collect(Collectors.toList());
        System.out.println("Числа по длине (возрастание): " + sortedAsc);
        System.out.println("Числа по длине (убывание): " + sortedDesc);

        // 3. Вывести на консоль те числа, длина которых меньше (больше) средней, а также длину.
        double averageLength = Arrays.stream(numbers).mapToInt(String::length).average().orElse(0);
        System.out.println("Средняя длина чисел: " + averageLength);
        System.out.println("Числа, длина которых меньше средней:");
        Arrays.stream(numbers).filter(num -> num.length() < averageLength)
                .forEach(num -> System.out.println(num + " (длина " + num.length() + ")"));
        System.out.println("Числа, длина которых больше средней:");
        Arrays.stream(numbers).filter(num -> num.length() > averageLength)
                .forEach(num -> System.out.println(num + " (длина " + num.length() + ")"));

        // 4. Найти число, в котором число различных цифр минимально. Если таких чисел несколько, найти первое из них.
        String minUniqueDigitsNumber = Arrays.stream(numbers).min(Comparator.comparingInt(A::countUniqueDigits)).orElse("");
        System.out.println("Число с минимальным количеством различных цифр: " + minUniqueDigitsNumber);

        // 5. Найти количество чисел, содержащих только четные цифры, а среди них — количество чисел с равным числом четных и нечетных цифр.
        long evenOnlyCount = Arrays.stream(numbers).filter(A::isAllEvenDigits).count();
        long evenOddEqualCount = Arrays.stream(numbers).filter(num -> isAllEvenDigits(num) && hasEqualEvenOddDigits(num)).count();
        System.out.println("Количество чисел с только четными цифрами: " + evenOnlyCount);
        System.out.println("Количество чисел с равным числом четных и нечетных цифр среди них: " + evenOddEqualCount);

        // 6. Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.
        String increasingDigitsNumber = Arrays.stream(numbers).filter(A::isIncreasingDigits).findFirst().orElse("Нет такого числа");
        System.out.println("Число с цифрами в порядке возрастания: " + increasingDigitsNumber);

        // 7. Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.
        String uniqueDigitsNumber = Arrays.stream(numbers).filter(A::hasAllUniqueDigits).findFirst().orElse("Нет такого числа");
        System.out.println("Число, состоящее только из различных цифр: " + uniqueDigitsNumber);

        // 8. Среди чисел найти число-палиндром. Если таких чисел больше одного, найти второе.
        List<String> palindromes = Arrays.stream(numbers).filter(A::isPalindrome).collect(Collectors.toList());
        if (palindromes.size() >= 2) {
            System.out.println("Второе число-палиндром: " + palindromes.get(1));
        } else if (palindromes.size() == 1) {
            System.out.println("Только одно число-палиндром: " + palindromes.get(0));
        } else {
            System.out.println("Числа-палиндромы отсутствуют");
        }

        // 9. Найти корни квадратного уравнения. Параметры уравнения передавать с командной строкой.
        if (args.length >= 3) {
            try {
                double a = Double.parseDouble(args[0]);
                double b = Double.parseDouble(args[1]);
                double c = Double.parseDouble(args[2]);
                solveQuadraticEquation(a, b, c);
            } catch (NumberFormatException e) {
                System.out.println("Параметры уравнения должны быть числами.");
            }
        } else {
            System.out.println("Для решения квадратного уравнения введите параметры a, b, c через командную строку.");
        }
    }

    private static int countUniqueDigits(String number) {
        return (int) number.chars().distinct().count();
    }

    private static boolean isAllEvenDigits(String number) {
        return number.chars().allMatch(ch -> (ch - '0') % 2 == 0);
    }

    private static boolean hasEqualEvenOddDigits(String number) {
        long evenCount = number.chars().filter(ch -> (ch - '0') % 2 == 0).count();
        long oddCount = number.length() - evenCount;
        return evenCount == oddCount;
    }

    private static boolean isIncreasingDigits(String number) {
        for (int i = 1; i < number.length(); i++) {
            if (number.charAt(i) <= number.charAt(i - 1)) return false;
        }
        return true;
    }

    private static boolean hasAllUniqueDigits(String number) {
        return countUniqueDigits(number) == number.length();
    }

    private static boolean isPalindrome(String number) {
        return new StringBuilder(number).reverse().toString().equals(number);
    }

    private static void solveQuadraticEquation(double a, double b, double c) {
        double discriminant = b * b - 4 * a * c;
        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Корни уравнения: x1 = " + root1 + ", x2 = " + root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.println("Единственный корень уравнения: x = " + root);
        } else {
            System.out.println("Корней нет (дискриминант отрицательный).");
        }
    }
}

