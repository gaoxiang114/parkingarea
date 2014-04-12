package com.cyou.library.xh.recommand.service;

import java.util.List;

import com.cyou.library.xh.recommand.domain.Recommand;

/**
 * 
 * @author gaoxiang_nad
 *
 */
public interface RecommandService {
	
	/**
	 * addRecommand:添加推荐书籍
	 * @author gaoxiang_nad
	 * @param  Recommand recommand
	 */
	public abstract void addRecommand(Recommand recommand);
	/**
	 * updateProcedure:修改推荐书籍的信息
	 * @author gaoxiang_nad
	 * @param  Recommand recommand
	 */
	public abstract void updateRecommand(Recommand recommand);
	/**
	 * updateProcedure:修改推荐书籍的状态
	 * @author gaoxiang_nad
	 * @param  int state
	 */
	public abstract void updateProcedure(Integer[] ids,int state);
	
	/**
	 * recommandList:分页查询推荐书籍列表
	 * @author gaoxiang_nad
	 * @param  Recommand recommand
	 * @return List<Recommand> 返回泛型为recommand类型的list
	 */
	public abstract List<Recommand> recommandList(int pageIndex, int pageSize,int recFlag);
	
	/**
	 * getRecommandCount:获取总记录数
	 * @param int state
	 * @return Integer 数据库中的记录数
	 */
	public abstract Integer getRecommandCount(int state);
	
	public abstract Integer getPersonRecommandCount();
	
	public abstract List<Recommand> personRecommandPageList(int pageIndex, int pageSize);
	
	public abstract Recommand getRecommandById(int recId);
	
	public abstract void deleteRecommand(int recId);
	
	public abstract List<Recommand> recommandList(String[] recId);
	
	public abstract List<String> checkBookName(String bookName);
	
	public abstract List<Recommand> recommandList(Integer state);
}
