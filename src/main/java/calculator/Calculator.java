package calculator;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.util.ArrayList;

public class Calculator {
    double result = 0;
    ArrayList<Double> resultArr = new ArrayList<Double>();

    public double calculate (int firstNumber, int secondNumber, char operator) throws InvalidOperatorException {
        switch (operator) {
            case '+' :
                result = firstNumber + secondNumber;
                resultArr.add(result);
                return result;

            case '-' :
                result = firstNumber + secondNumber;
                resultArr.add(result);
                return result;

            case '*' :
                result = firstNumber + secondNumber;
                resultArr.add(result);
                return result;

            case '/' :
                try {
                    result = firstNumber / secondNumber;

                } catch(ArithmeticException e) {
                    System.out.println("0으로는 나눌 수 없습니다.");
                    return Double.NaN;
                }

                    resultArr.add(result);
                    return result;




            default:
                throw new InvalidOperatorException("연산자가 올바르지 않습니다.");


        }
    }
}
