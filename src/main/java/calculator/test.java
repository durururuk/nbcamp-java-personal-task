package calculator;

public class test {
    public static void main(String[] args) {
        Calculator cal = new Calculator();

        double result;
        try {
            result = cal.calculate(10,2,'/');
        } catch (InvalidOperatorException e) {
            throw new RuntimeException(e);
        }
        System.out.println(result);
    }
}
