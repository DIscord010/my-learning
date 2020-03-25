package club.csiqu.learn.concurrent.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * @author chensiqu 2020/2/9T
 * @since 1.0.0
 */
public class SerialFileSearch {

    private static final Logger LOGGER = LoggerFactory.getLogger(SerialFileSearch.class);

    public static void searchFile(File file,
                                  String fileName,
                                  FileSearchResult result) {
        if (result == null) {
            throw new IllegalArgumentException("result must not be null");
        }
        File[] contents;
        contents = file.listFiles();
        if (contents == null || contents.length == 0) {
            return;
        }
        for (File content : contents) {
            if (content.isDirectory()) {
                searchFile(content, fileName, result);
            } else {
                if (content.getName().equals(fileName)) {
                    result.setFilePath(content.getAbsolutePath());
                    result.setFound(true);
                    if (LOGGER.isInfoEnabled()) {
                        LOGGER.info("file found, path is {}", file.getAbsolutePath());
                    }
                    return;
                }
            }
            if (result.getFound()) {
                return;
            }
        }
    }
}