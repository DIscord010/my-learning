package club.csiqu.learn.concurrent.mock.matrix;

/**
 * @author Siqu Chen 2020/7/30
 * @since 1.0
 */
public interface Multiplier {

    /**
     * 计算两个矩阵相乘
     *
     * @param matrix1 矩阵1
     * @param matrix2 矩阵2
     * @param result  矩阵相乘的结果
     */
    void multiply(double[][] matrix1, double[][] matrix2, double[][] result);
}