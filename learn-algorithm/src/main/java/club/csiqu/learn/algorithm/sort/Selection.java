package club.csiqu.learn.algorithm.sort;

/**
 * 选择排序
 * <p>
 * 初始状态：无序区为 R[1..n]，有序区为空。
 * 第 i趟排序(i=1,2,3..n-1)开始时，当前有序区和无序区分别为 R[1..i-1]和 R(i..n)。
 * 该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第 1个记录 R交换，
 * 使 R[1..i]和 R[i+1..n)分别变为记录个数增加 1个的新有序区和记录个数减少 1个的新无序区。
 * n-1趟结束，数组有序化了。
 */
public class Selection implements Sortable {

    private void select(int[] array) {
        int min;
        int temp;
        for (int i = 0; i < array.length; i++) {
            min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            // 是否需要交换
            if (min != i) {
                temp = array[min];
                array[min] = array[i];
                array[i] = temp;
            }
        }
    }

    @Override
    public void sort(int[] array) {
        select(array);
    }
}