package cn.com.agent.dao;

import cn.com.agent.dao.base.BaseDAO;
import cn.com.agent.pojo.UserDO;

public interface UserDAO extends BaseDAO<UserDO>{

	/**
	 * 通过用户ID获取用户信息
	 * @param uid
	 * @return
	 */
	public UserDO getUserById(long uid);
}
