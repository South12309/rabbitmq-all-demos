package ru.gb.rabbitmqhomework;

import com.rabbitmq.client.*;

import java.util.Scanner;

public class Receiver {
    private final static String QUEUE_NAME = "hello";
    private final static String EXCHANGE_NAME = "DoubleDirect";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
        String topicName="";
        Scanner sc = new Scanner(System.in);
        Thread consoleThread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        System.out.println("Введите тему set_topic <тема>");
        String topic = sc.nextLine();
        String[] parts = topic.split(" ");
        if (parts[0].equals("set_topic")) {
            topicName = parts[1];
        }
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, topicName);

        System.out.println(" [*] Waiting for messages");


        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(Thread.currentThread().getName() + " [x] Received '" + message + "'");
        };

        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
        });
    }

}
