package club.csiqu.patterns.iterator;

/**
 * 迭代器模式
 * <p>
 * 提供一种方法顺序访问一个聚合对象中各个元素,而又无须暴露该对象的内部表示。
 *
 * @author chensiqu
 * @since 2019/3/20 13:36
 */
public class IteratorMain {

    public static void main(String[] args) {
        NameCollection nameCollection = new NameCollection();

        // 自定义的迭代器进行迭代
        for (Iterator iter = nameCollection.getIterator(); iter.hasNext(); ) {
            String name = iter.next();
            System.out.println("Name : " + name);
        }
        System.out.println();
        // 实现 java.util.Iterator<>接口进行迭代
        for (String iter : nameCollection) {
            System.out.println("Name : " + iter);
        }
    }
}