package com.jacstuff.msscjms.listener;

import javax.jms.Message;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.jacstuff.msscjms.config.JmsConfig;
import com.jacstuff.msscjms.model.HelloWorldMessage;

@Component
public class HelloMessageListener {


	@JmsListener(destination = JmsConfig.MY_QUEUE)
	public void listen(@Payload HelloWorldMessage helloWorldMessage, 
						@Headers MessageHeaders headers, Message message) {
		System.out.println("message received: " + helloWorldMessage);
	}
}
