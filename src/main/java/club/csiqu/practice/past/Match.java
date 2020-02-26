package club.csiqu.practice.past;

/**
 * @author chensiqu
 * @since 2019/3/12 13:07
 */
public class Match {

    /**
     * 实现一个函数用来匹配包括'.'和'*'的正则表达式。
     * 模式中的字符'.'表示任意一个字符，
     * 而'*'表示它前面的字符可以出现任意次(包含 0次)。
     *
     * @param str     待匹配的字符串
     * @param pattern 匹配表达式
     * @return {@code true}如果匹配
     */
    private static boolean match(char[] str, char[] pattern) {

        if (str == null || pattern == null) {
            return false;
        }
        int strIndex = 0;
        int patternIndex = 0;
        return matchCore(str, strIndex, pattern, patternIndex);
    }

    private static boolean
    matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        // 有效性检验：str到尾，pattern到尾，匹配成功
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }
        // pattern先到尾，匹配失败
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }
        // 模式第 2个是 *，且字符串第 1个跟模式第 1个匹配,分 3种匹配模式。如不匹配，模式后移 2位
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
                return
                        //模式后移 2，视为 x*匹配 0个字符
                        matchCore(str, strIndex, pattern, patternIndex + 2)
                                // 视为模式匹配 1个字符
                                || matchCore(str, strIndex + 1, pattern, patternIndex + 2)
                                // *匹配 1个，再匹配 str中的下一个
                                || matchCore(str, strIndex + 1, pattern, patternIndex);
            } else {
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }
        // 模式第 2个不是 *，且字符串第 1个跟模式第 1个匹配，则都后移 1位，否则直接返回 false
        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(match("aaa".toCharArray(),
                "a*aaa".toCharArray()));
    }
}