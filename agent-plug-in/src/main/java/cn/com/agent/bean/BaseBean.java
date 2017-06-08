package cn.com.agent.bean;

import java.io.Serializable;

import cn.com.agent.bean.merch.MercBusiBean;

import com.alibaba.fastjson.JSON;

public class BaseBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6050486651391004601L;
	private String action;
	private String requestId;
	private String timestamp;
	private Object body;
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}
	
	public static void main(String[] args) {
		MerchantBean merchantBean = new MerchantBean();
		merchantBean.setMercBusi(new MercBusiBean());
		BaseBean baseBean = new BaseBean();
		baseBean.setAction("1234");
		baseBean.setRequestId("abc");
		baseBean.setTimestamp("12345678");
		baseBean.setBody(merchantBean);
		System.out.println(JSON.toJSON(baseBean));
	}
	
}
