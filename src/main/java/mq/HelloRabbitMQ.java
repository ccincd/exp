/*
 * Copyright (c) 2016 ywmj.com. All Rights Reserved.
 */
package mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * HelloRabbitMQ
 *
 * @author cc
 * @version 1.0, 2016/12/30
 */
public class HelloRabbitMQ {

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        /*factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setHost("127.0.0.1");
        factory.setPort(5672);*/
        Connection conn = factory.newConnection();
        Channel channel = conn.createChannel();
        channel.close();
        conn.close();
    }
}
