package edu.mta.Elearning.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "logsubjects")
public class DbLogSubjects extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SubjectLogId")
	private int SubjectLogId;
	
	@Column(name = "user_id")
	private int user_id;
	
	@Column(name = "CourseId")
	private int CourseId;
	
	@Column(name = "SubjectId")
	private int SubjectId;
	
	@Column(name = "FirstDate")
	private Timestamp FirstDate;
	
	@Column(name = "LastDate")
	private Timestamp LastDate;
	
	@Column(name = "PassedDate")
	private Timestamp PassedDate;
	
	@Column(name = "StudySec")
	private int StudySec;
	
	@Column(name = "IsFinished")
	private int IsFinished;
	
	@Column(name = "IsPassed")
	private int IsPassed;
	
	@Column(name = "Rate")
	private int Rate;
	
	@Column(name = "AnsweringTimeSec")
	private int AnsweringTimeSec;
	
	@Column(name = "ReadingExplainTimeSec")
	private int ReadingExplainTimeSec;
	
	@Column(name = "CreationTime")
	private Timestamp CreationTime;

	public int getSubjectLogId() {
		return SubjectLogId;
	}

	public void setSubjectLogId(int subjectLogId) {
		SubjectLogId = subjectLogId;
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

	public int getSubjectId() {
		return SubjectId;
	}

	public void setSubjectId(int subjectId) {
		SubjectId = subjectId;
	}

	public Timestamp getFirstDate() {
		return FirstDate;
	}

	public void setFirstDate(Timestamp firstDate) {
		FirstDate = firstDate;
	}

	public Timestamp getLastDate() {
		return LastDate;
	}

	public void setLastDate(Timestamp lastDate) {
		LastDate = lastDate;
	}

	public Timestamp getPassedDate() {
		return PassedDate;
	}

	public void setPassedDate(Timestamp passedDate) {
		PassedDate = passedDate;
	}

	public int getStudySec() {
		return StudySec;
	}

	public void setStudySec(int studySec) {
		StudySec = studySec;
	}

	public int getIsFinished() {
		return IsFinished;
	}

	public void setIsFinished(int isFinished) {
		IsFinished = isFinished;
	}

	public int getIsPassed() {
		return IsPassed;
	}

	public void setIsPassed(int isPassed) {
		IsPassed = isPassed;
	}

	public int getRate() {
		return Rate;
	}

	public void setRate(int rate) {
		Rate = rate;
	}

	public int getAnsweringTimeSec() {
		return AnsweringTimeSec;
	}

	public void setAnsweringTimeSec(int answeringTimeSec) {
		AnsweringTimeSec = answeringTimeSec;
	}

	public int getReadingExplainTimeSec() {
		return ReadingExplainTimeSec;
	}

	public void setReadingExplainTimeSec(int readingExplainTimeSec) {
		ReadingExplainTimeSec = readingExplainTimeSec;
	}

	public Timestamp getCreationTime() {
		return CreationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		CreationTime = creationTime;
	}
	
	
}
