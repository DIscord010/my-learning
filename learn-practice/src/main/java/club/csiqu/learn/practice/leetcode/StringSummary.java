package club.csiqu.learn.practice.leetcode;

/**
 * 字符串相关.
 *
 * @author Siqu Chen 2020/8/18
 * @since 1.0.0
 */
public class StringSummary {


    /**
     * 3.
     *
     * @param s 字符串
     * @return 不含重复字符的最长字串长度
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int max = 0;
        int i = 0;
        int j = 1;
        for (; j < chars.length; j++) {
            int index = searchForArray(chars, i, j - 1, chars[j]);
            if (index != -1) {
                max = Math.max(j - i, max);
                i = index + 1;
            }
        }
        return Math.max(max, j - i);
    }

    private int searchForArray(char[] chars, int begin, int end, char target) {
        for (int i = begin; i <= end; i++) {
            if (chars[i] == target) {
                return i;
            }
        }
        return -1;
    }
}