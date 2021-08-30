package club.csiqu.learn.pattern.strategy.validation;

/**
 * @author Siqu Chen 2021/8/26
 * @since 1.0
 */
public interface ValidationStrategy {

    /**
     * 对字符串进行校验
     *
     * @param string 目标字符串
     * @return 是否满足某一条件
     */
    boolean execute(String string);
}
