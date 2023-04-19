import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RationalNumber rn1, rn2, rnResult;
        ComplexNumber cn1, cn2, cnResult;

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1 - Сложение");
            System.out.println("2 - Вычитание");
            System.out.println("3 - Умножение");
            System.out.println("4 - Деление");
            System.out.println("0 - Выход");

            int choice = scanner.nextInt();
            if (choice == 0) {
                break;
            }

            System.out.println("Введите первое число:");
            System.out.println("Введите числитель:");
            int numerator1 = scanner.nextInt();
            System.out.println("Введите знаменатель:");
            int denominator1 = scanner.nextInt();
            rn1 = new RationalNumber(numerator1, denominator1);
            System.out.println("Введите второе число:");
            System.out.println("Введите числитель:");
            int numerator2 = scanner.nextInt();
            System.out.println("Введите знаменатель:");
            int denominator2 = scanner.nextInt();
            rn2 = new RationalNumber(numerator2, denominator2);

            switch (choice) {
                case 1:
                    rnResult = rn1.add(rn2);
                    System.out.println("Результат: " + rnResult);
                    break;
                case 2:
                    rnResult = rn1.subtract(rn2);
                    System.out.println("Результат: " + rnResult);
                    break;
                case 3:
                    rnResult = rn1.multiply(rn2);
                    System.out.println("Результат: " + rnResult);
                    break;
                case 4:
                    rnResult = rn1.divide(rn2);
                    System.out.println("Результат: " + rnResult);
                    break;
                default:
                    System.out.println("Неверный выбор");
                    break;
            }
        }

        scanner.close();
    }
}

public abstract class Number {
    public abstract Number add(Number other);
    public abstract Number subtract(Number other);
    public abstract Number multiply(Number other);
    public abstract Number divide(Number other);
}

public class RationalNumber extends Number {
    private int numerator;
    private int denominator;

    public RationalNumber(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public RationalNumber add(RationalNumber other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new RationalNumber(newNumerator, newDenominator);
    }

    public RationalNumber subtract(RationalNumber other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new RationalNumber(newNumerator, newDenominator);
    }

    public RationalNumber multiply(RationalNumber other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new RationalNumber(newNumerator, newDenominator);
    }

    public RationalNumber divide(RationalNumber other) {
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new RationalNumber(newNumerator, newDenominator);
    }

    public String toString() {
        return numerator + "/" + denominator;
    }
}

