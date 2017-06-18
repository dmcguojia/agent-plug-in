package cn.com.agent.bean;

import java.io.Serializable;

import cn.com.agent.bean.enums.SelfFeeTypeEnum;

public class RateBean implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5348971623964582276L;
	private Double feeRate;
	private Double minFee;
	private Double maxFee;
	private String feeRateType;
	private SelfFeeTypeEnum selfFeeTypeEnum;
	private CreditCardRateBean creditCardRateBean;
	private DebitCardRateBean debitCardRateBean;
	
	
	
	public Double getFeeRate() {
		return feeRate;
	}
	public void setFeeRate(Double feeRate) {
		this.feeRate = feeRate;
	}
	public Double getMinFee() {
		return minFee;
	}
	public void setMinFee(Double minFee) {
		this.minFee = minFee;
	}
	public Double getMaxFee() {
		return maxFee;
	}
	public void setMaxFee(Double maxFee) {
		this.maxFee = maxFee;
	}
	public String getFeeRateType() {
		return feeRateType;
	}
	public void setFeeRateType(String feeRateType) {
		this.feeRateType = feeRateType;
	}
	public SelfFeeTypeEnum getSelfFeeTypeEnum() {
		return selfFeeTypeEnum;
	}
	public void setSelfFeeTypeEnum(SelfFeeTypeEnum selfFeeTypeEnum) {
		this.selfFeeTypeEnum = selfFeeTypeEnum;
	}
	public CreditCardRateBean getCreditCardRateBean() {
		return creditCardRateBean;
	}
	public void setCreditCardRateBean(CreditCardRateBean creditCardRateBean) {
		this.creditCardRateBean = creditCardRateBean;
	}
	public DebitCardRateBean getDebitCardRateBean() {
		return debitCardRateBean;
	}
	public void setDebitCardRateBean(DebitCardRateBean debitCardRateBean) {
		this.debitCardRateBean = debitCardRateBean;
	}
	
}
