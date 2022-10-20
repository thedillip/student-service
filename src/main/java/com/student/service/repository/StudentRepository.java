package com.student.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.service.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
