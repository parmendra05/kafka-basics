package com.pack.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.pack.payloads.Person;

@Service
public class KafkaJsonProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJsonProducer.class);

	@Autowired
	private KafkaTemplate<String, Person> kafkaTemplate;

	public void sendMessage(Person data) {

		LOGGER.info(String.format("Message sent -> %s", data.toString()));

		Message<Person> message = MessageBuilder
				.withPayload(data)
				.setHeader(KafkaHeaders.TOPIC, "json-topic")
				.build();

		kafkaTemplate.send(message);
	}
}
