package cn.com.agent.bean;

import java.io.Serializable;

public class CreditCardRateBean implements Serializable{

	private Double feeRate;
	private Double minFee;
	private Double maxFee;
	private String feeRateType;
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
	
}
