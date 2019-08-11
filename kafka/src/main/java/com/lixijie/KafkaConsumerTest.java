package com.lixijie;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import java.util.Collections;
import java.util.Properties;

/**
 * 消费者
 */
public class KafkaConsumerTest {

    private final KafkaConsumer< String, String > consumer;
    private ConsumerRecords< String, String > msgList;
    private final String topic;
    private static final String GROUPID = "groupA";

    public KafkaConsumerTest(String topicName) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.0.101:9092,192.168.0.105:9092,192.168.0.106:9092");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "mykafka");
        this.consumer = new KafkaConsumer< String, String >(props);
        this.topic = topicName;
        this.consumer.subscribe(Collections.singletonList(topic));

        System.out.println("---------开始消费---------");
        try {
            while (true) {
                ConsumerRecords< String, String > records = consumer.poll(100);
                for (ConsumerRecord< String, String > record : records) {
                    System.out.println(String.format("topic:%s,offset:%d,消息:%s",
                            record.topic(), record.offset(), record.value()));
                }
            }
        } finally {
            consumer.close();
        }

    }


        public static void main(String args[]) {
            KafkaConsumerTest test1 = new KafkaConsumerTest("mykafka");

        }

}