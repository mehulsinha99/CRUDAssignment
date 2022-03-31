package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepo;
	
	public List<Student> findAllStudentService() {
		// TODO Auto-generated method stub
		return studentRepo.selectAllStudent();
	}

	
	public Student findStudentByIdService(int cRefID) {
		// TODO Auto-generated method stub
		return studentRepo.selectStudentByID(cRefID);
	}

	
	public void insertStudentService(Student cRef) {
		// TODO Auto-generated method stub
		studentRepo.insertStudent(cRef);
	}

	
	public void updateStudentService(Student cRef) {
		// TODO Auto-generated method stub
		studentRepo.updateStudent(cRef);
	}

	
	public void deleteStudentService(int cRefID) {
		// TODO Auto-generated method stub
		studentRepo.deleteStudent(cRefID);
	}

}
