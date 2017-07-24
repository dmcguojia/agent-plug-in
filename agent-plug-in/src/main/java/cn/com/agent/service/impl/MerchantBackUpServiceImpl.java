package cn.com.agent.service.impl;

import java.util.Map;
import java.util.ResourceBundle;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.com.agent.bean.BackupBean;
import cn.com.agent.bean.BaseBean;
import cn.com.agent.bean.MerchantBean;
import cn.com.agent.bean.RateBean;
import cn.com.agent.bean.ResponseBean;
import cn.com.agent.bean.ResultBean;
import cn.com.agent.bean.enums.APICodeEnum;
import cn.com.agent.bean.enums.BusiIndustryEnum;
import cn.com.agent.bean.enums.IdTypeEnum;
import cn.com.agent.bean.enums.MerchStatusEnum;
import cn.com.agent.bean.enums.SelfFeeTypeEnum;
import cn.com.agent.bean.merch.MercBusiBean;
import cn.com.agent.bean.merch.MercFeeBean;
import cn.com.agent.bean.merch.MercFileBean;
import cn.com.agent.bean.merch.MercInfoBean;
import cn.com.agent.bean.merch.MercMactBean;
import cn.com.agent.bean.merch.MercMcntBean;
import cn.com.agent.dao.MerchantBackupLogDAO;
import cn.com.agent.dao.MerchantDAO;
import cn.com.agent.pojo.MerchantBackupLogDO;
import cn.com.agent.pojo.MerchantDO;
import cn.com.agent.service.MerchantBackUpService;
import cn.com.agent.utils.DateUtils;
import cn.com.agent.utils.HttpPostInvoker;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;

@Service
public class MerchantBackUpServiceImpl implements MerchantBackUpService{
	@Autowired
	private MerchantDAO merchantDAO;
	@Autowired
	private MerchantBackupLogDAO merchantBackupLogDAO; 
	//代理商编号
	//private final static String orgId="SHANDONG";
	private final static String orgId=ResourceBundle.getBundle("paramater").getString("cardinfo.orgid");
	
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
		Map<String, Object> newHashMap = Maps.newHashMap();
		Map<String, Object> parseObject1 = JSON.parseObject(JSON.toJSONString(mercInfo), Map.class);
		Map<String, Object> parseObject2 = JSON.parseObject(JSON.toJSONString(mercBusi), Map.class);
		Map<String, Object> parseObject3 = JSON.parseObject(JSON.toJSONString(mercMcnt), Map.class);
		Map<String, Object> parseObject4 = JSON.parseObject(JSON.toJSONString(mercFile), Map.class);
		Map<String, Object> parseObject5 = JSON.parseObject(JSON.toJSONString(mercMact), Map.class);
		Map<String, Object> parseObject6 = JSON.parseObject(JSON.toJSONString(mercFee), Map.class);
		newHashMap.putAll(parseObject1);
		newHashMap.putAll(parseObject2);
		newHashMap.putAll(parseObject3);
		newHashMap.putAll(parseObject4);
		newHashMap.putAll(parseObject5);
		newHashMap.putAll(parseObject6);
		
		MerchantBackupLogDO merchantBackupLog = JSON.parseObject(JSON.toJSONString(newHashMap), MerchantBackupLogDO.class);
		merchantBackupLog.setAction(baseBean.getAction());
		merchantBackupLog.setRequestId(baseBean.getRequestId());
		merchantBackupLog.setTimestamp(baseBean.getTimestamp());
		merchantBackupLogDAO.saveMerchantBackupLog(merchantBackupLog);
		try {
			String returnMsg = HttpPostInvoker.invokeMethod("param="+JSON.toJSONString(baseBean));
			ResponseBean responseBean = JSON.parseObject(returnMsg, ResponseBean.class);
			if("0000".equals(responseBean.getCode())){
				merchantDAO.updateMerchantBackupStatus(merchNo, "00");
			}
			resultBean.setRetCode(responseBean.getCode());
			resultBean.setRetInfo(responseBean.getMessage());
			merchantBackupLogDAO.updateMerchantBackupLog(baseBean.getRequestId(), responseBean);
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
		mercInfo.setMercAbbr(merchant.getMerchName());//会员简称
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
		mercMcnt.setMblTel(org.apache.commons.lang.StringUtils.isEmpty(merchant.getContaTelNo())?merchant.getLawyTelNo():merchant.getContaTelNo());			//移动电话
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
			mercMact.setDpsbondBnkCity(merchantDAO.queryCityById(merchant.getMerchCity()).getXzCode());			//开户行所在市
			mercMact.setDpsbondBnkProv(mercMact.getDpsbondBnkCity().substring(0,2));			//开户行所在省
		}else{
			mercMact.setDpsbondBnkCity(merchantDAO.queryCityById(merchant.getDepositBankCity()).getXzCode());			//开户行所在市
			mercMact.setDpsbondBnkProv(mercMact.getDpsbondBnkCity().substring(0,2));			//开户行所在省
		}
		
		return mercMact;
	}
	private MercFeeBean generateMercFeeBean(MerchantDO merchant){
		MercFeeBean mercFee = new MercFeeBean();
		RateBean rateBean = merchantDAO.getMerchantRate(merchant.getBusiver(),merchant.getBusiIndustry());
		if(rateBean.getSelfFeeTypeEnum()==SelfFeeTypeEnum.card){
			if(rateBean.getDebitCardRateBean()!=null){
				mercFee.setT1DebitFeeRat((rateBean.getDebitCardRateBean().getFeeRate()/100)+"");			//借记卡T1交易费率（%）
				mercFee.setT1DebitFixedFee("0");			//借记卡T1交易固定手续费（元）
				mercFee.setT1DebitMinFeeAmt((rateBean.getDebitCardRateBean().getMinFee()/100)+"");			//借记卡T1交易最低手续费（元） 
				mercFee.setT1DebitMaxFeeAmt((rateBean.getDebitCardRateBean().getMaxFee()/100)+"");			//借记卡T1交易封顶手续费（元）
			}
			 
			if(rateBean.getCreditCardRateBean()!=null){
				mercFee.setT1CreditFeeRat((rateBean.getCreditCardRateBean().getFeeRate()/100)+"");			//贷记卡T1交易费率（%）
				mercFee.setT1CreditFixedFee("0");			//贷记卡T1交易固定手续费（元）
				mercFee.setT1CreditMinFeeAmt((rateBean.getCreditCardRateBean().getMinFee()/100)+"");			//贷记卡T1交易最低手续费（元）
				mercFee.setT1CreditMaxFeeAmt((rateBean.getCreditCardRateBean().getMaxFee()/100)+"");			//贷记卡T1交易封顶手续费（元）
			}
			
			
			mercFee.setD0FeeRat("0");			//D0交易费率（%）
			mercFee.setD0FixedFee("0");			//D0交易固定手续费（元）
			mercFee.setD0MinFeeAmt("0");			//D0交易最低手续费（元）
			mercFee.setD0MaxFeeAmt("0");			//D0交易封顶手续费（元） 
			
			if("02".equals(rateBean.getFeeRateType())){
				mercFee.setT1DebitMaxFeeAmt("99999");			//借记卡T1交易封顶手续费（元） 
				mercFee.setT1CreditMaxFeeAmt("99999");			//贷记卡T1交易封顶手续费（元）
			}
		}else{
			mercFee.setT1DebitFeeRat((rateBean.getFeeRate()/100)+"");			//借记卡T1交易费率（%）
			mercFee.setT1DebitFixedFee("0");			//借记卡T1交易固定手续费（元）
			mercFee.setT1DebitMinFeeAmt((rateBean.getMinFee()/100)+"");			//借记卡T1交易最低手续费（元） 
			mercFee.setT1DebitMaxFeeAmt((rateBean.getMaxFee()/100)+"");			//借记卡T1交易封顶手续费（元） 
			
			mercFee.setT1CreditFeeRat((rateBean.getFeeRate()/100)+"");			//贷记卡T1交易费率（%）
			mercFee.setT1CreditFixedFee("0");			//贷记卡T1交易固定手续费（元）
			mercFee.setT1CreditMinFeeAmt((rateBean.getMinFee()/100)+"");			//贷记卡T1交易最低手续费（元）
			mercFee.setT1CreditMaxFeeAmt((rateBean.getMaxFee()/100)+"");			//贷记卡T1交易封顶手续费（元）
			
			mercFee.setD0FeeRat("0");			//D0交易费率（%）
			mercFee.setD0FixedFee("0");			//D0交易固定手续费（元）
			mercFee.setD0MinFeeAmt("0");			//D0交易最低手续费（元）
			mercFee.setD0MaxFeeAmt("0");			//D0交易封顶手续费（元） 
			
			if("02".equals(rateBean.getFeeRateType())){
				mercFee.setT1DebitMaxFeeAmt("99999");			//借记卡T1交易封顶手续费（元） 
				mercFee.setT1CreditMaxFeeAmt("99999");			//贷记卡T1交易封顶手续费（元）
			}
		}
		
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
		Map<String, Object> newHashMap = Maps.newHashMap();
		Map<String, Object> parseObject1 = JSON.parseObject(JSON.toJSONString(mercInfo), Map.class);
		Map<String, Object> parseObject2 = JSON.parseObject(JSON.toJSONString(mercBusi), Map.class);
		Map<String, Object> parseObject3 = JSON.parseObject(JSON.toJSONString(mercMcnt), Map.class);
		Map<String, Object> parseObject4 = JSON.parseObject(JSON.toJSONString(mercFile), Map.class);
		Map<String, Object> parseObject5 = JSON.parseObject(JSON.toJSONString(mercMact), Map.class);
		Map<String, Object> parseObject6 = JSON.parseObject(JSON.toJSONString(mercFee), Map.class);
		newHashMap.putAll(parseObject1);
		newHashMap.putAll(parseObject2);
		newHashMap.putAll(parseObject3);
		newHashMap.putAll(parseObject4);
		newHashMap.putAll(parseObject5);
		newHashMap.putAll(parseObject6);
		
		MerchantBackupLogDO merchantBackupLog = JSON.parseObject(JSON.toJSONString(newHashMap), MerchantBackupLogDO.class);
		merchantBackupLog.setAction(baseBean.getAction());
		merchantBackupLog.setRequestId(baseBean.getRequestId());
		merchantBackupLog.setTimestamp(baseBean.getTimestamp());
		merchantBackupLogDAO.saveMerchantBackupLog(merchantBackupLog);
		try {
			String returnMsg = HttpPostInvoker.invokeMethod("param="+JSON.toJSONString(baseBean));
			ResponseBean responseBean = JSON.parseObject(returnMsg, ResponseBean.class);
			if("0000".equals(responseBean.getCode())){
				merchantDAO.updateMerchantBackupStatus(merchNo, "00");
			}
			resultBean.setRetCode(responseBean.getCode());
			resultBean.setRetInfo(responseBean.getMessage());
			merchantBackupLogDAO.updateMerchantBackupLog(baseBean.getRequestId(), responseBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultBean;
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
		Map<String, Object> msgMap = Maps.newHashMap();
		msgMap.put("mercId", merchNo);
		msgMap.put("orgId", orgId);
		BaseBean baseBean = new BaseBean();
		baseBean.setBody(msgMap);
		baseBean.setAction(APICodeEnum.MEMBER_DELETE.getCode());
		baseBean.setRequestId(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
		MerchantBackupLogDO merchantBackupLog = new MerchantBackupLogDO();
		merchantBackupLog.setAction(baseBean.getAction());
		merchantBackupLog.setRequestId(baseBean.getRequestId());
		merchantBackupLog.setTimestamp(baseBean.getTimestamp());
		merchantBackupLog.setMercId(merchNo);
		merchantBackupLog.setOrgId(orgId);
		merchantBackupLogDAO.saveMerchantBackupLog(merchantBackupLog);
		try {
			String returnMsg = HttpPostInvoker.invokeMethod("param="+JSON.toJSONString(baseBean));
			ResponseBean responseBean = JSON.parseObject(returnMsg, ResponseBean.class);
			if("0000".equals(responseBean.getCode())){
				merchantDAO.updateMerchantBackupStatus(merchNo, "99");
			}
			resultBean.setRetCode(responseBean.getCode());
			resultBean.setRetInfo(responseBean.getMessage());
			merchantBackupLogDAO.updateMerchantBackupLog(baseBean.getRequestId(), responseBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultBean;
	}
	
	public static void main(String[] args) {
		Double f = 80.0;
		System.out.println((f/100)+"");
		
	}
	@Override
	public ResultBean backupAddMerchant(BackupBean backupBean) {
		String merchNo = backupBean.getMerchNo();
		ResultBean resultBean = new ResultBean();
		MerchantDO merchant = merchantDAO.getMerchanByMerchNo(merchNo);
		/*if(!"01".equals(merchant.getBackupStatus())){
			resultBean.setRetCode("09");
			resultBean.setRetInfo("商户已经报备");
			return resultBean;
		}*/
		MercInfoBean mercInfo = generateMerchantBean(merchant);// 会员基本信息
		MercBusiBean mercBusi = generateMercBusiBean(merchant);// 会员营业信息
		MercMcntBean mercMcnt = generateMercMcntBean(merchant);// 联系人信息
		MercFileBean mercFile = generateMercFileBean(merchant);// 会员证件信息
		MercMactBean mercMact = generateMercMactBean(merchant);// 会员结算账户信息
		mercMact.setDeductSign(backupBean.getDeductSign());
		mercMact.setDpsbondSign(backupBean.getDeductSign());
		MercFeeBean mercFee = generateMercFeeBean(merchant);
		if(merchant.getSetlCycle().intValue()==0){//D0商户
			mercFee.setD0FeeRat(backupBean.getD0FeeRat());			//D0交易费率（%）
			mercFee.setD0FixedFee(backupBean.getD0FixedFee());			//D0交易固定手续费（元）
			mercFee.setD0MinFeeAmt(backupBean.getD0MinFeeAmt());			//D0交易最低手续费（元）
			mercFee.setD0MaxFeeAmt(backupBean.getD0MaxFeeAmt());			//D0交易封顶手续费（元） 
		}else{
			mercFee.setD0FeeRat("0");			//D0交易费率（%）
			mercFee.setD0FixedFee("0");			//D0交易固定手续费（元）
			mercFee.setD0MinFeeAmt("0");			//D0交易最低手续费（元）
			mercFee.setD0MaxFeeAmt("0");
		}
		
		
		MerchantBean merchantBean = new MerchantBean(mercInfo, mercBusi, mercMcnt, mercFile, mercMact, mercFee);
		BaseBean baseBean = new BaseBean();
		baseBean.setBody(merchantBean);
		baseBean.setAction(APICodeEnum.MEMBER_ADDANDMODIFY.getCode());
		baseBean.setRequestId(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
		Map<String, Object> newHashMap = Maps.newHashMap();
		Map<String, Object> parseObject1 = JSON.parseObject(JSON.toJSONString(mercInfo), Map.class);
		Map<String, Object> parseObject2 = JSON.parseObject(JSON.toJSONString(mercBusi), Map.class);
		Map<String, Object> parseObject3 = JSON.parseObject(JSON.toJSONString(mercMcnt), Map.class);
		Map<String, Object> parseObject4 = JSON.parseObject(JSON.toJSONString(mercFile), Map.class);
		Map<String, Object> parseObject5 = JSON.parseObject(JSON.toJSONString(mercMact), Map.class);
		Map<String, Object> parseObject6 = JSON.parseObject(JSON.toJSONString(mercFee), Map.class);
		newHashMap.putAll(parseObject1);
		newHashMap.putAll(parseObject2);
		newHashMap.putAll(parseObject3);
		newHashMap.putAll(parseObject4);
		newHashMap.putAll(parseObject5);
		newHashMap.putAll(parseObject6);
		
		MerchantBackupLogDO merchantBackupLog = JSON.parseObject(JSON.toJSONString(newHashMap), MerchantBackupLogDO.class);
		merchantBackupLog.setAction(baseBean.getAction());
		merchantBackupLog.setRequestId(baseBean.getRequestId());
		merchantBackupLog.setTimestamp(baseBean.getTimestamp());
		merchantBackupLogDAO.saveMerchantBackupLog(merchantBackupLog);
		try {
			String returnMsg = HttpPostInvoker.invokeMethod("param="+JSON.toJSONString(baseBean));
			ResponseBean responseBean = JSON.parseObject(returnMsg, ResponseBean.class);
			if("0000".equals(responseBean.getCode())){
				merchantDAO.updateMerchantBackupStatus(merchNo, "00");
			}
			resultBean.setRetCode(responseBean.getCode());
			resultBean.setRetInfo(responseBean.getMessage());
			merchantBackupLogDAO.updateMerchantBackupLog(baseBean.getRequestId(), responseBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultBean;
	}
	@Override
	public ResultBean backupUpdateMerchant(BackupBean backupBean) {
		String merchNo = backupBean.getMerchNo();
		ResultBean resultBean = new ResultBean();
		MerchantDO merchant = merchantDAO.getMerchanByMerchNo(merchNo);
		/*if(!"00".equals(merchant.getBackupStatus())){
			resultBean.setRetCode("09");
			resultBean.setRetInfo("无法修改商户报备信息");
			return resultBean;
		}*/
		MercInfoBean mercInfo = generateMerchantBean(merchant);// 会员基本信息
		MercBusiBean mercBusi = generateMercBusiBean(merchant);// 会员营业信息
		MercMcntBean mercMcnt = generateMercMcntBean(merchant);// 联系人信息
		MercFileBean mercFile = generateMercFileBean(merchant);// 会员证件信息
		MercMactBean mercMact = generateMercMactBean(merchant);// 会员结算账户信息
		mercMact.setDeductSign(backupBean.getDeductSign());
		mercMact.setDpsbondSign(backupBean.getDeductSign());
		MercFeeBean mercFee = generateMercFeeBean(merchant);
		if(merchant.getSetlCycle().intValue()==0){//D0商户
			mercFee.setD0FeeRat(backupBean.getD0FeeRat());			//D0交易费率（%）
			mercFee.setD0FixedFee(backupBean.getD0FixedFee());			//D0交易固定手续费（元）
			mercFee.setD0MinFeeAmt(backupBean.getD0MinFeeAmt());			//D0交易最低手续费（元）
			mercFee.setD0MaxFeeAmt(backupBean.getD0MaxFeeAmt());			//D0交易封顶手续费（元） 
		}else{
			mercFee.setD0FeeRat("0");			//D0交易费率（%）
			mercFee.setD0FixedFee("0");			//D0交易固定手续费（元）
			mercFee.setD0MinFeeAmt("0");			//D0交易最低手续费（元）
			mercFee.setD0MaxFeeAmt("0");
		}
		
		
		MerchantBean merchantBean = new MerchantBean(mercInfo, mercBusi, mercMcnt, mercFile, mercMact, mercFee);
		BaseBean baseBean = new BaseBean();
		baseBean.setBody(merchantBean);
		baseBean.setAction(APICodeEnum.MEMBER_ADDANDMODIFY.getCode());
		baseBean.setRequestId(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
		Map<String, Object> newHashMap = Maps.newHashMap();
		Map<String, Object> parseObject1 = JSON.parseObject(JSON.toJSONString(mercInfo), Map.class);
		Map<String, Object> parseObject2 = JSON.parseObject(JSON.toJSONString(mercBusi), Map.class);
		Map<String, Object> parseObject3 = JSON.parseObject(JSON.toJSONString(mercMcnt), Map.class);
		Map<String, Object> parseObject4 = JSON.parseObject(JSON.toJSONString(mercFile), Map.class);
		Map<String, Object> parseObject5 = JSON.parseObject(JSON.toJSONString(mercMact), Map.class);
		Map<String, Object> parseObject6 = JSON.parseObject(JSON.toJSONString(mercFee), Map.class);
		newHashMap.putAll(parseObject1);
		newHashMap.putAll(parseObject2);
		newHashMap.putAll(parseObject3);
		newHashMap.putAll(parseObject4);
		newHashMap.putAll(parseObject5);
		newHashMap.putAll(parseObject6);
		
		MerchantBackupLogDO merchantBackupLog = JSON.parseObject(JSON.toJSONString(newHashMap), MerchantBackupLogDO.class);
		merchantBackupLog.setAction(baseBean.getAction());
		merchantBackupLog.setRequestId(baseBean.getRequestId());
		merchantBackupLog.setTimestamp(baseBean.getTimestamp());
		merchantBackupLogDAO.saveMerchantBackupLog(merchantBackupLog);
		try {
			String returnMsg = HttpPostInvoker.invokeMethod("param="+JSON.toJSONString(baseBean));
			ResponseBean responseBean = JSON.parseObject(returnMsg, ResponseBean.class);
			if("0000".equals(responseBean.getCode())){
				merchantDAO.updateMerchantBackupStatus(merchNo, "00");
			}
			resultBean.setRetCode(responseBean.getCode());
			resultBean.setRetInfo(responseBean.getMessage());
			merchantBackupLogDAO.updateMerchantBackupLog(baseBean.getRequestId(), responseBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultBean;
	}
	@Override
	public ResultBean backupQueryMerchant(String merchNo) {
		ResultBean resultBean = new ResultBean();
		Map<String, Object> msgMap = Maps.newHashMap();
		msgMap.put("mercId", merchNo);
		msgMap.put("orgId", orgId);
		BaseBean baseBean = new BaseBean();
		baseBean.setBody(msgMap);
		baseBean.setAction(APICodeEnum.MEMBER_QUERY.getCode());
		baseBean.setRequestId(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
		MerchantBackupLogDO merchantBackupLog = new MerchantBackupLogDO();
		merchantBackupLog.setAction(baseBean.getAction());
		merchantBackupLog.setRequestId(baseBean.getRequestId());
		merchantBackupLog.setTimestamp(baseBean.getTimestamp());
		merchantBackupLog.setMercId(merchNo);
		merchantBackupLog.setOrgId(orgId);
		merchantBackupLogDAO.saveMerchantBackupLog(merchantBackupLog);
		try {
			String returnMsg = HttpPostInvoker.invokeMethod("param="+JSON.toJSONString(baseBean));
			ResponseBean responseBean = JSON.parseObject(returnMsg, ResponseBean.class);
			if("0000".equals(responseBean.getCode())){
				String merchantId = responseBean.getBody().getMerchantId();
				String status = responseBean.getBody().getStatus();
				merchantDAO.updateMerchantBackup(merchNo, status,merchantId);
				resultBean.setRetInfo("查询成功");
			}else {
				resultBean.setRetInfo("查询失败");
			}
			resultBean.setRetCode(responseBean.getCode());
			
			merchantBackupLogDAO.updateMerchantBackupLog(baseBean.getRequestId(), responseBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultBean;
	}
}
