package cn.com.agent.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name = "T_MERCHANT_BACKUP_LOG")
public class MerchantBackupLogDO implements Serializable{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5717260160472731370L;
	private Long tid;
	private String action;
	private String requestId;
	private String timestamp;
	
	private String mercAttr;
	private String regId;
	private String orgCod;
	private String regCapAmt;
	private String regAddr;
	private String taxCertId;
	private String crpIdTyp;
	private String crpIdNo;
	private String crpNm;
	
	private String t1DebitFeeRat;
	private String t1DebitFixedFee;
	private String t1DebitMinFeeAmt;
	private String t1DebitMaxFeeAmt;
	private String t1CreditFeeRat;
	private String t1CreditFixedFee;
	private String t1CreditMinFeeAmt;
	private String t1CreditMaxFeeAmt;
	private String d0FeeRat;
	private String d0FixedFee;
	private String d0MinFeeAmt;
	private String d0MaxFeeAmt;
	
	private String crpAboveImg;
	private String crpBelowImg;
	private String bankCardImg;
	private String personImg;
	private String handheldAboveImg;
	private String handheldBelowImg;
	
	private String orgId;
	private String mercId;
	private String mercProv;
	private String mercCity;
	private String mercTyp;
	private String mercSts;
	private String mercStlSts;
	private String mercCnm;
	private String mercAbbr;
	private String mercPyAbbr;
	private String mccCd;
	private String busAddr;
	private String mercHotLin;
	
	private String stlOac;
	private String effDt;
	private String expDt;
	private String stlOacCls;
	private String effFlg;
	private String deductSign;
	private String dpsbondAcnm;
	private String dpsbondLbnkNo;
	private String dpsbondBnkDesc;
	private String dpsbondSign;
	private String dpsbondBnkProv;
	private String dpsbondBnkCity;
	
	private String cttPsnCnm;
	private String mblTel;
	private String fixTel;
	private String email;
	private String msnQq;
	
	private String responseid;
	private String retcode;
	private String retinfo;
	private String status;
	private String merchantId;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_merchant_backup_log") 
	@SequenceGenerator(name="seq_merchant_backup_log",sequenceName="SEQ_MERCHANT_BACKUP_LOG",allocationSize=1)
	@Column(name = "TID", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getTid() {
		return tid;
	}
	public void setTid(Long tid) {
		this.tid = tid;
	}
	@Column(name = "ACTION")
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	@Column(name = "REQUESTID")
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	@Column(name = "TIMESTAMP")
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	@Column(name = "MERCATTR")
	public String getMercAttr() {
		return mercAttr;
	}
	public void setMercAttr(String mercAttr) {
		this.mercAttr = mercAttr;
	}
	@Column(name = "REGID")
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	@Column(name = "ORGCOD")
	public String getOrgCod() {
		return orgCod;
	}
	public void setOrgCod(String orgCod) {
		this.orgCod = orgCod;
	}
	@Column(name = "REGCAPAMT")
	public String getRegCapAmt() {
		return regCapAmt;
	}
	public void setRegCapAmt(String regCapAmt) {
		this.regCapAmt = regCapAmt;
	}
	@Column(name = "REGADDR")
	public String getRegAddr() {
		return regAddr;
	}
	public void setRegAddr(String regAddr) {
		this.regAddr = regAddr;
	}
	@Column(name = "TAXCERTID")
	public String getTaxCertId() {
		return taxCertId;
	}
	public void setTaxCertId(String taxCertId) {
		this.taxCertId = taxCertId;
	}
	@Column(name = "CRPIDTYP")
	public String getCrpIdTyp() {
		return crpIdTyp;
	}
	public void setCrpIdTyp(String crpIdTyp) {
		this.crpIdTyp = crpIdTyp;
	}
	@Column(name = "CRPIDNO")
	public String getCrpIdNo() {
		return crpIdNo;
	}
	public void setCrpIdNo(String crpIdNo) {
		this.crpIdNo = crpIdNo;
	}
	@Column(name = "CRPNM")
	public String getCrpNm() {
		return crpNm;
	}
	public void setCrpNm(String crpNm) {
		this.crpNm = crpNm;
	}
	@Column(name = "T1DEBITFEERAT")
	public String getT1DebitFeeRat() {
		return t1DebitFeeRat;
	}
	public void setT1DebitFeeRat(String t1DebitFeeRat) {
		this.t1DebitFeeRat = t1DebitFeeRat;
	}
	@Column(name = "T1DEBITFIXEDFEE")
	public String getT1DebitFixedFee() {
		return t1DebitFixedFee;
	}
	public void setT1DebitFixedFee(String t1DebitFixedFee) {
		this.t1DebitFixedFee = t1DebitFixedFee;
	}
	@Column(name = "T1DEBITMINFEEAMT")
	public String getT1DebitMinFeeAmt() {
		return t1DebitMinFeeAmt;
	}
	public void setT1DebitMinFeeAmt(String t1DebitMinFeeAmt) {
		this.t1DebitMinFeeAmt = t1DebitMinFeeAmt;
	}
	@Column(name = "T1DEBITMAXFEEAMT")
	public String getT1DebitMaxFeeAmt() {
		return t1DebitMaxFeeAmt;
	}
	public void setT1DebitMaxFeeAmt(String t1DebitMaxFeeAmt) {
		this.t1DebitMaxFeeAmt = t1DebitMaxFeeAmt;
	}
	@Column(name = "T1CREDITFEERAT")
	public String getT1CreditFeeRat() {
		return t1CreditFeeRat;
	}
	public void setT1CreditFeeRat(String t1CreditFeeRat) {
		this.t1CreditFeeRat = t1CreditFeeRat;
	}
	@Column(name = "T1CREDITFIXEDFEE")
	public String getT1CreditFixedFee() {
		return t1CreditFixedFee;
	}
	public void setT1CreditFixedFee(String t1CreditFixedFee) {
		this.t1CreditFixedFee = t1CreditFixedFee;
	}
	@Column(name = "T1CREDITMINFEEAMT")
	public String getT1CreditMinFeeAmt() {
		return t1CreditMinFeeAmt;
	}
	public void setT1CreditMinFeeAmt(String t1CreditMinFeeAmt) {
		this.t1CreditMinFeeAmt = t1CreditMinFeeAmt;
	}
	@Column(name = "T1CREDITMAXFEEAMT")
	public String getT1CreditMaxFeeAmt() {
		return t1CreditMaxFeeAmt;
	}
	public void setT1CreditMaxFeeAmt(String t1CreditMaxFeeAmt) {
		this.t1CreditMaxFeeAmt = t1CreditMaxFeeAmt;
	}
	@Column(name = "D0FEERAT")
	public String getD0FeeRat() {
		return d0FeeRat;
	}
	public void setD0FeeRat(String d0FeeRat) {
		this.d0FeeRat = d0FeeRat;
	}
	@Column(name = "D0FIXEDFEE")
	public String getD0FixedFee() {
		return d0FixedFee;
	}
	public void setD0FixedFee(String d0FixedFee) {
		this.d0FixedFee = d0FixedFee;
	}
	@Column(name = "D0MINFEEAMT")
	public String getD0MinFeeAmt() {
		return d0MinFeeAmt;
	}
	public void setD0MinFeeAmt(String d0MinFeeAmt) {
		this.d0MinFeeAmt = d0MinFeeAmt;
	}
	@Column(name = "D0MAXFEEAMT")
	public String getD0MaxFeeAmt() {
		return d0MaxFeeAmt;
	}
	public void setD0MaxFeeAmt(String d0MaxFeeAmt) {
		this.d0MaxFeeAmt = d0MaxFeeAmt;
	}
	@Column(name = "CRPABOVEIMG")
	public String getCrpAboveImg() {
		return crpAboveImg;
	}
	public void setCrpAboveImg(String crpAboveImg) {
		this.crpAboveImg = crpAboveImg;
	}
	@Column(name = "CRPBELOWIMG")
	public String getCrpBelowImg() {
		return crpBelowImg;
	}
	public void setCrpBelowImg(String crpBelowImg) {
		this.crpBelowImg = crpBelowImg;
	}
	@Column(name = "BANKCARDIMG")
	public String getBankCardImg() {
		return bankCardImg;
	}
	public void setBankCardImg(String bankCardImg) {
		this.bankCardImg = bankCardImg;
	}
	@Column(name = "PERSONIMG")
	public String getPersonImg() {
		return personImg;
	}
	public void setPersonImg(String personImg) {
		this.personImg = personImg;
	}
	@Column(name = "HANDHELDABOVEIMG")
	public String getHandheldAboveImg() {
		return handheldAboveImg;
	}
	public void setHandheldAboveImg(String handheldAboveImg) {
		this.handheldAboveImg = handheldAboveImg;
	}
	@Column(name = "HANDHELDBELOWIMG")
	public String getHandheldBelowImg() {
		return handheldBelowImg;
	}
	public void setHandheldBelowImg(String handheldBelowImg) {
		this.handheldBelowImg = handheldBelowImg;
	}
	@Column(name = "ORGID")
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	@Column(name = "MERCID")
	public String getMercId() {
		return mercId;
	}
	public void setMercId(String mercId) {
		this.mercId = mercId;
	}
	@Column(name = "MERCPROV")
	public String getMercProv() {
		return mercProv;
	}
	public void setMercProv(String mercProv) {
		this.mercProv = mercProv;
	}
	@Column(name = "MERCCITY")
	public String getMercCity() {
		return mercCity;
	}
	public void setMercCity(String mercCity) {
		this.mercCity = mercCity;
	}
	@Column(name = "MERCTYP")
	public String getMercTyp() {
		return mercTyp;
	}
	public void setMercTyp(String mercTyp) {
		this.mercTyp = mercTyp;
	}
	@Column(name = "MERCSTS")
	public String getMercSts() {
		return mercSts;
	}
	public void setMercSts(String mercSts) {
		this.mercSts = mercSts;
	}
	@Column(name = "MERCSTLSTS")
	public String getMercStlSts() {
		return mercStlSts;
	}
	public void setMercStlSts(String mercStlSts) {
		this.mercStlSts = mercStlSts;
	}
	@Column(name = "MERCCNM")
	public String getMercCnm() {
		return mercCnm;
	}
	public void setMercCnm(String mercCnm) {
		this.mercCnm = mercCnm;
	}
	@Column(name = "MERCABBR")
	public String getMercAbbr() {
		return mercAbbr;
	}
	public void setMercAbbr(String mercAbbr) {
		this.mercAbbr = mercAbbr;
	}
	@Column(name = "MERCPYABBR")
	public String getMercPyAbbr() {
		return mercPyAbbr;
	}
	public void setMercPyAbbr(String mercPyAbbr) {
		this.mercPyAbbr = mercPyAbbr;
	}
	@Column(name = "MCCCD")
	public String getMccCd() {
		return mccCd;
	}
	public void setMccCd(String mccCd) {
		this.mccCd = mccCd;
	}
	@Column(name = "BUSADDR")
	public String getBusAddr() {
		return busAddr;
	}
	public void setBusAddr(String busAddr) {
		this.busAddr = busAddr;
	}
	@Column(name = "MERCHOTLIN")
	public String getMercHotLin() {
		return mercHotLin;
	}
	public void setMercHotLin(String mercHotLin) {
		this.mercHotLin = mercHotLin;
	}
	@Column(name = "STLOAC")
	public String getStlOac() {
		return stlOac;
	}
	public void setStlOac(String stlOac) {
		this.stlOac = stlOac;
	}
	@Column(name = "EFFDT")
	public String getEffDt() {
		return effDt;
	}
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	@Column(name = "EXPDT")
	public String getExpDt() {
		return expDt;
	}
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	@Column(name = "STLOACCLS")
	public String getStlOacCls() {
		return stlOacCls;
	}
	public void setStlOacCls(String stlOacCls) {
		this.stlOacCls = stlOacCls;
	}
	@Column(name = "EFFFLG")
	public String getEffFlg() {
		return effFlg;
	}
	public void setEffFlg(String effFlg) {
		this.effFlg = effFlg;
	}
	@Column(name = "DEDUCTSIGN")
	public String getDeductSign() {
		return deductSign;
	}
	public void setDeductSign(String deductSign) {
		this.deductSign = deductSign;
	}
	@Column(name = "DPSBONDACNM")
	public String getDpsbondAcnm() {
		return dpsbondAcnm;
	}
	public void setDpsbondAcnm(String dpsbondAcnm) {
		this.dpsbondAcnm = dpsbondAcnm;
	}
	@Column(name = "DPSBONDLBNKNO")
	public String getDpsbondLbnkNo() {
		return dpsbondLbnkNo;
	}
	public void setDpsbondLbnkNo(String dpsbondLbnkNo) {
		this.dpsbondLbnkNo = dpsbondLbnkNo;
	}
	@Column(name = "DPSBONDBNKDESC")
	public String getDpsbondBnkDesc() {
		return dpsbondBnkDesc;
	}
	public void setDpsbondBnkDesc(String dpsbondBnkDesc) {
		this.dpsbondBnkDesc = dpsbondBnkDesc;
	}
	@Column(name = "DPSBONDSIGN")
	public String getDpsbondSign() {
		return dpsbondSign;
	}
	public void setDpsbondSign(String dpsbondSign) {
		this.dpsbondSign = dpsbondSign;
	}
	@Column(name = "DPSBONDBNKPROV")
	public String getDpsbondBnkProv() {
		return dpsbondBnkProv;
	}
	public void setDpsbondBnkProv(String dpsbondBnkProv) {
		this.dpsbondBnkProv = dpsbondBnkProv;
	}
	@Column(name = "DPSBONDBNKCITY")
	public String getDpsbondBnkCity() {
		return dpsbondBnkCity;
	}
	public void setDpsbondBnkCity(String dpsbondBnkCity) {
		this.dpsbondBnkCity = dpsbondBnkCity;
	}
	@Column(name = "CTTPSNCNM")
	public String getCttPsnCnm() {
		return cttPsnCnm;
	}
	public void setCttPsnCnm(String cttPsnCnm) {
		this.cttPsnCnm = cttPsnCnm;
	}
	@Column(name = "MBLTEL")
	public String getMblTel() {
		return mblTel;
	}
	public void setMblTel(String mblTel) {
		this.mblTel = mblTel;
	}
	@Column(name = "FIXTEL")
	public String getFixTel() {
		return fixTel;
	}
	public void setFixTel(String fixTel) {
		this.fixTel = fixTel;
	}
	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "MSNQQ")
	public String getMsnQq() {
		return msnQq;
	}
	public void setMsnQq(String msnQq) {
		this.msnQq = msnQq;
	}
	@Column(name = "RESPONSEID")
	public String getResponseid() {
		return responseid;
	}
	public void setResponseid(String responseid) {
		this.responseid = responseid;
	}
	@Column(name = "RETCODE")
	public String getRetcode() {
		return retcode;
	}
	public void setRetcode(String retcode) {
		this.retcode = retcode;
	}
	@Column(name = "RETINFO")
	public String getRetinfo() {
		return retinfo;
	}
	public void setRetinfo(String retinfo) {
		this.retinfo = retinfo;
	}
	@Column(name = "STATUS")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Column(name = "MERCHANTID")
	public String getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	
	
	
}
