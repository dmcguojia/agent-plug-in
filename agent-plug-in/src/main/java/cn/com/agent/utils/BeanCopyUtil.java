/* 
 * BeanCopyer.java  
 * 
 * version TODO
 *
 * 2015-7-13 
 * 
 * Copyright (c) 2015,zlebank.All rights reserved.
 * 
 */
package cn.com.agent.utils;

import net.sf.cglib.beans.BeanCopier;

/**
 * Bean copier
 * 
 * @author yangying
 * @version
 * @date 2015-7-13 下午04:57:23
 * @since
 */
public class BeanCopyUtil  {

	
    @SuppressWarnings("unchecked")
    public static <T> T copyBean(T t) {
        BeanCopier beanCopier = BeanCopier.create(t.getClass(), t.getClass(),
                false);

        T copy = null;
        try {
            copy = (T) t.getClass().newInstance();
        } catch (InstantiationException e) {
            RuntimeException re = new RuntimeException();
            re.initCause(e); 
            throw re;
        } catch (IllegalAccessException e) {
            RuntimeException re = new RuntimeException();
            re.initCause(e); 
            throw re;
        }
        beanCopier.copy(t, copy, null);
        return copy;
    }

    public static <T> T copyBean(Class<T> targetClass,Object source) {
        BeanCopier beanCopier = BeanCopier.create(source.getClass(), targetClass,
                false);

        T copy = null;
        try {
            copy = targetClass.newInstance();
        } catch (InstantiationException e) {
            RuntimeException re = new RuntimeException();
            re.initCause(e); 
            throw re;
        } catch (IllegalAccessException e) {
            RuntimeException re = new RuntimeException();
            re.initCause(e); 
            throw re;
        }
        beanCopier.copy(source, copy, null);
        return copy;
    }
}
