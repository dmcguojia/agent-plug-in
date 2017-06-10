package cn.com.agent.dao;

import java.util.Map;

import cn.com.agent.bean.query.TermQueryBean;
import cn.com.agent.dao.base.BaseDAO;
import cn.com.agent.pojo.FinaPosDO;

public interface FinaPosDAO extends BaseDAO<FinaPosDO>{

	/**
	 * 获取终端信息
	 * @param termNo
	 * @return
	 */
	public FinaPosDO getFinaPosByTermNo(String termNo);
	
	/**
	 * 分页查询终端信息
	 * @param termQueryBean
	 * @param page
	 * @param rows
	 * @return
	 */
	public Map<String, Object> queryTermByPage(TermQueryBean termQueryBean,int page,int rows);
}
