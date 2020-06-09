package club.csiqu.learn.basis.nio.file;


import com.google.common.base.Stopwatch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * @author Siqu Chen 2020/6/9
 * @since 1.0.0
 */
class FileUtilTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileUtilTest.class);

    private static final String FROM_PATH = "F:/file-test/test.txt";


    @Test
    public void testFileCopy() throws IOException {

        Stopwatch watch = Stopwatch.createStarted();
        FileUtil.fileCopyByInputStream(FROM_PATH, "F:/file-test/copy0.txt");
        LOGGER.debug("fileCopyByInputStream cost time:{}", watch);

        watch.reset();
        watch.start();
        FileUtil.fileCopyByBufferedStream(FROM_PATH, "F:/file-test/copy1.txt");
        LOGGER.debug("fileCopyByBufferedStream cost time:{}", watch);

        watch.reset();
        watch.start();
        FileUtil.fileCopyByChannel(FROM_PATH, "F:/file-test/copy2.txt");
        LOGGER.debug("fileCopyByChannel cost time:{}", watch);

        watch.reset();
        watch.start();
        FileUtil.fileCopyByMapped(FROM_PATH, "F:/file-test/copy3.txt");
        LOGGER.debug("fileCopyByMapped cost time:{}", watch);

        watch.reset();
        watch.start();
        FileUtil.fileCopyByTransferTo(FROM_PATH, "F:/file-test/copy4.txt");
        LOGGER.debug("fileCopyByTransferTo cost time:{}", watch);

        watch.reset();
        watch.start();
        FileUtil.fileCopyByFiles(FROM_PATH, "F:/file-test/copy5.txt");
        LOGGER.debug("fileCopyByFiles cost time:{}", watch);

        File file = new File("F:/file-test/copy5.txt");
        Assertions.assertTrue(file.exists());
    }
}