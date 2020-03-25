package club.csiqu.learn.practice.leetcode;

import java.util.Arrays;

/**
 * @author Siqu Chen 2020/3/13
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public class ArraySummary {

    /**
     * 最少移动次数使数组元素相等。
     * <p>
     * 暴力循环解法
     *
     * @param nums 数组
     * @return 最小移动数
     */
    public int minMoves2(int[] nums) {
        long temp = Integer.MAX_VALUE;
        for (int num : nums) {
            long t = 0;
            for (int i : nums) {
                t = t + Math.abs(i - num);
            }
            temp = Math.min(temp, t);
        }
        return (int)temp;
    }

    /**
     * 最少移动次数使数组元素相等。
     * <p>
     * 中位数解法
     *
     * @param nums 数组
     * @return 最小移动数
     */
    public int minMoves2Median(int[] nums) {
        Arrays.sort(nums);
        int mid, r = 0;
        if (nums.length % 2 == 1) {
            mid = nums[nums.length / 2];
        } else {
            mid = Math.min(nums[nums.length / 2], nums[nums.length / 2 - 1]);
        }
        for (int num : nums) {
            r = r + Math.abs(num - mid);
        }
        return r;
    }
}