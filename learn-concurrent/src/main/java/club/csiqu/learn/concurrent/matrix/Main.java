package club.csiqu.learn.concurrent.matrix;

import com.google.common.base.Stopwatch;

/**
 * 对串行版本的矩阵计算和多线程版本的矩阵计算进行时间比较
 *
 * @author chensiqu 2019/12/27
 * @since 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        double[][] matrix1 = MatrixGenerator.generate(2000, 2000);
        double[][] matrix2 = MatrixGenerator.generate(2000, 2000);
        double[][] result1 = new double[matrix1.length][matrix2[0].length];
        double[][] result2 = new double[matrix1.length][matrix2[0].length];
        Stopwatch stopwatch1 = Stopwatch.createStarted();
        SerialMultiplier.multiply(matrix1, matrix2, result1);
        stopwatch1.stop();
        System.out.println("cost time：" + stopwatch1);

        Stopwatch stopwatch2 = Stopwatch.createStarted();
        ParallelMultiplier.multiply(matrix1, matrix2, result2);
        // 通过这个判断线程池中的线程是否执行完全
        ParallelMultiplier.executor.shutdown();
        while (true) {
            if (ParallelMultiplier.executor.isTerminated()) {
                break;
            }
        }
        System.out.println("cost time：" + stopwatch2);
        // 判断串行判断与多线程版本结果是否一致
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1.length; j++) {
                if (result1[i][j] != result2[i][j]) {
                    System.out.println("出错");
                }
            }
        }
    }
}