package springbootjms.springboot.jms.queue.topic.config;

import javax.jms.ConnectionFactory;

import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
@ComponentScan(basePackages = "springbootjms.springboot.jms.queue.topic")
public class JmsConfigguration {
	
	@Bean	//Ham tao ket noi va send data => factory
	public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer){
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		configurer.configure(factory, connectionFactory);
		return factory;
	}
	
	@Bean	//Ham chuyen doi POJO => JSON
	public MessageConverter jacksonJmsConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter . setTargetType(MessageType.TEXT);
		converter . setTypeIdPropertyName("_type");
		return converter;
	}
}
