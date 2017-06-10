package cn.com.agent.bean;

import java.io.Serializable;

import cn.com.agent.bean.merch.MercBusiBean;
import cn.com.agent.bean.merch.MercFeeBean;
import cn.com.agent.bean.merch.MercFileBean;
import cn.com.agent.bean.merch.MercInfoBean;
import cn.com.agent.bean.merch.MercMactBean;
import cn.com.agent.bean.merch.MercMcntBean;

public class MerchantBean implements Serializable{
	private MercInfoBean mercInfo;// 会员基本信息
	private MercBusiBean mercBusi;// 会员营业信息
	private MercMcntBean mercMcnt;// 联系人信息
	private MercFileBean mercFile;// 会员证件信息
	private MercMactBean mercMact;// 会员结算账户信息
	private MercFeeBean mercFee;// 会员费率信息
	
	
	public MercInfoBean getMercInfo() {
		return mercInfo;
	}
	public void setMercInfo(MercInfoBean mercInfo) {
		this.mercInfo = mercInfo;
	}
	public MercBusiBean getMercBusi() {
		return mercBusi;
	}
	public void setMercBusi(MercBusiBean mercBusi) {
		this.mercBusi = mercBusi;
	}
	public MercMcntBean getMercMcnt() {
		return mercMcnt;
	}
	public void setMercMcnt(MercMcntBean mercMcnt) {
		this.mercMcnt = mercMcnt;
	}
	public MercFileBean getMercFile() {
		return mercFile;
	}
	public void setMercFile(MercFileBean mercFile) {
		this.mercFile = mercFile;
	}
	public MercMactBean getMercMact() {
		return mercMact;
	}
	public void setMercMact(MercMactBean mercMact) {
		this.mercMact = mercMact;
	}
	public MercFeeBean getMercFee() {
		return mercFee;
	}
	public void setMercFee(MercFeeBean mercFee) {
		this.mercFee = mercFee;
	}
	public MerchantBean(MercInfoBean mercInfo, MercBusiBean mercBusi,
			MercMcntBean mercMcnt, MercFileBean mercFile,
			MercMactBean mercMact, MercFeeBean mercFee) {
		super();
		this.mercInfo = mercInfo;
		this.mercBusi = mercBusi;
		this.mercMcnt = mercMcnt;
		this.mercFile = mercFile;
		this.mercMact = mercMact;
		this.mercFee = mercFee;
	}
	public MerchantBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
