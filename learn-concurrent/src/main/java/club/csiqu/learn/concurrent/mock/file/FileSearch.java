package club.csiqu.learn.concurrent.mock.file;

import club.csiqu.learn.concurrent.mock.file.model.FileSearchResult;

import java.io.File;

/**
 * @author Siqu Chen 2020/7/30
 * @since 1.0
 */
public interface FileSearch {

    /**
     * 在指定文件路径下查找某一文件
     *
     * @param file     文件路径
     * @param fileName 文件名
     * @return 查找结果
     */
    FileSearchResult searchFile(File file, String fileName);
}