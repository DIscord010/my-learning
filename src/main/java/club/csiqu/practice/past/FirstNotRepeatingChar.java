package club.csiqu.practice.past;

import java.util.*;

/**
 * @author chensiqu
 * @since 2019/3/11 13:38
 */
public class FirstNotRepeatingChar {

    /**
     * 在一个字符串(字符串长度在 0到1 0000之间，全部由字母组成)中
     * 找到第一个只出现一次的字符,并返回它的位置,如果没有则返回 -1(需要区分大小写)。
     *
     * @param str 字符串
     * @return 位置
     */
    private static int firstNotRepeatingChar(String str) {
        int[] ints = new int[58];
        for (int i = 0; i < str.length(); i++) {
            ints[str.charAt(i) - 'A']++;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == 1) {
                list.add(i);
                System.out.println(i);
            }
        }
        if (list.isEmpty()) {
            return -1;
        }
        int temp = str.indexOf(list.get(0) + 'A');
        for (int i = 1; i < list.size(); i++) {
            temp = temp > str.indexOf(list.get(i) + 'A') ?
                    str.indexOf(list.get(i) + 'A') : temp;
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println('z' - 'A');
        System.out.println(firstNotRepeatingChar(
                "NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp"));
    }
}