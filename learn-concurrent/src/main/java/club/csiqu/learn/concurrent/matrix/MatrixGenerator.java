package club.csiqu.learn.concurrent.matrix;

import java.util.Random;

/**
 * 矩阵生成器
 *
 * @author chensiqu 2019/12/27
 * @since 1.0.0
 */
public class MatrixGenerator {

    public static double[][] generate(int rows, int columns) {
        double[][] result = new double[rows][columns];
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = random.nextDouble() * 10;
            }
        }
        return result;
    }
}