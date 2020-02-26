package club.csiqu.patterns.principle.dependence;

/**
 * @author chensiqu
 * @since 2019/3/13 13:51
 */
class Mother {

    /**
     * 依赖于接口 而不是具体的实现类
     *
     * @param iReader 读物
     */
    void narrate(IReader iReader) {
        System.out.println("妈妈开始讲故事：");
        System.out.println(iReader.getContent());
    }
}