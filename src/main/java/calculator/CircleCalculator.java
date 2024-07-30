package calculator;

public class CircleCalculator {
    private static final double pi = 3.141592;

    //객체화를 할 필요 없이 바로 꺼내쓸 수 있도록 static을 사용했습니다.
    public static double calculate(int radius) {
        return (double) radius * radius * pi;
    }
}
