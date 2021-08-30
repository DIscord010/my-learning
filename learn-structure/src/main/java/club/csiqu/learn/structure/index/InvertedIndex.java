package club.csiqu.learn.structure.index;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private final Map<String, List<String>> indexMap = new HashMap<>();

    /** 单词数统计 */
    private final Map<String, Integer> count = new HashMap<>();

    /**
     * 建立倒排索引
     *
     * @param content  文件文本内容，即字符串。
     * @param filePath 文件路径
     */
    public void creatIndex(String content, String filePath) {
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
     * 根据单词返回文件路径
     *
     * @param word 目标单词
     * @return 拥有该单词的文本路径
     */
    public List<String> findWord(String word) {
        if (indexMap.containsKey(word)) {
            return indexMap.get(word);
        } else {
            return new ArrayList<>(0);
        }
    }

    /**
     * 根据文件路径获取文件内容
     *
     * @param filePath 文件路径
     * @return 文件内容字符串
     */
    public String getFile(String filePath) throws IOException {
        File file = new File(filePath);
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(inputStreamReader)) {
            return reader.readLine();
        }
    }
}