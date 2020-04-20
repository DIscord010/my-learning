package club.csiqu.learn.algorithm.sort;

/**
 * 快速排序
 * <p>
 * 从数列中挑出一个元素，称为基准(pivot)。
 * 重新排序数列，所有元素比基准值小的摆放在基准前面，
 * 所有元素比基准值大的摆在基准的后面(相同的数可以到任一边)。
 * 在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区(partition)操作。
 * 递归地(recursive)把小于基准值元素的子数列和大于基准值元素的子数列排序。
 *
 * @author chensiqu
 * @since 2019/3/21 16:15
 */
public class Quick implements Sortable {

    private void quick(int[] array) {
        quick(array, 0, array.length - 1);
    }

    private void quick(int[] array, int low, int high) {
        // 递归结束条件
        if (low < 0 || high > array.length - 1 || low >= high) {
            return;
        }
        int index = partition(array, low, high);
        if (index > low) {
            // 左序列递归
            quick(array, low, index - 1);
        }
        if (index < high) {
            // 右序列递归
            quick(array, index + 1, high);
        }
    }

    /**
     * 快速排序核心
     * <p>
     * 找到基准的位置，每次调用的时间复杂度为 O(n)。
     *
     * @param array 待排序数组
     * @param start 左边下标
     * @param end   右边下标
     * @return 结束后的基准位置
     */
    private int partition(int[] array, int start, int end) {
        // 选择随机的一个下标为基准下标
        int pivot = (int) (start + Math.random() * (end - start + 1));
        // 基点数值
        int mid = array[pivot];
        // 将基准放于最后一个位置
        ArrayUtils.swap(array, pivot, end);
        int i = start, j = end - 1;
        // 找到基准该在的位置
        while (true) {
            // 从左往右找到第一个比基准大的数
            while (array[i] < mid) {
                i++;
            }
            // 从右往左找到第一个小于基准的数
            while (array[j] > mid && j > i) {
                j--;
            }
            if (i < j) {
                // 进行交换
                ArrayUtils.swap(array, i++, j--);
            } else {
                break;
            }
        }
        ArrayUtils.swap(array, i, end);
        return i;
    }

    @Override
    public void sort(int[] array) {
        quick(array);
    }

    /**
     * 对快速排序进行测试
     *
     * @param args 主函数入口参数
     */
    public static void main(String[] args) {
        Quick quick = new Quick();
        int[] rand = {1, 5, 6, 2, 9, 11};
        ArrayUtils.showRand(rand);
        quick.quick(rand);
        ArrayUtils.showRand(rand);
    }
}