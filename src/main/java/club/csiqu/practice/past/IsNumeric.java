package club.csiqu.practice.past;

/**
 * @author chensiqu
 * @since 2019/3/13 16:26
 */
public class IsNumeric {

    /**
     * 请实现一个函数用来判断字符串是否表示数值(包括整数和小数)
     * <p>
     * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
     * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
     *
     * @param str 字符串
     * @return {@code true}如果表示数值
     */
    private static boolean isNumeric(char[] str) {

        // 直接调用 parseDouble 方法进行类型转换
        try {
            Double.parseDouble(new String(str));
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static boolean isNum(char[] chars, int begin, int end) {
        if (chars[begin] > '9' || chars[begin] < '0') {
            if (chars[begin] != '+' && chars[begin] != '-') {
                return false;
            }
        }
        for (int i = begin + 1; i <= end; i++) {
            if (chars[i] > '9' || chars[i] < '0') {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断字符串某个片段是否为纯数字
     *
     * @param chars 字符数组
     * @param begin 开始位置
     * @param end   结束位置
     * @return {@code true}如果为纯数字
     */
    private static boolean AllIsNum(char[] chars, int begin, int end) {
        for (int i = begin; i <= end; i++) {
            if (chars[i] > '9' || chars[i] < '0') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isNumeric("-1E-16".toCharArray()));
    }
}