package edu.mta.Elearning.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class KCboxDepth implements Serializable {
    private String FolderId;
    private String ParentId;
	public String getFolderId() {
		return FolderId;
	}
	public void setFolderId(String folderId) {
		this.FolderId = folderId;
	}
	public String getParentId() {
		return ParentId;
	}
	public void setParentId(String parentId) {
		ParentId = parentId;
	}
}
