package pl.sdacademy.unit.test.advance.exercises.task1;

public class Calculator {

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double division(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("b can't be 0");
        }
        return a / b;
    }
}
