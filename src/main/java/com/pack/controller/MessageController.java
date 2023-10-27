package com.pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pack.kafka.KafkaJsonProducer;
import com.pack.kafka.KafkaProducer;
import com.pack.payloads.Person;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

	@Autowired
	private KafkaProducer kafkaProducer;

	@Autowired
	private KafkaJsonProducer jsonKafkaProducer;

	@GetMapping("/publish/{message}")
	public ResponseEntity<String> publish(@PathVariable String message) {
		kafkaProducer.sendMessage(message);
		return new ResponseEntity<>("Messages published", HttpStatus.CREATED);
	}

	@PostMapping("/publish")
	public ResponseEntity<String> JsonMsgPublish(@RequestBody Person person) {
		jsonKafkaProducer.sendMessage(person);
		return ResponseEntity.ok("Json message sent to kafka topic");
	}
}
