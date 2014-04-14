package com.parkarea.common.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class BaseDao extends SqlSessionDaoSupport {

	/**
	 * @author gaoxiang_nad
	 * add:添加数据带参数
	 * @param method
	 * @param entity
	 * @return
	 */
	protected int add(String method,Object entity){
		return this.getSqlSession().insert(method, entity);
	}
	/**
	 * @author gaoxiang_nad
	 * delete:带参数的删除
	 * @param method
	 * @param entity
	 * @return Integer
	 */
	protected int delete(String method,Object entity){
		return this.getSqlSession().delete(method, entity);
	}

	/**
	 *  @author gaoxiang_nad
	 *  delete:不带参数的删除
	 * @param method
	 * @param entity
	 * @return Integer
	 */
	protected int delete(String method){
		return this.getSqlSession().delete(method);
	}

	/**
	 * @author gaoxiang_nad
	 * update:不带参数的修改方法
	 * @param method
	 * @return
	 */
	protected int update(String method){
		return this.getSqlSession().update(method);
	}
	/**
	 * @author gaoxiang_nad
	 * update:带参数的修改方法
	 * @param method
	 * @param object
	 * @return
	 */
	protected int update(String method,Object object){
		return this.getSqlSession().update(method, object);
	}

	/**
	 * @author gaoxiang_nad
	 * getUniqueOne:获取唯一的记录有参数
	 * @param method
	 * @param object
	 * @return 返回 T 泛型对象
	 */
	@SuppressWarnings("unchecked")
	protected <T> T getUniqueOne(String method,Object object){
		return (T)this.getSqlSession().selectOne(method, object);
	}

	/**
	 * @author gaoxiang_nad
	 * getFirstOne:获取第一条记录
	 * @param method
	 * @param object
	 * @return 返回 T 泛型对象
	 */
	@SuppressWarnings("unchecked")
	protected <T> T getFirstOne(String method,Object object){
		List<T> list = this.getSqlSession().selectList(method, object);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	/**
	 * @author gaoxiang_nad
	 * getUniqueOne 获取唯一记录无参数
	 * @param method
	 * @return 返回T 泛型
	 */
	@SuppressWarnings("unchecked")
	protected <T> T getUniqueOne(String method){
		return (T)this.getSqlSession().selectOne(method);
	}

	/**
	 * @author gaoxiang_nad
	 * getList:获取对象结果集无参数
	 * @param method
	 * @return 返回T泛型的一个结果集 List<T>
	 */
	@SuppressWarnings("unchecked")
	protected <T> List<T> getList(String method){
		return (List<T>)this.getSqlSession().selectList(method);
	}

	/**
	 * @author gaoxiang_nad
	 * getList:获取对象结果集有参数
	 * @param method
	 * @param object
	 * @return 返回T泛型的一个结果集List<T>
	 */
	@SuppressWarnings("unchecked")
	protected <T> List<T> getList(String method,Object object){
		return (List<T>)this.getSqlSession().selectList(method,object);
	}

	/**
	 * @author gaoxiang_nad
	 * getCount:获取数据记录数无条件
	 * @param method
	 * @return
	 */
	protected Integer getCount(String method){
		return (Integer)this.getSqlSession().selectOne(method);
	}

	/**
	 * @author gaoxiang_nad
	 * getCount:获取数据记录有参数
	 * @param method
	 * @param object
	 * @return Integer
	 */
	protected Integer getCount(String method ,Object object){
		return (Integer)this.getSqlSession().selectOne(method,object);
	}
}
