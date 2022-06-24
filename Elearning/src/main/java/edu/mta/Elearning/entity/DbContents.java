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

@Entity
@Table(name = "contents")
public class DbContents {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ContentId")
	private int ContentId;
	@Column(name = "ContentType")
	private int ContentType;
	@Column(name = "ContentName")
	private String ContentName;
	@Column(name = "FolderId")
	private int FolderId;
	@Column(name = "user_id")
	private UUID user_id;
	@Column(name = "Description")
	private String Description;
	@Column(name = "MediaUrl")
	private String MediaUrl;
	@Column(name = "CreationTime")
	private Timestamp CreationTime;
	
	@OneToMany(mappedBy = "ContentId", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<DbLogUnitTestDetails> logUnitTestDetailss = new ArrayList<DbLogUnitTestDetails>();
	
	@OneToMany(mappedBy = "ContentId", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<DbSubjectBindEdits> subjectBindEdits = new ArrayList<DbSubjectBindEdits>();
	
	@OneToMany(mappedBy = "ContentId", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<DbSubjectBindEdits> subSubjectBindEdits = new ArrayList<DbSubjectBindEdits>();
	
	@OneToMany(mappedBy = "ContentId", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<DbSubjectBinds> subjectBinds = new ArrayList<DbSubjectBinds>();
	
	@OneToMany(mappedBy = "ContentId", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<DbSubjectBinds> subSubjectBinds = new ArrayList<DbSubjectBinds>();
	
	public int getContentId() {
		return ContentId;
	}
	public void setContentId(int contentId) {
		ContentId = contentId;
	}
	public int getContentType() {
		return ContentType;
	}
	public void setContentType(int contentType) {
		ContentType = contentType;
	}
	public String getContentName() {
		return ContentName;
	}
	public void setContentName(String contentName) {
		ContentName = contentName;
	}
	public int getFolderId() {
		return FolderId;
	}
	public void setFolderId(int folderId) {
		FolderId = folderId;
	}
	public UUID getUser_id() {
		return user_id;
	}
	public void setUser_id(UUID user_id) {
		this.user_id = user_id;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getMediaUrl() {
		return MediaUrl;
	}
	public void setMediaUrl(String mediaUrl) {
		MediaUrl = mediaUrl;
	}
	public Timestamp getCreationTime() {
		return CreationTime;
	}
	public void setCreationTime(Timestamp creationTime) {
		CreationTime = creationTime;
	}
	public List<DbLogUnitTestDetails> getLogUnitTestDetailss() {
		return logUnitTestDetailss;
	}
	public void setLogUnitTestDetailss(List<DbLogUnitTestDetails> logUnitTestDetailss) {
		this.logUnitTestDetailss = logUnitTestDetailss;
	}
	
}
