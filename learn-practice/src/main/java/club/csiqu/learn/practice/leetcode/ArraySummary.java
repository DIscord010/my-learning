package club.csiqu.learn.practice.leetcode;

import java.util.Arrays;

/**
 * 数组相关.
 *
 * @author Siqu Chen 2020/3/13
 * @since 1.0
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
        int mid;
        int r = 0;
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

    /**
     * 给定数组和整数值，找到数组中和为目标值的两个整数的下标.
     *
     * @param nums   数组
     * @param target 目标值
     * @return 数组下标
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}