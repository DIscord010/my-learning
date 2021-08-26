package club.csiqu.learn.pattern.strategy.validation;

/**
 * @author Siqu Chen 2021/8/26
 * @since 1.0
 */
public class IsAllLowerCase implements ValidationStrategy{

    @Override
    public boolean execute(String string) {
        return string.matches("[a-z]+");
    }
}
