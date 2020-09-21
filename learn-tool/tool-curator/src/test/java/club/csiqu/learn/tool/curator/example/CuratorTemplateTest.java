package club.csiqu.learn.tool.curator.example;

import org.apache.curator.framework.recipes.cache.CuratorCacheListener;
import org.apache.curator.test.TestingServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Siqu Chen 2020/8/4
 * @since 1.0
 */
class CuratorTemplateTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CuratorTemplateTest.class);

    CuratorTemplate curatorTemplate;

    TestingServer zkServer;

    @BeforeEach
    public void setUp() throws Exception {
        int zkServerPort = 1122;
        this.zkServer = new TestingServer(zkServerPort, true);
        this.curatorTemplate = new CuratorTemplate("127.0.0.1:" + zkServerPort);
    }

    @AfterEach
    public void tearDown() throws Exception {
        curatorTemplate.close();
        zkServer.close();
    }

    @Test
    void testListByNode() throws Exception {
        curatorTemplate.createNode("/test");
        curatorTemplate.createNode("/test/test");
        List<String> children = curatorTemplate.listByNode("/test");
        Assertions.assertTrue(children.contains("test"));
    }

    @Test
    void testListener() throws Exception {
        AtomicInteger atomicInteger = new AtomicInteger();
        curatorTemplate.addListener("/test", (type, oldNode, node) -> {
            if (type == CuratorCacheListener.Type.NODE_CREATED) {
                LOGGER.info("Node created: {}", node);
                atomicInteger.addAndGet(1);
            }
        });
        curatorTemplate.createNode("/test");
        curatorTemplate.createNode("/test/test");
        curatorTemplate.createNode("/test/dddd");
        List<String> children = curatorTemplate.listByNode("/test");
        Assertions.assertTrue(children.contains("test"));
        Assertions.assertEquals(3, atomicInteger.get());
    }
}