package springbootjms.springboot.jms.queue.topic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
	
	@GetMapping("/pub/{message}")
	public String publishMessage(@PathVariable String message) {
		return "Publish message success -> " + message;
	}
	
	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello World!";
	}
}
