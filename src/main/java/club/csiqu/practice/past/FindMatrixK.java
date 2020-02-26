package club.csiqu.practice.past;

import java.util.Arrays;
import java.util.Scanner;

public class FindMatrixK {

    public static void main(String[] args) {
        int k, n;
        Scanner scanner = new Scanner(System.in, "UTF-8");
        k = scanner.nextInt();
        n = scanner.nextInt();
        int[] matrix = new int[n * n];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextInt();
        }
        Arrays.sort(matrix);
        System.out.print(matrix[k - 1]);
    }
}