package AopPracticeXML;

public class MyCalculatorImpl {

    public int add(int a, int b) {
        return a + b;
    }

    public void min(int a, int b) {
        System.out.println(a + '-' + b + "=" + (a - b));
    }

}
