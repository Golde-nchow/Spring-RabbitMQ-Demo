package com.simple.mq.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author User
 * @description RabbitMQ配置
 * @date 2020/9/27 22:43
 */
@Configuration
public class RabbitMqConfig {

    /**
     * 队列名称
     */
    @Value("${cjz.topic.queue.name}")
    private String topicQueue;

    /**
     * 交换器名称
     */
    @Value("${cjz.topic.exchange.name}")
    private String topicExchange;

    /**
     * 路由键
     */
    @Value("${cjz.topic.routingKey.name}")
    private String topicRoutingKey;

    /**
     * 日志打印
     */
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 队列初始化
     */
    @Bean
    public Queue topicQueue() {
        // 持久化:true；排他:false；自动删除:false
        return new Queue(topicQueue, true, false, false);
    }

    /**
     * 主体交换器初始化
     */
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(topicExchange, true, false);
    }

    /**
     * 交换器和（队列 + 路由键）绑定
     */
    @Bean
    public Binding bindingTopicQueue() {
        return BindingBuilder.bind(topicQueue()).to(topicExchange()).with(topicRoutingKey);
    }
}
