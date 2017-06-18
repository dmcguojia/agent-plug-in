package cn.com.agent.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.com.agent.bean.ResponseBean;
import cn.com.agent.dao.TermBackupLogDAO;
import cn.com.agent.dao.base.impl.HibernateBaseDAOImpl;
import cn.com.agent.pojo.TermBackupLogDO;

@Repository
public class TermBackupLogDAOImpl extends HibernateBaseDAOImpl<TermBackupLogDO> implements TermBackupLogDAO{

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public void saveTermBackupLog(TermBackupLogDO termBackupLogDO){
		saveEntity(termBackupLogDO);
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public void updateTermBackupLog(String requestId,ResponseBean responseBean){
		String hql = "update TermBackupLogDO set responseid = ?,retcode = ?,retinfo = ? where requestId = ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, responseBean.getRequestId());
		query.setParameter(1, responseBean.getCode());
		query.setParameter(2, responseBean.getMessage());
		query.setParameter(3, requestId);
		query.executeUpdate();
	}
}
