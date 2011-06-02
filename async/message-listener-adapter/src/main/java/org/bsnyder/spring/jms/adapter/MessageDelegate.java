package org.bsnyder.spring.jms.adapter;

import javax.jms.BytesMessage;
import javax.jms.MapMessage;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

public interface MessageDelegate {

    public abstract void handleMessage(TextMessage message);

    public abstract void handleMessage(BytesMessage message);

    public abstract void handleMessage(MapMessage message);

    public abstract void handleMessage(ObjectMessage message);

}