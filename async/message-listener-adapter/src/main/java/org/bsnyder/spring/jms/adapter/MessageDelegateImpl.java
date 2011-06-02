package org.bsnyder.spring.jms.adapter;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;

public class MessageDelegateImpl implements MessageDelegate {
    
    private static final Logger LOG = Logger.getLogger(MessageDelegateImpl.class);
    
    /* (non-Javadoc)
     * @see com.springone.springjms.async.adapter.MyMessageDelegate#handleMessage(javax.jms.TextMessage)
     */
    public void handleMessage(TextMessage message) {
        try {
            LOG.info("Consumed text message number [" + message.getIntProperty("messageCount") + "]");
        } catch (JMSException e) {
            LOG.error(e.getMessage(), e);
        }
    }
    
    /* (non-Javadoc)
     * @see com.springone.springjms.async.adapter.MyMessageDelegate#handleMessage(javax.jms.BytesMessage)
     */
    public void handleMessage(BytesMessage message) {
        try {
            LOG.info("Consumed bytes message number [" + message.getIntProperty("messageCount") + "]");
        } catch (JMSException e) {
            LOG.error(e.getMessage(), e);
        }
    }
    
    /* (non-Javadoc)
     * @see com.springone.springjms.async.adapter.MyMessageDelegate#handleMessage(javax.jms.MapMessage)
     */
    public void handleMessage(MapMessage message) {
        try {
            LOG.info("Consumed map message number [" + message.getIntProperty("messageCount") + "]");
        } catch (JMSException e) {
            LOG.error(e.getMessage(), e);
        }
    }
    
    /* (non-Javadoc)
     * @see com.springone.springjms.async.adapter.MyMessageDelegate#handleMessage(javax.jms.ObjectMessage)
     */
    public void handleMessage(ObjectMessage message) {
        try {
            LOG.info("Consumed object message number [" + message.getIntProperty("messageCount") + "]");
        } catch (JMSException e) {
            LOG.error(e.getMessage(), e);
        }
    }
}
