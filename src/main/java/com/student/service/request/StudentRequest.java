package com.student.service.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentRequest {
	private String name;
	private int age;
	private String gender;
	private String email;
	private String mobileNumber;
	private String collegeName;
	private String courseName;
	private long addressId;
}
