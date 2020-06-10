package club.csiqu.learn.algorithm.sort;

/**
 * 插入排序
 * <p>
 * 1.从第一个元素开始，该元素可以认为已经被排序。
 * 2.取出下一个元素，在已经排序的元素序列中从后向前扫描。
 * 3.如果该元素（已排序）大于新元素，将该元素移到下一位置。
 * 4.重复步骤 3，直到找到已排序的元素小于或者等于新元素的位置。
 * 5.将新元素插入到该位置后。
 * 6.重复步骤 2~5。
 *
 * @author Siqu Chen
 */
public class Insertion implements Sortable {

    @Override
    public void sort(int[] array) {
        insert1(array);
    }

    /**
     * 每次多进行了一次交换
     *
     * @param array 待排序数组
     */
    public void insert0(int[] array) {
        int current;
        for (int i = 1; i < array.length; i++) {
            current = array[i];
            for (int j = i - 1; j >= 0; j--) {
                if (current < array[j]) {
                    array[j + 1] = array[j];
                    array[j] = current;
                }
            }
        }
    }

    /**
     * 优化后，每次判断可以少交换一次，在跳出内循环后进行交换。
     *
     * @param array 待排序数组
     */
    public void insert1(int[] array) {
        int temp;

        for (int i = 1; i < array.length; i++) {
            temp = array[i];
            int j = i;
            // 利用短路特性
            while (j > 0 && temp < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
    }
}