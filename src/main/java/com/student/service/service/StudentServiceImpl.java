package com.student.service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.student.service.request.StudentRequest;
import com.student.service.response.StudentResponse;

@Service
public class StudentServiceImpl implements StudentService {

	@Override
	public String createStudent(StudentRequest studentRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentResponse> getAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentResponse getStudentByStudentId(long studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateStudentByStudentId(long studentId, StudentRequest studentRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteStudentByStudentId(long studentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
