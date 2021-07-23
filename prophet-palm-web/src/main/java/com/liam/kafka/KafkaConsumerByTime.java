package com.liam.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndTimestamp;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Description:
 * Created by prophet on 2019/11/20 12:49
 */
public class KafkaConsumerByTime {

    public static void main(String[] args) {

        Properties props = new Properties();
        props.put("bootstrap.servers", "10.10.96.56:9092,10.10.96.168:9092,10.10.96.49:9092");
        props.put("group.id", "testtesttopictestestset12151");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        String topic = "jx.order.finishPay.bi.message";

        try {
            // 获取topic的partition信息
            List<PartitionInfo> partitionInfos = consumer.partitionsFor(topic);
            List<TopicPartition> topicPartitions = new ArrayList<>();

            Map<TopicPartition, Long> timestampsToSearch = new HashMap<>();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date now = new Date();
            long nowTime = now.getTime();
            System.out.println("当前时间: " + df.format(now));
            long fetchDataTime = nowTime - 1000 * 60 * 30;  // 计算30分钟之前的时间戳

            for (PartitionInfo partitionInfo : partitionInfos) {
                topicPartitions.add(new TopicPartition(partitionInfo.topic(), partitionInfo.partition()));
                timestampsToSearch.put(new TopicPartition(partitionInfo.topic(), partitionInfo.partition()), 1573660800000L);
            }

            consumer.assign(topicPartitions);

            // 获取指定时间每个partition的偏移量
            Map<TopicPartition, OffsetAndTimestamp> map = consumer.offsetsForTimes(timestampsToSearch);

            OffsetAndTimestamp offsetTimestamp = null;
            System.out.println("开始设置各分区初始偏移量...");
            for (Map.Entry<TopicPartition, OffsetAndTimestamp> entry : map.entrySet()) {
                // 如果设置的查询偏移量的时间点大于最大的索引记录时间，那么value就为空
                offsetTimestamp = entry.getValue();
                if (offsetTimestamp != null) {
                    int partition = entry.getKey().partition();
                    long timestamp = offsetTimestamp.timestamp();
                    long offset = offsetTimestamp.offset();
                    System.out.println("partition = " + partition +
                            ", time = " + df.format(new Date(timestamp)) +
                            ", offset = " + offset);
                    // 设置读取消息的偏移量
                    consumer.seek(entry.getKey(), offset);
                }
            }
            System.out.println("设置各分区初始偏移量结束...");

            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(1000);
                for (ConsumerRecord<String, String> record : records) {
                    System.out.println("partition = " + record.partition() + ", offset = " + record.offset());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            consumer.close();
        }
    }
}
