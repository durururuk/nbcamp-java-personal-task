package calculator;

public class MultiplyOperator implements ArithmeticCalculator {

    @Override
    public double calculate(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }
}
