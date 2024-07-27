package calculator;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
    private double result = 0;
    private final Queue<Double> resultQueue = new LinkedList<>();

    public double getResult() {
        return result;
    }

    public Queue<Double> getResultQueue() {
        return new LinkedList<>(resultQueue);
    }

    public void pollResult() {
        resultQueue.poll();
    }

    public void inQuiry() {
        System.out.println("저장돤 결괏값은 다음과 같습니다..");
        System.out.print("[ ");
        for (Double resultValue : resultQueue) {
            System.out.print(resultValue + ", ");
        }
        System.out.print("]");
        System.out.println();
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
                throw new InvalidOperatorException("입력이 올바르지 않습니다.");


        }
    }
}
