package com.mqtt.app.model;

public class Message {
	
	private String terminalId;
	
	private String merchantName;

	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	@Override
	public String toString() {
		return "Message [terminalId=" + terminalId + ", merchantName=" + merchantName + "]";
	}
	
	

}
