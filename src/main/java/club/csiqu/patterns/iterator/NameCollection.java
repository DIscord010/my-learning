package club.csiqu.patterns.iterator;

/**
 * @author chensiqu
 * @since 2019/3/20 11:04
 */
public class NameCollection implements Container,Iterable<String> {

    private String[] names = {"Robert", "John", "Julie", "Lora"};

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    @Override
    public java.util.Iterator<String> iterator() {
        return new NameIterator();
    }

    /**
     * 实现了 Iterator接口的内部类
     */
    private class NameIterator implements Iterator, java.util.Iterator<String> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < names.length;
        }

        @Override
        public String next() {
            return this.hasNext() ? names[index++] : null;
        }
    }
}