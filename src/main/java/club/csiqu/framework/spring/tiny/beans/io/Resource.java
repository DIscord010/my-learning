package club.csiqu.framework.spring.tiny.beans.io;

import java.io.InputStream;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/19 9:43
 */
public interface Resource {

    InputStream getInputSteam() throws Exception;
}