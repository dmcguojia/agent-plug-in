package cn.com.agent.service;

import cn.com.agent.bean.ResultBean;

public interface MerchantBackUpService {
	
	/**
	 * 报备商户（新增）
	 * @param merchNo
	 * @return
	 */
	public ResultBean backupAddMerchant(String merchNo);
	/**
	 * 报备商户（更新）
	 * @param merchNo
	 * @return
	 */
	public ResultBean backupUpdateMerchant(String merchNo);
	/**
	 * 报备商户（删除）
	 * @param merchNo
	 * @return
	 */
	public ResultBean backupDeleteMerchant(String merchNo);
}
