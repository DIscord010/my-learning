package club.csiqu.practice.past;

import java.util.ArrayList;

/**
 * @author chensiqu
 * @since 2019/3/12 9:38
 */
public class FindContinuousSequence {

    /**
     * 找出所有和为S的连续正数序列
     *
     * @param sum S
     * @return 输出所有和为S的连续正数序列。
     */
    private static ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int low = 1;
        int high = 2;
        while (low < high) {
            if ((low + high) * (high - low + 1) >> 1 < sum) {
                //System.out.println(high);
                high++;
            } else if ((low + high) * (high - low + 1) >> 1 > sum) {
                low++;
                //System.out.println(low);
            } else if ((low + high) * (high - low + 1) >> 1 == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = low; i <= high; i++) {
                    list.add(i);
                }
                result.add(list);
                low++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> lists = findContinuousSequence(100);
        System.out.println(lists);
    }
}