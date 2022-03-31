package com.example.demo.repository;

import java.util.List;
import com.example.demo.Student;

public interface StudentRepository {
	void insertStudent(Student cRef);
	Student selectStudentByID(int cID);
	List<Student> selectAllStudent();
	void updateStudent(Student cRef);
	void deleteStudent(int cID);
}
