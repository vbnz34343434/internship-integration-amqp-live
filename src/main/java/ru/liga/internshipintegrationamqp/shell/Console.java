package ru.liga.internshipintegrationamqp.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.liga.internshipintegrationamqp.config.RabbitConfig;

@ShellComponent
@RequiredArgsConstructor
public class Console {

    private final RabbitTemplate rabbitTemplate;

    @ShellMethod("send message")
    public void send(@ShellOption String message) {
        rabbitTemplate.convertAndSend(RabbitConfig.MESSAGE_EXCHANGE, null, "dmelnik: " + message);
    }
}