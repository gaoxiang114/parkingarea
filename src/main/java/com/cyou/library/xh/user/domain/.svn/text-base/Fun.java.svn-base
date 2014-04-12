/**
 * 
 */
package com.cyou.library.xh.user.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author lirenkui
 *
 */
public class Fun implements Serializable{

	private static final long serialVersionUID = 1L;
	private int funId;//功能id 
	private String funName;//功能名称
	private int fatherId;//父级功能id
	private int funSeq;//功能顺序
	private String funUrl;//功能访问地址
	private int funLevel;
	private List<Fun> child;
	private String fatherName;
	private int grandid;
	public Fun() {
	}

	public int getGrandid() {
		return grandid;
	}

	public void setGrandid(int grandid) {
		this.grandid = grandid;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public List<Fun> getChild() {
		return child;
	}

	public void setChild(List<Fun> child) {
		this.child = child;
	}

	public int getFunId() {
		return funId;
	}

	public void setFunId(int funId) {
		this.funId = funId;
	}

	public String getFunName() {
		return funName;
	}

	public void setFunName(String funName) {
		this.funName = funName;
	}

	public int getFatherId() {
		return fatherId;
	}

	public void setFatherId(int fatherId) {
		this.fatherId = fatherId;
	}

	public int getFunSeq() {
		return funSeq;
	}

	public void setFunSeq(int funSeq) {
		this.funSeq = funSeq;
	}

	public String getFunUrl() {
		return funUrl;
	}

	public void setFunUrl(String funUrl) {
		this.funUrl = funUrl;
	}

	public int getFunLevel() {
		return funLevel;
	}

	public void setFunLevel(int funLevel) {
		this.funLevel = funLevel;
	}

	public String toString() {
		return "Fun [funId=" + funId + ", funName=" + funName + ", fatherId="
				+ fatherId + ", funSeq=" + funSeq + ", funUrl=" + funUrl
				+ ", funLevel=" + funLevel + "]";
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fatherId;
		result = prime * result + funId;
		result = prime * result + funLevel;
		result = prime * result + ((funName == null) ? 0 : funName.hashCode());
		result = prime * result + funSeq;
		result = prime * result + ((funUrl == null) ? 0 : funUrl.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fun other = (Fun) obj;
		if (fatherId != other.fatherId)
			return false;
		if (funId != other.funId)
			return false;
		if (funLevel != other.funLevel)
			return false;
		if (funName == null) {
			if (other.funName != null)
				return false;
		} else if (!funName.equals(other.funName))
			return false;
		if (funSeq != other.funSeq)
			return false;
		if (funUrl == null) {
			if (other.funUrl != null)
				return false;
		} else if (!funUrl.equals(other.funUrl))
			return false;
		return true;
	}
	
	
}
