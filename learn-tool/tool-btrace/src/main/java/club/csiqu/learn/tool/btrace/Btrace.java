package club.csiqu.learn.tool.btrace;

import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.println;

/**
 * JvisualVM使用 Btrace测试
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/10/2 9:35
 */
@BTrace
public class Btrace {

    /**
     * 在方法返回时打印参数信息
     *
     * @param o 方法
     */
    @OnMethod(clazz = "org.chensiqu.tool.btrace.Hello", method = "sayHello", location = @Location(Kind.RETURN))
    public static void printMethodRunTime(Object o) {
        println(o);
    }
}