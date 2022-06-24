package edu.mta.Elearning.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
@Table(name = "subjectchapteredits")
public class DbSubjectChapterEdits extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ChapterId")
	private int ChapterId;
	
	@Column(name = "SubjectId")
	private int SubjectId;
	
	@Column(name = "ChapterNo", columnDefinition = "int default 1")
	private int ChapterNo;
	
	@Column(name = "ChapterName")
	private String ChapterName;
	
	@Column(name = "Description")
	private String Description;
	
	@Column(name = "PreconditionType", columnDefinition = "int default 0")
	private int PreconditionType;
	
	@Column(name = "TestPassRate")
	private int TestPassRate;
	
	@Column(name = "TestFinishRate")
	private int TestFinishRate;
	
	@Column(name = "CreationTime")
	private Timestamp CreationTime;
	
	@Column(name = "LastModificationTime")
	private Timestamp LastModificationTime;
	
	@Column(name = "LastPublishDate")
	private Timestamp LastPublishDate;
	
	@OneToMany(mappedBy = "ChapterId", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<DbSubjectUnitsEdit> subjectUnitEdits = new ArrayList<DbSubjectUnitsEdit>();

	public int getChapterId() {
		return ChapterId;
	}

	public void setChapterId(int chapterId) {
		ChapterId = chapterId;
	}

	public int getSubjectId() {
		return SubjectId;
	}

	public void setSubjectId(int subjectId) {
		SubjectId = subjectId;
	}

	public int getChapterNo() {
		return ChapterNo;
	}

	public void setChapterNo(int chapterNo) {
		ChapterNo = chapterNo;
	}

	public String getChapterName() {
		return ChapterName;
	}

	public void setChapterName(String chapterName) {
		ChapterName = chapterName;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public int getPreconditionType() {
		return PreconditionType;
	}

	public void setPreconditionType(int preconditionType) {
		PreconditionType = preconditionType;
	}

	public int getTestPassRate() {
		return TestPassRate;
	}

	public void setTestPassRate(int testPassRate) {
		TestPassRate = testPassRate;
	}

	public int getTestFinishRate() {
		return TestFinishRate;
	}

	public void setTestFinishRate(int testFinishRate) {
		TestFinishRate = testFinishRate;
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

	public List<DbSubjectUnitsEdit> getSubjectUnitEdits() {
		return subjectUnitEdits;
	}

	public void setSubjectUnitEdits(List<DbSubjectUnitsEdit> subjectUnitEdits) {
		this.subjectUnitEdits = subjectUnitEdits;
	}
	
}
