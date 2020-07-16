package club.csiqu.learn.tool.kafka.producer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * @author Siqu Chen 2020/5/25
 * @since 1.0.0
 */
public class Producer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

    private KafkaProducer<String, String> kafkaProducer;

    private Producer() {
        init();
    }

    private void init() {
        Properties kafkaProps = new Properties();
        // 服务器地址
        kafkaProps.put("bootstrap.servers", "123.207.89.169:9092");
        // 键的序列化方式
        kafkaProps.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        // 值的序列化方式
        kafkaProps.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProducer = new KafkaProducer<>(kafkaProps);
    }

    public static Producer getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 发送并忘记，把消息发送至服务器，但是不关心是否到达
     */
    public void sendMessage(String topic, String key, String value) {
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, value);
        kafkaProducer.send(record);
    }

    /**
     * 同步发送消息
     */
    public void sendMessageSync(String topic, String key, String value) {
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, value);
        try {
            RecordMetadata recordMetadata = kafkaProducer.send(record).get();
            LOGGER.info("偏移量为：{}", recordMetadata.offset());
        } catch (Exception e) {
            LOGGER.warn("发送消息至Kafka出现异常：", e);
        }
    }

    /**
     * 异步发送消息
     */
    public void sendMessageAsync(String topic, String key, String value) {
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, value);
        kafkaProducer.send(record, new DemoProducerCallback());
    }

    /**
     * Kafka回调实现
     */
    private static class DemoProducerCallback implements Callback {

        @Override
        public void onCompletion(RecordMetadata recordMetadata, Exception e) {
            if (e != null) {
                LOGGER.warn("发送消息至Kafka发生异常：", e);
            }
        }
    }

    private static class SingletonHolder {

        private SingletonHolder() {}

        private static final Producer INSTANCE = new Producer();
    }
}