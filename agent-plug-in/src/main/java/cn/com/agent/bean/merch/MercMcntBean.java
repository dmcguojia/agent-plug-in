package cn.com.agent.bean.merch;

import java.io.Serializable;

public class MercMcntBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 813057825792738121L;

	private String cttPsnCnm;
	private String mblTel;
	private String fixTel;
	private String email;
	private String msnQq;
	public String getCttPsnCnm() {
		return cttPsnCnm;
	}
	public void setCttPsnCnm(String cttPsnCnm) {
		this.cttPsnCnm = cttPsnCnm;
	}
	public String getMblTel() {
		return mblTel;
	}
	public void setMblTel(String mblTel) {
		this.mblTel = mblTel;
	}
	public String getFixTel() {
		return fixTel;
	}
	public void setFixTel(String fixTel) {
		this.fixTel = fixTel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMsnQq() {
		return msnQq;
	}
	public void setMsnQq(String msnQq) {
		this.msnQq = msnQq;
	}
	
	

}
