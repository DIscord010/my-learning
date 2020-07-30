package club.csiqu.learn.concurrent.mock.matrix;

import com.google.common.base.Stopwatch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 对串行版本的矩阵计算和多线程版本的矩阵计算进行测试和时间比较
 *
 * @author Siqu Chen 2020/7/30
 * @since 1.0
 */
class MultiplierTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MultiplierTest.class);

    Multiplier serialMultiplier = new SerialMultiplier();

    Multiplier parallelMultiplier = new ParallelMultiplier();

    @Test
    void testMultiply() {
        double[][] matrix1 = MatrixGenerator.generate(2000, 2000);
        double[][] matrix2 = MatrixGenerator.generate(2000, 2000);
        double[][] result1 = new double[matrix1.length][matrix2[0].length];
        double[][] result2 = new double[matrix1.length][matrix2[0].length];

        Stopwatch stopwatch1 = Stopwatch.createStarted();
        serialMultiplier.multiply(matrix1, matrix2, result1);
        stopwatch1.stop();
        LOGGER.info("单线程矩阵相乘时间：{}", stopwatch1);

        Stopwatch stopwatch2 = Stopwatch.createStarted();
        parallelMultiplier.multiply(matrix1, matrix2, result2);
        // 通过这个判断线程池中的线程是否执行完全
        ParallelMultiplier.EXECUTOR.shutdown();
        while (true) {
            if (ParallelMultiplier.EXECUTOR.isTerminated()) {
                break;
            }
        }
        LOGGER.info("多线程矩阵相乘时间：{}", stopwatch2);
        // 判断串行判断与多线程版本结果是否一致
        boolean flag = true;
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1.length; j++) {
                if (result1[i][j] != result2[i][j]) {
                    flag = false;
                    break;
                }
            }
        }
        Assertions.assertTrue(flag);
    }
}