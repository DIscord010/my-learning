package club.csiqu.learn.algorithm.sort;

/**
 * 冒泡排序
 * <p>
 * 1.比较相邻的元素：如果第一个比第二个大，就交换它们两个。
 * 2.一趟结束，最后的元素会是最大的数。
 * 3.针对所有的元素重复以上的步骤。
 * 4.重复步骤 1~3，直到排序完成。
 *
 * @author Siqu Chen
 */
public class Bubble implements Sortable {

    @Override
    public void sort(int[] array) {
        bubble2(array);
    }

    /**
     * 基础冒泡排序，两次循环遍历。
     *
     * @param array 待排序数组
     */
    public void bubble0(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    ArrayUtils.swap(array, j, j + 1);
                }
            }
        }
    }

    /**
     * 冒泡排序升级，如果某一趟一次交换未发生即可认为是排序完成。
     *
     * @param array 待排序数组
     */
    public void bubble1(int[] array) {
        boolean swapFlag = true;
        int length = array.length - 1;
        while (swapFlag) {
            swapFlag = false;
            for (int j = 0; j < length; j++) {
                if (array[j] > array[j + 1]) {
                    ArrayUtils.swap(array, j, j + 1);
                    swapFlag = true;
                }
            }
            length--;
        }
    }

    /**
     * 冒泡排序再次改进，纪录该躺排序最后一次交换位置，下一趟到该位置即可。
     *
     * @param array 待排序数组
     */
    public void bubble2(int[] array) {
        int length;
        // 记录最后交换位置
        int lastSwapIndex = array.length - 1;
        while (lastSwapIndex > 0) {
            length = lastSwapIndex;
            lastSwapIndex = 0;
            for (int j = 0; j < length; j++) {
                if (array[j] > array[j + 1]) {
                    ArrayUtils.swap(array, j, j + 1);
                    lastSwapIndex = j;
                }
            }
        }
    }
}