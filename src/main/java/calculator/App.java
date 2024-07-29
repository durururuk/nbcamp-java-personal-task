package calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double result = 0;
        Calculator cal = new Calculator();
        int num1;
        int num2;
        int radius;
        boolean isCircle;

            //전체 반복문
            while (true) {
                isCircle = false;
                //입력이 올바르지 않으면 올바를 때까지 반복
                while (true) {
                    System.out.println("'원의 넓이'를 계산할지 '사칙연산'을 계산할지 입력해주세요.");
                    String whatCal = sc.nextLine();

                    if (whatCal.equals("사칙연산")) {
                        //사칙연산 수행 후 출력
                        System.out.print("첫 번째 숫자를 입력하세요: ");
                        num1 = sc.nextInt();
                        sc.nextLine();
                        System.out.print("두 번째 숫자를 입력하세요: ");
                        num2 = sc.nextInt();
                        sc.nextLine();
                        System.out.print("사칙연산 기호를 입력하세요: ");
                        char operator = sc.nextLine().charAt(0);
                        try {
                            result = cal.operation(operator,num1,num2);
                        } catch (Exception e) {
                            e.getMessage();
                        }
                        System.out.println("결과: " + result);
                        System.out.println();
                        cal.setQueue("fbo", result);
                        break;


                        //원의 넓이 계산 후 출력
                    } else if (whatCal.equals("원의 넓이")) {
                        isCircle = true;
                        System.out.println("원의 반지름을 입력해주세요.");
                        radius = sc.nextInt();
                        sc.nextLine();
                        result = cal.circle.calculate(radius);
                        System.out.println("결과: " + result);
                        System.out.println();
                        cal.setQueue("circle", result);
                        cal.getQueue("circle");
                        break;


                    } else {
                        System.out.println("입력이 올바르지 않습니다.");
                    }
                }





            System.out.print("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제) : ");
            String remove = sc.nextLine();
            if (remove.equals("remove")) {
                //원의 넓이를 계산했을 경우
                if(isCircle) {
                    System.out.println("가장 먼저 저장된 원의 넓이 연산 결과를 삭제합니다.");
                    cal.pollResult("circle");
                }   //사칙연산을 수행했을 경우
                    else {
                    System.out.println("가장 먼저 저장된 사칙 연산 연산 결과를 삭제합니다.");
                    cal.pollResult("FBO");
                }

            } else {
                System.out.println("가장 먼저 저장된 연산 결과를 삭제하지 않습니다.");
            }

            if(!isCircle) {
            System.out.print("저장된 사칙연산 결과를 조회하시겠습니까? (inquiry 입력 시 조회) : ");
            String inquiry = sc.nextLine();
            if (inquiry.equals("inquiry")) {
                cal.getQueue("FBO");
            } }

            System.out.println();
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) : ");
            /* exit을 입력 받으면 반복 종료 */
            String ctn = sc.nextLine();
            if (ctn.equals("exit")) {
                System.out.println("계산을 종료합니다.");
                break;
            } else {
                System.out.println("계산을 게속합니다.");
                System.out.println();
            }

        }

    }
}
