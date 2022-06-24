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
@Table(name = "logunittests")
public class DbLogUnitTests  extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TestLogId")
	private int TestLogId;
	
	@Column(name = "user_id")
	private int user_id;
	
	@Column(name = "CourseId")
	private int CourseId;
	
	@Column(name = "UnitId")
	private int UnitId;
	
	@Column(name = "LogNo")
	private int LogNo;
	
	@Column(name = "StudyDate")
	private Timestamp StudyDate;
	
	@Column(name = "StudySec")
	private int StudySec;
	
	@Column(name = "IsLast")
	private int IsLast;
	
	@Column(name = "MaxScore")
	private int MaxScore;
	
	@Column(name = "Score")
	private int Score;
	
	@Column(name = "IsSuspended")
	private int IsSuspended;
	
	@Column(name = "IsPassed")
	private int RaIsPassedte;
	
	@Column(name = "CreationTime")
	private Timestamp CreationTime;
	
	@OneToMany(mappedBy = "TestLogId", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<DbLogUnitTestDetails> logUnitTestDetailss = new ArrayList<DbLogUnitTestDetails>();

	public int getTestLogId() {
		return TestLogId;
	}

	public void setTestLogId(int testLogId) {
		TestLogId = testLogId;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getCourseId() {
		return CourseId;
	}

	public void setCourseId(int courseId) {
		CourseId = courseId;
	}

	public int getUnitId() {
		return UnitId;
	}

	public void setUnitId(int unitId) {
		UnitId = unitId;
	}

	public int getLogNo() {
		return LogNo;
	}

	public void setLogNo(int logNo) {
		LogNo = logNo;
	}

	public Timestamp getStudyDate() {
		return StudyDate;
	}

	public void setStudyDate(Timestamp studyDate) {
		StudyDate = studyDate;
	}

	public int getStudySec() {
		return StudySec;
	}

	public void setStudySec(int studySec) {
		StudySec = studySec;
	}

	public int getIsLast() {
		return IsLast;
	}

	public void setIsLast(int isLast) {
		IsLast = isLast;
	}

	public int getMaxScore() {
		return MaxScore;
	}

	public void setMaxScore(int maxScore) {
		MaxScore = maxScore;
	}

	public int getScore() {
		return Score;
	}

	public void setScore(int score) {
		Score = score;
	}

	public int getIsSuspended() {
		return IsSuspended;
	}

	public void setIsSuspended(int isSuspended) {
		IsSuspended = isSuspended;
	}

	public int getRaIsPassedte() {
		return RaIsPassedte;
	}

	public void setRaIsPassedte(int raIsPassedte) {
		RaIsPassedte = raIsPassedte;
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
