package cn.com.agent.dao;

import cn.com.agent.bean.ResponseBean;
import cn.com.agent.dao.base.BaseDAO;
import cn.com.agent.pojo.TermBackupLogDO;

public interface TermBackupLogDAO extends BaseDAO<TermBackupLogDO>{

	/**
	 * 
	 * @param termBackupLogDO
	 */
	public void saveTermBackupLog(TermBackupLogDO termBackupLogDO);

	/**
	 * 
	 * @param requestId
	 * @param responseBean
	 */
	public void updateTermBackupLog(String requestId, ResponseBean responseBean);

}
