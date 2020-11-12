package club.csiqu.learn.tool.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Siqu Chen 2020/11/12
 * @since 1.0.0
 */
public class MessageCallBack implements MqttCallback {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageCallBack.class);

    @Override
    public void connectionLost(Throwable throwable) {
        LOGGER.warn("MQTT connection Lost.");
    }

    @Override
    public void messageArrived(String topic, MqttMessage mqttMessage) {
        LOGGER.info("接收消息主题: {}", topic);
        LOGGER.info("接收消息Qos: {}", mqttMessage.getQos());
        String message = new String(mqttMessage.getPayload());
        LOGGER.info("接收消息内容: {}", message);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        LOGGER.info("deliveryComplete-----------{}", iMqttDeliveryToken.isComplete());
    }
}