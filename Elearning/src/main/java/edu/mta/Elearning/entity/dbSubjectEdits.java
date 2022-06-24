package edu.mta.Elearning.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "subjectchapters")
public class dbSubjectEdits extends BaseEntity{
	@Id
	@Column(name = "SubjectId")
	private int SubjectId;
	
	@Column(name = "SubjectName")
	private String SubjectName;
	
	@Column(name = "Description")
	private String Description;
	
	@Column(name = "Status", columnDefinition = "int default 1")
	private int Status;
	
	@Column(name = "SubjectType", columnDefinition = "int default 0")
	private int SubjectType;
	
	@Column(name = "CreationTime")
	private Timestamp CreationTime;
	
	@Column(name = "LastModificationTime")
	private Timestamp LastModificationTime;
	
	@Column(name = "LastPublishDate")
	private Timestamp LastPublishDate;
	
	@OneToMany(mappedBy = "SubjectId", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<DbSubjectChapterEdits> subjectChapter = new ArrayList<DbSubjectChapterEdits>();
	
	@OneToMany(mappedBy = "SubjectId", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<DbSubjectUnitsEdit> subjectUnits = new ArrayList<DbSubjectUnitsEdit>();
	
	@OneToMany(mappedBy = "SubjectId", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<DbSubjectBindEdits> subjectBindEdits = new ArrayList<DbSubjectBindEdits>();

	public int getSubjectId() {
		return SubjectId;
	}

	public void setSubjectId(int subjectId) {
		SubjectId = subjectId;
	}

	public String getSubjectName() {
		return SubjectName;
	}

	public void setSubjectName(String subjectName) {
		SubjectName = subjectName;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

	public int getSubjectType() {
		return SubjectType;
	}

	public void setSubjectType(int subjectType) {
		SubjectType = subjectType;
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

	public Timestamp getLastPublishDate() {
		return LastPublishDate;
	}

	public void setLastPublishDate(Timestamp lastPublishDate) {
		LastPublishDate = lastPublishDate;
	}

	public List<DbSubjectChapterEdits> getSubjectChapter() {
		return subjectChapter;
	}

	public void setSubjectChapter(List<DbSubjectChapterEdits> subjectChapter) {
		this.subjectChapter = subjectChapter;
	}

	public List<DbSubjectUnitsEdit> getSubjectUnits() {
		return subjectUnits;
	}

	public void setSubjectUnits(List<DbSubjectUnitsEdit> subjectUnits) {
		this.subjectUnits = subjectUnits;
	}

	public List<DbSubjectBindEdits> getSubjectBindEdits() {
		return subjectBindEdits;
	}

	public void setSubjectBindEdits(List<DbSubjectBindEdits> subjectBindEdits) {
		this.subjectBindEdits = subjectBindEdits;
	}
	
	

}
