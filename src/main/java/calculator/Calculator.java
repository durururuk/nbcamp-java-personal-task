package calculator;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
    //객체가 초기화되고도 변경될 필요가 없는 요소들이고, 캡슐화를 유지시키고 싶어서 private final을 사용하였습니다.
    private final Queue<Double> resultQueue;
    private final Queue<Double> circleResultQueue;
    private final ArithmeticCalculator add = new AddOperator();
    private final ArithmeticCalculator sub = new SubtractOperator();
    private final ArithmeticCalculator multi = new MultiplyOperator();
    private final ArithmeticCalculator div = new DivideOperator();
    private final ArithmeticCalculator mod = new ModOperator();
    private final CircleCalculator circle = new CircleCalculator();

    public Calculator() {
        resultQueue = new LinkedList<>();
        circleResultQueue = new LinkedList<>();
    }




    //가장 먼저 저장된 결과값을 삭제하기
    public void pollResult(String what) {
        if(what.equals("FBO")) {
            resultQueue.poll();
        } else {
            circleResultQueue.poll();
        }

    }

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
        return switch (operator) {
            case '+' -> add.calculate(firstNumber, secondNumber);
            case '-' -> sub.calculate(firstNumber, secondNumber);
            case '*' -> multi.calculate(firstNumber, secondNumber);
            case '/' -> div.calculate(firstNumber, secondNumber);
            case '%' -> mod.calculate(firstNumber, secondNumber);
            default -> {
                System.out.println("연산자가 올바르지 않습니다.");
                yield 0;
            }
        };
    }

    public double calculate(int radius) {
        return circle.calculate(radius);
    }






}
