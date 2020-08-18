package club.csiqu.learn.practice.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Siqu Chen 2020/8/18
 * @since 1.0.0
 */
class StringSummaryTest {

    StringSummary stringSummary = new StringSummary();

    @Test
    void testLengthOfLongestSubstring() {
        Assertions.assertEquals(3, stringSummary.lengthOfLongestSubstring("abcabcbb"));
        Assertions.assertEquals(3, stringSummary.lengthOfLongestSubstring("pwwkew"));
        Assertions.assertEquals(1, stringSummary.lengthOfLongestSubstring(" "));
        Assertions.assertEquals(6, stringSummary.lengthOfLongestSubstring("bbtablud"));
    }
}