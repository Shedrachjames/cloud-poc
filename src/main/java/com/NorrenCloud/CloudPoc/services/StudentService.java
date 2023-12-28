package com.NorrenCloud.CloudPoc.services;

import java.util.*;

import org.springframework.stereotype.Repository;

import com.NorrenCloud.CloudPoc.models.Student;
import com.NorrenCloud.CloudPoc.models.StudentView;

@Repository
public interface StudentService {
	void updateStudentByID(int id, Student s);
	List<StudentView> getStudents();
	void deleteStudentByEmail(String email);
	StudentView getStudentByEmail(String email);
	void addStudent(Student s);
}
