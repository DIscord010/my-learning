package club.csiqu.learn.structure.set;

/**
 * 自定义简单 BitSet
 *
 * @author chensiqu
 * @since 2019/4/9 22:15
 */
class BitSet {


    /** 位图数组 */
    private int[] words;

    /**
     * 构造函数，传入最大数值。
     *
     * @param max 最大数值
     */
    private BitSet(int max) {
        words = new int[(max >> 5) + 1];
    }

    /**
     * 判断某一数字是否存在
     *
     * @param bitIndex 数字
     * @return {@code true} 如果存在
     */
    private boolean get(int bitIndex) {
        // 在大于 2^5的情况下，1 << 32 相当于 1 << 0
        // 放入的坑
        System.out.println(wordIndex(bitIndex));
        // 坑的第几位
        System.out.println(1 << bitIndex);
        return (words[wordIndex(bitIndex)] & (1 << bitIndex)) != 0;
    }

    /**
     * 获取数字所在的数组下标
     *
     * @param bitIndex 数字
     * @return 该放置的数组下标
     */
    private int wordIndex(int bitIndex) {
        return bitIndex >> 5;
    }

    /**
     * 插入某一数字，即将该位置为 1
     *
     * @param bitIndex 数字
     */
    private void set(int bitIndex) {
        words[wordIndex(bitIndex)] |= 1 << bitIndex;
    }

    public static void main(String[] args) {

        BitSet bitSet = new BitSet(100);
        bitSet.set(100);
        System.out.println(bitSet.get(32));
        System.out.println(bitSet.get(2));
        bitSet.set(2);
        System.out.println(bitSet.get(10));
    }
}