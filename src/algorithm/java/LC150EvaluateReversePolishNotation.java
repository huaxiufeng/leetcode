package algorithm.java;

import java.util.Stack;

/**
 * Created by huaxiufeng on 18/11/29.
 */
public class LC150EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        if (null == tokens || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.charAt(token.length()-1) >= '0' && token.charAt(token.length()-1) <= '9') {
                stack.push(Integer.valueOf(token));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(calc(num1, num2, token));
            }
        }
        return stack.pop();
    }

    private int calc(int num1, int num2, String opt) {
        switch (opt) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        LC150EvaluateReversePolishNotation solution = new LC150EvaluateReversePolishNotation();
        System.out.println(solution.evalRPN(new String[]{"2", "1", "+", "3", "*"})); // 9
        System.out.println(solution.evalRPN(new String[]{"4", "13", "5", "/", "+"})); // 6
        System.out.println(solution.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"})); // 22
    }
}
