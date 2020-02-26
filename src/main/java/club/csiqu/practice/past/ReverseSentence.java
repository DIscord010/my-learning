package club.csiqu.practice.past;

/**
 * @author chensiqu
 * @since 2019/3/12 10:14
 */
public class ReverseSentence {

    /**
     * @param str 需要转换的字符串
     * @return 转换后的字符串
     */
    private static String reverseSentence(String str) {
        String[] strings = str.split(" ");
        if (strings.length == 0) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = strings.length - 1; i > 0; i--) {
            stringBuilder.append(strings[i]).append(" ");
        }
        stringBuilder.append(strings[0]);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseSentence(" "));
    }
}