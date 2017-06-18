package cn.com.agent.service;

import cn.com.agent.bean.BackupBean;
import cn.com.agent.bean.ResultBean;

public interface MerchantBackUpService {
	
	/**
	 * 报备商户（新增）
	 * @param merchNo
	 * @return
	 */
	public ResultBean backupAddMerchant(String merchNo);
	/**
	 * 
	 * @param backupBean
	 * @return
	 */
	public ResultBean backupAddMerchant(BackupBean backupBean);
	/**
	 * 报备商户（更新）
	 * @param merchNo
	 * @return
	 */
	public ResultBean backupUpdateMerchant(String merchNo);
	/**
	 * 
	 * @param backupBean
	 * @return
	 */
	public ResultBean backupUpdateMerchant(BackupBean backupBean);
	/**
	 * 报备商户（删除）
	 * @param merchNo
	 * @return
	 */
	public ResultBean backupDeleteMerchant(String merchNo);
}
