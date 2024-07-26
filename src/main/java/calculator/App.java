package calculator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Spliterator;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double result = 0;
        boolean check = true;
        int resultCount = 0;
        Calculator cal = new Calculator();

        while(check = true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            int num1 = sc.nextInt();
            sc.nextLine();
            System.out.print("두 번째 숫자를 입력하세요: ");
            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            int num2 = sc.nextInt();
            sc.nextLine();
            System.out.print("사칙연산 기호를 입력하세요: ");
            // 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다.
            char operator = sc.next().charAt(0);
            sc.nextLine();

            /* switch를 사용해서 연산을 실행하고 결과값을 출력합니다..*/
            try {
                result = cal.calculate(num1,num2,operator);
            } catch (InvalidOperatorException e) {
                throw new RuntimeException(e);
            }
            System.out.println("결과: " + result);
            System.out.println();

            System.out.print("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제) : ");
            String remove = sc.nextLine();
            if (remove.equals("remove")) {
                System.out.println("가장 먼저 저장된 연산 결과를 삭제합니다.");
                cal.resultQueue.poll();
                if (resultCount == 0) {continue;} else{resultCount--;}
            } else {
                System.out.println("가장 먼저 저장된 연산 결과를 삭제하지 않습니다.");
            }

            System.out.println("현재 저장된 결과값의 갯수 : " + (resultCount + 1));
                resultCount++;
            System.out.println();

            System.out.print("저장된 연산 결과를 조회하시겠습니까? (inquiry 입력 시 조회) : ");
            String inquiry = sc.nextLine();
            if (inquiry.equals("inquiry")) {
                System.out.println("저장돤 결괏값은 다음과 같습니다..");
                System.out.print("[ ");
                for (Double resultValue : cal.resultQueue) {
                    System.out.print(resultValue + ", ");
                }
                System.out.print("]");
                System.out.println();
            }

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) : ");
            /* exit을 입력 받으면 반복 종료 */
            String ctn = sc.nextLine();
            if (ctn.equals("exit")) {
                System.out.println("계산을 종료합니다.");
                break;
            } else {
                System.out.println("계산을 게속합니다.");
                System.out.println();
                result = 0;
            }

        }

    }
}
