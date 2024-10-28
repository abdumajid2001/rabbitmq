package abj.chatgptrabbitmq;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MqttController {

    private final MqttPublisher mqttPublisher;

    public MqttController(MqttPublisher mqttPublisher) {
        this.mqttPublisher = mqttPublisher;
    }

    @GetMapping("/publish")
    public String publish(@RequestParam String topic, @RequestParam String message) {
        mqttPublisher.publish(topic, message);
        return "Message published to topic " + topic;
    }

}

