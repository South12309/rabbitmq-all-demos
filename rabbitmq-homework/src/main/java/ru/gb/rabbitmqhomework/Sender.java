package ru.gb.rabbitmqhomework;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.Scanner;

public class Sender {
    private final static String QUEUE_NAME = "hello";
    private final static String EXCHANGER_NAME = "hello_exchanger";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(EXCHANGER_NAME, BuiltinExchangeType.DIRECT);
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            channel.queueBind(QUEUE_NAME, EXCHANGER_NAME, "java");

            Scanner sc = new Scanner(System.in);
            System.out.println("Введите сообщение");
            String msg = sc.nextLine();
            String[] parts = msg.split(" ");
            String topicName = parts[0];
            String s = msg.substring(msg.lastIndexOf(" "));

            channel.basicPublish(EXCHANGER_NAME, topicName, null, s.getBytes());
            System.out.println(" [x] Sent '" + s + "'");
        }
    }
}
