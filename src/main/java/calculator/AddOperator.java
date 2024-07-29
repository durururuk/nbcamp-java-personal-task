package calculator;

public class AddOperator implements ArithmeticCalculator {

    @Override
    public double calculate(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }
}
