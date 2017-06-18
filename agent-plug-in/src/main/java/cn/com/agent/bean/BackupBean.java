package cn.com.agent.bean;

import java.io.Serializable;

public class BackupBean implements Serializable{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4042165491856128645L;
	private String merchNo;
	private String deductSign;
	private String d0FeeRat;
	private String d0FixedFee;
	private String d0MinFeeAmt;
	private String d0MaxFeeAmt;
	public String getMerchNo() {
		return merchNo;
	}
	public void setMerchNo(String merchNo) {
		this.merchNo = merchNo;
	}
	public String getDeductSign() {
		return deductSign;
	}
	public void setDeductSign(String deductSign) {
		this.deductSign = deductSign;
	}
	public String getD0FeeRat() {
		return d0FeeRat;
	}
	public void setD0FeeRat(String d0FeeRat) {
		this.d0FeeRat = d0FeeRat;
	}
	public String getD0FixedFee() {
		return d0FixedFee;
	}
	public void setD0FixedFee(String d0FixedFee) {
		this.d0FixedFee = d0FixedFee;
	}
	public String getD0MinFeeAmt() {
		return d0MinFeeAmt;
	}
	public void setD0MinFeeAmt(String d0MinFeeAmt) {
		this.d0MinFeeAmt = d0MinFeeAmt;
	}
	public String getD0MaxFeeAmt() {
		return d0MaxFeeAmt;
	}
	public void setD0MaxFeeAmt(String d0MaxFeeAmt) {
		this.d0MaxFeeAmt = d0MaxFeeAmt;
	}
	
	
}
