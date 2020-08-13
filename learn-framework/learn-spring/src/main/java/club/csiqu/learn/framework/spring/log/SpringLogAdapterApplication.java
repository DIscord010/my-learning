package club.csiqu.learn.framework.spring.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * spring5的 JCL验证
 * <p>
 * 在没有任何其他日志处理的情况下，使用默认的 JUL日志处理。
 * 在拥有其他日志处理的情况下，分析源码：
 * 通过 {@link Class#forName(String)}依次判断当前项目使用的日志处理，
 * 再使用对应的适配器进行加载。
 * 分析后发现只支持 slf4j和 log4j2.x。
 *
 * @author chensiqu
 * @since 2019/3/29 15:58
 */
public class SpringLogAdapterApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLogAdapterApplication.class);

    public static void main(String[] args) {
        try {
            // 通过反射加载 org.apache.commons.logging.LogAdapter类
            Class<?> logAdapter = Class.forName("org.apache.commons.logging.LogAdapter");
            String fields = Arrays.toString(logAdapter.getDeclaredFields());
            LOGGER.info("{}", fields);
            // 获取私有属性 logApi的值
            Field field = logAdapter.getDeclaredField("logApi");
            field.setAccessible(true);
            // 此处在没有导入 slf4j和 log4j2日志包的情况下为 JUL
            LOGGER.info("{}", field.get(logAdapter));
        } catch (ClassNotFoundException | NoSuchFieldException | IllegalAccessException e) {
            LOGGER.warn("获取Spring LogAdapter失败：{}，可能为未引入JAR.", e.getMessage());
        }
    }
}