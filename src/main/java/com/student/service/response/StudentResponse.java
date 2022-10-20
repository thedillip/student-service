package com.student.service.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentResponse {
	private long studentId;
	private String name;
	private int age;
	private String gender;
	private String email;
	private String mobileNumber;
	private String collegeName;
	private String courseName;
	private long addressId;
}
