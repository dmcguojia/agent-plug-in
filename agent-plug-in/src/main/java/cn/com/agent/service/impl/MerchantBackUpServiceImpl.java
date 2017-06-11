package cn.com.agent.service.impl;

import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.com.agent.bean.BaseBean;
import cn.com.agent.bean.MerchantBean;
import cn.com.agent.bean.RateBean;
import cn.com.agent.bean.ResponseBean;
import cn.com.agent.bean.ResultBean;
import cn.com.agent.bean.enums.APICodeEnum;
import cn.com.agent.bean.enums.BusiIndustryEnum;
import cn.com.agent.bean.enums.IdTypeEnum;
import cn.com.agent.bean.enums.MerchStatusEnum;
import cn.com.agent.bean.merch.MercBusiBean;
import cn.com.agent.bean.merch.MercFeeBean;
import cn.com.agent.bean.merch.MercFileBean;
import cn.com.agent.bean.merch.MercInfoBean;
import cn.com.agent.bean.merch.MercMactBean;
import cn.com.agent.bean.merch.MercMcntBean;
import cn.com.agent.dao.MerchantDAO;
import cn.com.agent.pojo.MerchantDO;
import cn.com.agent.service.MerchantBackUpService;
import cn.com.agent.utils.DateUtils;
import cn.com.agent.utils.HttpPostInvoker;

import com.alibaba.fastjson.JSON;

@Service
public class MerchantBackUpServiceImpl implements MerchantBackUpService{

	@Autowired
	private MerchantDAO merchantDAO;
	//代理商编号
	private final static String orgId="SHANDONG";
	@Override
	public ResultBean backupAddMerchant(String merchNo) {
		ResultBean resultBean = new ResultBean();
		MerchantDO merchant = merchantDAO.getMerchanByMerchNo(merchNo);
		if(!"01".equals(merchant.getBackupStatus())){
			resultBean.setRetCode("09");
			resultBean.setRetInfo("商户已经报备");
			return resultBean;
		}
		MercInfoBean mercInfo = generateMerchantBean(merchant);// 会员基本信息
		MercBusiBean mercBusi = generateMercBusiBean(merchant);// 会员营业信息
		MercMcntBean mercMcnt = generateMercMcntBean(merchant);// 联系人信息
		MercFileBean mercFile = generateMercFileBean(merchant);// 会员证件信息
		MercMactBean mercMact = generateMercMactBean(merchant);// 会员结算账户信息
		MercFeeBean mercFee = generateMercFeeBean(merchant);
		MerchantBean merchantBean = new MerchantBean(mercInfo, mercBusi, mercMcnt, mercFile, mercMact, mercFee);
		BaseBean baseBean = new BaseBean();
		baseBean.setBody(merchantBean);
		baseBean.setAction(APICodeEnum.MEMBER_ADDANDMODIFY.getCode());
		baseBean.setRequestId(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
		try {
			String returnMsg = HttpPostInvoker.invokeMethod("param="+JSON.toJSONString(baseBean));
			ResponseBean responseBean = JSON.parseObject(returnMsg, ResponseBean.class);
			resultBean.setRetCode(responseBean.getCode());
			resultBean.setRetInfo(responseBean.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultBean;
	}
	private MercInfoBean generateMerchantBean(MerchantDO merchant){
		MercInfoBean mercInfo = new MercInfoBean();
		mercInfo.setOrgId(orgId);//代理商编号
		mercInfo.setMercId(merchant.getMerchNo());//会员号
		mercInfo.setMercProv("");//会员归属省
		mercInfo.setMercCity("");//会员归属市
		mercInfo.setMercTyp(BusiIndustryEnum.valueOf("BD"+merchant.getBusiIndustry()).getCode());//会员类型
		mercInfo.setMercSts(MerchStatusEnum.normal.getCode()+"");//状态
		mercInfo.setMercStlSts("0");//结算状态
		mercInfo.setMercCnm(merchant.getMerchName());//会员名称
		mercInfo.setMercAbbr(merchant.getTradeAddr());//会员简称
		mercInfo.setMercPyAbbr("");//拼音简称
		mercInfo.setMccCd(merchant.getMcclist());//会员行业类别
		mercInfo.setBusAddr(merchant.getBusiAddr());//营业地址
		mercInfo.setMercHotLin(merchant.getContaTelNo());//热线电话
		return mercInfo;
	}
	private MercBusiBean generateMercBusiBean(MerchantDO merchant){
		MercBusiBean mercBusi = new MercBusiBean();
		mercBusi.setMercAttr("");//			会员性质
		mercBusi.setRegId(merchant.getBusiLicense());	//		营业执照号
		mercBusi.setOrgCod(merchant.getInstiCode());	//		机构代码证
		mercBusi.setRegCapAmt("");//			注册资本
		mercBusi.setRegAddr("");	//		会员注册地址
		mercBusi.setTaxCertId(merchant.getTaxregNo());//			税务登记证号
		mercBusi.setCrpIdTyp(IdTypeEnum.valueOf("ID"+merchant.getLawyCertiType()).getCode());//			法人证件类型
		mercBusi.setCrpIdNo(merchant.getLawyCertiNo());	//		法人证件号码
		mercBusi.setCrpNm(merchant.getLawyerName());	//		法人名称
		
		return mercBusi;
	}
	private MercMcntBean generateMercMcntBean(MerchantDO merchant){
		MercMcntBean mercMcnt = new MercMcntBean();
		mercMcnt.setCttPsnCnm(merchant.getMerchName());//会员名称
		mercMcnt.setMblTel(merchant.getContaTelNo());			//移动电话
		mercMcnt.setFixTel("");			//固定电话
		mercMcnt.setEmail(merchant.getContaEmail());			//Email
		mercMcnt.setMsnQq("");			//MSN/QQ
		return mercMcnt;
	}
	private MercFileBean generateMercFileBean(MerchantDO merchant){
		String path = "/"+orgId+"/"+DateUtils.getCurrentYear()+"/"+DateUtils.getCurrentMonth()+"/"+merchant.getMerchNo()+"/";
		MercFileBean mercFile = new MercFileBean();
		mercFile.setCrpAboveImg(path+"1.jpg");			//身份证正面图片路径
		mercFile.setCrpBelowImg(path+"2.jpg");			//身份证反面图片路径
		mercFile.setBankCardImg(path+"3.jpg");			//银行卡正面图片路径
		mercFile.setPersonImg(path+"4.jpg");			//个人照图片路径
		mercFile.setHandheldAboveImg(path+"5.jpg");			//手持身份证正面图片路径
		mercFile.setHandheldBelowImg(path+"6.jpg");			//手持身份证反面图片路径
		return mercFile;
	}
	
	private MercMactBean generateMercMactBean(MerchantDO merchant){
		MercMactBean mercMact = new MercMactBean();
		mercMact.setStlOac(merchant.getSettleAccount());			//结算账号
		mercMact.setEffDt(DateUtils.getShortDateStr(merchant.getInTime())	);			//生效日期（注册时间）
		mercMact.setExpDt("");			//失效日期
		mercMact.setStlOacCls("0");			//结算账户类型
		mercMact.setEffFlg("1");			//生效标识
		if(merchant.getSettleAccount().startsWith("62")){
			mercMact.setDeductSign("1");	//结算账户标志
			mercMact.setDpsbondSign("1");			//结算账户标识
		}else{
			mercMact.setDeductSign("0");	//结算账户标志
			mercMact.setDpsbondSign("0");			//结算账户标识
		}
				
		mercMact.setDpsbondAcnm(merchant.getAccName());			//账号户名
		mercMact.setDpsbondLbnkNo(merchant.getDepositBank());			//联行行号
		Map<String, Object> bankInfo = merchantDAO.queryBankInfo(merchant.getDepositBank());
		mercMact.setDpsbondBnkDesc(bankInfo.get("BANK_NAME").toString());			//银行名称
		if(StringUtils.isEmpty(merchant.getDepositBankProvince())||StringUtils.isEmpty(merchant.getDepositBankCity())){//开户行省市为空时，用商户所在省市
			mercMact.setDpsbondBnkProv(merchantDAO.queryProvinceById(merchant.getMerchProvince()).getPCode());			//开户行所在省
			mercMact.setDpsbondBnkCity(merchantDAO.queryCityById(merchant.getMerchCity()).getXzCode());			//开户行所在市
		}else{
			mercMact.setDpsbondBnkProv(merchantDAO.queryProvinceById(merchant.getDepositBankProvince()).getPCode());			//开户行所在省
			mercMact.setDpsbondBnkCity(merchantDAO.queryCityById(merchant.getDepositBankCity()).getXzCode());			//开户行所在市
		}
		
		return mercMact;
	}
	private MercFeeBean generateMercFeeBean(MerchantDO merchant){
		MercFeeBean mercFee = new MercFeeBean();
		RateBean rateBean = merchantDAO.getMerchantRate(merchant.getBusiver());
		mercFee.setT1DebitFeeRat((rateBean.getFeeRate()/100)+"");			//借记卡T1交易费率（%）
		mercFee.setT1DebitFixedFee("0");			//借记卡T1交易固定手续费（元）
		mercFee.setT1DebitMinFeeAmt((rateBean.getMinFee()/100)+"");			//借记卡T1交易最低手续费（元） 
		mercFee.setT1DebitMaxFeeAmt((rateBean.getMaxFee()/100)+"");			//借记卡T1交易封顶手续费（元） 
		mercFee.setT1CreditFeeRat((rateBean.getFeeRate()/100)+"");			//贷记卡T1交易费率（%）
		mercFee.setT1CreditFixedFee("0");			//贷记卡T1交易固定手续费（元）
		mercFee.setT1CreditMinFeeAmt((rateBean.getMinFee()/100)+"");			//贷记卡T1交易最低手续费（元）
		mercFee.setT1CreditMaxFeeAmt((rateBean.getMaxFee()/100)+"");			//贷记卡T1交易封顶手续费（元）
		mercFee.setD0FeeRat((rateBean.getFeeRate()/100)+"");			//D0交易费率（%）
		mercFee.setD0FixedFee("0");			//D0交易固定手续费（元）
		mercFee.setD0MinFeeAmt((rateBean.getMinFee()/100)+"");			//D0交易最低手续费（元）
		mercFee.setD0MaxFeeAmt((rateBean.getMaxFee()/100)+"");			//D0交易封顶手续费（元） 
		return mercFee;
	}
	
	@Override
	public ResultBean backupUpdateMerchant(String merchNo) {
		ResultBean resultBean = new ResultBean();
		MerchantDO merchant = merchantDAO.getMerchanByMerchNo(merchNo);
		if(!"00".equals(merchant.getBackupStatus())){
			resultBean.setRetCode("09");
			resultBean.setRetInfo("无法修改商户报备信息");
			return resultBean;
		}
		return null;
	}
	@Override
	public ResultBean backupDeleteMerchant(String merchNo) {
		ResultBean resultBean = new ResultBean();
		MerchantDO merchant = merchantDAO.getMerchanByMerchNo(merchNo);
		if(!"00".equals(merchant.getBackupStatus())){
			resultBean.setRetCode("09");
			resultBean.setRetInfo("无法删除商户报备信息");
			return resultBean;
		}
		return null;
	}
	
	public static void main(String[] args) {
		Double f = 80.0;
		System.out.println((f/100)+"");
		
	}
}
