package club.csiqu.learn.concurrent.mock.matrix;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author chensiqu 2019/12/27
 * @since 1.0
 */
public class ParallelMultiplier implements Multiplier {

    private static final int CORE_SIZE = Runtime.getRuntime().availableProcessors();

    public static final ThreadPoolExecutor EXECUTOR = new ThreadPoolExecutor(
            CORE_SIZE,
            CORE_SIZE << 1,
            10L,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(4000000),
            new ThreadFactoryBuilder().setNameFormat("矩阵计算线程池:%d").build());

    @Override
    public void multiply(double[][] matrix1, double[][] matrix2, double[][] result) {
        final int rows1 = matrix1.length;
        final int columns1 = matrix1[0].length;
        final int columns2 = matrix2[0].length;
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < columns2; j++) {
                result[i][j] = 0;
                final int temp1 = i;
                final int temp2 = j;
                EXECUTOR.execute(() -> {
                    for (int k = 0; k < columns1; k++) {
                        result[temp1][temp2] += matrix1[temp1][k] * matrix2[k][temp2];
                    }
                });
            }
        }
    }
}