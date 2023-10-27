package com.pack.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

	@Bean
	public NewTopic myTopicBuilder() {
		return TopicBuilder.name("my-topic").build();
	}
	
	@Bean
	public NewTopic jsonTopicBuilder() {
		return TopicBuilder.name("json-topic").build();
	}
}
