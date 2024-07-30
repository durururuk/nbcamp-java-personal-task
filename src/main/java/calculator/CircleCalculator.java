package calculator;

public class CircleCalculator {
    //파이는 절대불변의 상수라 static final을 사용했습니다.
    private static final double pi = 3.141592;

    public double calculate(int radius) {
        return (double) radius * radius * pi;
    }
}
