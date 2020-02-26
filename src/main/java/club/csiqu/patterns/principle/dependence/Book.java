package club.csiqu.patterns.principle.dependence;

/**
 * @author chensiqu
 * @since 2019/3/13 13:51
 */
class Book implements IReader {

    @Override
    public String getContent() {
        return "很久很久以前有一个阿拉伯的故事……";
    }
}