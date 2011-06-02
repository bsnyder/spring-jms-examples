package org.bsnyder.spring.jms.producer;

import java.io.Serializable;

public class Payload implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	String payload;
	
	public Payload(String payload) {
		this.payload = payload;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

}
