package club.csiqu.practice.past;

import java.util.ArrayList;

/**
 * @author chensiqu
 * @since 2019/3/12 9:57
 */
public class FindNumbersWithSum {

    /**
     * 输入一个递增排序的数组和一个数字 S，在数组中查找两个数，使得他们的和正好是 S，
     * 如果有多对数字的和等于 S，输出两个数的乘积最小的。
     *
     * @param array 递增数组
     * @param sum   S
     * @return 两个数的乘积最小的那组
     */
    private static ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
        int left = 0;
        int right = array.length - 1;
        int temp = 10000;
        ArrayList<Integer> list = new ArrayList<>(2);
        while (left < right) {
            if (array[left] + array[right] > sum) {
                right--;
                System.out.println(right);
            } else if (array[left] + array[right] < sum) {
                left++;
            } else if (array[left] + array[right] == sum) {
                //System.out.println(123);
                if (array[left] * array[right] < temp) {
                    temp = array[left] * array[right];
                    list.add(0, array[left]);
                    list.add(1, array[right]);
                }
                left++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(findNumbersWithSum(new int[]{1, 2, 4, 7, 11, 15}, 15));
    }
}