package club.csiqu.practice.past;

import java.util.Scanner;

public class CallatzGuess {

    private static int cut(int n) {
        if (n % 2 == 0) {
            n = n >> 1;
        } else {
            n = (3 * n + 1) >> 1;
        }
        return n;
    }

    public static void main(String[] args) {
        int a;
        Scanner scan = new Scanner(System.in, "UTF-8");
        a = scan.nextInt();
        for (int i = 1; ; i++) {
            a = cut(a);
            if (a == 1) {
                System.out.print(i);
                return;
            }
        }
    }
}