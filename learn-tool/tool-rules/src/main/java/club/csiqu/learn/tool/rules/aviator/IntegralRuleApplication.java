package club.csiqu.learn.tool.rules.aviator;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Siqu Chen 2023/9/4
 * @since 1.0.0
 */
public class IntegralRuleApplication {

    public static void main(String[] args) {
        Expression compiled = AviatorEvaluator.compile("x > 1 && x <= 100");
        Map<String, Object> value = new HashMap<>();
        value.put("x", 1000000);
        System.out.print(compiled.execute(value));
    }
}