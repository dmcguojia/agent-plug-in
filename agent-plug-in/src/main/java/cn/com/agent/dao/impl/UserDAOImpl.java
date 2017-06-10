package cn.com.agent.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.com.agent.dao.UserDAO;
import cn.com.agent.dao.base.impl.HibernateBaseDAOImpl;
import cn.com.agent.pojo.UserDO;
@Repository
public class UserDAOImpl extends HibernateBaseDAOImpl<UserDO> implements UserDAO{

	@Override
	@Transactional(readOnly=true)
	public UserDO getUserById(long uid) {
		Criteria criteria = getSession().createCriteria(UserDO.class);
		criteria.add(Restrictions.eq("userId", uid));
		return (UserDO) criteria.uniqueResult();
	}

}
