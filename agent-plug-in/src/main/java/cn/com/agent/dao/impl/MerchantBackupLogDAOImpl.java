package cn.com.agent.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.com.agent.bean.ResponseBean;
import cn.com.agent.dao.MerchantBackupLogDAO;
import cn.com.agent.dao.base.impl.HibernateBaseDAOImpl;
import cn.com.agent.pojo.MerchantBackupLogDO;

@Repository
public class MerchantBackupLogDAOImpl extends HibernateBaseDAOImpl<MerchantBackupLogDO> implements MerchantBackupLogDAO{

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public void saveMerchantBackupLog(MerchantBackupLogDO merchantBackupLog){
		saveEntity(merchantBackupLog);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public void updateMerchantBackupLog(String requestId,ResponseBean responseBean){
		String hql = "update MerchantBackupLogDO set responseid = ?,retcode = ?,retinfo = ? where requestId = ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, responseBean.getRequestId());
		query.setParameter(1, responseBean.getCode());
		query.setParameter(2, responseBean.getMessage());
		query.setParameter(3, requestId);
		query.executeUpdate();
		if(responseBean.getBody()!=null) {
			updateMerchantBackupLog(requestId,responseBean.getBody().getMerchantId(),responseBean.getBody().getStatus());
		}
	}
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public void updateMerchantBackupLog(String requestId,String merchantId,String status) {
		String hql = "update MerchantBackupLogDO set status = ?,merchantId = ? where requestId = ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, status);
		query.setParameter(1, merchantId);
		query.setParameter(2, requestId);
		query.executeUpdate();
	}
}
