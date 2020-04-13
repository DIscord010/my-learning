package club.csiqu.learn.sort;

/**
 * 排序算法时间测试
 * <p>
 * 冒泡选择插入的时间复杂度都为 O(n^2)。
 * 冒泡比较次数与选择一样，选择只进行一次交换。
 * 选择：变量复制比交换略快。
 * 经测试：插入排序在这三种之中最快，略快于选择排序，基本是冒泡排序的两倍。
 * 百万个 0-1000000范围数据，插入排序达到分钟级，而 nlogn的算法只需秒级内。
 * 百万个 0-1000000范围数据，选择达到 7分钟，插入 2分钟。
 * 千万个 0-1000000范围数据，nlogn算法达到秒级。
 * 亿个 0-100000范围数据，nlogn算法达到十秒级。其中数据越多，快排表现越好。
 */
public class SortMain {

    public static void main(String[] args) {
        // 获取指定长度的范围以内随机数数组
        int length = 100;
        int scope = 100;
        int[] array0 = ArrayUtils.getRand(length, scope);
        int[] array1 = new int[array0.length];
        int[] array2 = new int[array0.length];
        int[] array3 = new int[array0.length];
        int[] array4 = new int[array0.length];
        int[] array5 = new int[array0.length];
        // 获取 jvm当前运行内存
        System.out.println("当前运行内存:" +
                (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
        // 获取 jvm最大运行内存
        System.out.println("最大运行内存:" + Runtime.getRuntime().maxMemory());

        System.out.println("数据个数：" + length + ",数据范围：0-" + scope);

        System.out.println("----------------数据生成结束------------------------");
        System.arraycopy(array0, 0, array1, 0, array0.length);
        System.arraycopy(array0, 0, array2, 0, array0.length);
        System.arraycopy(array0, 0, array3, 0, array0.length);
        System.arraycopy(array0, 0, array4, 0, array0.length);
        System.arraycopy(array0, 0, array5, 0, array0.length);

        System.out.println("----------------数据复制结束------------------------");

        // 打印未排序数组
        //ArrayUtils.showRand(array0);

        // 归并排序
        nanoTimeCount(new Merge(), array0);
        //ArrayUtils.showRand(array0);

        // 快速排序
        nanoTimeCount(new Quick(), array1);
        //ArrayUtils.showRand(array1);

        // 堆排序
        nanoTimeCount(new Heap(), array2);
        //ArrayUtils.showRand(array2);

        // 计数排序
        nanoTimeCount(new Counting(), array3);
        //ArrayUtils.showRand(array3);

        // 基数排序
        nanoTimeCount(new Radix(), array4);
        //ArrayUtils.showRand(array4);

        // 桶排序
        nanoTimeCount(new Bucket(), array5);
        //ArrayUtils.showRand(array5);
    }

    private static void nanoTimeCount(Sortable sort, int[] array) {
        long startTime = System.nanoTime();
        sort.sort(array);
        long endTime = System.nanoTime();
        System.out.println("程序运行时间： " +
                (endTime - startTime) + "ns" + " (" + sort.getClass() + ")");
    }
}