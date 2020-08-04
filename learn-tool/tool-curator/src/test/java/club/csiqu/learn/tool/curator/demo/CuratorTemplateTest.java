package club.csiqu.learn.tool.curator.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Siqu Chen 2020/8/4
 * @since 1.0
 */
class CuratorTemplateTest {

    CuratorTemplate curatorTemplate = new CuratorTemplate("192.168.71.143");

    @Test
    void testListByNode() throws Exception {
        List<String> children = curatorTemplate.listByNode("/dubbo");
        Assertions.assertTrue(children.contains("config"));
    }
}