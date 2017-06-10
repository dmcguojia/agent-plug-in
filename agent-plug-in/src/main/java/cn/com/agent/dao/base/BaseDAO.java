package cn.com.agent.dao.base;

import java.util.List;
import java.util.Map;


/**
 * 
 * 基础数据库连接层DAO
 *
 * @author guojia
 * @version
 * @date 2015-6-26 上午10:09:10
 * @param T
 * @since
 */
public interface BaseDAO<T> {
    /**
     * 更新实体类T后返回持久化的实体类T
     * @param t
     * @return
     */
	public T merge(T t);
	/**
     * 更新实体类T
     * @param t
     * @return
     */
    public T update(T t);
    /**
     * 保存实体类T
     * @param t
     * @return
     */
    public void saveEntity(T t);
    
    /**
     * 执行oracle存储过程
     * @param queryString 存储过程语句
     * @param columns 入参名称数组
     * @param paramaters 入参数值数组
     * @param cursor 输出游标名称
     * @return List结果集
     */
    public List<Map<String, Object>> executeOracleProcedure(String queryString,String[] columns, Object[] paramaters,String cursor);
    
    /**
     * 执行update更新sql
     * @param sql sql语句
     * @param paramaters 参数
     */
    public void updateBySQL(String sql, Object[] paramaters);
    
    /**
     * 执行findall查询
     * @param sql sql语句
     * @param paramaters 参数
     */
//	public List<?> findAll();
    
}
