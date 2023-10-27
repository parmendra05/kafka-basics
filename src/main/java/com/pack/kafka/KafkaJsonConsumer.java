package com.pack.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.pack.payloads.Person;

@Service
public class KafkaJsonConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJsonConsumer.class);

	@KafkaListener(topics = "json-topic", groupId = "myGroup")
	public void consume(Person person) {
		LOGGER.info(String.format("Json message recieved -> %s", person.toString()));
	}
}
