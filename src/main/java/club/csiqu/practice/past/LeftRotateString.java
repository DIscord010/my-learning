package club.csiqu.practice.past;

/**
 * @author chensiqu
 * @since 2019/3/11 17:38
 */
public class LeftRotateString {

    public String leftRotateString(String str, int n) {
        // 必须进行入参检测
        if (str == null || str.length() == 0) {
            return "";
        }
        n = n % str.length();
        return str.substring(n) + str.substring(0, n);
    }
}