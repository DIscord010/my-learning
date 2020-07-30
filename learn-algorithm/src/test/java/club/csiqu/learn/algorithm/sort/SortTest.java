package club.csiqu.learn.algorithm.sort;

import club.csiqu.learn.algorithm.sort.recursive.Heap;
import club.csiqu.learn.algorithm.sort.recursive.Merge;
import club.csiqu.learn.algorithm.sort.recursive.Quick;
import club.csiqu.learn.algorithm.sort.space.Bucket;
import club.csiqu.learn.algorithm.sort.space.Counting;
import club.csiqu.learn.algorithm.sort.space.Radix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 排序算法时间测试
 * <p>
 * 冒泡选择插入的时间复杂度都为 O(n^2)。
 * 冒泡比较次数与选择一样，选择只进行一次交换。
 * 选择：变量复制比交换略快。
 * 经测试：插入排序在这三种之中最快，略快于选择排序，基本是冒泡排序的两倍。
 * 百万个 0-1000000范围数据，插入排序达到分钟级，而 n*log(n)的算法只需秒级内。
 * 百万个 0-1000000范围数据，选择达到 7分钟，插入 2分钟。
 * 千万个 0-1000000范围数据，n*log(n)算法达到秒级。
 * 亿个 0-100000范围数据，n*log(n)算法达到十秒级。其中数据越多，快排表现越好。
 *
 * @author Siqu Chen 2020/6/10
 * @since 1.0
 */
public class SortTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(SortTest.class);

    @Test
    void testSort() {
        // 获取指定长度的范围以内随机数数组
        int length = 100000000;
        int scope = 100000;
        int[] array0 = ArrayUtils.getRand(length, scope);
        int[] array1 = new int[array0.length];
        int[] array2 = new int[array0.length];
        int[] array3 = new int[array0.length];
        int[] array4 = new int[array0.length];
        int[] array5 = new int[array0.length];
        // 获取 jvm当前运行内存
        LOGGER.debug("当前运行内存：{}", Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
        // 获取 jvm最大运行内存
        LOGGER.debug("最大运行内存：{}", Runtime.getRuntime().maxMemory());
        LOGGER.debug("数据个数：{}, 数据范围：0-{}", length, scope);

        LOGGER.debug("------------------数据生成结束-----------------------");
        System.arraycopy(array0, 0, array1, 0, array0.length);
        System.arraycopy(array0, 0, array2, 0, array0.length);
        System.arraycopy(array0, 0, array3, 0, array0.length);
        System.arraycopy(array0, 0, array4, 0, array0.length);
        System.arraycopy(array0, 0, array5, 0, array0.length);
        LOGGER.debug("------------------数据复制结束-----------------------");

        // 归并排序
        nanoTimeCount(new Merge(), array0);

        // 快速排序
        nanoTimeCount(new Quick(), array1);

        // 堆排序
        nanoTimeCount(new Heap(), array2);

        // 计数排序
        nanoTimeCount(new Counting(), array3);

        // 基数排序
        nanoTimeCount(new Radix(), array4);

        // 桶排序
        nanoTimeCount(new Bucket(), array5);

        Assertions.assertArrayEquals(array0, array1);
        Assertions.assertArrayEquals(array1, array2);
        Assertions.assertArrayEquals(array3, array4);
        Assertions.assertArrayEquals(array4, array5);
    }

    private void nanoTimeCount(Sortable sort, int[] array) {
        long startTime = System.nanoTime();
        sort.sort(array);
        long endTime = System.nanoTime();
        LOGGER.debug("程序运行时间：{}ns ({})", endTime - startTime, sort.getClass().getName());
    }
}