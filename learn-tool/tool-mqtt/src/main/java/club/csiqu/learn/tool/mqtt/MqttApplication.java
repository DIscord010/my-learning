package club.csiqu.learn.tool.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Siqu Chen 2020/11/12
 * @since 1.0.0
 */
public class MqttApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(MqttApplication.class);

    public static void main(String[] args) {
        // 统配符+代表匹配一个层级，而#可以匹配任意级别的层级且只能出现在主题尾部
        String subTopic = "test-topic/+";
        String pubTopic = "test-topic/1";

        int qos = 2;
        String broker = "tcp://123.207.89.169:1883";
        String clientId = "emqx_test_chen";
        MemoryPersistence persistence = new MemoryPersistence();

        try (MqttClient client = new MqttClient(broker, clientId, persistence)) {
            // MQTT连接选项
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setUserName("emqx_test_chen");
            connOpts.setPassword("emqx_test_chen_password".toCharArray());
            // 保留会话
            connOpts.setCleanSession(true);
            // 设置回调
            client.setCallback(new MessageCallBack());
            // 建立连接
            client.connect(connOpts);
            // 订阅
            client.subscribe(subTopic);
            // 消息发布所需参数
            String content = "Hello World";
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            client.publish(pubTopic, message);
            client.disconnect();
        } catch (MqttException e) {
            LOGGER.warn("MQTT Exception:", e);
        }
    }
}