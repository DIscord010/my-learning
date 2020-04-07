package club.csiqu.learn.structure.set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 自定义简单 BitSet
 *
 * @author chensiqu
 * @since 2019/4/9 22:15
 */
class BitSet {

    private static final Logger LOGGER = LoggerFactory.getLogger(BitSet.class);

    /** 位图数组 */
    private int[] words;

    /**
     * 构造函数，传入最大数值。
     *
     * @param max 最大数值
     */
    public BitSet(int max) {
        words = new int[(max >> 5) + 1];
    }

    /**
     * 判断某一数字是否存在
     *
     * @param bitIndex 数字
     * @return {@code true} 如果存在
     */
    public boolean get(int bitIndex) {
        if (LOGGER.isInfoEnabled()) {
            // 放入的坑
            LOGGER.info("index is {}", wordIndex(bitIndex));
            // 坑的第几位
            LOGGER.info("int index is {}", Integer.toBinaryString(1 << bitIndex));
        }
        // 在大于 2^5的情况下，1 << 32 相当于 1 << 0
        return (words[wordIndex(bitIndex)] & (1 << bitIndex)) != 0;
    }

    /**
     * 插入某一数字，即将该位置为 1
     *
     * @param bitIndex 数字
     */
    public void set(int bitIndex) {
        words[wordIndex(bitIndex)] |= 1 << bitIndex;
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
}