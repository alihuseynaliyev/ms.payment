package az.alinazim.ms.payment.config;

import lombok.Data;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class RabbitMQConfig {

    @Value("${rabbit.mq.payment}")
    private String queue;
    private final String exchange = queue + "_exchange";
    private final String routingKey = queue + "_routingKey";


    @Bean
    public DirectExchange orderExchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    public Queue orderQueue() {
        return QueueBuilder.durable(queue)
                .withArgument("x-dead-letter-exchange", queue + "dead-letter-exchange")
                .withArgument("x-dead-letter-routing-key", queue + "dead-letter-queue")
                .build();
    }

    @Bean
    public Binding orderBinding() {
        return BindingBuilder.bind(orderQueue()).to(orderExchange()).with(routingKey);
    }

    @Bean
    public DirectExchange deadLetterExchange() {
        return new DirectExchange(queue + "dead-letter-exchange");
    }

    @Bean
    public Queue deadLetterQueue() {
        return new Queue(queue + "dead-letter-queue");
    }

    @Bean
    public Binding deadLetterBinding() {
        return BindingBuilder.bind(deadLetterQueue())
                .to(deadLetterExchange())
                .with(queue + "dead-letter-queue");
    }
}
