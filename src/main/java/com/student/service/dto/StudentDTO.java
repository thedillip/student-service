package com.student.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDTO {
	private long studentId;
	private String name;
	private int age;
	private String gender;
	private String email;
	private String mobileNumber;
	private String collegeName;
	private String courseName;
}
