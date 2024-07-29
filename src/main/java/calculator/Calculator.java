package calculator;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
    private final Queue<Double> resultQueue;
    private final Queue<Double> circleResultQueue;
    ArithmeticCalculator add = new AddOperator();
    ArithmeticCalculator sub = new SubtractOperator();
    ArithmeticCalculator multi = new MultiplyOperator();
    ArithmeticCalculator div = new DivideOperator();
    ArithmeticCalculator mod = new ModOperator();
    CircleCalculator circle;

    public Calculator() {
        this.resultQueue = new LinkedList<>();
        this.circleResultQueue = new LinkedList<>();
        this.circle = new CircleCalculator();
    }




    //가장 먼저 저장된 결과값을 삭제하기
    public void pollResult(String what) {
        if(what.equals("FBO")) {
            resultQueue.poll();
        } else {
            circleResultQueue.poll();
        }

    }

    //저장된 결과값 보기
    public void getQueue(String what) {
        if (what.equals("FBO")) {
            System.out.println("저장된 결과값은 다음과 같습니다..");
            System.out.print("[ ");
            for (Double resultValue : resultQueue) {
                System.out.print(resultValue + ", ");
            }
            System.out.print("]");
            System.out.println();
        } else {
            System.out.println("저장된 결과값은 다음과 같습니다..");
            System.out.print("[ ");
            for (Double resultValue : circleResultQueue) {
                System.out.print(resultValue + ", ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    //결과값 저장하기
    public void setQueue(String what, double result) {
        if (what.equals("circle")) {
            circleResultQueue.add(result);
        } else{
            resultQueue.add(result);
        }
    }

    public double operation(char operator, int firstNumber, int secondNumber) {
        switch (operator) {
            case '+' : return add.calculate(firstNumber, secondNumber);
            case '-' : return sub.calculate(firstNumber, secondNumber);
            case '*' : return multi.calculate(firstNumber,secondNumber);
            case '/' : return div.calculate(firstNumber,secondNumber);
            case '%' : return mod.calculate(firstNumber, secondNumber);
            default :
                System.out.println("연산자가 올바르지 않습니다.");
                return 0;
        }
    }





}
