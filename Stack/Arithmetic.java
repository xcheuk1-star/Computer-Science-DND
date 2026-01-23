import java.util.ArrayList;

public class Arithmetic {

    // Evaluates a String exp that has an arithmetic expression, written in
    // classic notation
    public static int evaluate(String exp) {}

    // Returns the result of doing operand1 operation operand2,
    // e.g. operate(5, 2, "-") should return 3
    public static int operate(int operand1, int operand2, String operation) {
        return 0;
    }

    // Evaluates a String exp that has an arithmetic expression written in STOUT
    // notation
    public static int evaluateStout(String exp) {
        return 0;
    }

    public static String convertClassicToStout(String exp) {
        MyStack<Character> ops = new MyStack<Character>();
        char[] eq = exp.toCharArray();
        StringBuilder stout = new StringBuilder();
        String rank = "(^*%/+-)";
        for (int i = 0; i < eq.length; i++) {
            char on = eq[i];
            if (rank.indexOf(on) == -1) {
                stout.append(on);
            } else {
                if (ops.peek() == null) {
                    ops.push(on);
                } else if (compareOps(on, ops.peek()) == true) {
                    ops.push(on);
                } else {
                    while (ops.isEmpty() == false && compareOps(on, ops.peek()) == false) {
                        if (ops.peek() != '(' || ops.peek() != ')') {
                            stout.append(ops.peek());
                            ops.pop();
                        } else {
                            ops.pop();
                        }
                    }
                    if (on != '(' || on != ')') {
                        stout.append(on);
                    }
                }
            }
        }
        return stout + "";
    }


    public static boolean compareOps(char on, char stacked) {
        int a = 0;
        int b = 0;
        String rank = "(^*%/+-)";
        if (rank.indexOf(on) == 0) {
            a = 5;
        }
        if (rank.indexOf(stacked) == 0) {
            b = 5;
        }
        if (rank.indexOf(on) == 1) {
            a = 4;
        }
        if (rank.indexOf(stacked) == 1) {
            b = 4;
        }
        if (rank.indexOf(on) > 1 && rank.indexOf(on) < 5) {
            a = 3;
        }
        if (rank.indexOf(stacked) > 1 && rank.indexOf(stacked) < 5) {
            b = 3;
        }
        if (rank.indexOf(on) > 4 && rank.indexOf(on) < 7) {
            a = 2;
        }
        if (rank.indexOf(stacked) > 4 && rank.indexOf(stacked) < 7) {
            b = 2;
        } else {
            a = 1;
            b = 1;
        }
        if (a <= b) {
            return false;
        } else {
            return true;
        }
    }
}
