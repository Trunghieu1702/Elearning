package edu.mta.Elearning.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "coursesubjects")
public class DbCourseSubjects extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "CourseId")
	private int CourseId;
	
	@Column(name = "SubjectId")
	private String SubjectId;
	
	@Column(name = "OrderNo")
	private String OrderNo;
	
	@Column(name = "PreconditionType", columnDefinition = "int default 1")
	private String PreconditionType;
	
	@Column(name = "CreationTime")
	private Timestamp CreationTime;
	
	@Column(name = "LastModificationTime")
	private Timestamp LastModificationTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCourseId() {
		return CourseId;
	}

	public void setCourseId(int courseId) {
		CourseId = courseId;
	}

	public String getSubjectId() {
		return SubjectId;
	}

	public void setSubjectId(String subjectId) {
		SubjectId = subjectId;
	}

	public String getOrderNo() {
		return OrderNo;
	}

	public void setOrderNo(String orderNo) {
		OrderNo = orderNo;
	}

	public String getPreconditionType() {
		return PreconditionType;
	}

	public void setPreconditionType(String preconditionType) {
		PreconditionType = preconditionType;
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
}
