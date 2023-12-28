package com.NorrenCloud.CloudPoc.models;

public class StudentView {
	private int id;
	private Student student;

	public StudentView() {
		super();
	}

	public StudentView(int id, Student student) {
		super();
		this.id = id;
		this.student = student;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "StudentView [id=" + id + ", student=" + student + "]";
	}

}
