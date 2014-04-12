package com.cyou.library.xh.recommand.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cyou.library.xh.recommand.dao.RecommandDao;
import com.cyou.library.xh.recommand.domain.Recommand;
import com.cyou.library.xh.recommand.service.RecommandService;
@Service("recommandService")
public class RecommandSeviceImpl implements RecommandService {
	@Resource(name="recommandDao")
	private RecommandDao recommandDao;
	
	public void addRecommand(Recommand recommand) {
		this.recommandDao.addRecommand(recommand);
	}
	
	public void updateRecommand(Recommand recommand){
		this.recommandDao.updateRecommand(recommand);
	}
	
	public void updateProcedure(Integer[] ids,int state) {
		this.recommandDao.updateProcedure(ids,state);
	}

	public List<Recommand> recommandList(int pageIndex, int pageSize,int recFlag) {
		return this.recommandDao.recommandList(pageIndex,pageSize,recFlag);
	}

	public Integer getRecommandCount(int state) {
		return this.recommandDao.getRecommandCount(state);
	}

	public Recommand getRecommandById(int recId) {
		return this.recommandDao.getRecommandById(recId);
	}

	public void deleteRecommand(int recId) {
		this.recommandDao.deleteRecommand(recId);
	}

	public List<Recommand> recommandList(String[] recId) {
		return this.recommandDao.recommandList(recId);
	}

	public List<String> checkBookName(String bookName) {
		return this.recommandDao.checkBookName(bookName);
	}

	public Integer getPersonRecommandCount() {
		return this.recommandDao.getPersonRecommandCount();
	}

	public List<Recommand> personRecommandPageList(int pageIndex, int pageSize) {
		return this.recommandDao.personRecommandPageList(pageIndex, pageSize);
	}

	public List<Recommand> recommandList(Integer state) {
		return this.recommandDao.recommandList(state);
	}

}
