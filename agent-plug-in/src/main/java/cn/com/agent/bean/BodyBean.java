package cn.com.agent.bean;

import java.io.Serializable;

public class BodyBean implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6631995191474965843L;
	private String status;
	private String merchantId;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	
}
