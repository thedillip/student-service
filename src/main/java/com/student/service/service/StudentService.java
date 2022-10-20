package com.student.service.service;

import java.util.List;

import com.student.service.request.StudentRequest;
import com.student.service.response.StudentResponse;

public interface StudentService {
	String createStudent(StudentRequest studentRequest);
	List<StudentResponse> getAllStudents();
	StudentResponse getStudentByStudentId(long studentId);
	String updateStudentByStudentId(long studentId, StudentRequest studentRequest);
	String deleteAllStudents();
	String deleteStudentByStudentId(long studentId);
}
