package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.Student;


@Service
public interface StudentService {
	List<Student> findAllStudentService();
	Student findStudentByIdService(int cRefID);
	void insertStudentService(Student cRef);
	void updateStudentService(Student cRef);
	void deleteStudentService(int cRefID);
}
