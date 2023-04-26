package ru.liga.internshipintegrationamqp.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public static final String MESSAGE_EXCHANGE = "exchange-name";
    public static final String RECEIVE_QUEUE = "my-queue";

    @Bean
    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory factory = new CachingConnectionFactory("chatHost");
        factory.setUsername("username");
        factory.setVirtualHost("vhost");
        factory.setPassword("password");
        return factory;
    }

    @Bean
    public FanoutExchange getExchange() {

        return new FanoutExchange(MESSAGE_EXCHANGE);
    }

    @Bean
    public Queue getQueue() {
        return new Queue(RECEIVE_QUEUE);
    }

    @Bean
    public Binding getBinding() {
        return BindingBuilder
                .bind(getQueue())
                .to(getExchange());
    }
}
