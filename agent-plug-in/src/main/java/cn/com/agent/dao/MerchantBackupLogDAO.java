package cn.com.agent.dao;

import cn.com.agent.bean.ResponseBean;
import cn.com.agent.dao.base.BaseDAO;
import cn.com.agent.pojo.MerchantBackupLogDO;

public interface MerchantBackupLogDAO extends BaseDAO<MerchantBackupLogDO>{

	/**
	 * 
	 * @param merchantBackupLog
	 */
	public void saveMerchantBackupLog(MerchantBackupLogDO merchantBackupLog);

	/**
	 * 
	 * @param requestId
	 * @param responseBean
	 */
	public void updateMerchantBackupLog(String requestId, ResponseBean responseBean);
}
