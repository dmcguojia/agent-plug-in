package cn.com.agent.dao;

import java.util.List;
import java.util.Map;

import cn.com.agent.bean.CardRateBean;
import cn.com.agent.dao.base.BaseDAO;

public interface FeeDAO extends BaseDAO<Object>{

	/**
	 * 
	 * @param variables
	 * @param page
	 * @param rows
	 * @return
	 */
	public Map<String, Object> findNewCardRateByPage(CardRateBean cardRateEntity, String page, String rows);

	/**
	 * 
	 * @param status
	 * @return
	 */
	public List<?> queryBusiPack(String status);

	/**
	 * 
	 * @param feever
	 * @return
	 */
	public List<?> queryFeeCase(String feever);

	/**
	 * 
	 * @param caseid
	 * @return
	 */
	public Map<String, Object> queryOneCardRate(String caseid);

	/**
	 * 
	 * @param feever
	 * @return
	 */
	public Object queryFeeCaseByName(String feever);

	/**
	 * 
	 * @param cardRateEntity
	 * @return
	 */
	public Map<String, Object> addOneCardRate(CardRateBean cardRateEntity);

	/**
	 * 
	 * @param cardrate
	 * @return
	 */
	public Map<String, Object> updateCardRate(CardRateBean cardrate);
}
