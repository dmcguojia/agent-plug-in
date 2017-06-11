package cn.com.agent.dao;

import java.util.Map;

import cn.com.agent.bean.RateBean;
import cn.com.agent.bean.query.MerchantQueryBean;
import cn.com.agent.dao.base.BaseDAO;
import cn.com.agent.pojo.CityDO;
import cn.com.agent.pojo.MerchantDO;
import cn.com.agent.pojo.ProvinceDO;

public interface MerchantDAO extends BaseDAO<MerchantDO>{

	/**
	 * 报备商户查询（分页）
	 * @param merchantQueryBean
	 * @param page
	 * @param rows
	 * @return
	 */
	public Map<String, Object> queryMerchantByPage(MerchantQueryBean merchantQueryBean,Long page,Long rows);
	
	/**
	 * 通过商户号获取商户
	 * @param merchNo
	 * @return
	 */
	public MerchantDO getMerchanByMerchNo(String merchNo);
	
	/**
	 * 查询银行信息
	 * @param bankNode
	 * @return
	 */
	public Map<String, Object> queryBankInfo(String bankNode);
	
	public ProvinceDO queryProvinceById(long tid);
	public CityDO queryCityById(long tid);
	
	public RateBean getMerchantRate(String busiPackCode);
}
