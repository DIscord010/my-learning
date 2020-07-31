package club.csiqu.learn.concurrent.mock.file;

import club.csiqu.learn.concurrent.mock.file.model.FileSearchResult;

import java.io.File;

/**
 * @author chensiqu 2020/2/9
 * @since 1.0
 */
public class SerialFileSearch implements FileSearch {

    @Override
    public FileSearchResult searchFile(File file, String fileName) {
        final FileSearchResult fileSearchResult = new FileSearchResult();
        searchFile(file, fileName, fileSearchResult);
        return fileSearchResult;
    }

    private static void searchFile(File file, String fileName, FileSearchResult result) {
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
                    return;
                }
            }
            if (result.getFound()) {
                return;
            }
        }
    }
}