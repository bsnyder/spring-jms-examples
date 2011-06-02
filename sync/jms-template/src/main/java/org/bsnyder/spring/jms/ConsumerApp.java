package org.bsnyder.spring.jms;

import javax.jms.JMSException;

import org.bsnyder.spring.jms.receiver.SimpleMessageReceiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This class drives the example from the consumer side. It loads the Spring 
 * {@link ApplicationContext} and sends messages. The entire configuration for 
 * this app is held in <tt>src/main/resources/jms-context.xml</tt>. 
 * 
 * @author bsnyder
 *
 */
public class ConsumerApp {
	
	private static final Logger LOG = LoggerFactory.getLogger(ConsumerApp.class);
    
    /**
     * Run the app and tell the producer to send its messages. 
     * 
     * @param args
     * @throws JMSException
     */
    public static void main(String[] args) throws JMSException {
    	ApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/consumer-jms-context.xml", ConsumerApp.class);
    	
    	SimpleMessageReceiver receiver = context.getBean(SimpleMessageReceiver.class);
    	for (int i = 0; i < 100; ++i) {
    		receiver.receive();
    	}
    }
    
}
