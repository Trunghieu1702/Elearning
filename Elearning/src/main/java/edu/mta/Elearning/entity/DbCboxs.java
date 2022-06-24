package edu.mta.Elearning.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "cboxs")
public class DbCboxs extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FolderId")
	private int FolderId;
	
	@Column(name = "ParentId")
	private int ParentId;
	
	@Column(name = "FolderName")
	private String FolderName;
	
	@Column(name = "user_id",columnDefinition = "VARCHAR(255)")
	@Type(type="org.hibernate.type.UUIDCharType")
	private UUID user_id;
	
	@OneToMany(mappedBy = "FolderId", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<DbContents> contents = new ArrayList<DbContents>();
	
	@Column(name = "CreationTime")
	private Timestamp CreationTime;
	public int getFolderId() {
		return FolderId;
	}
	public void setFolderId(int folderId) {
		this.FolderId = folderId;
	}
	public int getParentId() {
		return ParentId;
	}
	public void setParentId(int parentId) {
		this.ParentId = parentId;
	}
	public String getFolderName() {
		return FolderName;
	}
	public void setFolderName(String folderName) {
		this.FolderName = folderName;
	}
	
	public Timestamp getCreationTime() {
		return CreationTime;
	}
	public void setCreationTime(Timestamp creationTime) {
		this.CreationTime = creationTime;
	}
	public UUID getUser_id() {
		return user_id;
	}
	public void setUser_id(UUID user_id) {
		this.user_id = user_id;
	}

	
}
