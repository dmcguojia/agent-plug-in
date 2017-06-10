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

import cn.com.agent.bean.query.MerchantQueryBean;
import cn.com.agent.dao.MerchantDAO;
import cn.com.agent.dao.base.impl.HibernateBaseDAOImpl;
import cn.com.agent.pojo.MerchantDO;

@Repository
public class MerchantDAOImpl extends HibernateBaseDAOImpl<MerchantDO> implements MerchantDAO{

	@Override
	@Transactional(readOnly=true)
	public Map<String, Object> queryMerchantByPage(MerchantQueryBean merchantQueryBean,Long page,Long rows){
		Map<String, Object> returnMap = Maps.newHashMap();
		Criteria criteria2 = getSession().createCriteria(MerchantDO.class);
		Criteria criteria = getSession().createCriteria(MerchantDO.class);
		if(!StringUtils.isEmpty(merchantQueryBean.getMerchNo())){
			criteria.add(Restrictions.eq("merchNo",merchantQueryBean.getMerchNo()));
			criteria2.add(Restrictions.eq("merchNo",merchantQueryBean.getMerchNo()));
		}
		if(!StringUtils.isEmpty(merchantQueryBean.getMerchName())){
			criteria.add(Restrictions.like("merchName", "%"+merchantQueryBean.getMerchName()+"%"));
			criteria2.add(Restrictions.like("merchName", "%"+merchantQueryBean.getMerchName()+"%"));
		}
		criteria.add(Restrictions.eq("status", "00"));
		criteria2.add(Restrictions.eq("status", "00"));
		criteria.setFirstResult((page.intValue() - 1) * rows.intValue());  
	    criteria.setMaxResults(rows.intValue()); 
	    
	    List<?> list = criteria.list();
	    
	    returnMap.put("total",criteria2.setProjection(Projections.rowCount()).uniqueResult());
        returnMap.put("rows", list);
		return returnMap;
	}

	@Override
	@Transactional(readOnly=true)
	public MerchantDO getMerchanByMerchNo(String merchNo) {
		Criteria criteria = getSession().createCriteria(MerchantDO.class);
		criteria.add(Restrictions.eq("merchNo", merchNo));
		return (MerchantDO) criteria.uniqueResult();
	}
}
