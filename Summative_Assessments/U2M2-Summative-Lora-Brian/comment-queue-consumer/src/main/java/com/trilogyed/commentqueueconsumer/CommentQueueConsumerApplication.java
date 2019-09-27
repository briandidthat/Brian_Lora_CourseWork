package com.trilogyed.commentqueueconsumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class CommentQueueConsumerApplication {
	public static final String TOPIC_EXCHANGE_NAME = "comment-exchange";
	public static final String QUEUE_NAME = "comment-queue";
	public static final String ROUTING_KEY = "comment.create.#";

	// Creating a Queue Object that is needed to perform queues (will encapsulate Queue name)
	@Bean
	Queue queue() {
		return new Queue(QUEUE_NAME, false);
	}

	// Will instantiate the Topic Exchange Object
	@Bean
	TopicExchange exchange() {
		return new TopicExchange(TOPIC_EXCHANGE_NAME);
	}

	// Binding the queue and exchange together  WITH the routing key for cohesive use
	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
	}

	@Bean
	@Primary
	public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
		ObjectMapper objectMapper = builder.build();
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		return objectMapper;
	}

	// Finally, defining the Jackson converter we will need to convert NoteEntry object json
	// Producer(Book service) calls convertAndSend --> Consumer(NoteQueueConsumer) receives as Json for use.
	@Bean
	public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	public static void main(String[] args) {
		SpringApplication.run(CommentQueueConsumerApplication.class, args);
	}

}
