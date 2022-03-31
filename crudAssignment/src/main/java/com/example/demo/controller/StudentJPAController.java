package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Student;
import com.example.demo.service.StudentService;

@CrossOrigin(origins = "*", value = "*")
@RestController
public class StudentJPAController {
	
	@Autowired
	StudentService studentServ;
	
	public StudentJPAController() {
		System.out.println("StudentJPAController running...");
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	//Getting all records
	//localhost:8080/getAllStudent
	@GetMapping
	@RequestMapping(path="/getAllStudent") 
	public List<Student> getAllStudent(){
		return studentServ.findAllStudentService();
	}
	
	//Searching by studentID
	//localhost:8080/getStudentByID/102
	@GetMapping
	@RequestMapping(path="/getStudentByID/{cID}")
	public Student getStudentByID(@PathVariable("cID") int studentToFind) throws StudentNotFoundException{
		
		Student found = null;
		found = studentServ.findStudentByIdService(studentToFind);
		
		if(found==null) {
			StudentNotFoundException ste = new StudentNotFoundException("Not found in records");
		}
		
		return found;
	}
	
	//Adding a new student
	//localhost:8080/addStudent
	@PostMapping
	@RequestMapping(path="/addStudent")
	public void addStudent(@RequestBody Student studentToInsert) throws StudentNotFoundException {
		Student newStudent = new Student();
		//newStudent.setStudentID(studentToInsert.getStudentID());
		newStudent.setStudentName(studentToInsert.getStudentName());
		newStudent.setStudentSubject(studentToInsert.getStudentSubject());
		
		studentServ.insertStudentService(newStudent);
	}
	
	//Updating a record
	//localhost:8080/updateStudent
	@PostMapping
	@RequestMapping(path="/updateStudent")
	public void updateStudent(@RequestBody Student studentToUpdate) throws StudentNotFoundException{
		
		boolean found = false;
		studentServ.updateStudentService(studentToUpdate);
		found = true;
		if(found) {
			System.out.println("Record modified...");
			
		} 
		else {
			System.out.println("Not found");
			StudentNotFoundException NotFoundExp = new StudentNotFoundException("ID not found");
			throw NotFoundExp;
		}
	}
	
	//Deleting a record
	//localhost:8080/deleteStudent
	@PostMapping
	@RequestMapping(path="/deleteStudent")
	public void deleteStudent(@RequestBody Student studentToDelete) throws StudentNotFoundException{
		
		boolean found = false;
		studentServ.deleteStudentService(studentToDelete.getStudentID());
		found = true;
		if(found) {
			System.out.println("Record deleted...");
			
		} 
		else {
			System.out.println("Not found");
			StudentNotFoundException NotFoundExp = new StudentNotFoundException("ID not found");
			throw NotFoundExp;
		}
	}
}
