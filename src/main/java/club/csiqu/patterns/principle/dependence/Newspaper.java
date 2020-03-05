package club.csiqu.patterns.principle.dependence;

/**
 * @author chensiqu
 * @since 2019/3/13 13:51
 */
class Newspaper implements Reader {

    @Override
    public String getContent() {
        return "林书豪38+7领导尼克斯击败湖人……";
    }
}