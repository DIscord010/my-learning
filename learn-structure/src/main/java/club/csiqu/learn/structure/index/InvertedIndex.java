package club.csiqu.learn.structure.index;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * 倒排索引的简单实现。
 * <p>
 * 只支持以空格为分割的英文句子。
 *
 * @author chensiqu
 * @since 2019/6/10 13:45
 */
public class InvertedIndex {

    /** 倒排索引存放 */
    private Map<String, List<String>> indexMap = new HashMap<>();

    /** 单词数统计 */
    private Map<String, Integer> count = new HashMap<>();

    /**
     * 建立倒排索引
     *
     * @param content  文件文本内容，即字符串。
     * @param filePath 文件路径
     */
    private void creatIndex(String content, String filePath) {

        List<String> list;

        // 根据空格分词
        String[] words = content.split(" ");

        for (String word : words) {
            if (!indexMap.containsKey(word)) {

                list = new ArrayList<>();
                list.add(filePath);
                indexMap.put(word, list);
                count.put(word, 1);
            } else {

                list = indexMap.get(word);
                if (!list.contains(filePath)) {
                    list.add(filePath);
                }
                count.put(word, count.get(word) + 1);
            }
        }
    }

    /**
     * 根据单词输出查询到的文件内容
     *
     * @param word 指定单词
     */
    private void findWord(String word) {

        if (indexMap.containsKey(word)) {
            List<String> list = indexMap.get(word);
            list.forEach(s -> System.out.println(getFile(s)));
        }
    }

    /**
     * 根据文件路径获取文件内容
     *
     * @param filePath 文件路径
     * @return 文件内容字符串
     */
    private String getFile(String filePath) {

        File file = new File(filePath);

        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(inputStreamReader)) {
            return reader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static void main(String[] args) {
        InvertedIndex invertedIndex = new InvertedIndex();

        // 根据文件名读取文件内容并建立倒排索引
        for (int i = 1; i <= 3; i++) {
            String path = "src/main/resources/index/"
                    + i + ".txt";
            invertedIndex.creatIndex(Objects.requireNonNull(invertedIndex.getFile(path)), path);
        }

        // 输出倒排索引的全部内容
        for (Map.Entry<String, List<String>> map : invertedIndex.indexMap.entrySet()) {
            System.out.println(map.getKey() + ":" + map.getValue());
        }

        // 输出单词统计
        for (Map.Entry<String, Integer> num : invertedIndex.count.entrySet()) {
            System.out.println(num.getKey() + ":" + num.getValue());
        }

        // 查询拥有单词 love的文件内容
        invertedIndex.findWord("love");
        // 查询拥有单词 i的文件内容
        invertedIndex.findWord("i");
    }
}