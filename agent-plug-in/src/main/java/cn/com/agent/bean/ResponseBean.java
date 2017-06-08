package cn.com.agent.bean;

import java.io.Serializable;

public class ResponseBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6875285651094657167L;
	private String requestId;
	private String code;
	private String message;
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
