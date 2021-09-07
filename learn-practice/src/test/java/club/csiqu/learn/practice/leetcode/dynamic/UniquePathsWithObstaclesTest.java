package club.csiqu.learn.practice.leetcode.dynamic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Siqu Chen 2021/9/7
 * @since 1.0
 */
class UniquePathsWithObstaclesTest {

    @Test
    void uniquePathsWithObstacles() {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        Assertions.assertEquals(2, UniquePathsWithObstacles.uniquePathsWithObstacles(obstacleGrid));
        Assertions.assertEquals(0,
                UniquePathsWithObstacles.uniquePathsWithObstacles(new int[][]{{1, 0}}));
        Assertions.assertEquals(1,
                UniquePathsWithObstacles.uniquePathsWithObstacles(new int[][]{{0, 1}, {0, 0}}));
    }
}