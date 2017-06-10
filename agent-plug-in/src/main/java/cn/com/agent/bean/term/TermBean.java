package cn.com.agent.bean.term;

import java.io.Serializable;

public class TermBean implements Serializable{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 694887061541891047L;
	private String orgId;//代理商编号
	private String mercId;//会员号
	private String trmNo;//终端号
	private String trmSn;//终端序列号
	private String mfrNo;//厂家编号
	private String modNo;//型号编号
	private String appNo;//应用编码
	private String trmSts;//设备状态 N:停用 Y:正常 F:注销
	private String macKey;//终端的mac key
	private String pinKey;//终端的pin key
	private String tmKey;//终端的tm key
	private String trmProv;//终端归属省
	private String trmCity;//终端归属市
	
	
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getMercId() {
		return mercId;
	}
	public void setMercId(String mercId) {
		this.mercId = mercId;
	}
	public String getTrmNo() {
		return trmNo;
	}
	public void setTrmNo(String trmNo) {
		this.trmNo = trmNo;
	}
	public String getTrmSn() {
		return trmSn;
	}
	public void setTrmSn(String trmSn) {
		this.trmSn = trmSn;
	}
	public String getMfrNo() {
		return mfrNo;
	}
	public void setMfrNo(String mfrNo) {
		this.mfrNo = mfrNo;
	}
	public String getModNo() {
		return modNo;
	}
	public void setModNo(String modNo) {
		this.modNo = modNo;
	}
	public String getAppNo() {
		return appNo;
	}
	public void setAppNo(String appNo) {
		this.appNo = appNo;
	}
	public String getTrmSts() {
		return trmSts;
	}
	public void setTrmSts(String trmSts) {
		this.trmSts = trmSts;
	}
	public String getMacKey() {
		return macKey;
	}
	public void setMacKey(String macKey) {
		this.macKey = macKey;
	}
	public String getPinKey() {
		return pinKey;
	}
	public void setPinKey(String pinKey) {
		this.pinKey = pinKey;
	}
	public String getTmKey() {
		return tmKey;
	}
	public void setTmKey(String tmKey) {
		this.tmKey = tmKey;
	}
	public String getTrmProv() {
		return trmProv;
	}
	public void setTrmProv(String trmProv) {
		this.trmProv = trmProv;
	}
	public String getTrmCity() {
		return trmCity;
	}
	public void setTrmCity(String trmCity) {
		this.trmCity = trmCity;
	}
	
	
}
