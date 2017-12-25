package com.anxpp.demo;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

@SpringBootApplication
public class DemoRabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoRabbitmqApplication.class, args);
    }

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Bean
    CommandLineRunner starter() {
        return args -> {
            System.out.println("Sending message...");
            int i = 1000;
            while (i-- > 0)
                rabbitTemplate.convertAndSend(queueName, String.valueOf(1000 - i));
        };
    }

    private final static String queueName = "numberQueue";

    // 队列
    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }

    // 主题
    @Bean
    TopicExchange exchange() {
        return new TopicExchange("simple");
    }

    //
    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(queueName);
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueName);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }
}
