package cn.com.agent.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import cn.com.agent.bean.BaseBean;
import cn.com.agent.bean.MerchantBean;
import cn.com.agent.bean.ResponseBean;
import cn.com.agent.bean.ResultBean;
import cn.com.agent.bean.enums.APICodeEnum;
import cn.com.agent.bean.merch.MercBusiBean;
import cn.com.agent.bean.merch.MercFeeBean;
import cn.com.agent.bean.merch.MercFileBean;
import cn.com.agent.bean.merch.MercInfoBean;
import cn.com.agent.bean.merch.MercMactBean;
import cn.com.agent.bean.merch.MercMcntBean;
import cn.com.agent.dao.MerchantDAO;
import cn.com.agent.pojo.MerchantDO;
import cn.com.agent.service.MerchantBackUpService;
import cn.com.agent.utils.HttpPostInvoker;

@Service
public class MerchantBackUpServiceImpl implements MerchantBackUpService{

	@Autowired
	private MerchantDAO merchantDAO;
	
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
		
		return mercInfo;
	}
	private MercBusiBean generateMercBusiBean(MerchantDO merchant){
		MercBusiBean mercBusi = new MercBusiBean();
		
		return mercBusi;
	}
	private MercMcntBean generateMercMcntBean(MerchantDO merchant){
		MercMcntBean mercMcnt = new MercMcntBean();
		
		return mercMcnt;
	}
	private MercFileBean generateMercFileBean(MerchantDO merchant){
		MercFileBean mercFile = new MercFileBean();
		
		return mercFile;
	}
	
	private MercMactBean generateMercMactBean(MerchantDO merchant){
		MercMactBean mercMact = new MercMactBean();
		
		return mercMact;
	}
	private MercFeeBean generateMercFeeBean(MerchantDO merchant){
		MercFeeBean mercFee = new MercFeeBean();
		
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
		System.out.println(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase().length());
	}
}
