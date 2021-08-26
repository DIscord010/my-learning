package club.csiqu.learn.pattern.strategy.validation;

/**
 * @author Siqu Chen 2021/8/26
 * @since 1.0
 */
public class Validator {

    private final ValidationStrategy strategy;

    public Validator(ValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validate(String string) {
        return strategy.execute(string);
    }
}
