package club.csiqu.learn.concurrent.mock.file.model;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 用来存放文件搜索结果
 *
 * @author chensiqu 2020/2/9
 * @since 1.0
 */
public class FileSearchResult {

    /**
     * 是否查找到
     */
    private final AtomicBoolean isFound;

    /**
     * 文件路径
     */
    private volatile String filePath;

    public FileSearchResult() {
        this.isFound = new AtomicBoolean(false);
    }

    public boolean getFound() {
        return isFound.get();
    }

    public void setFound(boolean found) {
        isFound.getAndSet(found);
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}