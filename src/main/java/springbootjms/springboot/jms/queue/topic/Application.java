package springbootjms.springboot.jms.queue.topic;

import java.util.Iterator;
import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import springbootjms.springboot.jms.queue.topic.entity.Product;

@SpringBootApplication
@EnableJms
public class Application {
	
	private static final String MESSAGE_QUEUE = "message_queue";
	private static final String TOPIC_NAME = "message_topic";

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
		
		for (int i = 1; i < 5; i++) {
			Product p = new Product();
			p.setId(i);
			p.setName("Pandora Box " + i);
			p.setQuantity(new Random().nextInt(10000 - 1 + 1) + 1);
			
			System.out.println("Sending product: " + i);
			
			jmsTemplate.convertAndSend(MESSAGE_QUEUE, p);
			
			jmsTemplate.convertAndSend(TOPIC_NAME, p);
		}
	}

}
