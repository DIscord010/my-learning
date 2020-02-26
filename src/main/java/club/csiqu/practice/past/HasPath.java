package club.csiqu.practice.past;

/**
 * 设计一个函数，
 * 用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 核心思想用一个标志数组标志位置是否走过，
 * 路走不通则再进行回溯。
 *
 * @author chensiqu
 * @since 2019/3/28 13:47
 */
public class HasPath {

    /**
     * 判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
     *
     * @param matrix 目标矩阵
     * @param rows   行
     * @param cols   列
     * @param str    目标字符串
     * @return {@code true}如果存在
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {

        // 标志数组，标志该位置是否走过
        boolean[] flag = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (core(matrix, rows, cols, i, j, flag, str, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断在一个矩阵中是否存在一条包含某字符串所有字符的路径核心算法。
     *
     * @param matrix 矩阵
     * @param rows   行
     * @param cols   列
     * @param i      点的位置横坐标
     * @param j      点的位置纵坐标
     * @param flag   标志数组
     * @param str    目标字符串
     * @param k      字符位置
     * @return {@code true}如果该点和目标字符匹配
     */
    private boolean core(char[] matrix, int rows, int cols,
                         int i, int j, boolean[] flag,
                         char[] str, int k) {
        // 一维数组，所以位置信息为 i*cols+j
        int index = i * cols + j;
        // 越界判断和是否命中判断
        if (i < 0 || j < 0 || i >= rows || j >= cols || matrix[index] != str[k] || flag[index]) {
            return false;
        }
        // 当 k为目标数组长度 -1，说明存在
        if (k == str.length - 1) {
            return true;
        }
        // 标志位置走过
        flag[index] = true;
        // 深度优先遍历
        if (core(matrix, rows, cols, i - 1, j, flag, str, k + 1)
                || core(matrix, rows, cols, i + 1, j, flag, str, k + 1)
                || core(matrix, rows, cols, i, j - 1, flag, str, k + 1)
                || core(matrix, rows, cols, i, j + 1, flag, str, k + 1)
        ) {
            return true;
        }
        // 回溯思想核心，还原标志数组，再进行递归
        flag[index] = false;
        return false;
    }
}