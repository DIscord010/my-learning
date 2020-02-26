package club.csiqu.practice.past;

import java.util.Stack;

public class EvaluateReverse {

    private static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int temp1;
        int temp2;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    temp1 = stack.pop();
                    temp2 = stack.pop();
                    stack.push(temp2 + temp1);
                    break;
                case "-":
                    temp1 = stack.pop();
                    temp2 = stack.pop();
                    stack.push(temp2 - temp1);
                    break;
                case "*":
                    temp1 = stack.pop();
                    temp2 = stack.pop();
                    stack.push(temp2 * temp1);
                    break;
                case "/":
                    temp1 = stack.pop();
                    temp2 = stack.pop();
                    stack.push(temp2 / temp1);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"0", "3", "/"}));
    }
}