package club.csiqu.practice.past;

import java.util.ArrayList;

/**
 * @author chensiqu
 * @since 2019/3/8 15:46
 */
public class Permutation {

    /**
     * 输入一个字符串，按字典序打印出该字符串中字符的所有排列。
     * 例如输入字符串 abc，则打印出
     * 由字符 a、b、c所能排列出来的所有字符串 abc、acb、bac、bca、cab和 cba。
     *
     * @param str 字符串
     * @return 字符串集合
     */
    private static ArrayList<String> permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        permutation(new StringBuilder(str), list, new StringBuilder());
        return list;
    }

    private static
    void permutation(StringBuilder str, ArrayList<String> list, StringBuilder result) {
        if (str.length() == 1) {
            if (!list.contains(result + str.toString())) {
                list.add(result.append(str).toString());
                result.deleteCharAt(result.length() - 1);
                return;
            }
        }
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str);
            permutation(new StringBuilder(str).deleteCharAt(i), list,
                    result.append(str.charAt(i)));
            result.deleteCharAt(result.length() - 1);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> list1 = permutation("aab");
        for (String str : list1) {
            System.out.print(" " + str);
        }
        ArrayList<String> list2 = permutation("ab");
        for (String str : list2) {
            System.out.print(" " + str);
        }
    }
}