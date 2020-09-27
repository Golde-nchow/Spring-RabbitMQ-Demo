package com.simple.mq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author User
 * @description 简单的生产者和消费者
 * @date 2020/9/27 22:17
 */
@SpringBootApplication
public class ProducerAndConsumerApp {

    public static void main(String[] args) {
        SpringApplication.run(ProducerAndConsumerApp.class, args);
    }

}
