package club.csiqu.practice.past;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Given a string s and a dictionary of words dict,
 * add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 *
 * @author chensiqu
 * @since 2019/4/2 17:28
 */
public class PossibleSentences {

    /**
     * 主函数
     *
     * @param args 主函数入口参数
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        String s = scanner.nextLine();
        String dict = scanner.nextLine();
        s = s.split("=")[1];
        // 入参处理
        s = s.replace("\"", "");
        dict = dict.split("=")[1];
        String[] dicts = dict.split(",");
        // 入参处理
        for (int i = 0; i < dicts.length; i++) {
            dicts[i] = dicts[i].replace("\"", "");
        }
        // 存放结果
        ArrayList<String> result = new ArrayList<>();

        // 取出字典的单词与字符串 0-d.length()比对
        for (String d : dicts) {
            if (d.length() <= s.length()) {
                if (s.substring(0, d.length()).equals(d)) {
                    // 去掉 d.length()长度，继续比对
                    String temp = d + " " +
                            (core(new StringBuffer(s).delete(0, d.length()), dicts));
                    // 如果全部命中
                    if (temp.length() > s.length()) {
                        result.add(temp);
                    }
                }
            }
        }

        // 去掉结果中尾巴的空格
        for (int i = 0; i < result.size(); i++) {
            result.set(i, result.get(i).substring(0, result.get(i).length() - 1));
        }
        // 测试案例的输出是倒过来的
        Collections.reverse(result);
        System.out.println(result);
    }

    /**
     * 核心
     *
     * @param s     待比对字符串
     * @param dicts 字典数组
     * @return 比对生成的字符串
     */
    private static String core(StringBuffer s, String[] dicts) {
        // 存放结果
        StringBuilder res = new StringBuilder();
        for (String dict : dicts) {
            if (dict.length() <= s.length()) {
                if (s.substring(0, dict.length()).equals(dict)) {
                    res.append(dict).append(" ");
                    res.append(core(s.delete(0, dict.length()), dicts));
                }
            }
        }
        return res.toString();
    }
}