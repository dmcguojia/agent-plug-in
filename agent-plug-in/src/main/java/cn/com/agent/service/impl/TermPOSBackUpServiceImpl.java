package cn.com.agent.service.impl;

import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;

import cn.com.agent.bean.BaseBean;
import cn.com.agent.bean.ResponseBean;
import cn.com.agent.bean.ResultBean;
import cn.com.agent.bean.enums.APICodeEnum;
import cn.com.agent.bean.term.TermBean;
import cn.com.agent.dao.FinaPosDAO;
import cn.com.agent.dao.TermBackupLogDAO;
import cn.com.agent.pojo.FinaPosDO;
import cn.com.agent.pojo.MerchantBackupLogDO;
import cn.com.agent.pojo.MerchantDO;
import cn.com.agent.pojo.TermBackupLogDO;
import cn.com.agent.service.TermPOSBackUpService;
import cn.com.agent.utils.BeanCopyUtil;
import cn.com.agent.utils.HttpPostInvoker;
@Service
public class TermPOSBackUpServiceImpl implements TermPOSBackUpService{
	//代理商编号
	//private final static String orgId="SHANDONG";
	private final static String orgId="4801666000";
	@Autowired
	private FinaPosDAO finaPosDAO;
	@Autowired
	private TermBackupLogDAO termBackupLogDAO;
	@Override
	public ResultBean backupAddTermPOS(String termNo) {
		ResultBean resultBean = new ResultBean();
		FinaPosDO termPOS = finaPosDAO.getFinaPosByTermNo(termNo);
		if(!"01".equals(termPOS.getBackupStatus())){
			resultBean.setRetCode("09");
			resultBean.setRetInfo("终端已经报备");
			return resultBean;
		}
		TermBean termBean = new TermBean();
		termBean.setOrgId(orgId);			//代理商编号
		termBean.setMercId(termPOS.getMerchNo());			//会员号
		termBean.setTrmNo(termNo);			//终端号
		termBean.setTrmSn("SN"+StringUtils.leftPad("1", 14, "0"));			//终端序列号
		termBean.setMfrNo(termPOS.getVicCode());			//厂家编号
		termBean.setModNo(termPOS.getTypeCode());			//型号编号
		termBean.setAppNo("008");			//应用编码
		termBean.setTrmSts("Y");			//设备状态
		termBean.setMacKey(StringUtils.leftPad("3", 32, "0"));			//终端的mac key
		termBean.setPinKey(StringUtils.leftPad("4", 32, "0"));			//终端的pin key
		termBean.setTmKey(StringUtils.leftPad("5", 32, "0"));			//终端的tm key
		//termBean.setMacKey("ase1212331se13212123sfsf");			//终端的mac key
		//termBean.setPinKey("512sfqwes123123");
		//termBean.setTmKey("6365sf123sasf");
		termBean.setTrmProv("");			//终端归属省
		termBean.setTrmCity("");			//终端归属市
		BaseBean baseBean = new BaseBean();
		baseBean.setBody(termBean);
		baseBean.setAction(APICodeEnum.TERM_ADDANDMODIFY.getCode());
		baseBean.setRequestId(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
		
		TermBackupLogDO termBackupLog = BeanCopyUtil.copyBean(TermBackupLogDO.class, termBean);
		termBackupLog.setAction(baseBean.getAction());
		termBackupLog.setRequestId(baseBean.getRequestId());
		termBackupLog.setTimestamp(baseBean.getTimestamp());
		termBackupLogDAO.saveTermBackupLog(termBackupLog);
		
		try {
			String returnMsg = HttpPostInvoker.invokeMethod("param="+JSON.toJSONString(baseBean));
			ResponseBean responseBean = JSON.parseObject(returnMsg, ResponseBean.class);
			resultBean.setRetCode(responseBean.getCode());
			resultBean.setRetInfo(responseBean.getMessage());
			if("0000".equals(responseBean.getCode())){
				finaPosDAO.updateTermBackupStatus(termNo, "00");
			}
			termBackupLogDAO.updateTermBackupLog(baseBean.getRequestId(), responseBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public ResultBean backupUpdateTermPOS(String termNo) {
		ResultBean resultBean = new ResultBean();
		FinaPosDO termPOS = finaPosDAO.getFinaPosByTermNo(termNo);
		if(!"00".equals(termPOS.getBackupStatus())){
			resultBean.setRetCode("09");
			resultBean.setRetInfo("终端未报备");
			return resultBean;
		}
		TermBean termBean = new TermBean();
		termBean.setOrgId(orgId);			//代理商编号
		termBean.setMercId(termPOS.getMerchNo());			//会员号
		termBean.setTrmNo(termNo);			//终端号
		termBean.setTrmSn("SN"+StringUtils.leftPad("1", 14, "0"));			//终端序列号
		termBean.setMfrNo(termPOS.getVicCode());			//厂家编号
		termBean.setModNo(termPOS.getTypeCode());			//型号编号
		termBean.setAppNo("008");			//应用编码
		termBean.setTrmSts("Y");			//设备状态
		termBean.setMacKey(StringUtils.leftPad("3", 32, "0"));			//终端的mac key
		termBean.setPinKey(StringUtils.leftPad("4", 32, "0"));			//终端的pin key
		termBean.setTmKey(StringUtils.leftPad("5", 32, "0"));			//终端的tm key
		//termBean.setMacKey("ase1212331se13212123sfsf");			//终端的mac key
		//termBean.setPinKey("512sfqwes123123");
		//termBean.setTmKey("6365sf123sasf");
		termBean.setTrmProv("");			//终端归属省
		termBean.setTrmCity("");			//终端归属市
		BaseBean baseBean = new BaseBean();
		baseBean.setBody(termBean);
		baseBean.setAction(APICodeEnum.TERM_ADDANDMODIFY.getCode());
		baseBean.setRequestId(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
		
		TermBackupLogDO termBackupLog = BeanCopyUtil.copyBean(TermBackupLogDO.class, termBean);
		termBackupLog.setAction(baseBean.getAction());
		termBackupLog.setRequestId(baseBean.getRequestId());
		termBackupLog.setTimestamp(baseBean.getTimestamp());
		termBackupLogDAO.saveTermBackupLog(termBackupLog);
		
		try {
			String returnMsg = HttpPostInvoker.invokeMethod("param="+JSON.toJSONString(baseBean));
			ResponseBean responseBean = JSON.parseObject(returnMsg, ResponseBean.class);
			resultBean.setRetCode(responseBean.getCode());
			resultBean.setRetInfo(responseBean.getMessage());
			if("0000".equals(responseBean.getCode())){
				finaPosDAO.updateTermBackupStatus(termNo, "00");
			}
			termBackupLogDAO.updateTermBackupLog(baseBean.getRequestId(), responseBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public ResultBean backupDeleteTermPOS(String termNo) {
		ResultBean resultBean = new ResultBean();
		FinaPosDO termPOS = finaPosDAO.getFinaPosByTermNo(termNo);
		if(!"00".equals(termPOS.getBackupStatus())){
			resultBean.setRetCode("09");
			resultBean.setRetInfo("终端未报备");
			return resultBean;
		}
		Map<String, Object> msgMap = Maps.newHashMap();
		msgMap.put("mercId", termPOS.getMerchNo());
		msgMap.put("orgId", orgId);
		msgMap.put("trmNo", termNo);
		BaseBean baseBean = new BaseBean();
		baseBean.setBody(msgMap);
		baseBean.setAction(APICodeEnum.TERM_DELETE.getCode());
		baseBean.setRequestId(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
		TermBackupLogDO termBackupLog = new TermBackupLogDO();
		termBackupLog.setAction(baseBean.getAction());
		termBackupLog.setRequestId(baseBean.getRequestId());
		termBackupLog.setTimestamp(baseBean.getTimestamp());
		termBackupLog.setMercId(termPOS.getMerchNo());
		termBackupLog.setOrgId(orgId);
		termBackupLog.setTrmNo(termNo);
		termBackupLogDAO.saveTermBackupLog(termBackupLog);
		try {
			String returnMsg = HttpPostInvoker.invokeMethod("param="+JSON.toJSONString(baseBean));
			ResponseBean responseBean = JSON.parseObject(returnMsg, ResponseBean.class);
			resultBean.setRetCode(responseBean.getCode());
			resultBean.setRetInfo(responseBean.getMessage());
			if("0000".equals(responseBean.getCode())){
				finaPosDAO.updateTermBackupStatus(termNo, "99");
			}
			termBackupLogDAO.updateTermBackupLog(baseBean.getRequestId(), responseBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultBean;
	}

	public static void main(String[] args) {
		System.out.println(StringUtils.leftPad("0", 32, "0").length());
	}
}
