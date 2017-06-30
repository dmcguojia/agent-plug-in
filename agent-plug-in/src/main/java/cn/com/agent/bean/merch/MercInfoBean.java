package cn.com.agent.bean.merch;

import java.io.Serializable;

import javassist.expr.NewArray;

import com.alibaba.fastjson.JSON;

public class MercInfoBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6032765733309928049L;

	private String orgId;
	private String mercId;
	private String mercProv;
	private String mercCity;
	private String memType="2";
	private String mercTyp;
	private String mercSts;
	private String mercStlSts;
	private String mercCnm;
	private String mercAbbr;
	private String mercPyAbbr;
	private String mccCd;
	private String busAddr;
	private String mercHotLin;
	
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
	public String getMercProv() {
		return mercProv;
	}
	public void setMercProv(String mercProv) {
		this.mercProv = mercProv;
	}
	public String getMercCity() {
		return mercCity;
	}
	public void setMercCity(String mercCity) {
		this.mercCity = mercCity;
	}
	public String getMercTyp() {
		return mercTyp;
	}
	public void setMercTyp(String mercTyp) {
		this.mercTyp = mercTyp;
	}
	public String getMercSts() {
		return mercSts;
	}
	public void setMercSts(String mercSts) {
		this.mercSts = mercSts;
	}
	public String getMercStlSts() {
		return mercStlSts;
	}
	public void setMercStlSts(String mercStlSts) {
		this.mercStlSts = mercStlSts;
	}
	public String getMercCnm() {
		return mercCnm;
	}
	public void setMercCnm(String mercCnm) {
		this.mercCnm = mercCnm;
	}
	public String getMercAbbr() {
		return mercAbbr;
	}
	public void setMercAbbr(String mercAbbr) {
		this.mercAbbr = mercAbbr;
	}
	public String getMercPyAbbr() {
		return mercPyAbbr;
	}
	public void setMercPyAbbr(String mercPyAbbr) {
		this.mercPyAbbr = mercPyAbbr;
	}
	public String getMccCd() {
		return mccCd;
	}
	public void setMccCd(String mccCd) {
		this.mccCd = mccCd;
	}
	public String getBusAddr() {
		return busAddr;
	}
	public void setBusAddr(String busAddr) {
		this.busAddr = busAddr;
	}
	public String getMercHotLin() {
		return mercHotLin;
	}
	public void setMercHotLin(String mercHotLin) {
		this.mercHotLin = mercHotLin;
	}
	public String getMemType() {
		return memType;
	}
	public void setMemType(String memType) {
		this.memType = memType;
	}
}
