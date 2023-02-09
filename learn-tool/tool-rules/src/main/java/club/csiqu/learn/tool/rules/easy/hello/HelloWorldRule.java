package club.csiqu.learn.tool.rules.easy.hello;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Rule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Siqu Chen 2023/2/9
 * @since 1.0
 */
@Rule(name = "Hello Rule", description = "Always say hello world")
public class HelloWorldRule {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldRule.class);

    @Condition
    public boolean when() {
        return true;
    }

    @Action
    public void then() {
        LOGGER.info("Hello world.");
    }
}
