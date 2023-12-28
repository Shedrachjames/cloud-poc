package com.NorrenCloud.CloudPoc.dao;

//import oracle.jdbc.*;
//import oracle.ucp.jdbc.PoolDataSource;
//import oracle.ucp.jdbc.PoolDataSourceFactory;

//import oracle.ucp.jdbc.*;
import java.sql.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.NorrenCloud.CloudPoc.models.DataRules;
import com.NorrenCloud.CloudPoc.models.Student;
import com.NorrenCloud.CloudPoc.models.StudentView;
import com.NorrenCloud.CloudPoc.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// insert record
	public void addStudent(Student s) {

		String sql = "insert into students(first_name,last_name,department,birth_date,email,address)"
				+ " values(?,?,?,?,?,?)";

		jdbcTemplate.update(sql, DataRules.firstOrMiddleNameRule(s.getFirstname()),
				DataRules.lastNameRule(s.getLastname()), DataRules.othersRule(s.getDepartment()),
				s.getBirthDate(), DataRules.emailRule(s.getEmail()), DataRules.emailRule(s.getAddress()));
	}

	// update record by ID
	@Override
	public void updateStudentByID(int id, Student s) {
		String sql = "update students "
				+ "set first_name=?, last_name=?, department=?,birth_Date=?, email=?,  address=?  " + " where id=?";
		jdbcTemplate.update(sql, DataRules.firstOrMiddleNameRule(s.getFirstname()),
				DataRules.lastNameRule(s.getLastname()), DataRules.othersRule(s.getDepartment()), s.getBirthDate(),
				DataRules.emailRule(s.getEmail()), DataRules.othersRule(s.getAddress()), id);

	}

	// obtain all records
	@Override
	public List<StudentView> getStudents() {
		String sql = "select id,first_name,last_name,department,birth_date,email,address from students";

		return jdbcTemplate.query(sql, new RowMapper<StudentView>() {

			@Override
			public StudentView mapRow(ResultSet result, int i) throws SQLException {
				// TODO Auto-generated method stub
				StudentView stv = new StudentView();
				Student student = new Student();

				int id = result.getInt(1);
				String firstname = result.getString(2);
				String lastname = result.getString(3);
				String department = result.getString(4);
				Date birthDate = result.getDate(5);
				String email = result.getString(6);
				String address = result.getString(7);

				student.setFirstname(firstname);
				student.setLastname(lastname);
				student.setDepartment(department);
				student.setBirthDate(birthDate);
				student.setEmail(email);
				student.setAddress(address);

				stv.setId(id);
				stv.setStudent(student);

				return stv;
			}

		});

	}

	// deletion of record
	@Override
	public void deleteStudentByEmail(String email) {
		String sql = "delete from students " + "where email=?";
		jdbcTemplate.update(sql, DataRules.emailRule(email));

	}

	// obtain a record
	@Override
	public StudentView getStudentByEmail(String email) {
		String sql = "select id,first_name,last_name,department,birth_date,email,address from students "
				+ "where email= ?"; // + DataRules.emailRule(email);
		;

		StudentView studentView = jdbcTemplate.queryForObject(sql, new RowMapper<StudentView>() {

			@Override
			public StudentView mapRow(ResultSet result, int i) throws SQLException {
				// TODO Auto-generated method stub
				StudentView stv = new StudentView();
				Student student = new Student();

				int id = result.getInt(1);
				String firstname = result.getString(2);
				String lastname = result.getString(3);
				String department = result.getString(4);
				Date birthDate = result.getDate(5);
				String email = result.getString(6);
				String address = result.getString(7);

				student.setFirstname(firstname);
				student.setLastname(lastname);
				student.setDepartment(department);
				student.setBirthDate(birthDate);
				student.setEmail(email);
				student.setAddress(address);

				stv.setId(id);
				stv.setStudent(student);

				return stv;
			}

		},DataRules.emailRule(email));
		return studentView;
	}

}
