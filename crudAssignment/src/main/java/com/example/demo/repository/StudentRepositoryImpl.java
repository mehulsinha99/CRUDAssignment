package com.example.demo.repository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.example.demo.Student;


@Repository("studentrepo")
public class StudentRepositoryImpl extends BaseRepository implements StudentRepository {

	StudentRepositoryImpl(){
		System.out.println("StudentRepositoryImpl constructor");
	}
	
	@Transactional
	public void insertStudent(Student cRef) {
		// TODO Auto-generated method stub
		super.persist(cRef);
	}

	@Transactional
	public Student selectStudentByID(int cID) {
		// TODO Auto-generated method stub
		return super.find(Student.class, cID);
	}

	@Transactional
	public List<Student> selectAllStudent() {
		// TODO Auto-generated method stub
		return super.findAll("Student");
	}

	@Transactional
	public void updateStudent(Student cRef) {
		// TODO Auto-generated method stub
		super.merge(cRef);

	}

	@Transactional
	public void deleteStudent(int cID) {
		// TODO Auto-generated method stub
		super.remove(Student.class, cID);
	}

}
