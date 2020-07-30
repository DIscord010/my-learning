package club.csiqu.learn.structure.index;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * @author Siqu Chen 2020/3/26
 * @since 1.0
 */
class InvertedIndexTest {

    @Test
    void testFindWord() throws IOException {
        InvertedIndex invertedIndex = new InvertedIndex();
        // 根据文件名读取文件内容并建立倒排索引
        for (int i = 1; i <= 3; i++) {
            String path = getClass().getResource("/").getPath() + "index/"
                    + i + ".txt";
            invertedIndex.creatIndex(Objects.requireNonNull(invertedIndex.getFile(path)), path);
        }
        List<String> filePaths = invertedIndex.findWord("hangzhou");
        Assertions.assertEquals(1, filePaths.size());
        Assertions.assertEquals("i live in hangzhou where are you.", invertedIndex.getFile(filePaths.get(0)));
    }
}