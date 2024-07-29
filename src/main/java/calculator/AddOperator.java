package calculator;

public class AddOperator extends ArithmeticCalculator {

    @Override
    public double calculate(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }
}
