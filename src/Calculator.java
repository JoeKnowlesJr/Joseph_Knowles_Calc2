import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class Calculator implements Serializable {
    static final String ADD = "+";
    static final String SUB = "-";
    static final String MUL = "*";
    static final String DIV = "/";
    static final String EQU = "=";

    Calculator() {
    }

    private static final String validOperators = "^/*+-=";
    private List<String> operators = new ArrayList<>();
    private List<Double> operands = new ArrayList<>();

    void performOperation(double operand) {
        operands.add(operand);
    }

    void performOperation(String operator) {
        if (!(validOperators.contains(operator))) {
            System.out.printf(Locale.getDefault(), "Invalid operator! - %s", operator);
            return;
        }
        operators.add(operator);
    }

    Object getResults() {
        int opIdx;
        do {
            opIdx = operators.indexOf(DIV);
            if (opIdx != -1) {
                double result = (operands.get(opIdx) / operands.get(opIdx + 1));
                operands.remove(opIdx + 1);
                operands.remove(opIdx);
                operands.add(0, result);
                operators.remove(opIdx);
            } else {
                opIdx = operators.indexOf(MUL);
                if (opIdx != -1) {
                    double result = (operands.get(opIdx) * operands.get(opIdx + 1));
                    operands.remove(opIdx + 1);
                    operands.remove(opIdx);
                    operands.add(0, result);
                    operators.remove(opIdx);
                } else {
                    opIdx = operators.indexOf(ADD);
                    if (opIdx != -1) {
                        double result = (operands.get(opIdx) + operands.get(opIdx + 1));
                        operands.remove(opIdx + 1);
                        operands.remove(opIdx);
                        operands.add(0, result);
                        operators.remove(opIdx);
                    } else {
                        opIdx = operators.indexOf(SUB);
                        if (opIdx != -1) {
                            double result = (operands.get(opIdx) - operands.get(opIdx + 1));
                            operands.remove(opIdx + 1);
                            operands.remove(opIdx);
                            operands.add(0, result);
                            operators.remove(opIdx);
                        } else {
                            opIdx = operators.indexOf(EQU);
                            if (opIdx != -1) {
                                if (operands.size() == 1) return operands.get(0);
                            }
                        }
                    }
                }
            }
        } while (opIdx != -1) ;
        return "Incomplete statement!";
    }
}