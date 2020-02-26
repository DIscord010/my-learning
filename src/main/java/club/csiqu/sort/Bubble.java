package club.csiqu.sort;

/**
 * 冒泡排序
 * <p>
 * 比较相邻的元素。如果第一个比第二个大，就交换它们两个。
 * 一趟结束，最后的元素会是最大的数。
 * 针对所有的元素重复以上的步骤。
 * 重复步骤 1~3，直到排序完成。
 */
public class Bubble implements Sortable {

    /**
     * 基础冒泡排序，两次循环遍历。
     *
     * @param array 待排序数组
     */
    public void bubble(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 冒泡排序升级，如果某一趟一次交换未发生即可认为是排序完成。
     *
     * @param array 待排序数组
     */
    public void bubble0(int[] array) {
        int temp;
        boolean flag = true;
        int length = array.length - 1;
        while (flag) {
            flag = false;
            for (int j = 0; j < length; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true;
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
    private void bubble1(int[] array) {
        int temp;
        int length;
        int flag = array.length - 1;
        while (flag > 0) {
            length = flag;
            flag = 0;
            for (int j = 0; j < length; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = j;
                }
            }
        }
    }

    @Override
    public void sort(int[] array) {
        bubble1(array);
    }
}