package club.csiqu.learn.pattern.principle.dependence;

/**
 * @author chensiqu
 * @since 2019/3/13 13:51
 */
class Mother {

    /**
     * 依赖于接口 而不是具体的实现类
     *
     * @param reader 读物
     */
    void narrate(Reader reader) {
        System.out.println("妈妈开始讲故事：");
        System.out.println(reader.getContent());
    }
}