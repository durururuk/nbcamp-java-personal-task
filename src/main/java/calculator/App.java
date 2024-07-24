package calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;

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
        char symbol = sc.next().charAt(0);
        sc.nextLine();

        /* switch를 사용해서 연산을 실행하고 결과값을 출력합니다..*/
        switch (symbol) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;

            case 'X':
                result = num1 * num2;
                break;

            case '/':
                if (num2 == 0) {
                    System.out.println("0으로는 나눌 수 없습니다.");
                    break;
                } else {
                    result = num1 / num2;
                    break;
                }

            default:
                System.out.println("입력이 올바르지 않습니다.");
                break;


        }
        System.out.println("결과: " + result);

    }
}
