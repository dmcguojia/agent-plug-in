package cn.com.agent.bean.query;

import java.io.Serializable;

public class MerchantQueryBean implements Serializable{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7017153599280598314L;
	private String merchNo;
	private String merchName;
	private long userId;
	public String getMerchNo() {
		return merchNo;
	}
	public void setMerchNo(String merchNo) {
		this.merchNo = merchNo;
	}
	public String getMerchName() {
		return merchName;
	}
	public void setMerchName(String merchName) {
		this.merchName = merchName;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	
}
