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
}