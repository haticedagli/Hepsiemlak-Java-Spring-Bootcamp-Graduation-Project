package com.hepsiemlak.userservice.config;

import com.hepsiemlak.userservice.model.event.EventRoutingKeys;
import lombok.Data;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class RabbitMqConfig {

	@Value("${mq.producer.user.exchange}")
	private String userExchange;
	@Value("${mq.producer.user.queueName}")
	private String queueName;

	@Bean
	public Queue queue() {
		return new Queue(queueName, true);
	}

	@Bean
	public DirectExchange exchange() {
		return new DirectExchange(userExchange);
	}

	@Bean
	public Binding bindingCreated(Queue queue, DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(EventRoutingKeys.USER_CREATED.getRoutingKey());
	}

	@Bean
	public Binding bindingDeleted(Queue queue, DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(EventRoutingKeys.USER_DELETED.getRoutingKey());
	}

	@Bean
	public Jackson2JsonMessageConverter consumerJackson2JsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}
}
