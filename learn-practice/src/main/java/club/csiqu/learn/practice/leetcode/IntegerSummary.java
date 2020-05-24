package club.csiqu.learn.practice.leetcode;

/**
 * @author Siqu Chen 2020/3/13
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public class IntegerSummary {

    /**
     * 给定整数，判断它是否是 2的幂次方
     *
     * @param n 整数
     * @return 是否 2的幂次方
     */
    public boolean isPowerOfTwo(int n) {
        return (n > 0) && (1 << 30) % n == 0;
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