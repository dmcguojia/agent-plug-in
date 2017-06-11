package cn.com.agent.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import cn.com.agent.bean.BaseBean;
import cn.com.agent.bean.ResponseBean;
import cn.com.agent.bean.ResultBean;
import cn.com.agent.bean.enums.APICodeEnum;
import cn.com.agent.bean.term.TermBean;
import cn.com.agent.dao.FinaPosDAO;
import cn.com.agent.pojo.FinaPosDO;
import cn.com.agent.service.TermPOSBackUpService;
import cn.com.agent.utils.HttpPostInvoker;
@Service
public class TermPOSBackUpServiceImpl implements TermPOSBackUpService{
	//代理商编号
	private final static String orgId="SHANDONG";
	@Autowired
	private FinaPosDAO finaPosDAO;
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
		termBean.setTrmSn("");			//终端序列号
		termBean.setMfrNo(termPOS.getVicCode());			//厂家编号
		termBean.setModNo(termPOS.getTypeCode());			//型号编号
		termBean.setAppNo("");			//应用编码
		termBean.setTrmSts("Y");			//设备状态
		termBean.setMacKey("");			//终端的mac key
		termBean.setPinKey("");			//终端的pin key
		termBean.setTmKey("");			//终端的tm key
		termBean.setTrmProv("");			//终端归属省
		termBean.setTrmCity("");			//终端归属市
		BaseBean baseBean = new BaseBean();
		baseBean.setBody(termBean);
		baseBean.setAction(APICodeEnum.TERM_ADDANDMODIFY.getCode());
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

	@Override
	public ResultBean backupUpdateTermPOS(String termNo) {
		
		return null;
	}

	@Override
	public ResultBean backupDeleteTermPOS(String termNo) {
		
		return null;
	}

}
