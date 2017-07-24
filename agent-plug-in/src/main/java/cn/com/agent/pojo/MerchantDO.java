package cn.com.agent.pojo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TMerchant entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_MERCHANT")
public class MerchantDO implements java.io.Serializable {

	// Fields

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4801781355850697369L;
	private Long merchId;
	private String merchNo;
	private String merchName;
	private Long merchProvince;
	private Long merchCity;
	private Long merchInsti;
	private String expaInstiid;
	private Long regType;
	private Long projName;
	private Long projOrgin;
	private Long setlCycle;
	private String acqBank;
	private String taxregNo;
	private String busiLicense;
	private String busiAddr;
	private Long busiProvince;
	private String busiPostCode;
	private String tradeAddr;
	private Long tradeProvince;
	private String tandePostCode;
	private String instiCode;
	private String busiIndustry;
	private String lawyerName;
	private Long lawyCertiType;
	private String lawyCertiNo;
	private String lawyTelNo;
	private String depositBank;
	private String accName;
	private String settleAccount;
	private String contaName;
	private String contaTelNo;
	private String contaPostCode;
	private String contaAddr;
	private String contaEmail;
	private String busiScan;
	private String taxgegScan;
	private String lawyerScan;
	private String inquiryScan;
	private String unionScan;
	private String shopScan;
	private String otherScan;
	private Long merchLevel;
	private Long merchRiskLevel;
	private Double serviceCharge;
	private String status;
	private String jbpmid;
	private Long inUser;
	private Timestamp inTime;
	private Long stexaUser;
	private Timestamp stexaTime;
	private String stopinion;
	private Long civilexaUser;
	private Timestamp civilexaTime;
	private String civilexaOpinion;
	private String notes;
	private String remarks;
	private Long applyMerchId;
	private String bankCode;
	private String busiver;
	private String zonecode;
	private String canalcode;
	private String groupcode;
	private String splitver;
	private String riskver;
	private String mcclist;
	private String alias;
	private Timestamp lawyCertiDate;
	private Timestamp busiLicenseDate;
	private Timestamp instiCodeDate;
	private String backupStatus;
	private String merchantId;
	/**
	 * 增加商户所属市辖区/县  开户行省  市  所属市辖区/县     开通终端数量  实际开通终端数量
	 */
	private Long merchDistrict;
	private Long depositBankProvince;
	private Long depositBankCity;
	private Long depositBankDistrict;
	private Long requiredTermianlNum;
	private Long resTermianlNum;
	private Long upLoadLogId;//上传日志ID
	private String impId;//导入商户标识
	
	private String source;
	private Long apiLogId;
	private String entranceNo;
	
	// Constructors

	/** default constructor */
	public MerchantDO() {
	}

	/** minimal constructor */
	public MerchantDO(Long merchId, String merchNo, String merchName,
			Long merchProvince, Long merchCity, Long merchInsti,
			Timestamp inTime) {
		this.merchId = merchId;
		this.merchNo = merchNo;
		this.merchName = merchName;
		this.merchProvince = merchProvince;
		this.merchCity = merchCity;
		this.merchInsti = merchInsti;
		this.inTime = inTime;
	}

	/** full constructor */
	public MerchantDO(Long merchId, String merchNo, String merchName,
			Long merchProvince, Long merchCity, Long merchInsti,
			String expaInstiid, Long regType, Long projName, Long projOrgin,
			Long setlCycle, String acqBank, String taxregNo,
			String busiLicense, String busiAddr, Long busiProvince,
			String busiPostCode, String tradeAddr, Long tradeProvince,
			String tandePostCode, String instiCode, String busiIndustry,
			String lawyerName, Long lawyCertiType, String lawyCertiNo,
			String lawyTelNo, String depositBank, String accName,
			String settleAccount, String contaName, String contaTelNo,
			String contaPostCode, String contaAddr, String contaEmail,
			String busiScan, String taxgegScan, String lawyerScan,
			String inquiryScan, String unionScan, String shopScan,
			String otherScan, Long merchLevel, Long merchRiskLevel,
			Double serviceCharge, String status, String jbpmid, Long inUser,
			Timestamp inTime, Long stexaUser, Timestamp stexaTime,
			String stopinion, Long civilexaUser, Timestamp civilexaTime,
			String civilexaOpinion, String notes, String remarks,
			Long applyMerchId, String bankCode, String busiver,
			String zonecode, String canalcode, String groupcode,
			String splitver, String riskver) {
		this.merchId = merchId;
		this.merchNo = merchNo;
		this.merchName = merchName;
		this.merchProvince = merchProvince;
		this.merchCity = merchCity;
		this.merchInsti = merchInsti;
		this.expaInstiid = expaInstiid;
		this.regType = regType;
		this.projName = projName;
		this.projOrgin = projOrgin;
		this.setlCycle = setlCycle;
		this.acqBank = acqBank;
		this.taxregNo = taxregNo;
		this.busiLicense = busiLicense;
		this.busiAddr = busiAddr;
		this.busiProvince = busiProvince;
		this.busiPostCode = busiPostCode;
		this.tradeAddr = tradeAddr;
		this.tradeProvince = tradeProvince;
		this.tandePostCode = tandePostCode;
		this.instiCode = instiCode;
		this.busiIndustry = busiIndustry;
		this.lawyerName = lawyerName;
		this.lawyCertiType = lawyCertiType;
		this.lawyCertiNo = lawyCertiNo;
		this.lawyTelNo = lawyTelNo;
		this.depositBank = depositBank;
		this.accName = accName;
		this.settleAccount = settleAccount;
		this.contaName = contaName;
		this.contaTelNo = contaTelNo;
		this.contaPostCode = contaPostCode;
		this.contaAddr = contaAddr;
		this.contaEmail = contaEmail;
		this.busiScan = busiScan;
		this.taxgegScan = taxgegScan;
		this.lawyerScan = lawyerScan;
		this.inquiryScan = inquiryScan;
		this.unionScan = unionScan;
		this.shopScan = shopScan;
		this.otherScan = otherScan;
		this.merchLevel = merchLevel;
		this.merchRiskLevel = merchRiskLevel;
		this.serviceCharge = serviceCharge;
		this.status = status;
		this.jbpmid = jbpmid;
		this.inUser = inUser;
		this.inTime = inTime;
		this.stexaUser = stexaUser;
		this.stexaTime = stexaTime;
		this.stopinion = stopinion;
		this.civilexaUser = civilexaUser;
		this.civilexaTime = civilexaTime;
		this.civilexaOpinion = civilexaOpinion;
		this.notes = notes;
		this.remarks = remarks;
		this.applyMerchId = applyMerchId;
		this.bankCode = bankCode;
		this.busiver = busiver;
		this.zonecode = zonecode;
		this.canalcode = canalcode;
		this.groupcode = groupcode;
		this.splitver = splitver;
		this.riskver = riskver;
	}

	// Property accessors
	@Id
	@Column(name = "MERCH_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getMerchId() {
		return this.merchId;
	}

	public void setMerchId(Long merchId) {
		this.merchId = merchId;
	}

	@Column(name = "MERCH_NO", unique = true, nullable = false, length = 15)
	public String getMerchNo() {
		return this.merchNo;
	}

	public void setMerchNo(String merchNo) {
		this.merchNo = merchNo;
	}

	@Column(name = "MERCH_NAME", nullable = false, length = 64)
	public String getMerchName() {
		return this.merchName;
	}

	public void setMerchName(String merchName) {
		this.merchName = merchName;
	}

	@Column(name = "MERCH_PROVINCE", nullable = false, precision = 10, scale = 0)
	public Long getMerchProvince() {
		return this.merchProvince;
	}

	public void setMerchProvince(Long merchProvince) {
		this.merchProvince = merchProvince;
	}

	@Column(name = "MERCH_CITY", nullable = false, precision = 10, scale = 0)
	public Long getMerchCity() {
		return this.merchCity;
	}

	public void setMerchCity(Long merchCity) {
		this.merchCity = merchCity;
	}

	@Column(name = "MERCH_INSTI", nullable = false, precision = 10, scale = 0)
	public Long getMerchInsti() {
		return this.merchInsti;
	}

	public void setMerchInsti(Long merchInsti) {
		this.merchInsti = merchInsti;
	}

	@Column(name = "EXPA_INSTIID", length = 11)
	public String getExpaInstiid() {
		return this.expaInstiid;
	}

	public void setExpaInstiid(String expaInstiid) {
		this.expaInstiid = expaInstiid;
	}

	@Column(name = "REG_TYPE", precision = 10, scale = 0)
	public Long getRegType() {
		return this.regType;
	}

	public void setRegType(Long regType) {
		this.regType = regType;
	}

	@Column(name = "PROJ_NAME", precision = 10, scale = 0)
	public Long getProjName() {
		return this.projName;
	}

	public void setProjName(Long projName) {
		this.projName = projName;
	}

	@Column(name = "PROJ_ORGIN", precision = 10, scale = 0)
	public Long getProjOrgin() {
		return this.projOrgin;
	}

	public void setProjOrgin(Long projOrgin) {
		this.projOrgin = projOrgin;
	}

	@Column(name = "SETL_CYCLE", precision = 10, scale = 0)
	public Long getSetlCycle() {
		return this.setlCycle;
	}

	public void setSetlCycle(Long setlCycle) {
		this.setlCycle = setlCycle;
	}

	@Column(name = "ACQ_BANK", length = 32)
	public String getAcqBank() {
		return this.acqBank;
	}

	public void setAcqBank(String acqBank) {
		this.acqBank = acqBank;
	}

	@Column(name = "TAXREG_NO", length = 32)
	public String getTaxregNo() {
		return this.taxregNo;
	}

	public void setTaxregNo(String taxregNo) {
		this.taxregNo = taxregNo;
	}

	@Column(name = "BUSI_LICENSE", length = 32)
	public String getBusiLicense() {
		return this.busiLicense;
	}

	public void setBusiLicense(String busiLicense) {
		this.busiLicense = busiLicense;
	}

	@Column(name = "BUSI_ADDR", length = 128)
	public String getBusiAddr() {
		return this.busiAddr;
	}

	public void setBusiAddr(String busiAddr) {
		this.busiAddr = busiAddr;
	}

	@Column(name = "BUSI_PROVINCE", precision = 10, scale = 0)
	public Long getBusiProvince() {
		return this.busiProvince;
	}

	public void setBusiProvince(Long busiProvince) {
		this.busiProvince = busiProvince;
	}

	@Column(name = "BUSI_POST_CODE", length = 6)
	public String getBusiPostCode() {
		return this.busiPostCode;
	}

	public void setBusiPostCode(String busiPostCode) {
		this.busiPostCode = busiPostCode;
	}

	@Column(name = "TRADE_ADDR", length = 128)
	public String getTradeAddr() {
		return this.tradeAddr;
	}

	public void setTradeAddr(String tradeAddr) {
		this.tradeAddr = tradeAddr;
	}

	@Column(name = "TRADE_PROVINCE", precision = 10, scale = 0)
	public Long getTradeProvince() {
		return this.tradeProvince;
	}

	public void setTradeProvince(Long tradeProvince) {
		this.tradeProvince = tradeProvince;
	}

	@Column(name = "TANDE_POST_CODE", length = 6)
	public String getTandePostCode() {
		return this.tandePostCode;
	}

	public void setTandePostCode(String tandePostCode) {
		this.tandePostCode = tandePostCode;
	}

	@Column(name = "INSTI_CODE", length = 10)
	public String getInstiCode() {
		return this.instiCode;
	}

	public void setInstiCode(String instiCode) {
		this.instiCode = instiCode;
	}

	@Column(name = "BUSI_INDUSTRY", length = 4)
	public String getBusiIndustry() {
		return this.busiIndustry;
	}

	public void setBusiIndustry(String busiIndustry) {
		this.busiIndustry = busiIndustry;
	}

	@Column(name = "LAWYER_NAME", length = 32)
	public String getLawyerName() {
		return this.lawyerName;
	}

	public void setLawyerName(String lawyerName) {
		this.lawyerName = lawyerName;
	}

	@Column(name = "LAWY_CERTI_TYPE", precision = 10, scale = 0)
	public Long getLawyCertiType() {
		return this.lawyCertiType;
	}

	public void setLawyCertiType(Long lawyCertiType) {
		this.lawyCertiType = lawyCertiType;
	}

	@Column(name = "LAWY_CERTI_NO", length = 32)
	public String getLawyCertiNo() {
		return this.lawyCertiNo;
	}

	public void setLawyCertiNo(String lawyCertiNo) {
		this.lawyCertiNo = lawyCertiNo;
	}

	@Column(name = "LAWY_TEL_NO", length = 32)
	public String getLawyTelNo() {
		return this.lawyTelNo;
	}

	public void setLawyTelNo(String lawyTelNo) {
		this.lawyTelNo = lawyTelNo;
	}

	@Column(name = "DEPOSIT_BANK", length = 12)
	public String getDepositBank() {
		return this.depositBank;
	}

	public void setDepositBank(String depositBank) {
		this.depositBank = depositBank;
	}

	@Column(name = "ACC_NAME", length = 64)
	public String getAccName() {
		return this.accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	@Column(name = "SETTLE_ACCOUNT", length = 32)
	public String getSettleAccount() {
		return this.settleAccount;
	}

	public void setSettleAccount(String settleAccount) {
		this.settleAccount = settleAccount;
	}

	@Column(name = "CONTA_NAME", length = 32)
	public String getContaName() {
		return this.contaName;
	}

	public void setContaName(String contaName) {
		this.contaName = contaName;
	}

	@Column(name = "CONTA_TEL_NO", length = 32)
	public String getContaTelNo() {
		return this.contaTelNo;
	}

	public void setContaTelNo(String contaTelNo) {
		this.contaTelNo = contaTelNo;
	}

	@Column(name = "CONTA_POST_CODE", length = 6)
	public String getContaPostCode() {
		return this.contaPostCode;
	}

	public void setContaPostCode(String contaPostCode) {
		this.contaPostCode = contaPostCode;
	}

	@Column(name = "CONTA_ADDR", length = 128)
	public String getContaAddr() {
		return this.contaAddr;
	}

	public void setContaAddr(String contaAddr) {
		this.contaAddr = contaAddr;
	}

	@Column(name = "CONTA_EMAIL", length = 64)
	public String getContaEmail() {
		return this.contaEmail;
	}

	public void setContaEmail(String contaEmail) {
		this.contaEmail = contaEmail;
	}

	@Column(name = "BUSI_SCAN", length = 128)
	public String getBusiScan() {
		return this.busiScan;
	}

	public void setBusiScan(String busiScan) {
		this.busiScan = busiScan;
	}

	@Column(name = "TAXGEG_SCAN", length = 128)
	public String getTaxgegScan() {
		return this.taxgegScan;
	}

	public void setTaxgegScan(String taxgegScan) {
		this.taxgegScan = taxgegScan;
	}

	@Column(name = "LAWYER_SCAN", length = 128)
	public String getLawyerScan() {
		return this.lawyerScan;
	}

	public void setLawyerScan(String lawyerScan) {
		this.lawyerScan = lawyerScan;
	}

	@Column(name = "INQUIRY_SCAN", length = 128)
	public String getInquiryScan() {
		return this.inquiryScan;
	}

	public void setInquiryScan(String inquiryScan) {
		this.inquiryScan = inquiryScan;
	}

	@Column(name = "UNION_SCAN", length = 128)
	public String getUnionScan() {
		return this.unionScan;
	}

	public void setUnionScan(String unionScan) {
		this.unionScan = unionScan;
	}

	@Column(name = "SHOP_SCAN", length = 128)
	public String getShopScan() {
		return this.shopScan;
	}

	public void setShopScan(String shopScan) {
		this.shopScan = shopScan;
	}

	@Column(name = "OTHER_SCAN", length = 128)
	public String getOtherScan() {
		return this.otherScan;
	}

	public void setOtherScan(String otherScan) {
		this.otherScan = otherScan;
	}

	@Column(name = "MERCH_LEVEL", precision = 1, scale = 0)
	public Long getMerchLevel() {
		return this.merchLevel;
	}

	public void setMerchLevel(Long merchLevel) {
		this.merchLevel = merchLevel;
	}

	@Column(name = "MERCH_RISK_LEVEL", precision = 1, scale = 0)
	public Long getMerchRiskLevel() {
		return this.merchRiskLevel;
	}

	public void setMerchRiskLevel(Long merchRiskLevel) {
		this.merchRiskLevel = merchRiskLevel;
	}

	@Column(name = "SERVICE_CHARGE", precision = 12)
	public Double getServiceCharge() {
		return this.serviceCharge;
	}

	public void setServiceCharge(Double serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	@Column(name = "STATUS", length = 2)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "JBPMID", length = 32)
	public String getJbpmid() {
		return this.jbpmid;
	}

	public void setJbpmid(String jbpmid) {
		this.jbpmid = jbpmid;
	}

	@Column(name = "IN_USER", precision = 10, scale = 0)
	public Long getInUser() {
		return this.inUser;
	}

	public void setInUser(Long inUser) {
		this.inUser = inUser;
	}

	@Column(name = "IN_TIME", nullable = false, length = 7)
	public Timestamp getInTime() {
		return this.inTime;
	}

	public void setInTime(Timestamp inTime) {
		this.inTime = inTime;
	}

	@Column(name = "STEXA_USER", precision = 10, scale = 0)
	public Long getStexaUser() {
		return this.stexaUser;
	}

	public void setStexaUser(Long stexaUser) {
		this.stexaUser = stexaUser;
	}

	@Column(name = "STEXA_TIME", length = 7)
	public Timestamp getStexaTime() {
		return this.stexaTime;
	}

	public void setStexaTime(Timestamp stexaTime) {
		this.stexaTime = stexaTime;
	}

	@Column(name = "STOPINION", length = 512)
	public String getStopinion() {
		return this.stopinion;
	}

	public void setStopinion(String stopinion) {
		this.stopinion = stopinion;
	}

	@Column(name = "CIVILEXA_USER", precision = 10, scale = 0)
	public Long getCivilexaUser() {
		return this.civilexaUser;
	}

	public void setCivilexaUser(Long civilexaUser) {
		this.civilexaUser = civilexaUser;
	}

	@Column(name = "CIVILEXA_TIME", length = 7)
	public Timestamp getCivilexaTime() {
		return this.civilexaTime;
	}

	public void setCivilexaTime(Timestamp civilexaTime) {
		this.civilexaTime = civilexaTime;
	}

	@Column(name = "CIVILEXA_OPINION", length = 512)
	public String getCivilexaOpinion() {
		return this.civilexaOpinion;
	}

	public void setCivilexaOpinion(String civilexaOpinion) {
		this.civilexaOpinion = civilexaOpinion;
	}

	@Column(name = "NOTES", length = 128)
	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Column(name = "REMARKS", length = 128)
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name = "APPLY_MERCH_ID", precision = 10, scale = 0)
	public Long getApplyMerchId() {
		return this.applyMerchId;
	}

	public void setApplyMerchId(Long applyMerchId) {
		this.applyMerchId = applyMerchId;
	}

	@Column(name = "BANK_CODE", length = 12)
	public String getBankCode() {
		return this.bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	@Column(name = "BUSIVER", length = 8)
	public String getBusiver() {
		return this.busiver;
	}

	public void setBusiver(String busiver) {
		this.busiver = busiver;
	}

	@Column(name = "ZONECODE", length = 4)
	public String getZonecode() {
		return this.zonecode;
	}

	public void setZonecode(String zonecode) {
		this.zonecode = zonecode;
	}

	@Column(name = "CHANNELCODE", length = 8)
	public String getCanalcode() {
		return this.canalcode;
	}

	public void setCanalcode(String canalcode) {
		this.canalcode = canalcode;
	}

	@Column(name = "GROUPCODE", length = 8)
	public String getGroupcode() {
		return this.groupcode;
	}

	public void setGroupcode(String groupcode) {
		this.groupcode = groupcode;
	}

	@Column(name = "SPLITVER", length = 8)
	public String getSplitver() {
		return this.splitver;
	}

	public void setSplitver(String splitver) {
		this.splitver = splitver;
	}

	@Column(name = "RISKVER", length = 8)
	public String getRiskver() {
		return this.riskver;
	}

	public void setRiskver(String riskver) {
		this.riskver = riskver;
	}
	@Column(name = "MCCLIST", length = 4)
	public String getMcclist() {
		return this.mcclist;
	}

	public void setMcclist(String mcclist) {
		this.mcclist = mcclist;
	}
	
	@Column(name = "ALIAS", length = 40)
	public String getAlias() {
		return this.alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	@Column(name = "LAWY_CERTI_DATE")
	public Timestamp getLawyCertiDate() {
		return this.lawyCertiDate;
	}

	public void setLawyCertiDate(Timestamp lawyCertiDate) {
		this.lawyCertiDate = lawyCertiDate;
	}

	
	@Column(name = "BUSI_LICENSE_DATE")
	public Timestamp getBusiLicenseDate() {
		return this.busiLicenseDate;
	}

	public void setBusiLicenseDate(Timestamp busiLicenseDate) {
		this.busiLicenseDate = busiLicenseDate;
	}

	
	@Column(name = "INSTI_CODE_DATE", length = 7)
	public Timestamp getInstiCodeDate() {
		return this.instiCodeDate;
	}

	public void setInstiCodeDate(Timestamp instiCodeDate) {
		this.instiCodeDate = instiCodeDate;
	}

	@Column(name = "MERCH_DISTRICT", precision = 10, scale = 0)
	public Long getMerchDistrict() {
		return merchDistrict;
	}

	public void setMerchDistrict(Long merchDistrict) {
		this.merchDistrict = merchDistrict;
	}
	
	@Column(name = "DEPOSIT_BANK_PROVINCE", precision = 10, scale = 0)
	public Long getDepositBankProvince() {
		return depositBankProvince;
	}

	public void setDepositBankProvince(Long depositBankProvince) {
		this.depositBankProvince = depositBankProvince;
	}
	
	@Column(name = "DEPOSIT_BANK_CITY", precision = 10, scale = 0)
	public Long getDepositBankCity() {
		return depositBankCity;
	}

	public void setDepositBankCity(Long depositBankCity) {
		this.depositBankCity = depositBankCity;
	}
	
	@Column(name = "DEPOSIT_BANK_DISTRICT", precision = 10, scale = 0)
	public Long getDepositBankDistrict() {
		return depositBankDistrict;
	}

	public void setDepositBankDistrict(Long depositBankDistrict) {
		this.depositBankDistrict = depositBankDistrict;
	}
	
	@Column(name = "REQUIRED_TERMINAL_NUM", precision = 10, scale = 0)
	public Long getRequiredTermianlNum() {
		return requiredTermianlNum;
	}

	public void setRequiredTermianlNum(Long requiredTermianlNum) {
		this.requiredTermianlNum = requiredTermianlNum;
	}
	
	@Column(name = "RES_TERMINAL_NUM", precision = 10, scale = 0)
	public Long getResTermianlNum() {
		return resTermianlNum;
	}

	public void setResTermianlNum(Long resTermianlNum) {
		this.resTermianlNum = resTermianlNum;
	}
	@Column(name = "UPLOADTID")
	public Long getUpLoadLogId() {
		return upLoadLogId;
	}

	public void setUpLoadLogId(Long upLoadLogId) {
		this.upLoadLogId = upLoadLogId;
	}
	@Column(name = "IMPID")
	public String getImpId() {
		return impId;
	}

	public void setImpId(String impId) {
		this.impId = impId;
	}
	@Column(name = "SOURCE" ,length=4)
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	@Column(name = "API_LOG_ID" ,length=10)
	public Long getApiLogId() {
		return apiLogId;
	}

	public void setApiLogId(Long apiLogId) {
		this.apiLogId = apiLogId;
	}
	@Column(name = "ENTRANCENO",length=16)
	public String getEntranceNo() {
		return entranceNo;
	}

	public void setEntranceNo(String entranceNo) {
		this.entranceNo = entranceNo;
	}
	
	@Column(name = "BACKUP_STATUS")
	public String getBackupStatus() {
		return backupStatus;
	}

	public void setBackupStatus(String backupStatus) {
		this.backupStatus = backupStatus;
	}
	@Column(name = "MERCHANTID")
	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	
	
	
}