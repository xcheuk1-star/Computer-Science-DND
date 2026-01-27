import java.util.ArrayList;

public class Arithmetic {

    // Evaluates a String exp that has an arithmetic expression, written in
    // classic notation
    public static int evaluate(String exp) {
        String converted = convertClassicToStout(exp);
        int toReturn = evaluateStout(converted);
        return toReturn;
    }

    // Returns the result of doing operand1 operation operand2,
    // e.g. operate(5, 2, "-") should return 3
    public static int operate(int operand1, int operand2, String operation) {
        if (operation.equals("-")) {
            return operand1 - operand2;
        }
        if (operation.equals("+")) {
            return operand1 + operand2;
        }
        if (operation.equals("*")) {
            return operand1 * operand2;
        }
        if (operation.equals("/")) {
            return operand1 / operand2;
        }
        if (operation.equals("%")) {
            return operand1 % operand2;
        }
        if (operation.equals("^")) {
            return operand1 ^ operand2;
        } else {
            return 1;
        }
    }

    // Evaluates a String exp that has an arithmetic expression written in STOUT
    // notation
    public static int evaluateStout(String exp) {
        char[] eq = exp.toCharArray();
        String rank = "^*%/+-";
        MyStack<String> toEval = new MyStack<String>();
        for (int i = 0; i < eq.length; i++) {
            if (eq[i] == ' ') {
                continue;
            }
            if (rank.indexOf(eq[i]) == -1 && eq[i + 1] == ' ') {
                toEval.push(Character.toString(eq[i]));
                continue;
            }
            if (eq[i] == '-' && eq[i + 1] != ' ') {
                String toAdd = "";
                for (int j = i; eq[j] != ' '; j++) {
                    toAdd = toAdd + String.valueOf(eq[j]);
                    i = j;
                }
                toEval.push(toAdd);
                continue;
            }
            if (rank.indexOf(eq[i]) == -1 && eq[i + 1] != ' ') {
                String toAdd = "";
                for (int j = i; eq[j] != ' '; j++) {
                    toAdd = toAdd + String.valueOf(eq[j]);
                    i = j;
                }
                toEval.push(toAdd);
                continue;
            }
            if (rank.indexOf(eq[i]) != -1) {
                String op = Character.toString(eq[i]).trim();
                int num2 = Integer.parseInt(toEval.pop());
                int num1 = Integer.parseInt(toEval.pop());
                int sol = operate(num1, num2, op);
                toEval.push(Integer.toString(sol));
                continue;
            }
        }
        return Integer.parseInt(toEval.peek());
    }

    public static String convertClassicToStout(String exp) {
        MyStack<Character> ops = new MyStack<Character>();
        char[] eq = exp.toCharArray();
        StringBuilder stout = new StringBuilder();
        String rank = "^*%/+-()";
        for (int i = 0; i < eq.length; i++) {
            char on = eq[i];
            if (rank.indexOf(on) == -1) {
                stout.append(on);
                continue;
            }
            if (on == '-' && eq[i + 1] != ' ') {
                stout.append(on);
                stout.append(eq[i + 1]);
                i = i + 1;
            } else {
                if (ops.isEmpty()) {
                    ops.push(on);
                    continue;
                }
                if (on == ')') {
                    while (!ops.isEmpty() && ops.peek() != '(') {
                        stout.append(" " + ops.pop() + " ");
                    }
                    if (!ops.isEmpty() && ops.peek() == '(') {
                        ops.pop();
                    }
                }
                if (compareOps(on, ops.peek()) == true || on == '(') {
                    ops.push(on);
                    continue;
                }
                if (compareOps(on, ops.peek()) == false) {
                    while (ops.isEmpty() == false && compareOps(on, ops.peek()) == false) {
                        if (ops.peek() != '(' && ops.peek() != ')') {
                            stout.append(" " + ops.pop() + " ");
                        } else {
                            ops.pop();
                        }
                    }
                    ops.push(on);
                    continue;
                }
            }
        }

        while (ops.isEmpty() == false) {
            if (ops.peek() != '(' && ops.peek() != ')') {
                stout.append(ops.pop());
            } else {
                ops.pop();
            }
        }
        return stout.toString().trim().replaceAll("\\s+", " ");
    }


    public static boolean compareOps(char on, char stacked) {
        int a = 1;
        int b = 1;
        String rank = "^*%/+-";
        if (rank.indexOf(on) == 0) {
            a = 4;
        }
        if (rank.indexOf(stacked) == 0) {
            b = 4;
        }
        if (rank.indexOf(on) > 0 && rank.indexOf(on) < 4) {
            a = 3;
        }
        if (rank.indexOf(stacked) > 0 && rank.indexOf(stacked) < 4) {
            b = 3;
        }
        if (rank.indexOf(on) > 3 && rank.indexOf(on) < 6) {
            a = 2;
        }
        if (rank.indexOf(stacked) > 3 && rank.indexOf(stacked) < 6) {
            b = 2;
        }
        if (a <= b) {
            return false;
        } else {
            return true;
        }
    }
}
