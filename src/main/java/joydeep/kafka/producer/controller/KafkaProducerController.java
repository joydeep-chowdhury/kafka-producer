package joydeep.kafka.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import joydeep.kafka.producer.model.User;

@RestController
@RequestMapping("kafka")
public class KafkaProducerController {
	@Autowired
	private KafkaTemplate<String ,User> kafkaTemplate;
	private static final String TOPIC="kafka_example";
	
//	@GetMapping("/publish/{message}")
//	public String post(@PathVariable("message") final String message)
//	{
//		kafkaTemplate.send(TOPIC,message);
//	     return "Published successfully";	
//	}
	
	
	@RequestMapping(value="/publishJson",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public String postMessage(@RequestBody User requestUser)
	{
		kafkaTemplate.send(TOPIC,requestUser);
	     return "Published successfully";	
	}
}
