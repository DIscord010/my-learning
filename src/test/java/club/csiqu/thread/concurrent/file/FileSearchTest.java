package club.csiqu.thread.concurrent.file;

import com.google.common.base.Stopwatch;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * @author chensiqu 2020/2/9
 * @since 1.0.0
 */
public class FileSearchTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileSearchTest.class);

    @Test
    public void searchFile() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        SerialFileSearch.searchFile(new File("E:/IDEA/"),
                "mysql-rr.md",
                new FileSearchResult());
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("cost time: {}", stopwatch);
        }
    }
}