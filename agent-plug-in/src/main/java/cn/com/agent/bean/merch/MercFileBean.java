package cn.com.agent.bean.merch;

import java.io.Serializable;

public class MercFileBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2096889612413386929L;

	private String crpAboveImg;
	private String crpBelowImg;
	private String bankCardImg;
	private String personImg;
	private String handheldAboveImg;
	private String handheldBelowImg;
	
	
	public String getCrpAboveImg() {
		return crpAboveImg;
	}
	public void setCrpAboveImg(String crpAboveImg) {
		this.crpAboveImg = crpAboveImg;
	}
	public String getCrpBelowImg() {
		return crpBelowImg;
	}
	public void setCrpBelowImg(String crpBelowImg) {
		this.crpBelowImg = crpBelowImg;
	}
	public String getBankCardImg() {
		return bankCardImg;
	}
	public void setBankCardImg(String bankCardImg) {
		this.bankCardImg = bankCardImg;
	}
	public String getPersonImg() {
		return personImg;
	}
	public void setPersonImg(String personImg) {
		this.personImg = personImg;
	}
	public String getHandheldAboveImg() {
		return handheldAboveImg;
	}
	public void setHandheldAboveImg(String handheldAboveImg) {
		this.handheldAboveImg = handheldAboveImg;
	}
	public String getHandheldBelowImg() {
		return handheldBelowImg;
	}
	public void setHandheldBelowImg(String handheldBelowImg) {
		this.handheldBelowImg = handheldBelowImg;
	}
	
	

}
