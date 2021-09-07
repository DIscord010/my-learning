package club.csiqu.learn.practice.leetcode.dynamic;

/**
 * 63.
 *
 * @author Siqu Chen 2021/9/7
 * @since 1.0
 */
public class UniquePathsWithObstacles {

    private UniquePathsWithObstacles() {}

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int[][] result = new int[m][n];
        result[0][0] = 1;
        for (int i = 1; i < m; i++) {
            result[i][0] = obstacleGrid[i][0] == 1 ? 0 : result[i - 1][0];
        }
        for (int j = 1; j < n; j++) {
            result[0][j] = obstacleGrid[0][j] == 1 ? 0 : result[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    result[i][j] = 0;
                    continue;
                }
                result[i][j] = result[i][j - 1] + result[i - 1][j];
            }
        }
        return result[m - 1][n - 1];
    }
}
