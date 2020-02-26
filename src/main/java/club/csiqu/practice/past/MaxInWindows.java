package club.csiqu.practice.past;

import java.util.ArrayList;

/**
 * 最大窗口滑动值
 *
 * @author chensiqu
 * @since 2019/3/14 17:30
 */
public class MaxInWindows {

    public ArrayList<Integer> maxInWindows(int[] num, int size) {

        //Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (size == 0 || size > num.length) {
            return list;
        }
        int i = 0, j = size - 1;
        while (j < num.length) {
            list.add(getMax(num, i, j));
            i++;
            j++;
        }
        return list;

    }

    private Integer getMax(int[] ints, int begin, int end) {
        int temp = ints[begin];
        for (int i = begin + 1; i <= end; i++) {
            if (ints[i] > temp) {
                temp = ints[i];
            }
        }
        return temp;
    }
}