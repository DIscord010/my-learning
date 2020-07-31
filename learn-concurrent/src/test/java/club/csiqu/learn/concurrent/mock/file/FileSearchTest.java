package club.csiqu.learn.concurrent.mock.file;

import club.csiqu.learn.concurrent.mock.file.model.FileSearchResult;
import com.google.common.base.Stopwatch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Siqu Chen 2020/7/31
 * @since 1.0
 */
class FileSearchTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileSearchTest.class);

    private final FileSearch serialFileSearch = new SerialFileSearch();

    private final FileSearch parallelFileSearch = new ParallelFileSearch();

    @Test
    void testSearchFile() {
        Stopwatch stopwatch1 = Stopwatch.createStarted();
        FileSearchResult result1 = serialFileSearch.searchFile(new File("D:/"), "winpty-agent.exe");
        stopwatch1.stop();
        LOGGER.info("查找文件结束，时间：{}", stopwatch1);

        Stopwatch stopwatch2 = Stopwatch.createStarted();
        FileSearchResult result2 = parallelFileSearch.searchFile(new File("D:/"), "winpty-agent.exe");
        stopwatch2.stop();
        LOGGER.info("查找文件结束，时间：{}，文件位置：{}", stopwatch2, result2.getFilePath());
        Assertions.assertEquals(result1.getFilePath(), result2.getFilePath());
    }
}