package club.csiqu.learn.basis.jvm.instrument;

import java.lang.management.ManagementFactory;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/16 15:27
 */
class Base {

    public static void main(String[] args) {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        String s = name.split("@")[0];
        // 打印当前 Pid
        System.out.println("pid:" + s);
        while (true) {
            try {
                Thread.sleep(5000L);
            } catch (Exception e) {
                break;
            }
            process();
        }
    }

    private static void process() {
        System.out.println("process");
    }
}