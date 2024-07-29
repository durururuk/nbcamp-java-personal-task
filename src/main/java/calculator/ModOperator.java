package calculator;

public class ModOperator extends ArithmeticCalculator {

    @Override
    public double calculate(int firstNumber, int secondNumber) {
        try {
            return (double) firstNumber % secondNumber;
        } catch(ArithmeticException e) {
            System.out.println("0으로는 나눌 수 없습니다!");
            return Double.NaN;
        }
    }
}


