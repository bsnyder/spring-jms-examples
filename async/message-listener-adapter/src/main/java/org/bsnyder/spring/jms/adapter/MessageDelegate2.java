package org.bsnyder.spring.jms.adapter;

import java.util.Map;

public interface MessageDelegate2 {

    public abstract void processMessage(String message);

    public abstract void processMessage(byte[] message);

    public abstract void processMessage(Map message);

    public abstract void processMessage(Object message);

}