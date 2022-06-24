package edu.mta.Elearning.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "logunittestdetails")
public class DbLogUnitTestDetails extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TestLogDetailId")
	private int TestLogDetailId;
	
	@Column(name = "TestLogId")
	private int TestLogId;
	
	@Column(name = "BindId")
	private int BindId;
	
	@Column(name = "ContentId")
	private int ContentId;
	
	@Column(name = "TestOrder")
	private int TestOrder;
	
	@Column(name = "Answer")
	private Timestamp Answer;
	
	@Column(name = "Correct")
	private int Correct;
	
	@Column(name = "IsCorrect")
	private int IsCorrect;
	
	@Column(name = "MaxScore")
	private int MaxScore;
	
	@Column(name = "Score")
	private int Score;
	
	@Column(name = "CreationTime")
	private Timestamp CreationTime;

	public int getTestLogDetailId() {
		return TestLogDetailId;
	}

	public void setTestLogDetailId(int testLogDetailId) {
		TestLogDetailId = testLogDetailId;
	}

	public int getTestLogId() {
		return TestLogId;
	}

	public void setTestLogId(int testLogId) {
		TestLogId = testLogId;
	}

	public int getBindId() {
		return BindId;
	}

	public void setBindId(int bindId) {
		BindId = bindId;
	}

	public int getContentId() {
		return ContentId;
	}

	public void setContentId(int contentId) {
		ContentId = contentId;
	}

	public int getTestOrder() {
		return TestOrder;
	}

	public void setTestOrder(int testOrder) {
		TestOrder = testOrder;
	}

	public Timestamp getAnswer() {
		return Answer;
	}

	public void setAnswer(Timestamp answer) {
		Answer = answer;
	}

	public int getCorrect() {
		return Correct;
	}

	public void setCorrect(int correct) {
		Correct = correct;
	}

	public int getIsCorrect() {
		return IsCorrect;
	}

	public void setIsCorrect(int isCorrect) {
		IsCorrect = isCorrect;
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

	public Timestamp getCreationTime() {
		return CreationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		CreationTime = creationTime;
	}
	
}
