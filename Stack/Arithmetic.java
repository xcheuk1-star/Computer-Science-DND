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
        ArrayList<Character> stout = new ArrayList<Character>();
        for (int i = 0; i < eq.length; i++) {
            char on = eq[i];
            if (on != ' ') {
                if ((int) on < 48 || (int) on > 57) {
                    if (rank.indexOf(on) > 0) {
                        stout.add(on);
                    }
                } else {
                    ops.push(on);
                }
            }
        }
    }

    public boolean compareOps(char on, char stacked) {
        String rank = "^*%/+-";
        if (rank.indexOf(on) == 0 && rank.indexOf(stacked) > 0) {
            return true;
        }
        if (rank.indexOf(on) > 0 && rank.indexOf(on) < 4 && rank.indexOf(stacked) < 3) {
            return false;
        }
    }
}
