package club.csiqu.framework.spring.tiny.beans.io;

import java.net.URL;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/19 9:46
 */
public class ResourceLoader {

    public Resource getResource(String location) {

        URL resouce = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resouce);
    }
}