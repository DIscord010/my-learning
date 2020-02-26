package club.csiqu.sort;

/**
 * 堆排序
 * <p>
 * 将初始待排序关键字序列(R1,R2,……Rn)构建成大顶堆，此堆为初始的无序区。
 * 将堆顶元素 R[1]与最后一个元素 R[n]交换，此时得到新的无序区(R1,R2,……Rn-1)和新的有序区(Rn),
 * 且满足 R[1,2,……n-1]小于等于 R[n]。
 * 由于交换后新的堆顶 R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,……Rn-1)
 * 调整为新堆，然后再次将 R[1]与无序区最后一个元素交换，
 * 得到新的无序区(R1,R2,……Rn-2)和新的有序区(Rn-1,Rn)。
 * 不断重复此过程直到有序区的元素个数为 n-1，则整个排序过程完成。
 *
 * @author chensiqu
 * @since 2019/3/22 10:35
 */
public class Heap implements Sortable {

    /** 记录长度 */
    private static int len;

    private void heap(int[] array) {
        len = array.length;
        if (len < 1) {
            return;
        }
        // 构造最大堆
        buildMaxHeap(array);
        while (len > 0) {
            ArrayUtils.swap(array, 0, len - 1);
            len--;
            adjustHeap(array, 0);
        }
    }

    /**
     * 初始化成为最大堆
     */
    private void buildMaxHeap(int[] array) {
        for (int i = ((len - 1) >> 1); i >= 0; i--) {
            adjustHeap(array, i);
        }

    }

    /**
     * 调整最大堆
     *
     * @param array 数组
     * @param i     节点
     */
    private void adjustHeap(int[] array, int i) {
        int maxIndex = i;
        // 此处从数组下标 0开始的最大堆，所以左孩子为 i*2+1
        if (i * 2 + 1 < len && array[i * 2 + 1] > array[maxIndex]) {
            maxIndex = i * 2 + 1;
        }
        // 此处从数组下标 0开始的最大堆，所以右孩子为 i*2+2
        if (i * 2 + 2 < len && array[i * 2 + 2] > array[maxIndex]) {
            maxIndex = i * 2 + 2;
        }
        if (maxIndex != i) {
            ArrayUtils.swap(array, maxIndex, i);
            adjustHeap(array, maxIndex);
        }
    }

    @Override
    public void sort(int[] array) {
        heap(array);
    }
}