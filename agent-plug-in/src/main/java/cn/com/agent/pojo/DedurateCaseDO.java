package cn.com.agent.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TBusiCase entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_BUSI_CASE")
public class DedurateCaseDO implements  java.io.Serializable{

	// Fields

	private Long busiCaseId;
	private String busicode;
	private String businame;
	private String busiPackCode;
	private Long status;
	private Long setlflg;
	private Long selfFeeType;
	private Long distType;
	private Long feeRetflag;
	private String appAmtflag;
	private String payAmtflag;
	private String merchAmtflag;
	private String merchFeeflag;
	private Date createTime;
	private Date updateTime;
	private String notes;
	private String remarks;

	// Constructors

	/** default constructor */
	public DedurateCaseDO() {
	}

	/** minimal constructor */
	public DedurateCaseDO(String busicode, String businame, String busiPackCode,
			Long status) {
		this.busicode = busicode;
		this.businame = businame;
		this.busiPackCode = busiPackCode;
		this.status = status;
	}

	/** full constructor */
	public DedurateCaseDO(String busicode, String businame, String busiPackCode,
			Long status, Long setlflg, Long selfFeeType,
			Long distType, Long feeRetflag, String appAmtflag,
			String payAmtflag, String merchAmtflag, String merchFeeflag,
			Date createTime, Date updateTime, String notes, String remarks) {
		this.busicode = busicode;
		this.businame = businame;
		this.busiPackCode = busiPackCode;
		this.status = status;
		this.setlflg = setlflg;
		this.selfFeeType = selfFeeType;
		this.distType = distType;
		this.feeRetflag = feeRetflag;
		this.appAmtflag = appAmtflag;
		this.payAmtflag = payAmtflag;
		this.merchAmtflag = merchAmtflag;
		this.merchFeeflag = merchFeeflag;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.notes = notes;
		this.remarks = remarks;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "BUSI_CASE_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getBusiCaseId() {
		return this.busiCaseId;
	}

	public void setBusiCaseId(Long busiCaseId) {
		this.busiCaseId = busiCaseId;
	}

	@Column(name = "BUSICODE", nullable = false, length = 4)
	public String getBusicode() {
		return this.busicode;
	}

	public void setBusicode(String busicode) {
		this.busicode = busicode;
	}

	@Column(name = "BUSINAME", nullable = false, length = 64)
	public String getBusiname() {
		return this.businame;
	}

	public void setBusiname(String businame) {
		this.businame = businame;
	}

	@Column(name = "BUSI_PACK_CODE", nullable = false, length = 8)
	public String getBusiPackCode() {
		return this.busiPackCode;
	}

	public void setBusiPackCode(String busiPackCode) {
		this.busiPackCode = busiPackCode;
	}

	@Column(name = "STATUS", nullable = false, precision = 1, scale = 0)
	public Long getStatus() {
		return this.status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	@Column(name = "SETLFLG", precision = 1, scale = 0)
	public Long getSetlflg() {
		return this.setlflg;
	}

	public void setSetlflg(Long setlflg) {
		this.setlflg = setlflg;
	}

	@Column(name = "SELF_FEE_TYPE", precision = 1, scale = 0)
	public Long getSelfFeeType() {
		return this.selfFeeType;
	}

	public void setSelfFeeType(Long selfFeeType) {
		this.selfFeeType = selfFeeType;
	}

	@Column(name = "DIST_TYPE", precision = 1, scale = 0)
	public Long getDistType() {
		return this.distType;
	}

	public void setDistType(Long distType) {
		this.distType = distType;
	}

	@Column(name = "FEE_RETFLAG", precision = 1, scale = 0)
	public Long getFeeRetflag() {
		return this.feeRetflag;
	}

	public void setFeeRetflag(Long feeRetflag) {
		this.feeRetflag = feeRetflag;
	}

	@Column(name = "APP_AMTFLAG", length = 1)
	public String getAppAmtflag() {
		return this.appAmtflag;
	}

	public void setAppAmtflag(String appAmtflag) {
		this.appAmtflag = appAmtflag;
	}

	@Column(name = "PAY_AMTFLAG", length = 1)
	public String getPayAmtflag() {
		return this.payAmtflag;
	}

	public void setPayAmtflag(String payAmtflag) {
		this.payAmtflag = payAmtflag;
	}

	@Column(name = "MERCH_AMTFLAG", length = 1)
	public String getMerchAmtflag() {
		return this.merchAmtflag;
	}

	public void setMerchAmtflag(String merchAmtflag) {
		this.merchAmtflag = merchAmtflag;
	}

	@Column(name = "MERCH_FEEFLAG", length = 1)
	public String getMerchFeeflag() {
		return this.merchFeeflag;
	}

	public void setMerchFeeflag(String merchFeeflag) {
		this.merchFeeflag = merchFeeflag;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_TIME", length = 7)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATE_TIME", length = 7)
	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
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
	
}
