package com.NorrenCloud.CloudPoc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.NorrenCloud.CloudPoc.dao.StudentServiceImpl;
import com.NorrenCloud.CloudPoc.models.ApiResponse;
import com.NorrenCloud.CloudPoc.models.Student;
import com.NorrenCloud.CloudPoc.models.StudentView;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Norren-POC with Oracle Cloud ")
@RestController
public class StudentController {
	@Autowired
	private StudentServiceImpl impl;
	protected ApiResponse apiResponse;	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<ApiResponse> hello(){
		apiResponse=new ApiResponse();
		apiResponse.setResponse("Welcome... ");
		apiResponse.setStatusCode(HttpStatus.OK);
		
		return new ResponseEntity<>(apiResponse,HttpStatus.OK);
	}
	
	@RequestMapping(value="/api/addStudent", method=RequestMethod.POST)
	public ResponseEntity<ApiResponse> addStudent(@RequestBody Student student){
		impl.addStudent(student);
		apiResponse=new ApiResponse();
		apiResponse.setResponse(student);
		apiResponse.setStatusCode(HttpStatus.OK);
		
		return new ResponseEntity<>(apiResponse,HttpStatus.OK);
	}
	
	@RequestMapping(value="/api/updateStudentByID", method=RequestMethod.PUT)
	public ResponseEntity<ApiResponse> updateStudentByID(@RequestParam("id") int id, @RequestBody Student student){
		impl.updateStudentByID(id, student);
		apiResponse=new ApiResponse();
		apiResponse.setResponse("Record has been successfully updated...");
		apiResponse.setStatusCode(HttpStatus.OK);

		return new ResponseEntity<>(apiResponse,HttpStatus.OK);
	}
	
	@RequestMapping(value="/api/getStudents" , method=RequestMethod.GET)
	public ResponseEntity<ApiResponse> getStudents(){
		List<StudentView> list=impl.getStudents();
		apiResponse=new ApiResponse();
		apiResponse.setResponse(list);
		apiResponse.setStatusCode(HttpStatus.OK);
		
		return new ResponseEntity<>(apiResponse,HttpStatus.OK);
	}
	
	@RequestMapping(value="/api/deleteStudentByEmail", method=RequestMethod.DELETE)
	public ResponseEntity<ApiResponse> deleteStudentByEmail(@RequestParam("email") String email) {
		impl.deleteStudentByEmail(email);
		apiResponse=new ApiResponse();
		apiResponse.setResponse("Record has been successfully deleted...");
		apiResponse.setStatusCode(HttpStatus.OK);

		return new ResponseEntity<>(apiResponse,HttpStatus.OK);	
	}
	
	@RequestMapping(value="/api/getStudentByEmail", method=RequestMethod.GET)
	public ResponseEntity<ApiResponse> getStudentByEmail(@RequestParam("email") String email){
		StudentView studentView= impl.getStudentByEmail(email);
		apiResponse=new ApiResponse();
		apiResponse.setResponse(studentView);
		apiResponse.setStatusCode(HttpStatus.OK);

		return new ResponseEntity<>(apiResponse,HttpStatus.OK);
	}
	 
}
