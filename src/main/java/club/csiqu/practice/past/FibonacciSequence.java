package club.csiqu.practice.past;

public class FibonacciSequence {

    private static int fibonacci(int n) {
        int[] a = new int[n + 1];
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        a[0] = 0;
        a[1] = 1;
        for (int i = 2; i <= n; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n];
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(6));
    }
}