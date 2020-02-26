package club.csiqu.basis.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


/**
 * {@link FileChannel}使用
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/26 11:39
 */
public class FileChannelSample {

    public static void main(String[] args) throws IOException {

        RandomAccessFile accessFile = new RandomAccessFile("src/main/resources/file/test.txt", "rw");
        FileChannel fileChannel = accessFile.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(48);
        // read into buffer
        int bytesRead = fileChannel.read(buffer);

        while (bytesRead != -1) {
            System.out.println("Read " + bytesRead + " Bytes");
            buffer.flip();
            // 按字节读取
            while (buffer.hasRemaining()) {
                System.out.print((char) buffer.get());
            }
            buffer.clear();
            bytesRead = fileChannel.read(buffer);
        }
        accessFile.close();
    }
}