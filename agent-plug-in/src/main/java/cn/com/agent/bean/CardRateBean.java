package cn.com.agent.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * TCardRate entity. @author MyEclipse Persistence Tools
 */
public class CardRateBean implements java.io.Serializable {

	// Fields

	/**
     * serialVersionUID
     */
    private static final long serialVersionUID = 6686745495610585285L;
    private Long tid;
	private String feever;
	private String busicode;
	private String cardtype;
	private BigDecimal feeRate;
	private BigDecimal minFee;
	private BigDecimal maxFee;
	private String rateType;
	private Long inuser;
	private Date intime;
	private String notes;
	private String remarks;
	private String minFeeStr;
	private String maxFeeStr;
	private String feeRateStr;
	// Constructors

	/** default constructor */
	public CardRateBean() {
	}

	/** minimal constructor */
	public CardRateBean(Long tid, String feever, String busicode,
			String cardtype, BigDecimal feeRate) {
		this.tid = tid;
		this.feever = feever;
		this.busicode = busicode;
		this.cardtype = cardtype;
		this.feeRate = feeRate;
	}

	/** full constructor */
	public CardRateBean(Long tid, String feever, String busicode,
			String cardtype, BigDecimal feeRate, BigDecimal minFee, BigDecimal maxFee,
			String rateType, Long inuser, Date intime, String notes,
			String remarks) {
		this.tid = tid;
		this.feever = feever;
		this.busicode = busicode;
		this.cardtype = cardtype;
		this.feeRate = feeRate;
		this.minFee = minFee;
		this.maxFee = maxFee;
		this.rateType = rateType;
		this.inuser = inuser;
		this.intime = intime;
		this.notes = notes;
		this.remarks = remarks;
	}

	// Property accessors
	public Long getTid() {
		return this.tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}

	public String getFeever() {
		return this.feever;
	}

	public void setFeever(String feever) {
		this.feever = feever;
	}

	public String getBusicode() {
		return this.busicode;
	}

	public void setBusicode(String busicode) {
		this.busicode = busicode;
	}

	public String getCardtype() {
		return this.cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public BigDecimal getFeeRate() {
		return this.feeRate;
	}

	public void setFeeRate(BigDecimal feeRate) {
		this.feeRate = feeRate;
	}

	public BigDecimal getMinFee() {
		return this.minFee;
	}

	public void setMinFee(BigDecimal minFee) {
		this.minFee = minFee;
	}

	public BigDecimal getMaxFee() {
		return this.maxFee;
	}

	public void setMaxFee(BigDecimal maxFee) {
		this.maxFee = maxFee;
	}

	public String getRateType() {
		return this.rateType;
	}

	public void setRateType(String rateType) {
		this.rateType = rateType;
	}

	public Long getInuser() {
		return this.inuser;
	}

	public void setInuser(Long inuser) {
		this.inuser = inuser;
	}

	public Date getIntime() {
		return this.intime;
	}

	public void setIntime(Date intime) {
		this.intime = intime;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
    public String getMinFeeStr() {
        return minFeeStr;
    }

    public void setMinFeeStr(String minFeeStr) {
        this.minFeeStr = minFeeStr;
    }
    public String getMaxFeeStr() {
        return maxFeeStr;
    }

    public void setMaxFeeStr(String maxFeeStr) {
        this.maxFeeStr = maxFeeStr;
    }
    public String getFeeRateStr() {
        return feeRateStr;
    }

    public void setFeeRateStr(String feeRateStr) {
        this.feeRateStr = feeRateStr;
    }
}