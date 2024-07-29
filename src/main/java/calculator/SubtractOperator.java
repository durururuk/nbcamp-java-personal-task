package calculator;

public class SubtractOperator extends ArithmeticCalculator {

    @Override
    public double calculate(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }
}
