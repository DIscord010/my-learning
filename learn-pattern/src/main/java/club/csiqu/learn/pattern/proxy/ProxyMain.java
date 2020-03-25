package club.csiqu.learn.pattern.proxy;

/**
 * 代理模式
 *
 * @author chensiqu
 * @since 2019/3/19 13:46
 */
public class ProxyMain {

    public static void main(String[] args) {
        Image image = new ImageProxy("test.jpg");

        // 此处会初始化被代理类的实例
        image.display();
        System.out.println();
        image.display();
    }
}