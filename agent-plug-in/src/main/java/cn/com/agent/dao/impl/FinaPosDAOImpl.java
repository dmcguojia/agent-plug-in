package cn.com.agent.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.google.common.collect.Maps;

import cn.com.agent.bean.query.TermQueryBean;
import cn.com.agent.dao.FinaPosDAO;
import cn.com.agent.dao.base.impl.HibernateBaseDAOImpl;
import cn.com.agent.pojo.FinaPosDO;
import cn.com.agent.pojo.MerchantDO;

@Repository
public class FinaPosDAOImpl extends HibernateBaseDAOImpl<FinaPosDO> implements FinaPosDAO{

	@Override
	@Transactional(readOnly=true)
	public FinaPosDO getFinaPosByTermNo(String termNo) {
		Criteria criteria = getSession().createCriteria(FinaPosDO.class);
		criteria.setFetchMode("merchant", org.hibernate.FetchMode.JOIN);
		return (FinaPosDO) criteria.uniqueResult();
	}

	@Override
	@Transactional(readOnly=true)
	public Map<String, Object> queryTermByPage(TermQueryBean termQueryBean,
			int page, int rows) {
		Map<String, Object> returnMap = Maps.newHashMap();
		Criteria criteria2 = getSession().createCriteria(FinaPosDO.class);
		Criteria criteria = getSession().createCriteria(FinaPosDO.class);
		if(!StringUtils.isEmpty(termQueryBean.getMerchNO())){
			criteria.add(Restrictions.eq("merchNo",termQueryBean.getMerchNO()));
			criteria2.add(Restrictions.eq("merchNo",termQueryBean.getMerchNO()));
		}
		if(!StringUtils.isEmpty(termQueryBean.getTermNo())){
			criteria.add(Restrictions.eq("merchName", termQueryBean.getTermNo()));
			criteria2.add(Restrictions.like("merchName", termQueryBean.getTermNo()));
		}
		criteria.add(Restrictions.eq("status", "00"));
		criteria2.add(Restrictions.eq("status", "00"));
		criteria.setFirstResult((page - 1) * rows);  
	    criteria.setMaxResults(rows); 
	    
	    List<?> list = criteria.list();
	    
	    returnMap.put("total",criteria2.setProjection(Projections.rowCount()).uniqueResult());
        returnMap.put("rows", list);
		return returnMap;
	}

}
