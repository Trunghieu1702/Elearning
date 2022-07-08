package edu.mta.Elearning.dto;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.springframework.stereotype.Component;

import edu.mta.Elearning.object.Cboxs;

@Component
public class CboxDto {
	
	public static final int BUTTON = -1;
	public static final int FOLDER = 0;
	public static final int FILE = 1;
	private long Folderid; 
	
	private long ParentId ;
	private String FolderName ;
	private UUID UserId ;
	private Timestamp CreationTime ;
	private Timestamp LastModificationTime ;
	private int sort ;
	private int type ;

	private String strCreationTime ;
	private String strLastModificationTime ;
	
	
	public long getFolderid() {
		return Folderid;
	}
	public void setFolderid(long folderid) {
		Folderid = folderid;
	}
	public long getParentId() {
		return ParentId;
	}
	public void setParentId(long parentId) {
		ParentId = parentId;
	}
	public String getFolderName() {
		return FolderName;
	}
	public void setFolderName(String folderName) {
		FolderName = folderName;
	}
	public UUID getUserId() {
		return UserId;
	}
	public void setUserId(UUID userId) {
		UserId = userId;
	}
	public Timestamp getCreationTime() {
		return CreationTime;
	}
	public void setCreationTime(Timestamp creationTime) {
		CreationTime = creationTime;
	}
	public Timestamp getLastModificationTime() {
		return LastModificationTime;
	}
	public void setLastModificationTime(Timestamp lastModificationTime) {
		LastModificationTime = lastModificationTime;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getStrCreationTime() {
		return strCreationTime;
	}
	public void setStrCreationTime(String strCreationTime) {
		this.strCreationTime = strCreationTime;
	}
	public String getStrLastModificationTime() {
		return strLastModificationTime;
	}
	public void setStrLastModificationTime(String strLastModificationTime) {
		this.strLastModificationTime = strLastModificationTime;
	}

	public CboxDto() {}
	public CboxDto(Cboxs cbox,int _sort,int _type) {
		DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("YYYY-MM-dd");
		this.Folderid=cbox.getFolderId();
		this.ParentId =  cbox.getParentId();
		this.FolderName = cbox.getFolderName();
		this.UserId = cbox.getUser_id() ;
		this.CreationTime = cbox.getCreationTime() ;
//		this.LastModificationTime = ;
		this.sort = _sort;
		this.type =_type;

		this.strCreationTime  = cbox.getCreationTime().toLocalDateTime().format(FORMATTER);

	}

}
