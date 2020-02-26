package club.csiqu.practice.past;

/**
 * 机器人的运动范围
 *
 * @author chensiqu
 * @since 2019/3/28 15:03
 */
public class MovingCount {

    /** 运动的格子数 */
    private int count = 0;

    /**
     * 地上有一个 m行和 n列的方格。
     * 一个机器人从坐标 0,0的格子开始移动，
     * 每一次只能向左，右，上，下四个方向移动一格，
     * 但是不能进入行坐标和列坐标的数位之和大于 k的格子。
     * 例如，当 k为 18时，机器人能够进入方格(35,37)，
     * 因为 3+5+3+7 = 18。但是，它不能进入方格(35,38)，
     * 因为 3+5+3+8 = 19。请问该机器人能够达到多少个格子？
     *
     * @param threshold 目标条件
     * @param rows      行数
     * @param cols      列数
     * @return {@code count}机器人能够达到的格子数
     */
    public int movingCount(int threshold, int rows, int cols) {

        // 标志数组
        boolean[][] flag = new boolean[rows][cols];
        core(rows, cols, 0, 0, flag, threshold);
        return count;
    }

    /**
     * 机器人的运动范围
     *
     * @param rows      行数
     * @param cols      列数
     * @param i         格子横坐标
     * @param j         格子纵坐标
     * @param flag      标志数组
     * @param threshold 目标条件
     */
    private void core(int rows, int cols,
                      int i, int j,
                      boolean[][] flag, int threshold) {

        // 越界判断和是否命中判断
        if (i < 0 || j < 0 || i >= rows || j >= cols || sum(i, j) > threshold || flag[i][j]) {
            return;
        } else {
            count++;
        }
        // 标志位置走过
        flag[i][j] = true;
        // 深度优先遍历
        core(rows, cols, i - 1, j, flag, threshold);
        core(rows, cols, i + 1, j, flag, threshold);
        core(rows, cols, i, j - 1, flag, threshold);
        core(rows, cols, i, j + 1, flag, threshold);
    }

    /**
     * 判断条件
     *
     * @param i 数值
     * @param j 数值
     * @return 例如 {@code i=10,j=19}，就返回 1+0+1+9
     */
    private int sum(int i, int j) {

        int sum = 0;
        do {
            sum += i % 10;
        } while ((i = i / 10) > 0);
        do {
            sum += j % 10;
        } while ((j = j / 10) > 0);
        return sum;
    }
}