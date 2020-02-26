package club.csiqu.practice.past;

public class SumN {

    private static int sum(int n) {
        int sum = n;
        int a = 0;
        // 利用 || 或者 && 的短路特性来作为出口
        boolean value = (n == 0) || (a == (sum += sum(n - 1)));
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sum(5));
    }
}