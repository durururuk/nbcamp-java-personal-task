package calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double result = 0;
        int resultCount = 0;
        Calculator cal = new Calculator();
        int num1 = 0;
        int num2 = 0;

        while(true) {

            System.out.print("첫 번째 숫자를 입력하세요: ");
            num1 = sc.nextInt();
            sc.nextLine();
            System.out.print("두 번째 숫자를 입력하세요: ");
            num2 = sc.nextInt();
            sc.nextLine();
            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);
            sc.nextLine();


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
                cal.pollResult();
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
                for (Double resultValue : cal.getResultQueue()) {
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
                break;
            }

        }

    }
}
