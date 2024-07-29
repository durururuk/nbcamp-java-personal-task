package calculator;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
    private final Queue<Double> resultQueue;
    private final Queue<Double> circleResultQueue;
    private static final double pi = 3.141592;
    //외부에서 resultQueue와 circleResultQueue를 수정할 수 없도록 private final로 설정
    // pi의 경우에는 절대 불변의 상수임으로 private static final로 설정


    public Calculator() {
        this.resultQueue = new LinkedList<>();
        this.circleResultQueue = new LinkedList<>();
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
            System.out.println("저장돤 결괏값은 다음과 같습니다..");
            System.out.print("[ ");
            for (Double resultValue : resultQueue) {
                System.out.print(resultValue + ", ");
            }
            System.out.print("]");
            System.out.println();
        } else {
            System.out.println("저장돤 결괏값은 다음과 같습니다..");
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





    //인스턴트 필드 사용 없이 입력된 매개변수만 가지고 계산을 실행함으로 static 메서드로 설정
    public static double calculate (int firstNumber, int secondNumber, char operator) throws InvalidOperatorException {
        switch (operator) {
            case '+' :
               return firstNumber + secondNumber;

            case '-' :
                return firstNumber - secondNumber;

            case '*' :
                return firstNumber * secondNumber;

            case '/' :
                try {
                    return (double) firstNumber / secondNumber;

                } catch(ArithmeticException e) {
                    System.out.println("0으로는 나눌 수 없습니다.");
                    return Double.NaN;
                }

            default:
                throw new InvalidOperatorException("입력이 올바르지 않습니다.");
        }
    }

    public static double calculate(int radius) {
        return (double) radius * radius * pi;
    }
}
