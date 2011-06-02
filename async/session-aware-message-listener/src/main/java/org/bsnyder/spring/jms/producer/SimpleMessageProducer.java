package org.bsnyder.spring.jms.producer;

import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class SimpleMessageProducer {
    
    private static final Logger LOG = LoggerFactory.getLogger(SimpleMessageProducer.class);
    
    protected int numberOfMessages = 100; 
    
    protected JmsTemplate jmsTemplate; 
    
    protected Queue replyToDestination;
    
    public void setNumberOfMessages(int numberOfMessages) {
        this.numberOfMessages = numberOfMessages;
    }

    public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public Queue getReplyToDestination() {
		return replyToDestination;
	}

	public void setReplyToDestination(Queue replyToDestination) {
		this.replyToDestination = replyToDestination;
	}

	public void sendMessages() throws JMSException {
        final StringBuilder buffer = new StringBuilder(); 
        
        for (int i = 0; i < numberOfMessages; ++i) {
            buffer.append("Message '").append(i).append("' sent at: ").append(new Date());
            
            final int count = i;
            final String payload = buffer.toString();
            
            jmsTemplate.send(new MessageCreator() {
                public Message createMessage(Session session) throws JMSException {
                    TextMessage message = session.createTextMessage(payload); 
                    message.setJMSReplyTo(replyToDestination);
                    LOG.info("Sending request message number '{}'", count);
                    return message;
                }
            });
        }
    }
}
