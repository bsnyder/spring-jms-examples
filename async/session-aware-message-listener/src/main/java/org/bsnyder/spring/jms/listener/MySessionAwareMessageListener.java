package org.bsnyder.spring.jms.listener;

import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.listener.SessionAwareMessageListener;

public class MySessionAwareMessageListener implements SessionAwareMessageListener<Message> {
    
    private static final Logger LOG = LoggerFactory.getLogger(MySessionAwareMessageListener.class);

	@Override
	public void onMessage(Message message, Session session) throws JMSException {
        try {
            LOG.info("Received message: {}", ((TextMessage)message).getText());
            
            // Send a reply message 
            StringBuilder buffer = new StringBuilder("Reply message sent at: ").append(new Date());
            TextMessage newMessage = session.createTextMessage(buffer.toString());
            MessageProducer producer =  session.createProducer(message.getJMSReplyTo());
            LOG.info("Sending reply message");
            producer.send(newMessage);
        } catch (JMSException e) {
            LOG.error(e.getMessage(), e);
        }
		
	}

}
