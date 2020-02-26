package club.csiqu.practice.past;

import java.util.Scanner;

/**
 * 方格走法
 *
 * @author chensiqu
 * @since 2019/4/2 17:10
 */
public class GridWay {

    /** 存放走法数 */
    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        int x, y;
        x = scanner.nextInt();
        y = scanner.nextInt();
        core(x, y, 0, 0);
        System.out.println(count);

        // 动态规划数组，数组内数值为到这点的走法。
        int[][] ints = new int[x + 1][y + 1];
        // 初始化 第一行走法全为 1
        for (int i = 0; i < y + 1; i++) {
            ints[0][i] = 1;
        }
        // 初始化 第一列走法全为 1
        for (int i = 1; i < x + 1; i++) {
            ints[i][0] = 1;
        }
        // 从 ints[1][1]开始，这点的走法为上方的点加上左方的点走法相加。
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                ints[i][j] = ints[i - 1][j] + ints[i][j - 1];
            }
        }
        System.out.println(ints[x][y]);

    }

    /**
     * 递归深度优先遍历解法
     *
     * @param rows 行
     * @param cols 列
     * @param i    横坐标
     * @param j    纵坐标
     */
    private static void core(int rows, int cols,
                             int i, int j) {
        if (i > rows || j > cols) {
            return;
        }
        // 到达目标点，则 count++
        if ((i == rows) && (j == cols)) {
            count++;
            return;
        }
        // 深度优先遍历
        core(rows, cols, i + 1, j);
        core(rows, cols, i, j + 1);
    }
}