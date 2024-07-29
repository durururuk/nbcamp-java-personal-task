package calculator;

public class SubtractOperator implements ArithmeticCalculator {

    @Override
    public double calculate(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }
}
