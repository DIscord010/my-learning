package club.csiqu.practice.past;

import java.util.Stack;

public class IsPopOrder {

    private static boolean isPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i1 : pushA) {
            stack.push(i1);
            while (index < popA.length && stack.peek() == popA[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(isPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
    }
}