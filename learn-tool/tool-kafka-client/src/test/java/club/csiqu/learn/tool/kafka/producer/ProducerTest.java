package club.csiqu.learn.tool.kafka.producer;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

/**
 * @author Siqu Chen 2020/5/25
 * @since 1.0
 */
class ProducerTest {

    @AfterAll
    static void closeProducer() {
        Producer.getInstance().close();
    }

    @Test
    void testSendMessage() {
        Producer producer = Producer.getInstance();
        producer.sendMessage("TEST", null, "test1");
    }

    @Test
    void testSendMessageSync() {
        Producer producer = Producer.getInstance();
        producer.sendMessageSync("TEST", null, "test2");
    }

    @Test
    void testSendMessageAsyc() {
        Producer producer = Producer.getInstance();
        producer.sendMessageAsync("TEST", null, "test3");
    }
}