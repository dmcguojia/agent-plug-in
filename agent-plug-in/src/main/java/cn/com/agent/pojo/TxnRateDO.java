package cn.com.agent.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TTxnRate entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_TXN_RATE")
public class TxnRateDO  implements java.io.Serializable{
	
	// Fields
	private String busicode;
	private String busipackcode;
	private Double feeRate;
	private Double minFee;
	private Double maxFee;
	private String notes;
	private String remarks;
	private String feeRateType;

	// Constructors

	/** default constructor */
	public TxnRateDO() {
	}

	/** minimal constructor */
	public TxnRateDO(String busicode) {
		this.busicode = busicode;
	}

	/** full constructor */
	public TxnRateDO(String busipackcode,String busicode, Double feeRate, Double minFee, Double maxFee,
			String notes, String remarks, String feeRateType) {
		this.busipackcode = busipackcode;
		this.busicode = busicode;
		this.feeRate = feeRate;
		this.minFee = minFee;
		this.maxFee = maxFee;
		this.notes = notes;
		this.remarks = remarks;
		this.feeRateType = feeRateType;
	}

	// Property accessors
	@Id
	@Column(name = "BUSICODE", unique = true, nullable = false, length=4)
	public String getBusicode() {
		return this.busicode;
	}

	public void setBusicode(String busicode) {
		this.busicode = busicode;
	}

	@Column(name = "FEE_RATE", precision = 4, scale = 0)
	public Double getFeeRate() {
		return this.feeRate;
	}

	public void setFeeRate(Double feeRate) {
		this.feeRate = feeRate;
	}

	@Column(name = "MIN_FEE", precision = 12, scale = 0)
	public Double getMinFee() {
		return this.minFee;
	}

	public void setMinFee(Double minFee) {
		this.minFee = minFee;
	}

	@Column(name = "MAX_FEE", precision = 12, scale = 0)
	public Double getMaxFee() {
		return this.maxFee;
	}

	public void setMaxFee(Double maxFee) {
		this.maxFee = maxFee;
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

	@Column(name = "FEE_RATE_TYPE", length = 2)
	public String getFeeRateType() {
		return this.feeRateType;
	}

	public void setFeeRateType(String feeRateType) {
		this.feeRateType = feeRateType;
	}
	@Column(name = "BUSI_PACK_CODE", length = 8)
	public String getBusipackcode() {
		return busipackcode;
	}

	public void setBusipackcode(String busipackcode) {
		this.busipackcode = busipackcode;
	}
	
	
	
/*	public BusinessModel getBusiness() {
		return business;
	}

	public void setBusiness(BusinessModel business) {
		this.business = business;
	}*/
	
	
}
