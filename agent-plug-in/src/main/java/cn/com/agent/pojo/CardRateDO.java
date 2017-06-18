package cn.com.agent.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "T_CARD_RATE")
public class CardRateDO implements Serializable{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1915789267239346277L;
	private long tid;
	private String feever;
	private String busicode;
	private int cardtype;
	private Double feeRate;
	private Double minFee;
	private Double maxFee;
	private String rateType;
	private long inuser;
	private Date intime;
	private String notes;
	private String remarks;
	
	@Id
	@GeneratedValue
	@Column(name = "TID", unique = true, nullable = false, precision = 10, scale = 0)
	public long getTid() {
		return tid;
	}
	public void setTid(long tid) {
		this.tid = tid;
	}
	@Column(name = "FEEVER")
	public String getFeever() {
		return feever;
	}
	public void setFeever(String feever) {
		this.feever = feever;
	}
	@Column(name = "BUSICODE")
	public String getBusicode() {
		return busicode;
	}
	public void setBusicode(String busicode) {
		this.busicode = busicode;
	}
	@Column(name = "CARDTYPE")
	public int getCardtype() {
		return cardtype;
	}
	public void setCardtype(int cardtype) {
		this.cardtype = cardtype;
	}
	@Column(name = "FEE_RATE")
	public Double getFeeRate() {
		return feeRate;
	}
	public void setFeeRate(Double feeRate) {
		this.feeRate = feeRate;
	}
	@Column(name = "MIN_FEE")
	public Double getMinFee() {
		return minFee;
	}
	public void setMinFee(Double minFee) {
		this.minFee = minFee;
	}
	@Column(name = "MAX_FEE")
	public Double getMaxFee() {
		return maxFee;
	}
	public void setMaxFee(Double maxFee) {
		this.maxFee = maxFee;
	}
	@Column(name = "RATE_TYPE")
	public String getRateType() {
		return rateType;
	}
	public void setRateType(String rateType) {
		this.rateType = rateType;
	}
	@Column(name = "INUSER")
	public long getInuser() {
		return inuser;
	}
	public void setInuser(long inuser) {
		this.inuser = inuser;
	}
	@Column(name = "INTIME")
	public Date getIntime() {
		return intime;
	}
	public void setIntime(Date intime) {
		this.intime = intime;
	}
	@Column(name = "NOTES")
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	@Column(name = "REMARKS")
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	

}
