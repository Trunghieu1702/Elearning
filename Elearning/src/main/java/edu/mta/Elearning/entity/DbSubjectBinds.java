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
@Table(name = "subjectbinds")
public class DbSubjectBinds extends BaseEntity{
	@Id
	@Column(name = "BindId")
	private int BindId;
	
	@Column(name = "SubjectId")
	private String SubjectId;
	
	@Column(name = "UnitId")
	private String UnitId;
	
	@Column(name = "GenreNo", columnDefinition = "int default 1")
	private int GenreNo;
	
	@Column(name = "BindNo", columnDefinition = "int default 1")
	private int BindNo;
	
	@Column(name = "ContentId")
	private int ContentId;
	
	@Column(name = "SubContentId")
	private int SubContentId;
	
	@Column(name = "Score")
	private int Score;
	
	@Column(name = "CreationTime")
	private Timestamp CreationTime;
	
	@Column(name = "LastModificationTime")
	private Timestamp LastModificationTime;
	
	@OneToMany(mappedBy = "BindId", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<DbLogUnitTestDetails> logUnitTestDetails = new ArrayList<DbLogUnitTestDetails>();

	public int getBindId() {
		return BindId;
	}

	public void setBindId(int bindId) {
		BindId = bindId;
	}

	public String getSubjectId() {
		return SubjectId;
	}

	public void setSubjectId(String subjectId) {
		SubjectId = subjectId;
	}

	public String getUnitId() {
		return UnitId;
	}

	public void setUnitId(String unitId) {
		UnitId = unitId;
	}

	public int getGenreNo() {
		return GenreNo;
	}

	public void setGenreNo(int genreNo) {
		GenreNo = genreNo;
	}

	public int getBindNo() {
		return BindNo;
	}

	public void setBindNo(int bindNo) {
		BindNo = bindNo;
	}

	public int getContentId() {
		return ContentId;
	}

	public void setContentId(int contentId) {
		ContentId = contentId;
	}

	public int getSubContentId() {
		return SubContentId;
	}

	public void setSubContentId(int subContentId) {
		SubContentId = subContentId;
	}

	public int getScore() {
		return Score;
	}

	public void setScore(int score) {
		Score = score;
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

	public List<DbLogUnitTestDetails> getLogUnitTestDetails() {
		return logUnitTestDetails;
	}

	public void setLogUnitTestDetails(List<DbLogUnitTestDetails> logUnitTestDetails) {
		this.logUnitTestDetails = logUnitTestDetails;
	}
	
	
}
