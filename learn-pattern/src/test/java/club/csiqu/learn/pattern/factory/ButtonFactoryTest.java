package club.csiqu.learn.pattern.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Siqu Chen 2020/9/11
 * @since 1.0
 */
class ButtonFactoryTest {


    @Test
    void testCreateButton() {
        ButtonFactory buttonFactory = new DefaultButtonFactory();
        Button button = buttonFactory.createButton();
        Assertions.assertEquals("Render a button in a Windows style",button.render());
    }
}