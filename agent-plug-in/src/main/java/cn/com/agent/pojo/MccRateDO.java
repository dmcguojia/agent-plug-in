package cn.com.agent.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TMccRate entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_MCC_RATE")
public class MccRateDO implements java.io.Serializable {

	// Fields
	private String busipackcode;
	private String mcc;
	private Double feeRate;
	private Double minFee;
	private Double maxFee;
	private String notes;
	private String remarks;
	private String feeRateType;
	private String mccname;

	// Constructors

	/** default constructor */
	public MccRateDO() {
	}

	/** minimal constructor */
	public MccRateDO(String mcc, String busipackcode) {
		this.mcc = mcc;
		this.busipackcode = busipackcode;
	}

	/** full constructor */
	public MccRateDO(String busipackcode,String mcc, Double feeRate, Double minFee, Double maxFee,
			String notes, String remarks, String feeRateType, String mccname) {
		this.busipackcode= busipackcode;
		this.mcc = mcc;
		this.feeRate = feeRate;
		this.minFee = minFee;
		this.maxFee = maxFee;
		this.notes = notes;
		this.remarks = remarks;
		this.feeRateType = feeRateType;
		this.mccname = mccname;
	}

	// Property accessors
	@Id
	@Column(name = "MCC", unique = true, nullable = false, length = 4)
	public String getMcc() {
		return this.mcc;
	}

	public void setMcc(String mcc) {
		this.mcc = mcc;
	}

	@Column(name = "FEE_RATE", nullable = false, precision = 4, scale = 0)
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

	@Column(name = "MCCNAME", length = 64)
	public String getMccname() {
		return this.mccname;
	}

	public void setMccname(String mccname) {
		this.mccname = mccname;
	}
	@Column(name = "BUSI_PACK_CODE", length = 8)
	public String getBusipackcode() {
		return busipackcode;
	}

	public void setBusipackcode(String busipackcode) {
		this.busipackcode = busipackcode;
	}
	
}