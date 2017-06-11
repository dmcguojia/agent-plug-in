package cn.com.agent.bean;

import java.io.Serializable;

public class RateBean implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5348971623964582276L;
	private Double feeRate;
	private Double minFee;
	private Double maxFee;
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
	
}
