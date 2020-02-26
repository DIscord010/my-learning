package club.csiqu.practice.exam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 牛客模拟笔试算法题
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/7/17 19:25
 */
public class Exam {

    /**
     * 七月份模拟笔试第一题
     */
    public void test1971() {
        Scanner in = new Scanner(System.in, "UTF-8");
        int n = in.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = in.nextInt();
        }
        Arrays.sort(ints);

        int[] temps = new int[n];

        int temp = n / 2;

        temps[temp] = ints[0];

        int j = 1;
        int k = 1;

        for (int i = 1; i < n; i++) {

            if (j == 1) {
                temps[temp - k] = ints[i];
                j = 0;
            } else {
                temps[temp + k] = ints[i];
                j = 1;
                k = k + 1;
            }
        }
        int result = Math.abs(temps[0] - temps[n - 1]);
        for (int i = 0; i < n - 1; i++) {

            int t = temps[i] - temps[i + 1];

            if (result < Math.abs(t)) {

                result = Math.abs(t);
            }
        }
        System.out.println(result);
    }
}