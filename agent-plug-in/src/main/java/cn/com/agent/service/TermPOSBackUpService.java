package cn.com.agent.service;

import cn.com.agent.bean.ResultBean;

public interface TermPOSBackUpService {

	/**
	 * 报备终端（新增）
	 * @param termNo
	 * @return
	 */
	public ResultBean backupAddTermPOS(String termNo);
	/**
	 * 报备终端（更新）
	 * @param termNo
	 * @return
	 */
	public ResultBean backupUpdateTermPOS(String termNo);
	/**
	 * 报备终端（删除）
	 * @param termNo
	 * @return
	 */
	public ResultBean backupDeleteTermPOS(String termNo);
}
