package cn.com.agent.bean.query;

import java.io.Serializable;

public class TermQueryBean implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1672416289556364702L;
	private String termNo;
	private String merchNO;
	private long userId;
	public String getTermNo() {
		return termNo;
	}
	public void setTermNo(String termNo) {
		this.termNo = termNo;
	}
	public String getMerchNO() {
		return merchNO;
	}
	public void setMerchNO(String merchNO) {
		this.merchNO = merchNO;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	
}
