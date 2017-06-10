/* 
 * BaseHibernateImpl.java  
 * 
 * version TODO
 *
 * 2015-6-25 
 * 
 * Copyright (c) 2015,.All rights reserved.
 * 
 */
package cn.com.agent.dao.base.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.service.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import cn.com.agent.dao.base.BaseDAO;

/**
 * hibernate数据库连接实现类，里面有SessionFactory，可以取到Session
 * 
 * @author guojia
 * @version
 * @date 2015-6-25 下午05:28:34
 * @since
 */
@Transactional
@SuppressWarnings("all")
public class HibernateBaseDAOImpl<T> implements BaseDAO<T> {

	private static final Logger log = LoggerFactory.getLogger(HibernateBaseDAOImpl.class);
    @Autowired
    private SessionFactory sessionFactory = null;
    
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    
    @SuppressWarnings("unchecked")
    @Override
    public T merge(T t) {
        return (T) getSession().merge(t.getClass().getSimpleName(), t);
    }
    @Override
    public void saveEntity(T t) {
          getSession().save(t);
    }
    @Override
    public T update(T t) {
        getSession().update(t);
        return t;
    }
    @Override
    public List<Map<String, Object>> executeOracleProcedure(String queryString,String[] columns, Object[] paramaters,String cursor){
        
        List<Map<String, Object>> resultList = null;
        ResultSet rs = null;
        Connection connection = null;
        ConnectionProvider cp = ((SessionFactoryImplementor)this.getSessionFactory()).getConnectionProvider();
        java.sql.CallableStatement proc = null;
        try {
            log.info(""+queryString);
            connection = cp.getConnection();
            proc = connection.prepareCall(queryString); 
            
            for(int i=1;i<=columns.length;i++){
                log.info(columns[i-1]+":"+paramaters[i-1]);
                proc.setObject(columns[i-1], paramaters[i-1]);
            }
            proc.registerOutParameter(cursor, oracle.jdbc.OracleTypes.CURSOR);
            //执行过程
            proc.execute();
            //获得打开的游标（结果集）
            rs = (ResultSet)proc.getObject(cursor);
            
            ResultSetMetaData rsmd = rs.getMetaData();   
            int columnCount = rsmd.getColumnCount(); 
            resultList = new ArrayList<Map<String,Object>>();
            while (rs.next()){ 
                Map<String,Object> value = new HashMap<String, Object>();
                for (int i=1; i<=columnCount; i++){  
                    value.put(rsmd.getColumnName(i), rs.getObject(i));
                }   
                resultList.add(value);
            }
            connection.commit();
            //proc.close();
            if(rs!=null)
            rs.close();
            if(connection!=null)
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                if(proc!=null){
                    proc.close();
                }
                if(rs!=null)
                rs.close(); 
                if(connection!=null)
                connection.close();
                proc=null;
                rs = null;
                connection = null;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        return resultList;

    }
    public Map<String, Object> executePageOracleProcedure(String queryString,String[] columns, Object[] paramaters,String cursorName,String totalName){
        Map<String, Object> returnMap = new HashMap<String, Object>();
        List resultList = null;
        ResultSet rs = null;
        int rets = 0;
        Connection connection = null;
        ConnectionProvider cp = ((SessionFactoryImplementor)this.getSessionFactory()).getConnectionProvider();
        try {
            java.sql.CallableStatement proc = null;
            
            connection = cp.getConnection();
            proc = connection.prepareCall(queryString); 
            
            for(int i=1;i<=columns.length;i++){
                proc.setObject(columns[i-1], paramaters[i-1]);
            }
            
            proc.registerOutParameter(totalName, oracle.jdbc.OracleTypes.NUMBER);
            proc.registerOutParameter(cursorName, oracle.jdbc.OracleTypes.CURSOR);
            //执行过程
            proc.execute();
            
            //获得打开的游标（结果集）
            rets = proc.getInt(totalName);
            rs = (ResultSet)proc.getObject(cursorName);
            ResultSetMetaData rsmd = rs.getMetaData();   
            int columnCount = rsmd.getColumnCount();   
   
            resultList = new ArrayList();
            while (rs.next()){ 
                Map<String,Object> value = new HashMap<String, Object>();
                for (int i=1; i<=columnCount; i++){  
                    value.put(rsmd.getColumnName(i), rs.getObject(i));
                }   
                resultList.add(value);
            }
            
            
            returnMap.put("total", rets);
            returnMap.put("rows", resultList);
            
            if(connection!=null)
            connection.commit();
            if(rs!=null)
            rs.close();  
            proc.close();
            if(connection!=null)
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                if(connection!=null)
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return returnMap;

    }
    public void updateBySQL(String sql, Object[] paramaters) {
        try {
            Session session = getSession();
            SQLQuery query = (SQLQuery) session.createSQLQuery(sql);
            if (null != paramaters) {
                for (int i = 0; i < paramaters.length; i++) {
                    query.setParameter(i, paramaters[i]);
                }
            }
            query.executeUpdate();
        } catch (HibernateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public List<?> queryByHQL(String queryString,Object[] paramaters) {
        List<?> result = null;
        try {
            Query query = getSession().createQuery(
                    queryString);
            if (paramaters != null) {
                for (int i = 0; i < paramaters.length; i++) {
                    query.setParameter(i, paramaters[i]);
                }
            }
            result = query.list();
        } catch (HibernateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return result;
    }
    
    public List<?> queryBySQL(String queryString, String paramaterName,
            Collection<?> paramater) {
        log.info("queryString is " + queryString);
        SQLQuery query = null;
        List<?> resultList = null;
        try {
            Session session = getSession();
            query = (SQLQuery) session.createSQLQuery(queryString).
            setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
            query.setParameterList(paramaterName, paramater);
            resultList = query.list();
             
        } catch (HibernateException e) {
            log.error("sql query error", e);
            throw e;
        }
        return resultList;
    }
    
    public List<?> queryBySQL(String queryString,Object[] paramaters) {
        List<?> resultList = null;
        try {
            Session session = getSession();
            SQLQuery query = (SQLQuery) session
                    .createSQLQuery(queryString).setResultTransformer(
                            Transformers.ALIAS_TO_ENTITY_MAP);
            if (null != paramaters) {
                for (int i = 0; i < paramaters.length; i++) {
                    query.setParameter(i, paramaters[i]);
                }
            }
            resultList = query.list();
        } catch (HibernateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
        return resultList;
    }
    
    public void updateByHQL(String queryString,Object[] paramaters) {
        try {
            Session session = getSession();
            Query query = session.createQuery(queryString);
            if (paramaters != null) {
                for (int i = 0; i < paramaters.length; i++) {
                    query.setParameter(i, paramaters[i]);
                }
            }
            query.executeUpdate();
        } catch (HibernateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
    }
    
    public T querByHQL(String queryString, Object[] paramaters) {
    	
        log.info("queryString is " + queryString);
        T resultList = null;
        try {
            Session session = getSession();
            Query query = session.createQuery(queryString);
//            setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
//            query.setParameterList(paramaterName, paramater);
            resultList = (T) query.uniqueResult();
             
        } catch (HibernateException e) {
            log.error("sql query error", e);
            throw e;
        }
        return resultList;
    }
    
}
