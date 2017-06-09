package cn.com.agent.bean.merch;

import java.io.Serializable;

public class MercBusiBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5035010202283239620L;

	private String mercAttr;
	private String regId;
	private String orgCod;
	private String regCapAmt;
	private String regAddr;
	private String taxCertId;
	private String crpIdTyp;
	private String crpIdNo;
	private String crpNm;
	
	
	public String getMercAttr() {
		return mercAttr;
	}
	public void setMercAttr(String mercAttr) {
		this.mercAttr = mercAttr;
	}
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	public String getOrgCod() {
		return orgCod;
	}
	public void setOrgCod(String orgCod) {
		this.orgCod = orgCod;
	}
	public String getRegCapAmt() {
		return regCapAmt;
	}
	public void setRegCapAmt(String regCapAmt) {
		this.regCapAmt = regCapAmt;
	}
	public String getRegAddr() {
		return regAddr;
	}
	public void setRegAddr(String regAddr) {
		this.regAddr = regAddr;
	}
	public String getTaxCertId() {
		return taxCertId;
	}
	public void setTaxCertId(String taxCertId) {
		this.taxCertId = taxCertId;
	}
	public String getCrpIdTyp() {
		return crpIdTyp;
	}
	public void setCrpIdTyp(String crpIdTyp) {
		this.crpIdTyp = crpIdTyp;
	}
	public String getCrpIdNo() {
		return crpIdNo;
	}
	public void setCrpIdNo(String crpIdNo) {
		this.crpIdNo = crpIdNo;
	}
	public String getCrpNm() {
		return crpNm;
	}
	public void setCrpNm(String crpNm) {
		this.crpNm = crpNm;
	}
	
	

}
