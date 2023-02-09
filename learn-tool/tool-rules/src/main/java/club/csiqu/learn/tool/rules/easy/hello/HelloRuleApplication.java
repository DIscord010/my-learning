package club.csiqu.learn.tool.rules.easy.hello;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;

/**
 * @author Siqu Chen 2023/2/9
 * @since 1.0
 */
public class HelloRuleApplication {

    public static void main(String[] args) {
        Facts facts = new Facts();
        Rules rules = new Rules();
        rules.register(new HelloWorldRule());
        RulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.fire(rules, facts);
    }
}
