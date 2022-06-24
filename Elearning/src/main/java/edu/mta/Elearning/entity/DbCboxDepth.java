package edu.mta.Elearning.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;



@Entity
@IdClass(KCboxDepth.class)
@Table(name = "cboxsdepth")
public class DbCboxDepth extends BaseEntity{

	@Id
	@Column(name = "folderid")
	public int FolderId;
	
	@Id
	@Column(name = "parentid")
	public int ParentId;
	
	@Column(name = "depth")
	public int depth;

	public int getFolderId() {
		return FolderId;
	}

	public void setFolderId(int folderId) {
		FolderId = folderId;
	}

	public int getParentId() {
		return ParentId;
	}

	public void setParentId(int parentId) {
		ParentId = parentId;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
	
}
