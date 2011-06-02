package org.bsnyder.spring.jms.receiver;

import javax.jms.Message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;

public class SimpleMessageReceiver {
    
    private static final Logger LOG = LoggerFactory.getLogger(SimpleMessageReceiver.class);

    protected JmsTemplate jmsTemplate; 
    
    public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void receive(String receiveType) {
		if ("jmsReceive".equalsIgnoreCase(receiveType)) {
			jmsReceive();
		} else if ("receiveAndConvert".equalsIgnoreCase(receiveType)) {
			receiveAndConvert();
		}
	}
	
	public void jmsReceive() {
		Message message = jmsTemplate.receive();
		LOG.debug("Received a JMS message: {}", message);
    }
	
	public void receiveAndConvert() {
		String message = (String) jmsTemplate.receiveAndConvert();
		LOG.debug("Received a text message: {}", message);
	}

}
