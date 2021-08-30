package club.csiqu.learn.pattern.strategy.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Siqu Chen 2021/8/26
 * @since 1.0
 */
public class ValidatorApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidatorApplication.class);

    public static void main(String[] args) {
        // before
        Validator numericValidator = new Validator(new IsNumeric());
        LOGGER.info("aah validate result:{}", numericValidator.validate("aah"));
        Validator lowerCaseValidator = new Validator(new IsLowerCase());
        LOGGER.info("good validate result:{}", lowerCaseValidator.validate("good"));

        // after
        LOGGER.info("nice validate result:{}", new Validator((String s) ->
                s.matches("[a-z]+")).validate("nice"));
    }
}
