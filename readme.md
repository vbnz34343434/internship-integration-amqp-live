### Spring Integration 2. Live. Rabbit

#### Описание

1. Заранее развернуть Rabbit [тут](https://customer.cloudamqp.com)
2. Показать как создать подключение к ConnectionFactory, создать exchange и queue
3. Показать полученеи сообщения из queue
4. Показать отправку сообщения в exchange

```java

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
```
