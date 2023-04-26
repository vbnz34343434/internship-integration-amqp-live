package ru.liga.internshipintegrationamqp.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ru.liga.internshipintegrationamqp.config.RabbitConfig;

@Component
@Slf4j
public class RabbitMqListener {

    @RabbitListener(queues = RabbitConfig.RECEIVE_QUEUE)
    public void listen(String message) {
        log.warn(String.format("message received from %s: %s", RabbitConfig.RECEIVE_QUEUE, message));
    }
}
