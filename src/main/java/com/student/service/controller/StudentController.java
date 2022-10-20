package com.student.service.controller;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.service.request.StudentRequest;
import com.student.service.response.ApiEntity;
import com.student.service.response.ApiResponseObject;
import com.student.service.response.StudentResponse;
import com.student.service.service.StudentService;
import com.student.service.util.StudentServiceConstant;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@Slf4j
@Tag(name = "Student Controller")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Operation(summary = "createStudent")
	@PostMapping(path = "/student", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ApiResponseObject> createStudent(
			@Parameter(name = "in_StudentRequest", description = "StudentRequest", required = true) @RequestBody StudentRequest studentRequest) {
		HttpStatus status = null;
		HttpHeaders httpHeaders = new HttpHeaders();
		String message = null;
		String response = null;
		log.info("########## Hitting /student API in Controller Layer. :: in_StudentRequest = {} ##########",
				studentRequest);
		try {
			response = studentService.createStudent(studentRequest);
			if (response.equals(StudentServiceConstant.SUCCESS_MSG)) {
				message = StudentServiceConstant.CREATED_MSG;
				status = HttpStatus.CREATED;
			} else {
				message = "Sorry ! An Error Occured While Saving the Resource";
				status = HttpStatus.BAD_REQUEST;
			}
		} catch (Exception e) {
			log.info("############# Exception Occured in /student API in Controller Layer. ##########", e);
			message = e.getMessage();
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<>(new ApiEntity<>(message, response), httpHeaders, status);
	}

	@Operation(summary = "getAllStudents")
	@GetMapping(path = "/student", produces = "application/json")
	public ResponseEntity<ApiResponseObject> getAllStudents() {
		HttpStatus status = null;
		HttpHeaders httpHeaders = new HttpHeaders();
		String message = null;
		List<StudentResponse> response = null;
		log.info("########## Hitting /student API in Controller Layer. ##########");
		try {
			response = studentService.getAllStudents();
			if (CollectionUtils.isNotEmpty(response)) {
				message = StudentServiceConstant.DATA_FOUND;
				status = HttpStatus.OK;
			} else {
				message = StudentServiceConstant.DATA_NOT_FOUND;
				status = HttpStatus.NOT_FOUND;
			}
		} catch (Exception e) {
			log.info("############# Exception Occured in /student API in Controller Layer. ##########", e);
			message = e.getMessage();
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<>(new ApiEntity<>(message, response), httpHeaders, status);
	}

	@Operation(summary = "getStudentByStudentId")
	@GetMapping(path = "/student/{student_id}", produces = "application/json")
	public ResponseEntity<ApiResponseObject> getStudentByStudentId(
			@Parameter(description = "Long", required = true) @PathVariable(name = "student_id", required = true) long studentId) {
		HttpStatus status = null;
		HttpHeaders httpHeaders = new HttpHeaders();
		String message = null;
		StudentResponse response = null;
		log.info(
				"########## Hitting /student/{student_id} API in Controller Layer. :: Input Parameter :: studentId = {} ##########"
						+ studentId);
		try {
			response = studentService.getStudentByStudentId(studentId);
			if (response != null) {
				status = HttpStatus.OK;
				message = StudentServiceConstant.DATA_FOUND;
			} else {
				status = HttpStatus.NOT_FOUND;
				message = StudentServiceConstant.DATA_NOT_FOUND;
			}
		} catch (Exception e) {
			log.info("########## Exception Occured in /student/{roll_no} API in Controller Layer. ########## ", e);
			message = e.getMessage();
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<>(new ApiEntity<>(message, response), httpHeaders, status);
	}

	@Operation(summary = "updateStudentByStudentId")
	@PutMapping(path = "/student/{student_id}")
	public ResponseEntity<ApiResponseObject> updateStudentByStudentId(
			@Parameter(description = "Long", required = true) @PathVariable(name = "student_id", required = true) long studentId,
			@Parameter(name = "in_StudentRequest", description = "StudentRequest", required = true) @RequestBody(required = true) StudentRequest studentRequest) {
		HttpStatus status = null;
		HttpHeaders httpHeaders = new HttpHeaders();
		String message = null;
		String response = null;
		log.info(
				"########## Hitting /student/{student_id} API in Controller Layer. :: Input Parameter :: studentId = {} , in_StudentRequest = {} ##########",
				studentId, studentRequest);
		try {
			response = studentService.updateStudentByStudentId(studentId, studentRequest);
			if (response.equals(StudentServiceConstant.SUCCESS_MSG)) {
				status = HttpStatus.OK;
				message = StudentServiceConstant.UPDATED_MSG;
			} else if (response.equals(StudentServiceConstant.NOT_PRESENT)) {
				status = HttpStatus.NOT_FOUND;
				message = StudentServiceConstant.RESOURCE_NOT_PRESENT;
			}
		} catch (Exception e) {
			log.info("########## Exception Occured in /student/{student_id} API in Controller Layer. ########## ", e);
			message = e.getMessage();
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<>(new ApiEntity<>(message, response), httpHeaders, status);

	}

	@Operation(summary = "deleteStudentByStudentId")
	@DeleteMapping(path = "/student/{student_id}")
	public ResponseEntity<ApiResponseObject> deleteStudentByStudentId(
			@Parameter(description = "Long", required = true) @PathVariable(name = "student_id", required = true) long studentId) {
		HttpStatus status = null;
		HttpHeaders httpHeaders = new HttpHeaders();
		String message = null;
		String response = null;
		log.info(
				"########## Hitting /student/{student_id} API in Controller Layer. :: Input Parameter :: studentId = {} ##########"
						+ studentId);
		try {
			response = studentService.deleteStudentByStudentId(studentId);
			if (response.equals(StudentServiceConstant.SUCCESS_MSG)) {
				status = HttpStatus.OK;
				message = StudentServiceConstant.DELETED_MSG;
			} else if (response.equals(StudentServiceConstant.NOT_PRESENT)) {
				status = HttpStatus.NOT_FOUND;
				message = StudentServiceConstant.RESOURCE_NOT_PRESENT;
			}
		} catch (Exception e) {
			log.info("########## Exception Occured in /student/{student_id} API in Controller Layer. ########## ", e);
			message = e.getMessage();
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(new ApiEntity<>(message, response), httpHeaders, status);
	}

	@Operation(summary = "deleteAllStudentDetails")
	@DeleteMapping(path = "/student")
	public ResponseEntity<ApiResponseObject> deleteAllStudent() {
		HttpStatus status = null;
		HttpHeaders httpHeaders = new HttpHeaders();
		String message = null;
		String response = null;
		log.info("########## Hitting /student API in Controller Layer. ##########");
		try {
			response = studentService.deleteAllStudents();
			if (response.equals(StudentServiceConstant.SUCCESS_MSG)) {
				status = HttpStatus.OK;
				message = StudentServiceConstant.DELETED_MSG;
			} else if (response.equals(StudentServiceConstant.NOT_PRESENT)) {
				status = HttpStatus.NOT_FOUND;
				message = StudentServiceConstant.RESOURCE_NOT_PRESENT;
			}
		} catch (Exception e) {
			log.info("########## Exception Occured in /student API in Controller Layer. ########## " + e);
			message = e.getMessage();
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(new ApiEntity<>(message, response), httpHeaders, status);
	}
}
