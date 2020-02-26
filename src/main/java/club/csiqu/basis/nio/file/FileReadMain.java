package club.csiqu.basis.nio.file;

import com.google.common.base.Stopwatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/10/17
 */
public class FileReadMain {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileReadMain.class);

    /**
     * 使用传统的 IO进行文件拷贝
     *
     * @throws IOException IO异常
     */
    private static void fileCopyByInputStream() throws IOException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        File file = new File("F:/test.txt");
        File copy = new File("F:/copy1.txt");
        try (FileInputStream in = new FileInputStream(file);
             FileOutputStream out = new FileOutputStream(copy)) {

            byte[] data = new byte[1024];
            // 读取内容
            while (in.read(data) != -1) {
                out.write(data);
            }
        }
        stopwatch.stop();
        LOGGER.info("fileCopyByInputStream time：" + stopwatch);
    }

    /**
     * 使用传统的 IO进行文件拷贝（缓冲）
     *
     * @throws IOException IO异常
     */
    private static void fileCopyByBufferedStream() throws IOException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        File file = new File("F:/test.txt");
        File copy = new File("F:/copy1.txt");
        try (FileInputStream in = new FileInputStream(file);
             FileOutputStream out = new FileOutputStream(copy);
             BufferedInputStream inputStream = new BufferedInputStream(in);
             BufferedOutputStream outputStream = new BufferedOutputStream(out)) {

            byte[] data = new byte[1024];
            // 读取内容
            while (inputStream.read(data) != -1) {
                outputStream.write(data);
            }
        }
        stopwatch.stop();
        LOGGER.info("fileCopyByBufferedStream time：" + stopwatch);
    }

    /**
     * 使用 NIO拷贝文件所花费的时间
     *
     * @throws IOException IO异常
     */
    private static void fileCopyByChannel() throws IOException {
        // 使用直接内存，申请内存的时间花费高，但是文件拷贝的效率会变高
        //ByteBuffer buffer = ByteBuffer.allocateDirect(2 << 16);
        Stopwatch stopwatch = Stopwatch.createStarted();
        File file = new File("F:/test.txt");
        File copy = new File("F:/copy2.txt");
        try (FileInputStream in = new FileInputStream(file);
             FileChannel channel = in.getChannel();
             FileOutputStream out = new FileOutputStream(copy);
             FileChannel copyChannel = out.getChannel()) {

            // NIO读取文件的效率与缓冲区的大小有密切关系，缓存区大小越大系统调用的次数越低
            // 当达到一定大小时则不会再降低效率（个人认为是申请内存的时间花费大于系统调用的时间花费）
            // 太大的话直接进入老年代会导致 GC问题
            ByteBuffer buffer = ByteBuffer.allocate(2 << 18);
            while (channel.read(buffer) != -1) {
                buffer.flip();
                copyChannel.write(buffer);
                buffer.clear();
            }
        }
        stopwatch.stop();
        LOGGER.info("fileCopyByNIO time：" + stopwatch);
    }

    /**
     * 使用 NIO中的内存映射拷贝文件花费的时间
     *
     * @throws IOException IO异常
     */
    private static void fileCopyByMapped() throws IOException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        File file = new File("F:/test.txt");
        File copy = new File("F:/copy3.txt");
        try (FileInputStream in = new FileInputStream(file);
             FileChannel channel = in.getChannel();
             FileOutputStream out = new FileOutputStream(copy);
             FileChannel copyChannel = out.getChannel()) {

            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
            copyChannel.write(buffer);
        }
        stopwatch.stop();
        LOGGER.info("fileCopyByMapped time：" + stopwatch);
    }

    /**
     * 使用 {@link FileChannel#transferTo(long, long, WritableByteChannel)}方法进行文件拷贝。
     *
     * @throws IOException IO异常
     */
    private static void fileCopyByTransTo() throws IOException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        File file = new File("F:/test.txt");
        File copy = new File("F:/copy4.txt");
        try (FileInputStream in = new FileInputStream(file);
             FileChannel channel = in.getChannel();
             FileOutputStream out = new FileOutputStream(copy);
             FileChannel copyChannel = out.getChannel()) {

            channel.transferTo(0, channel.size(), copyChannel);
        }
        stopwatch.stop();
        LOGGER.info("fileCopyByTransTo time：" + stopwatch);
    }

    /**
     * @throws IOException IO异常
     */
    private static void fileCopyByFiles() throws IOException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        File file = new File("F:/copy5.txt");
        if (file.exists()) {
            Files.delete(file.toPath());
        }
        Files.copy(Paths.get("F:/test.txt"), Paths.get("F:/copy5.txt"));
        stopwatch.stop();
        LOGGER.info("fileCopyByFiles time：" + stopwatch);
    }

    public static void main(String[] args) throws IOException {
        fileCopyByInputStream();
        fileCopyByBufferedStream();
        fileCopyByChannel();
        fileCopyByMapped();
        fileCopyByTransTo();
        fileCopyByFiles();
    }
}