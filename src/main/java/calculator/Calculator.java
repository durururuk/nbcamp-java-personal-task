package calculator;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
    double result = 0;
    Queue<Double> resultQueue = new LinkedList<>();
    
    public void resultQueue() {
        this.resultQueue = resultQueue;
    }

    public double calculate (int firstNumber, int secondNumber, char operator) throws InvalidOperatorException {
        switch (operator) {
            case '+' :
                result = firstNumber + secondNumber;
                resultQueue.add(result);
                return result;

            case '-' :
                result = firstNumber - secondNumber;
                resultQueue.add(result);
                return result;

            case '*' :
                result = firstNumber * secondNumber;
                resultQueue.add(result);
                return result;

            case '/' :
                try {
                    result = (double) firstNumber / secondNumber;

                } catch(ArithmeticException e) {
                    System.out.println("0으로는 나눌 수 없습니다.");
                    return Double.NaN;
                }

                    resultQueue.add(result);
                    return result;




            default:
                throw new InvalidOperatorException("연산자가 올바르지 않습니다.");


        }
    }
}
