package club.csiqu.learn.concurrent.mock.file;

import club.csiqu.learn.concurrent.mock.file.model.FileSearchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Siqu Chen 2020/7/30
 * @since 1.0
 */
public class ParallelFileSearch implements FileSearch {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParallelFileSearch.class);

    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(10);

    @Override
    public FileSearchResult searchFile(File file, String fileName) {
        final CompletableFuture<FileSearchResult> future = new CompletableFuture<>();
        EXECUTOR_SERVICE.submit(new SearchFileTask(file, fileName, future));
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            LOGGER.warn("并发查找文件出现异常：", e);
        }
        return new FileSearchResult();
    }

    private static class SearchFileTask implements Runnable {

        private final File file;

        private final String fileName;

        private final CompletableFuture<FileSearchResult> completableFuture;

        public SearchFileTask(File file, String fileName, CompletableFuture<FileSearchResult> completableFuture) {
            this.file = file;
            this.fileName = fileName;
            this.completableFuture = completableFuture;
        }

        @Override
        public void run() {
            File[] contents;
            contents = file.listFiles();
            if (contents == null || contents.length == 0) {
                return;
            }
            for (File content : contents) {
                if (content.isDirectory()) {
                    EXECUTOR_SERVICE.submit(new SearchFileTask(content, fileName, completableFuture));
                } else {
                    if (content.getName().equals(fileName)) {
                        FileSearchResult fileSearchResult = new FileSearchResult();
                        fileSearchResult.setFound(true);
                        fileSearchResult.setFilePath(content.getAbsolutePath());
                        completableFuture.complete(fileSearchResult);
                        return;
                    }
                }
                if (completableFuture.isDone()) {
                    return;
                }
            }
        }
    }
}