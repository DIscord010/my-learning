package club.csiqu.learn.pattern.builder;

/**
 * 表示食物的抽象类
 *
 * @author chensiqu
 * @since 2019/3/19 10:03
 */
abstract class AbstractItem {

    abstract String name();

    abstract Packing packing();

    abstract float price();

}