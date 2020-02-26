package club.csiqu.patterns.proxy;

/**
 * @author chensiqu
 * @since 2019/3/19 13:42
 */
public class ImageProxy implements Image {

    private RealImage realImage;

    private String fileName;

    ImageProxy(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        System.out.println("-------------------");
        realImage.display();
    }
}