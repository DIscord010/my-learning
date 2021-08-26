package club.csiqu.learn.pattern.strategy.validation;

/**
 * @author Siqu Chen 2021/8/26
 * @since 1.0
 */
public interface ValidationStrategy {

    boolean execute(String string);
}
