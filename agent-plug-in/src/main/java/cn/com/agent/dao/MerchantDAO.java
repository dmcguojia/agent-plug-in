package cn.com.agent.dao;

import java.util.Map;

import cn.com.agent.bean.query.MerchantQueryBean;
import cn.com.agent.dao.base.BaseDAO;
import cn.com.agent.pojo.MerchantDO;

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
}
