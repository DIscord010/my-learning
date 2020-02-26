package club.csiqu.practice.past;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author chensiqu
 */
public class DigitalClassification {

    public static void main(String[] args) {
        int N;
        Scanner scanner = new Scanner(System.in, "UTF-8");
        N = scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        int A1 = 0, A2 = 0, A3 = 0, A5 = 0;
        float A4 = 0;
        // 交错求和判断信号
        int temp = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {

            if (arr[i] % 5 == 0 && arr[i] % 2 == 0) {
                A1 = A1 + arr[i];
            }
            if (arr[i] % 5 == 1) {
                if (temp == 0) {
                    A2 = A2 + arr[i];
                } else {
                    A2 = A2 - arr[i];
                }
                temp++;
                temp = temp % 2;
            }
            if (arr[i] % 5 == 2) {
                A3++;
            }
            if (arr[i] % 5 == 3) {
                A4 = A4 + arr[i];
                sum++;
            }
            if (arr[i] % 5 == 4) {
                if (arr[i] > A5) {
                    A5 = arr[i];
                }
            }
        }
        A4 = A4 / sum;
        DecimalFormat df = new DecimalFormat(".0");
        if (A1 == 0) {
            System.out.print('N' + " ");
        } else {
            System.out.print(A1 + " ");
        }
        if (A2 == 0) {
            System.out.print('N' + " ");
        } else {
            System.out.print(A2 + " ");
        }
        if (A3 == 0) {
            System.out.print('N' + " ");
        } else {
            System.out.print(A3 + " ");
        }
        if (sum == 0) {
            System.out.print('N' + " ");
        } else {
            System.out.print(df.format(A4) + " ");
        }
        if (A5 == 0) {
            System.out.print('N');
        } else {
            System.out.print(A5);
        }
    }
}