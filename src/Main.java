public class Main {

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.performOperation(10.5);
        calc.performOperation(Calculator.ADD);
        calc.performOperation(5.2);
        calc.performOperation(Calculator.MUL);
        calc.performOperation(10);
        calc.performOperation(Calculator.ADD);
        calc.performOperation(8);
        calc.performOperation(Calculator.DIV);
        calc.performOperation(2);
        calc.performOperation(Calculator.SUB);
        calc.performOperation(7);
        calc.performOperation(Calculator.EQU);
        System.out.println(calc.getResults());
    }
//      10.5 + 5.2 * 10 + 8 / 2 - 7 =
}
