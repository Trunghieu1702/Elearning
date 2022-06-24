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
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "Courses", uniqueConstraints = { //
		@UniqueConstraint(name = "course_uk_1", columnNames = "CourseCode")})
public class DbCourses {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CourseId")
	private int CourseId;
	
	@Column(name = "CourseCode")
	private String CourseCode;
	
	@Column(name = "CourseName")
	private String CourseName;
	
	@Column(name = "CourseType", columnDefinition = "int default 1")
	private String CourseType;
	
	@Column(name = "CourseImage")
	private String CourseImage;
	
	@Column(name = "Description")
	private String Description;
	
	@Column(name = "Status", columnDefinition = "int default 1")
	private int Status;
	
	@Column(name = "Price", columnDefinition = "int default 0")
	private int Price;
	
	@Column(name = "CreationTime")
	private Timestamp CreationTime;
	
	@Column(name = "LastModificationTime")
	private Timestamp LastModificationTime;
	
	@OneToMany(mappedBy = "CourseId", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<DbLogSubjects> LogSubjects = new ArrayList<DbLogSubjects>();
	
	@OneToMany(mappedBy = "CourseId", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<DbLogChapters> logChapters = new ArrayList<DbLogChapters>();
	
	@OneToMany(mappedBy = "CourseId", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<DbLogUnits> logUnits = new ArrayList<DbLogUnits>();
	
	@OneToMany(mappedBy = "CourseId", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<DbLogUnitTests> logUnitTests = new ArrayList<DbLogUnitTests>();
	
	@OneToMany(mappedBy = "CourseId", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<DbCourseSubjects> courseSubjects = new ArrayList<DbCourseSubjects>();

	public int getCourseId() {
		return CourseId;
	}

	public void setCourseId(int courseId) {
		CourseId = courseId;
	}

	public String getCourseCode() {
		return CourseCode;
	}

	public void setCourseCode(String courseCode) {
		CourseCode = courseCode;
	}

	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String courseName) {
		CourseName = courseName;
	}

	public String getCourseType() {
		return CourseType;
	}

	public void setCourseType(String courseType) {
		CourseType = courseType;
	}

	public String getCourseImage() {
		return CourseImage;
	}

	public void setCourseImage(String courseImage) {
		CourseImage = courseImage;
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

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
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

	public List<DbLogSubjects> getLogSubjects() {
		return LogSubjects;
	}

	public void setLogSubjects(List<DbLogSubjects> logSubjects) {
		LogSubjects = logSubjects;
	}

	public List<DbLogChapters> getLogChapters() {
		return logChapters;
	}

	public void setLogChapters(List<DbLogChapters> logChapters) {
		this.logChapters = logChapters;
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

	public List<DbCourseSubjects> getCourseSubjects() {
		return courseSubjects;
	}

	public void setCourseSubjects(List<DbCourseSubjects> courseSubjects) {
		this.courseSubjects = courseSubjects;
	}

}
