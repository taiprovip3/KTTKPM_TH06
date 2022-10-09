package springbootjms.springboot.jms.queue.topic.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import springbootjms.springboot.jms.queue.topic.entity.Product;

@Component
public class MessageReceiver {
	
	private static final String MESSAGE_QUEUE = "message_queue";
	private static final String MESSAGE_TOPIC = "message_topic";
	
//	@JmsListener(destination = MESSAGE_QUEUE)
//	public void receiveMessageFromQueueApache(Product p) {
//		System.out.println("Listening product -> " + p);
//	}
	
	@JmsListener(destination = MESSAGE_TOPIC)
	public void reciveMessageFromTopicApache(Product p) {
		System.out.println("Listening from subcriber -> " + p);
	}

}
