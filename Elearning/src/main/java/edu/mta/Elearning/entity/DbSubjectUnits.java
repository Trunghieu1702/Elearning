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
@Table(name = "subjectunits")
public class DbSubjectUnits extends BaseEntity{
	
	@Id
	@Column(name = "UnitId")
	private int UnitId;
	
	@Column(name = "SubjectId")
	private int SubjectId;
	
	@Column(name = "ChapterId")
	private int ChapterId;
	
	@Column(name = "UnitNo", columnDefinition = "int default 1")
	private int UnitNo;
	
	@Column(name = "UnitName")
	private int UnitName;
	
	@Column(name = "UnitType", columnDefinition = "int default 1")
	private Timestamp UnitType;
	
	@Column(name = "Description")
	private int ExplainText;
	
	@Column(name = "PreconditionType", columnDefinition = "int default 0")
	private int PreconditionType;
	
	@Column(name = "TimeLimit", columnDefinition = "int default 0")
	private int TimeLimit;
	
	@Column(name = "Random", columnDefinition = "int default 0")
	private int Random;
	
	@Column(name = "BeginText")
	private int BeginText;
	
	@Column(name = "EndText")
	private int EndText;
	
	@Column(name = "CreationTime")
	private Timestamp CreationTime;
	
	@Column(name = "LastModificationTime")
	private Timestamp LastModificationTime;
	
	@Column(name = "LastPublishDate")
	private Timestamp LastPublishDate;
	
	@OneToMany(mappedBy = "UnitId", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<DbLogUnits> logUnits = new ArrayList<DbLogUnits>();
	
	@OneToMany(mappedBy = "UnitId", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<DbLogUnitTests> logUnitTests = new ArrayList<DbLogUnitTests>();
	
	@OneToMany(mappedBy = "UnitId", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<DbSubjectBinds> subjectBinds = new ArrayList<DbSubjectBinds>();

	public int getUnitId() {
		return UnitId;
	}

	public void setUnitId(int unitId) {
		UnitId = unitId;
	}

	public int getSubjectId() {
		return SubjectId;
	}

	public void setSubjectId(int subjectId) {
		SubjectId = subjectId;
	}

	public int getChapterId() {
		return ChapterId;
	}

	public void setChapterId(int chapterId) {
		ChapterId = chapterId;
	}

	public int getUnitNo() {
		return UnitNo;
	}

	public void setUnitNo(int unitNo) {
		UnitNo = unitNo;
	}

	public int getUnitName() {
		return UnitName;
	}

	public void setUnitName(int unitName) {
		UnitName = unitName;
	}

	public Timestamp getUnitType() {
		return UnitType;
	}

	public void setUnitType(Timestamp unitType) {
		UnitType = unitType;
	}

	public int getExplainText() {
		return ExplainText;
	}

	public void setExplainText(int explainText) {
		ExplainText = explainText;
	}

	public int getPreconditionType() {
		return PreconditionType;
	}

	public void setPreconditionType(int preconditionType) {
		PreconditionType = preconditionType;
	}

	public int getTimeLimit() {
		return TimeLimit;
	}

	public void setTimeLimit(int timeLimit) {
		TimeLimit = timeLimit;
	}

	public int getRandom() {
		return Random;
	}

	public void setRandom(int random) {
		Random = random;
	}

	public int getBeginText() {
		return BeginText;
	}

	public void setBeginText(int beginText) {
		BeginText = beginText;
	}

	public int getEndText() {
		return EndText;
	}

	public void setEndText(int endText) {
		EndText = endText;
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

	public List<DbLogUnits> getLogUnits() {
		return logUnits;
	}

	public void setLogUnits(List<DbLogUnits> logUnits) {
		this.logUnits = logUnits;
	}

	public List<DbLogUnitTests> getLogUnitTests() {
		return logUnitTests;
	}

	public void setLogUnitTests(List<DbLogUnitTests> logUnitTests) {
		this.logUnitTests = logUnitTests;
	}

	public List<DbSubjectBinds> getSubjectBinds() {
		return subjectBinds;
	}

	public void setSubjectBinds(List<DbSubjectBinds> subjectBinds) {
		this.subjectBinds = subjectBinds;
	}
	
	
}
