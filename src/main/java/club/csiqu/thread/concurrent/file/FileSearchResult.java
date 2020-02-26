package club.csiqu.thread.concurrent.file;

/**
 * 用来存放文件搜索结果
 *
 * @author chensiqu 2020/2/9
 * @since 1.0.0
 */
public class FileSearchResult {

    private Boolean isFound;

    private String filePath;

    FileSearchResult() {
        this.isFound = false;
    }

    public Boolean getFound() {
        return isFound;
    }

    public void setFound(Boolean found) {
        isFound = found;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}