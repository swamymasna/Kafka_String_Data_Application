package com.swamy.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swamy.kafka.KafkaProducer;

@RestController
@RequestMapping("kafka")
public class MessageRestController {

	@Autowired
	private KafkaProducer kafkaProducer;
	
	@GetMapping("/publish")
	public ResponseEntity<String>publish(@RequestParam String message){
		kafkaProducer.sendMessage(message);
		return ResponseEntity.ok("Message Sent Successfully....!");
	}
	//	http://localhost:9090/kafka/publish?message=Hello World
}









