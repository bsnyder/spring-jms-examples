package org.bsnyder.spring.jms.producer;

import java.util.Date;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class MessageProducer {
    
    private static final Logger LOG = LoggerFactory.getLogger(MessageProducer.class);
    
    protected JmsTemplate jmsTemplate; 
    
    protected int numberOfMessages = 100; 
    
    public void setNumberOfMessages(int numberOfMessages) {
        this.numberOfMessages = numberOfMessages;
    }

    public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	public void sendMessages(String messageType) throws JMSException {
		if ("text".equalsIgnoreCase(messageType)) {
			sendTextMessages();
		} else if ("bytes".equalsIgnoreCase(messageType)) {
			sendBytesMessages();
		} else if ("map".equalsIgnoreCase(messageType)) {
			sendMapMessages();
		} else if ("object".equalsIgnoreCase(messageType)) {
			sendObjectMessages();
		}
	}

	public void sendTextMessages() throws JMSException {
        final StringBuilder buffer = new StringBuilder(); 
        
        for (int i = 0; i < numberOfMessages; ++i) {
            buffer.append("Message '").append(i).append("' sent at: ").append(new Date());
            
            final int count = i;
            final String payload = buffer.toString();
            
            jmsTemplate.send(new MessageCreator() {
                public Message createMessage(Session session) throws JMSException {
                    TextMessage message = session.createTextMessage(payload); 
                    message.setIntProperty("messageCount", count);
                    LOG.info("Sending text message number '{}'", count);
                    return message;
                }
            });
        }
    }
	
	public void sendBytesMessages() throws JMSException {
        final StringBuilder buffer = new StringBuilder(); 
        
        for (int i = 0; i < numberOfMessages; ++i) {
            buffer.append("Message '").append(i).append("' sent at: ").append(new Date());
            
            final int count = i;
            final String payload = buffer.toString();
            
            jmsTemplate.send(new MessageCreator() {
                public Message createMessage(Session session) throws JMSException {
                    BytesMessage message = session.createBytesMessage();
                    message.writeUTF(payload);
                    message.setIntProperty("messageCount", count);
                    LOG.info("Sending bytes message number '{}'", count);
                    return message;
                }
            });
        }
    }
	
	public void sendMapMessages() throws JMSException {
        final StringBuilder buffer = new StringBuilder(); 
        
        for (int i = 0; i < numberOfMessages; ++i) {
            buffer.append("Message '").append(i).append("' sent at: ").append(new Date());
            
            final int count = i;
            final String payload = buffer.toString();
            
            jmsTemplate.send(new MessageCreator() {
                public Message createMessage(Session session) throws JMSException {
                    MapMessage message = session.createMapMessage(); 
                    message.setString("payload", payload);
                    message.setIntProperty("messageCount", count);
                    LOG.info("Sending map message number '{}'", count);
                    return message;
                }
            });
        }
    }
	
	public void sendObjectMessages() throws JMSException {
        final StringBuilder buffer = new StringBuilder(); 
        
        for (int i = 0; i < numberOfMessages; ++i) {
            buffer.append("Message '").append(i).append("' sent at: ").append(new Date());
            
            final int count = i;
            final String payloadStr = buffer.toString();
            final Payload payload = new Payload(payloadStr);
            
            jmsTemplate.send(new MessageCreator() {
                public Message createMessage(Session session) throws JMSException {
                    ObjectMessage message = session.createObjectMessage(payload);
                    message.setIntProperty("messageCount", count);
                    LOG.info("Sending object message number '{}'", count);
                    return message;
                }
            });
        }
    }
	
}
